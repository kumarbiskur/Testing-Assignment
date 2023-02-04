
@Test
Feature:RCB player list

  @foreginPalyesList
  Scenario: Valdate the foreign players for
  Given : Read the response 'response' to validate the foreign players
  Then : Validate playing list have only four foreign players


  @wicketKeeperList
  Scenario: Valdate the wicket keeper
    Given : Read the response 'response'to validate the wicket keeper
    Then : Validate playing list have only one wicket keeper