$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/TransactionStatistics.feature");
formatter.feature({
  "name": "User can successfully get, create TransactionInfo and get StatisticInfo",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "baseUri is http://localhost:8087/v2",
  "keyword": "Given "
});
formatter.match({
  "location": "TransactionStatisticsSteps.baseUri(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User gets a created TransactionInfo",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user creates an TransactionInfo",
  "keyword": "When "
});
formatter.match({
  "location": "TransactionStatisticsSteps.theUserCallsGetTransactionInfo()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the TransactionInfo is successfully created",
  "keyword": "And "
});
formatter.match({
  "location": "TransactionStatisticsSteps.theTransactionInfoIsSuccessfullyCreated()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user gets the current StatisticInfo",
  "keyword": "And "
});
formatter.match({
  "location": "TransactionStatisticsSteps.theUserRetrievesTheTransactionInfo()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user receives status code of 200",
  "keyword": "Then "
});
formatter.match({
  "location": "TransactionStatisticsSteps.theUserReceivesStatusCodeOf(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the retrieved StatisticInfo is correct",
  "keyword": "And "
});
formatter.match({
  "location": "TransactionStatisticsSteps.theRetrievedTransactionInfoIsCorrect()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "baseUri is http://localhost:8087/v2",
  "keyword": "Given "
});
formatter.match({
  "location": "TransactionStatisticsSteps.baseUri(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User gets a created TransactionInfos",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user creates an TransactionInfos",
  "keyword": "When "
});
formatter.match({
  "location": "TransactionStatisticsSteps.theUserCallsGetTransactionInfos()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "at least one TransactionInfo is successfully created",
  "keyword": "And "
});
formatter.match({
  "location": "TransactionStatisticsSteps.theTransactionInfosIsSuccessfullyCreated()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user gets the current StatisticInfo",
  "keyword": "And "
});
formatter.match({
  "location": "TransactionStatisticsSteps.theUserRetrievesTheTransactionInfo()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user receives status code of 200",
  "keyword": "Then "
});
formatter.match({
  "location": "TransactionStatisticsSteps.theUserReceivesStatusCodeOf(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the retrieved StatisticInfo is correct",
  "keyword": "And "
});
formatter.match({
  "location": "TransactionStatisticsSteps.theRetrievedTransactionInfoIsCorrect()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "baseUri is http://localhost:8087/v2",
  "keyword": "Given "
});
formatter.match({
  "location": "TransactionStatisticsSteps.baseUri(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User gets an existing StatisticInfo",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user gets the current StatisticInfo",
  "keyword": "When "
});
formatter.match({
  "location": "TransactionStatisticsSteps.theUserRetrievesTheTransactionInfo()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user receives status code of 200",
  "keyword": "Then "
});
formatter.match({
  "location": "TransactionStatisticsSteps.theUserReceivesStatusCodeOf(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the retrieved StatisticInfo is correct",
  "keyword": "And "
});
formatter.match({
  "location": "TransactionStatisticsSteps.theRetrievedTransactionInfoIsCorrect()"
});
formatter.result({
  "status": "passed"
});
});