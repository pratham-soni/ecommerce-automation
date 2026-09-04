@ECOM_purchase

Feature: E-commerce purchase

  Scenario: User completes a purchase successfully

    Given the user is on the login page
    When the user logs in with valid credentials
    And the user adds the backpack to the cart
    And the user proceeds to checkout
    And the user enters valid customer details
    And the user completes the order
    Then the order should be confirmed