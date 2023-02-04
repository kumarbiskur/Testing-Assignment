package com.vagrant.stepdefs;

import com.vagrant.common.CommonObject;
import com.vagrant.utils.Generics;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.util.ArrayList;

public class ValidateWicketKeeper {

    //Author - Kumar
    //Date of creation - 02/02/2023
    //Usage - Validating the Wicket Keeper player in the playing list


    public CommonObject baseObject;

    Generics generics = new Generics();
    JSONObject payLoad = null;


    @Given(": Read the response {string}to validate the wicket keeper")
    public void readTheResponseResponseToValidateTheWicketKeeper(String fileName) throws Throwable {

        payLoad = generics.getPayLoad(fileName);


    }

    @Then(": Validate playing list have only one wicket keeper")
    public void validatePlayingListHaveOnlyOneWicketKeeper() {

        ArrayList<String> wicketKeeperName = new ArrayList<String>();

        wicketKeeperName.add("Dinesh Karthik");



        JSONArray resPlayerLists= (JSONArray) payLoad.get("player");

        ArrayList<String> list = new ArrayList<String>();

        int count=0;
        for(int k=0;k<wicketKeeperName.size();k++)
        {
            for (int i = 0; i < resPlayerLists.size(); i++) {


                String resPlayerNameList = (String) ((JSONObject) resPlayerLists.get(i)).get("name");

                if(wicketKeeperName.get(k).equalsIgnoreCase(resPlayerNameList)) {

                    count++;

                }

            }
            Assert.assertEquals("Only Four Foregin Players Are In List:",1,count);


        }


    }


}
