Feature: NewProducts

Background:
	Given I open inthestyle

	@FunctionalTest
  	Scenario Outline: the user should be open url
  	  	And I Mousehover <model>
  	  	Then Click on <submodel>
  	  	Then I Click on Allnewnextpage
  	  	Examples:
  	  	|model|submodel|
  	  	|first|allnew|
  	  	|clothing|allclothing|
  	  	|dress|alldress|

