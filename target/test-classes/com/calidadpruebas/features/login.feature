Feature: User login
@edge
  Scenario: Successful login with valid credentials
    Given the user is on the Facebook login page
    When the user enters valid credentials "danielfw5k@gmail.com" and "calidad2024"
    Then the user should be redirected to the homepage
@edge
  Scenario: Unsuccessful login with invalid credentials
    Given the user is on the Facebook login page
    When the user enters invalid credentials "danielf@gmail.com" and "2024"
    Then an error message should be displayed


