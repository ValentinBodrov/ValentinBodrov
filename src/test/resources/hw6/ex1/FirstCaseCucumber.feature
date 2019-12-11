Feature: First Test Case Cucumber file

  Scenario: Check login
    Given I open EPAM JDI Site
    Then Browser title should be 'Home Page' on the Home Page
    When I login as user 'epam' with password '1234' on the Home Page
    Then username should be 'PITER CHAILOVSKII' on the Home Page
    And the four pictures should be displayed on the Home Page
    And the four texts should be displayed under pictures on the Home Page
    And the headline should be displayed on the Home Page
    And the description should be displayed under the headline on the Home Page
    When I click on subcategory 'SERVICE' in the header on the Home Page
    Then service subcategory in the header should have data
      | SUPPORT            |
      | DATES              |
      | SEARCH             |
      | COMPLEX TABLE      |
      | SIMPLE TABLE       |
      | USER TABLE         |
      | TABLE WITH PAGES   |
      | DIFFERENT ELEMENTS |
      | PERFORMANCE        |
    When  I click on subcategory 'Service' in the left side menu on the Home Page
    Then service subcategory in the left side menu should have data
      | Support            |
      | Dates              |
      | Complex Table      |
      | Simple Table       |
      | Search             |
      | User Table         |
      | Table with pages   |
      | Different elements |
      | Performance        |
    When I click on subcategory 'SERVICE' in the header on the Home Page
    And I click on 'DIFFERENT ELEMENTS' in the dropdown menu on the Home Page
    Then 'Different Elements' page is opened
    And the 4 checkboxed should be displayed on Different Elements Page
    And the 4 radiobuttons should be displayed on Different Elements Page
    And the dropdown should be displayed on Different Elements Page
    And a default button should be displayed on Different Elements Page
    And a button should be displayed on Different Elements Page
    And the Right Section should be displayed on Different Elements Page
    And the Left Section should be displayed on Different Elements Page
    When I click on checkbox with label 'Water' on Different Elements Page
    And I click on checkbox with label 'Wind' on Different Elements Page
    Then the checkbox with label 'Water' should be checked on Different Elements Page
    And the checkbox with label 'Wind' should be checked on Different Elements Page
    And the log rows should contain information about checkbox with label 'Water' on Different Elements Page
    And the log rows should contain information about checkbox with label 'Wind' on Different Elements Page
    When I click on radiobutton with label 'Selen' on Different Elements Page
    Then the radiobutton with label 'Selen' should be checked on Different Elements Page
    And the log rows should contain information about radiobutton with label 'Selen' on Different Elements Page
    When I select in a dropdown an element 'Yellow' on Different Elements Page
    Then the element 'Yellow' in a dropdown should be selected on Different Elements Page
    And the log rows should contain information about dropdown element 'Yellow' on Different Elements Page
    When I click on checkbox with label 'Water' on Different Elements Page
    And I click on checkbox with label 'Wind' on Different Elements Page
    Then the checkbox with label 'Water' should not be checked on Different Elements Page
    And the checkbox with label 'Wind' should not be checked on Different Elements Page
    And the log rows should not contain information about checkbox with label 'Water' on Different Elements Page
    And the log rows should not contain information about checkbox with label 'Wind' on Different Elements Page