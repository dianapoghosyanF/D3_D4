package com.xxx.bdd;

import javax.annotation.Resource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;
import com.xxx.MainApplication;
import com.xxx.model.dto.StatisticInfo;


@RunWith(SpringRunner.class)
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
  classes = MainApplication.class )
public abstract class AbstractSteps
{
  @LocalServerPort
  protected int port;

  @Resource
  public WebApplicationContext webApplicationContext;

  @Autowired
  private TestRestTemplate restTemplate;

  private ResponseEntity lastGetResponse;
  private ResponseEntity lastPostResponse;

  private int lastStatusCode;

  private String baseUri;

  protected void get(String url, Object... urlVariable) throws Exception {
    final ResponseEntity<StatisticInfo> response =
      restTemplate.exchange(baseUri + url, HttpMethod.GET, null, StatisticInfo.class);
    lastGetResponse = response;
    lastStatusCode = lastGetResponse.getStatusCodeValue();
  }

  protected <T> void post(String url, T body, Object... urlVariables) throws Exception {
    final ResponseEntity response = restTemplate.exchange(
      baseUri + url, HttpMethod.POST, new HttpEntity<T>(body), Void.class);

    lastPostResponse = response;
    lastStatusCode = lastPostResponse.getStatusCodeValue();
  }

  protected ResponseEntity getLastGetResponse() {
    return lastGetResponse;
  }

  protected ResponseEntity getLastPostResponse() {
    return lastPostResponse;
  }

  public int getLastStatusCode() {
    return lastStatusCode;
  }

  public void setBaseUri( String baseUri )
  {
    this.baseUri = baseUri;
  }
}
