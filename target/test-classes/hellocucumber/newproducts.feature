Feature: NewProducts

Background:
	Given I open inthestyle

	@FunctionalTest
  	Scenario Outline: the user should be open url
  	  	And I Mousehover <model>
  	  	Then Click on <submodel>
		Then Select <colours>
		Then Return total count <colours>
  	  	Then I Click on Allnewnextpage
  	  	Examples:
  	  	|model|submodel|colours|
  	  	|first|allnew|Multi|

	@FunctionalTest
	Scenario Outline: the user should be open url
		And I Mousehover <model>
		Then Click on <submodel>
		Then Select <colours>
		Then Return total count <colours>
		Then I Click on Allnewnextpage
		Examples:
			|model|submodel|colours|
			|clothing|allclothing|Black|
	@FunctionalTest
	Scenario Outline: the user should be open url
		And I Mousehover <model>
		Then Click on <submodel>
		Then Select <colours>
		Then Return total count <colours>
		Then I Click on Allnewnextpage
		Examples:
			|model|submodel|colours|
			|dress|alldress|Blue|

