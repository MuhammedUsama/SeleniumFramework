Feature: User Registration
	I want to check that user can register in our e-commerce website.

  Scenario Outline: User Registration
  Given The user in the home page
  When  I click on register link 
  And  I entered "<firstname>" , "<lastname>" , "<email>" , "<password>"
  Then The registeration pages is played successfully 
	
	Examples:
	| firstname | lastname | email | password |
	| Muhammed | Usama | usus13@gmail.com | 123456789 |
	| Ahmed | Mahmoud | mm2@yahoo.com | 12345678 |
	