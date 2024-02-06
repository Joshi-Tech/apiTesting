Feature: PUT response


  Scenario: User should get correct response for a register PUT request
    Given I provide the end point for PUT request as : "/api/users/2"
    When I provide the name as: "morpheus" and job as: "zion resident" to a "update" user
    Then I should get PUT status code:200 for "update"
    And the date create at should be today's date
