Feature: POST response


  Scenario: User should get correct response for a register POST request
    Given I provide the end point for POST request as : "/api/register"
    When I provide the email as: "xyz@abc.com" and password as: "password" to a "register" user
    Then I should get POST status code:201 for "register user"

  Scenario: User should get correct response for a login POST request
    Given I provide the end point for POST request as : "/api/login"
    When I provide the email as: "eve.holt@reqres.in" and password as: "cityslicka" to a "login" user
    Then I should get POST status code:200 for "login user"
