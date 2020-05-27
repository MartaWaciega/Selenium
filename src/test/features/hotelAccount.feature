Feature: New account on my hotel

  Scenario : User create new account
    Given User open browser with My Hotel main page
    When User click sign in button
    When User enter email prz@gmail.com and click create an account button
    When User enter title Pan on personal information page
    When User enter first name John on field first name
    When User enter last name Snow on field last name
    When User enter password 1235##5@ on field password
    When User enter date of birthday on field date of Birthday
    When User enter in checkbox sign up for newsletter and receive special offers
    Then The first one should contain create new account
    And Close browser
