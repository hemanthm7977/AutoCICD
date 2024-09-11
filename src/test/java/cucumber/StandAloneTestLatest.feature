
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

  @tag2
  Scenario Outline: Positive test of sumbitting the order
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
