Feature: Awwards

Background:
	Given I open awwwards

	@FunctionalTest
	Scenario Outline: User should handle timeouts wait until visible of login then Logout
		Then I click on Login
		And I enter <user> as <password>
		Then click on LoginNow
		And click on Logout
		Examples:
			|user|password|
			|venuistqb@gmail.com|welcome@london|

	@FunctionalTest
	Scenario Outline: User Navigating to New Browser Window
		Then I click on Login
		And I enter <user> as <password>
		Then click on LoginNow
		And click on polawebsite
		Then I navigate to new window

		Examples:
			|user|password|
			|venuistqb@gmail.com|welcome@london|

	@FunctionalTest
	Scenario Outline: User find image and print image name
		Then I click on Login
		And I enter <user> as <password>
		Then click on LoginNow
		Then I get image title
		Examples:
			|user|password|
			|venuistqb@gmail.com|welcome@london|



