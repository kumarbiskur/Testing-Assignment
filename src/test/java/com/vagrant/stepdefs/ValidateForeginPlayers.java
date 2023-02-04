package com.vagrant.stepdefs;


import com.fasterxml.jackson.databind.JsonNode;
import com.vagrant.common.CommonObject;
import com.vagrant.utils.Generics;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.util.ArrayList;


public class ValidateForeginPlayers {

    //Author - Kumar
    //Date of creation - 02/02/2023
    //Usage - Validating the foregin player in the playing list


    public CommonObject baseObject;

    Generics generics = new Generics();
    JSONObject payLoad = null;


    @Given(": Read the response {string} to validate the foreign players")
    public void readTheResponseResponseToValidateTheForeignPlayers(String fileName) throws Throwable {


        payLoad = generics.getPayLoad(fileName);


    }

    @Then(": Validate playing list have only four foreign players")
    public void validatePlayingListHaveOnlyFourForeignPlayers() {
        ArrayList<String> foreignPlayersNameList = new ArrayList<String>();

        foreignPlayersNameList.add("Faf Du Plessis");
        foreignPlayersNameList.add("Glenn Maxwell");
        foreignPlayersNameList.add("Wanindu Hasaranga");
        foreignPlayersNameList.add("Josh Hazlewood");


        JSONArray resPlayerLists = (JSONArray) payLoad.get("player");

        int count = 0;
        for (int k = 0; k < foreignPlayersNameList.size(); k++) {
            for (int i = 0; i < resPlayerLists.size(); i++) {


                String resPlayerNameList = (String) ((JSONObject) resPlayerLists.get(i)).get("name");

                if (foreignPlayersNameList.get(k).equalsIgnoreCase(resPlayerNameList)) {

                    count++;

                }

            }

        }
        Assert.assertEquals("Only Four Foregin Players Are In List:", 4, count);


    }


}














