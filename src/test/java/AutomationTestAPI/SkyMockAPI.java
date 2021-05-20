package AutomationTestAPI;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.*;

public class SkyMockAPI {

    //Last 3 Tests are related with each other.
    //Please start the tests one by one
    //retrieveAllFixtures -> storeNewFixture -> updateFixture -> deleteFixture

    //Global variables for full Fixture Input
     Fixture newFixture = new Fixture();
     FootballFullState newFootballFullState = new FootballFullState();
     List<Object> possibles = new ArrayList<>();
     List<Object> corners = new ArrayList<>();
     List<Object> redCards = new ArrayList<>();
     List<Object> yellowCards = new ArrayList<>();
     FixtureStatus newFixtureStatus = new FixtureStatus();
     Goal newGoal = new Goal();
     Team teamHOME = new Team();
     Team teamAWAY = new Team();

    @BeforeClass
    public void beforeClass(){
        baseURI = "http://localhost:3000";

        //Filling global variables with dummy data
        //Fixture > (FixtureStatus <=> FootballFullSate) > (Goals <=> Teams)

        //Fill Teams
        teamHOME.setTeamId("HOME");
        teamHOME.setAssociation("HOME");
        teamHOME.setName("Galatasaray");

        teamAWAY.setTeamId("AWAY");
        teamAWAY.setAssociation("AWAY");
        teamAWAY.setName("Fenerbahce");

        List<Team> newTeams = new ArrayList<>();
        newTeams.add(teamHOME);
        newTeams.add(teamAWAY);


        //Fill Goals
        newGoal.setClockTime(500);
        newGoal.setConfirmed(true);
        newGoal.setId(658901);
        newGoal.setOwnGoal(false);
        newGoal.setPenalty(false);
        newGoal.setPeriod("FIRST_HALF");
        newGoal.setPlayerId(336658);
        newGoal.setTeamId("1");

        List<Goal> newGoals = new ArrayList<>();
        newGoals.add(newGoal);


        //Fill FixtureStatus
        newFixtureStatus.setDisplayed(true);
        newFixtureStatus.setSuspended(false);


        //Fill FootballFullState
        newFootballFullState.setHomeTeam("Galatasaray");
        newFootballFullState.setAwayTeam("Fenerbahce");
        newFootballFullState.setFinished(false);
        newFootballFullState.setGameTimeInSeconds(600);
        newFootballFullState.setPeriod("FIRST_HALF");
        newFootballFullState.setPossibles(possibles);
        newFootballFullState.setCorners(corners);
        newFootballFullState.setRedCards(redCards);
        newFootballFullState.setYellowCards(yellowCards);
        newFootballFullState.setStartDateTime("2019-03-20T10:49:38.655Z");
        newFootballFullState.setStarted(true);
        newFootballFullState.setTeams(newTeams);
        newFootballFullState.setGoals(newGoals);

        //Fill Fixture
        newFixture.setFixtureId("4");
        newFixture.setFixtureStatus(newFixtureStatus);
        newFixture.setFootballFullState(newFootballFullState);

    }

    @Test
    public void retrieveAllFixtures(){

        //GET all fixtures and store them in a List
        Response response = given().accept(ContentType.JSON).
                when().get("/fixtures");

        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(),"application/json; charset=utf-8");

        Fixture[] fixtures = response.body().as(Fixture[].class);
        List<Fixture> fixtureList = new ArrayList<>();
        fixtureList.addAll(Arrays.asList(fixtures));

        //1.Retrieve all fixtures
        //  i.Assert that there are 3 fixtures within the returned object.
        System.out.println("Total Fixtures in response body = " + fixtureList);
        assertEquals(fixtureList.size(),3);


        //  ii.Assert that each of the 3 fixtures has a fixtureId value.
        for (Fixture fixture:fixtureList) {
            System.out.println("FixtureID = " + fixture.getFixtureId());
            assertFalse(fixture.getFixtureId().isEmpty());
        }

    }

    @Test
    public void storeNewFixture() {

        //POST the new Fixture
        Response response = given().accept(ContentType.JSON).
                and().contentType(ContentType.JSON).
                and().body(newFixture).
                when().post("/fixture");

        assertEquals(response.statusCode(),202);


        //GET the newly added Fixture
        long start = System.currentTimeMillis();

        while(response.statusCode() != 200){
            response = given().accept(ContentType.JSON).
                    when().get("/fixture/" + newFixture.getFixtureId());

            //Check statusCode and milliseconds with each iteration
            System.out.println(response.statusCode() + " statusCode");
            System.out.println(System.currentTimeMillis() - start + " milliseconds");

        }

        Fixture fixture = response.body().as(Fixture.class);

        //Assert that Posted fixture added to API with correct data
        assertEquals(fixture.getFootballFullState().getTeams().get(0).getAssociation(),
                newFootballFullState.getTeams().get(0).getAssociation());


    }

    @Test
    public void updateFixture(){

        //Get the all fixtures first and store them in a List
        Response response = given().accept(ContentType.JSON).
                when().get("/fixtures");

        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(),"application/json; charset=utf-8");

        Fixture[] fixtures = response.body().as(Fixture[].class);
        List<Fixture> fixtureList = new ArrayList<>();
        fixtureList.addAll(Arrays.asList(fixtures));

        //Hold last fixture before changes
        Fixture lastFixture = new Fixture();

        lastFixture.setFixtureId(fixtureList.get(fixtureList.size()-1).getFixtureId());
        lastFixture.setFixtureStatus(fixtureList.get(fixtureList.size()-1).getFixtureStatus());
        lastFixture.setFootballFullState(fixtureList.get(fixtureList.size()-1).getFootballFullState());

        String AwayTeamBeforeChanges = lastFixture.getFootballFullState().getAwayTeam();
        String HomeTeamBeforeChanges = lastFixture.getFootballFullState().getHomeTeam();
        String HomeTeamFromTeamsSection = lastFixture.getFootballFullState().getTeams().get(0).getName();
        String AwayTeamFromTeamsSection = lastFixture.getFootballFullState().getTeams().get(1).getName();

        //Create new fixture for update and assertion
        Fixture dummyFixture = new Fixture();

        dummyFixture.setFixtureId(lastFixture.getFixtureId());
        dummyFixture.setFixtureStatus(lastFixture.getFixtureStatus());
        dummyFixture.setFootballFullState(lastFixture.getFootballFullState());

        //Create new team names with String
        String newTeamHome = "AC Milan";
        String newTeamAway = "Juventus";

        //Set the new teams name
        newFootballFullState.setAwayTeam(newTeamAway);
        newFootballFullState.setHomeTeam(newTeamHome);

        //Set the new teams name in the teams section
        List<Team> newTeams = new ArrayList<>();
        newTeams.add(teamHOME);
        newTeams.add(teamAWAY);
        teamHOME.setName(newTeamHome);
        teamAWAY.setName(newTeamAway);

        newFootballFullState.setTeams(newTeams);
        dummyFixture.setFootballFullState(newFootballFullState);

        //Change the last fixture in the List with the new fixture
        fixtureList.remove(fixtureList.size()-1);
        fixtureList.add(dummyFixture);


        //Send PUT method for each fixture in the List
        for (Fixture fixture : fixtureList) {
            response = given().accept(ContentType.JSON).
                    and().contentType(ContentType.JSON).
                    and().body(fixture).
                    when().put("/fixture");

            assertEquals(response.statusCode(),204);
        }

        //GET the changed fixture from API
        response = given().accept(ContentType.JSON).
                when().get("/fixture/" + dummyFixture.getFixtureId());

        //Store the changed elements for assertion from API
        Fixture fixtureAfterChange = response.body().as(Fixture.class);

        String AwayTeamAfterChanges = fixtureAfterChange.getFootballFullState().getAwayTeam();
        String HomeTeamAfterChanges = fixtureAfterChange.getFootballFullState().getHomeTeam();
        String HomeTeamFromTeamsSection2 = fixtureAfterChange.getFootballFullState().getTeams().get(0).getName();
        String AwayTeamFromTeamsSection2 = fixtureAfterChange.getFootballFullState().getTeams().get(1).getName();

        //Assert that Home team name has been changed
        assertNotEquals(HomeTeamBeforeChanges, HomeTeamAfterChanges);

        //Assert that Away team name has been changed
        assertNotEquals(AwayTeamBeforeChanges, AwayTeamAfterChanges);

        //Assert that Home team have been changed in Teams Section
        assertNotEquals(HomeTeamFromTeamsSection, HomeTeamFromTeamsSection2);

        //Assert that Away team have been changed in Teams Section
        assertNotEquals(AwayTeamFromTeamsSection, AwayTeamFromTeamsSection2);

    }

    @Test
    public void deleteFixture(){

        //Get the all fixtures first and store them in a List
        Response response = given().accept(ContentType.JSON).
                when().get("/fixtures");

        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(),"application/json; charset=utf-8");

        Fixture[] fixtures = response.body().as(Fixture[].class);
        List<Fixture> fixtureList = new ArrayList<>();
        fixtureList.addAll(Arrays.asList(fixtures));

        //DELETE the last fixture in API
        response = given().accept(ContentType.JSON).
                when().delete("/fixture/" + fixtureList.get(fixtureList.size()-1).getFixtureId());

        //GET and store the fixtures after DELETE action
        Response responseAfterDelete = given().accept(ContentType.JSON).
                when().get("/fixtures");

        assertEquals(responseAfterDelete.statusCode(),200);
        assertEquals(responseAfterDelete.contentType(),"application/json; charset=utf-8");

        Fixture[] fixturesAfterDelete = responseAfterDelete.body().as(Fixture[].class);
        List<Fixture> fixtureListAfterDelete = new ArrayList<>();
        fixtureListAfterDelete.addAll(Arrays.asList(fixturesAfterDelete));

        //Assert that last fixture in API has been deleted
        assertNotEquals(fixtureList.size(), fixtureListAfterDelete.size());


    }
}
