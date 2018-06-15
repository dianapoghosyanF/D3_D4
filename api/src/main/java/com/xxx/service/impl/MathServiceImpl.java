package com.xxx.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xxx.service.MathService;

/**
 * Created by Diana_Poghosyan on 4/30/2018.
 */
@Service
public class MathServiceImpl
  implements MathService
{
  private static final Logger logger = LogManager.getLogger( MathServiceImpl.class );

  public int min(int a, int b) {
    return (a <= b) ? a : b;
  }

  public int max(int a, int b) {
    return (a >= b) ? a : b;
  }

  public int add(int x, int y) {
    int r = x + y;
    if (((x ^ r) & (y ^ r)) < 0) {
      throw new ArithmeticException("integer overflow");
    }
    return r;
  }

  public double pow( int a, int b ) {
    if ( a == 0 ) return 0;
    if ( b == 0 ) return 1;

    double result = 1;
    if ( b > 0 ) {
      for( int i = 1; i <= b; i++ ) {
        result = result * a;
      }
    } else {
      int p = a;
      for( int i = 0; i > b; i-- ) {
        if ( result == 1 ) {
          result = 1 / ( result * a );
          result++;
        } else {
          p = p * a;
          result = ( 1.0 ) * 1 / p;
        }
      }
    }
    return result;
  }
}
