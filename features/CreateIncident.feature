Feature: Create Incident in ServiceNow

Background: 
Given Setup the endpoint 
And Authorize
And Enable Logs
And Set Content Type

Scenario: Create the new incident using Rest-Assured
And Set the body contents
Then Post the request