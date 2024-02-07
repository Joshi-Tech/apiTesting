Feature: GET end point features

  Scenario: GET endpoint for unknown user should give 200 status code
    Given I provide endpoint for user as : "/api/unknown"
    Then I should get status code:200 for "unknown user"

  Scenario: GET endpoint for a single user should give 200 status code
    Given I provide endpoint for user as : "/api/users/2"
    Then I should get status code:200 for "single user"

  Scenario: User should get status code 200 and correct details of users in a list of users endpoint
    Given I provide endpoint for user as : "/api/users?page=2"
    Then I should get status code:200 for "users list"
    And I should see an user with email:"janet.weaver@reqres.in"
