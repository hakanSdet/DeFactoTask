Feature: Defacto company task

  @wip
  Scenario: Defacto automation task
    Given I navigate to home page
    Then I verify that page is loaded
    When I hover the mouse over "KADIN" module
    And I click "Mevsimlik Mont - Ceket" side menu
    And I select "S" size
    And I select a random product in Mevsimlik Mont - Ceket side menu
    Then I verify that page is loaded
    When I select a random size for selected product
    And I click SEPETE EKLE button
    And I click Sepetim
    And I click SEPETE GİT
    Then I verify that page is loaded
    And I delete selected product
    Then I verify that the cart is empty

