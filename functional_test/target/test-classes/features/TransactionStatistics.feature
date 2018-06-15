Feature: User can successfully get, create TransactionInfo and get StatisticInfo

Background:
    Given baseUri is http://localhost:8087/v2

Scenario: User gets a created TransactionInfo
    When the user creates an TransactionInfo
    And the TransactionInfo is successfully created
    And the user gets the current StatisticInfo
    Then the user receives status code of 200
    And the retrieved StatisticInfo is correct

Scenario: User gets a created TransactionInfos
    When the user creates an TransactionInfos
    And at least one TransactionInfo is successfully created
    And the user gets the current StatisticInfo
    Then the user receives status code of 200
    And the retrieved StatisticInfo is correct

Scenario: User gets an existing StatisticInfo
    When the user gets the current StatisticInfo
    Then the user receives status code of 200
    And the retrieved StatisticInfo is correct


