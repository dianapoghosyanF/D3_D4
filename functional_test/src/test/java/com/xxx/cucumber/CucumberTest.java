package com.xxx.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Created by Diana_Poghosyan on 5/6/2018.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
  plugin = {"pretty", "html:target/cucumber"},// "html:target/cucumber" "json:target/cucumber/cucumber.json"
  features = "src/test/resources/features",
  glue = {"com.xxx.bdd"})
public class CucumberTest {

}