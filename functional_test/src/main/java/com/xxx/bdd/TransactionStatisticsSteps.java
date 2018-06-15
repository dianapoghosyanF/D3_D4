package com.xxx.bdd;

import java.math.BigDecimal;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.xxx.model.dto.TransactionInfo;
import com.xxx.model.dto.StatisticInfo;
import com.xxx.util.Constants;

//@Ignore
public class TransactionStatisticsSteps extends AbstractSteps {

  private static StatisticInfo EXPECTED_OBJ = null;

  @Given("^baseUri is (.*)$")
  public void baseUri(String uri) {
    Assert.assertNotNull(uri);
    Assert.assertTrue(!uri.isEmpty());
    setBaseUri( uri );
  }

  @When("^the user creates an TransactionInfo$")
  public void theUserCallsGetTransactionInfo() throws Throwable {
    long currentUTCTime = ZonedDateTime.now( ZoneOffset.UTC ).toInstant().toEpochMilli();
    EXPECTED_OBJ = new StatisticInfo( BigDecimal.valueOf( 1000.0 ), 1000, 1000, 1000, 1);
    post(Constants.CREATE_TRANSACTION_URI, new TransactionInfo( currentUTCTime,1000) );
  }

  @When("^the user creates an TransactionInfos$")
  public void theUserCallsGetTransactionInfos() throws Throwable {
    List<TransactionInfo> transactionInfos = new ArrayList<>( 3 );
    ZonedDateTime currentUTCTime = ZonedDateTime.now( ZoneOffset.UTC );
    long currentUTCTimeMsc = currentUTCTime.toInstant().toEpochMilli();

    EXPECTED_OBJ = new StatisticInfo( BigDecimal.valueOf( 6000.0 ), 2000, 3000, 1000, 3);
    transactionInfos.add( new TransactionInfo( currentUTCTimeMsc,3000) );
    transactionInfos.add( new TransactionInfo( currentUTCTimeMsc,2000) );
    transactionInfos.add( new TransactionInfo( currentUTCTime.minusSeconds( 70 ).toInstant().toEpochMilli(),1000) );
    post(Constants.CREATE_TRANSACTIONS_URI, transactionInfos );
  }

  @And("^at least one TransactionInfo is successfully created$")
  public void theTransactionInfosIsSuccessfullyCreated() {
    Assert.assertEquals(Constants.CREATED_SUCCESS_CODE, getLastPostResponse().getStatusCodeValue());
  }

  @And("^the TransactionInfo is successfully created$")
  public void theTransactionInfoIsSuccessfullyCreated() {
    Assert.assertEquals(Constants.CREATED_SUCCESS_CODE, getLastPostResponse().getStatusCodeValue());
  }

  @And("^the user gets the current StatisticInfo$")
  public void theUserRetrievesTheTransactionInfo() throws Throwable {
    get( Constants.GET_STATISTICS_URI );
  }

  @Then("^the user receives status code of (\\d+)$")
  public void theUserReceivesStatusCodeOf(int statusCode) throws Throwable {
    Assert.assertEquals(statusCode, getLastStatusCode());
  }

  @And("^the retrieved StatisticInfo is correct$")
  public void theRetrievedTransactionInfoIsCorrect() throws Throwable {
    Assert.assertEquals( EXPECTED_OBJ, getLastGetResponse().getBody());
  }
}
