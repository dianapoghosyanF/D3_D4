package com.xxx.rest.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xxx.model.dto.StatisticInfo;
import com.xxx.model.dto.TransactionInfo;
import com.xxx.rest.jaxrs.util.Validator;
import com.xxx.service.TransactionStatisticService;
import com.xxx.util.Constants;

/**
 * Created by Diana_Poghosyan on 5/3/2018.
 */
@CrossOrigin(origins = "*")
@RestController
@ExposesResourceFor(StatisticInfo.class)
@RequestMapping(value = "/v2", produces = MediaType.APPLICATION_JSON_VALUE)
public class TransactionStatisticsContoller
{
  private static final Logger logger = LogManager.getLogger( TransactionStatisticsContoller.class );

  @Autowired
  private TransactionStatisticService transactionStatisticService;

  @Autowired
  private Validator validator;

  @GetMapping(value = Constants.GET_STATISTICS_URI)
  public ResponseEntity retrieveStatisticInfo()
  {
    try {
      StatisticInfo statisticInfo = transactionStatisticService.getStatisticInfo();
      logger.info( "Retrieved object " + statisticInfo );
      return new ResponseEntity<>( statisticInfo, HttpStatus.OK );
    } catch( Exception e ) {
      return new ResponseEntity<>( e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR );
    }
  }

  @PostMapping(value = Constants.CREATE_TRANSACTION_URI, consumes = MediaType.APPLICATION_JSON_VALUE )
  public ResponseEntity populateTransactionInfo( @RequestBody TransactionInfo transactionInfo )
  {
    logger.info( "Creating object " + transactionInfo );
    try {
      if ( validator.isValidTimestamp( transactionInfo.getTimestamp() ) ) {
        transactionStatisticService.addTransactionInfo( transactionInfo );
        return new ResponseEntity<>( HttpStatus.CREATED );
      } else {
        return new ResponseEntity<>( HttpStatus.NO_CONTENT );
      }
    } catch( Exception e ) {
      return new ResponseEntity<>( e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR );
    }
  }

  @PostMapping(value = Constants.CREATE_TRANSACTIONS_URI, consumes = MediaType.APPLICATION_JSON_VALUE )
  public ResponseEntity populateTransactionInfos( @RequestBody List<TransactionInfo> transactionInfos )
  {
    logger.info( "Creating objects " + transactionInfos );
    boolean areThereValid = true;
    try {
      for( TransactionInfo t : transactionInfos ) {
        if ( validator.isValidTimestamp( t.getTimestamp() ) ) {
          transactionStatisticService.addTransactionInfo( t );
          areThereValid &= false;
        } else {
          areThereValid &= true;
        }
      }
    } catch( Exception e ) {
      return new ResponseEntity<>( e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR );
    }

    if ( !areThereValid ) {
      return new ResponseEntity<>( HttpStatus.CREATED );
    } else {
      return new ResponseEntity<>( HttpStatus.NO_CONTENT );
    }
    }
  }
