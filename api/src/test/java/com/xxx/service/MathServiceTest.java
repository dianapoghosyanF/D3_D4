package com.xxx.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import com.xxx.StatisticsMainApplication;
import com.xxx.service.impl.MathServiceImpl;

import ma.glasnost.orika.MapperFacade;

public class MathServiceTest
  extends StatisticsMainApplication
{
  private MathService mathService;


  @Mock
  private MapperFacade mockTransactionInfoMapper;

  private static final int N = 5;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    mathService = new MathServiceImpl();
    try {
      //TestUtil.setPrivateFieldValue( mathService,
      //  "infoMapper", mockInfoMapper );
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException();
    }
  }

  @UseDataProvider("minTestData")
  @Test
  public void min( int a, int b, int expected ) {
    int actual = mathService.min(a, b);
    assertEquals( expected, actual );
  }

  @UseDataProvider("maxTestData")
  @Test
  public void max( int a, int b, int expected ) {
    int actual = mathService.max(a, b);
    assertEquals( expected, actual );
  }

  @UseDataProvider("addTestData")
  @Test
  public void add( int a, int b, int expected ) {
    int actual = mathService.add(a, b);
    assertEquals( expected, actual );
  }

  @UseDataProvider("powTestData")
  @Test
  public void pow( int a, int b, double expected ) {
    double actual = mathService.pow(a, b);
    assertEquals( expected, actual, 0 );
  }

  @DataProvider
  public static Object[][] minTestData() {

    return new Object[][] {
      { 0, 0, 0 },
      { 0, 5, 0 },
      { 4, 0, 0 },
      { 2, 3, 2 },
      { 5, -2, -2 },
      { -5, -15, -15 },
      { -5, 5, -5 },
    };
  }

  @DataProvider
  public static Object[][] maxTestData() {

    return new Object[][] {
      { 0, 0, 0 },
      { 0, 5, 5 },
      { 4, 0, 4 },
      { 2, 3, 3 },
      { 5, -2, 5 },
      { -5, -15, -5 }
    };
  }

  @DataProvider
  public static Object[][] addTestData() {

    return new Object[][] {
      { 0, 0, 0 },
      { 0, 5, 5 },
      { 4, 0, 4 },
      { 2, 3, 5 },
      { 5, -2, 3 },
      { -5, -15, -20 },
      { -5, 5, 0 },
    };
  }

  @DataProvider
  public static Object[][] powTestData() {

    return new Object[][] {
      { 0, 0, 0 },
      { 0, 5, 0 },
      { 4, 0, 1 },
      { 2, 3, 8 },
      { 5, -2, 0.04 },
    };
  }


}

