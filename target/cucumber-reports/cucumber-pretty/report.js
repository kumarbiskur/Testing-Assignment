$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/TestScenarios.feature");
formatter.feature({
  "name": "RCB player list",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Test"
    }
  ]
});
formatter.scenario({
  "name": "Valdate the foreign players for",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Test"
    },
    {
      "name": "@foreginPalyesList"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": ": Read the response \u0027response\u0027 to validate the foreign players",
  "keyword": "Given "
});
formatter.match({
  "location": "ValidateForeginPlayers.readTheResponseResponseToValidateTheForeignPlayers(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": ": Validate playing list have only four foreign players",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidateForeginPlayers.validatePlayingListHaveOnlyFourForeignPlayers()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Valdate the wicket keeper",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Test"
    },
    {
      "name": "@wicketKeeperList"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": ": Read the response \u0027response\u0027to validate the wicket keeper",
  "keyword": "Given "
});
formatter.match({
  "location": "ValidateWicketKeeper.readTheResponseResponseToValidateTheWicketKeeper(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": ": Validate playing list have only one wicket keeper",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidateWicketKeeper.validatePlayingListHaveOnlyOneWicketKeeper()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});