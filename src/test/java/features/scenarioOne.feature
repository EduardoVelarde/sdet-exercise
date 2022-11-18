@web-page
Feature: Assigment Selenium-Java
  First task of the assigment

  @Amazon
  Scenario: Selenium Assignment
    Given Open the Browser using this url "https://www.amazon.com.mx/"
    When I click in the search bar
      And I search for "refrigerador"
      And I scroll down until a find the text "Samsung"
      And I click to the button add to cart
      And I click dont add protection
      And I click in the search bar
      And I search for "refrigerador"
      And I scroll down until a find the text "Mabe"
      And I click to the button add to cart
      And I click dont add protection

  @Amazon @validationOne
  Scenario: Selenium Assignment
    Given I click on cart
    When I scroll down until a find the text on subtotalPage
    And I save the value of subtotal
    Then I expect to be greater than 1000
    And I expect to be less than 1000
