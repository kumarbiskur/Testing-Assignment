package com.vagrant.utils;

import com.vagrant.basics.TestConfig;


import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;


public class Generics {

    //Author - Kumar
    //Date of creation - 02/02/2023
    //Usage - Common Funcaiton and method is defined

    ObjectMapper mapper = new ObjectMapper();

    public JSONObject getPayLoad(String path) throws Throwable {
        JSONObject data = null;
        try {
            JSONParser parser = new JSONParser();
            FileReader fileReader = new FileReader(getPayLoadPath(path));
            data = (JSONObject) parser.parse(fileReader);

        } catch (Exception e) {
            Assert.fail("File is not found " + e.getMessage());
        }
        return data;
    }

    public String getPayLoadPath(String path) throws Throwable {
        String completePath;
        String modifiedPath = "";
        String[] arrayPath;
        int loop;
        try {
            arrayPath = path.split("/");
            for (loop = 0; loop < arrayPath.length; loop++) {
                modifiedPath = modifiedPath + TestConfig.PathSeparator + arrayPath[loop];
            }

            completePath = TestConfig.baseDir + TestConfig.PathSeparator + "src" + TestConfig.PathSeparator
                    + "test" + TestConfig.PathSeparator + "resources" + TestConfig.PathSeparator + "response"
                    + modifiedPath + ".json";

            return completePath;
        } catch (Throwable t) {
            throw t;
        }
    }

    public JsonNode getJsonObject(String jsonString) {
        JsonNode jsonObj = null;
        try {
            jsonObj = mapper.readTree(jsonString.replaceAll("\\\\", ""));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObj;
    }

    public String getCurrentTime(String timeFormat) throws Throwable {
        String dtmCurrentTimeInfo;
        try {
            // Current Time Is Generated
            Date date = new Date();
            DateFormat timeformat = new SimpleDateFormat(timeFormat);
            dtmCurrentTimeInfo = timeformat.format(date);
            return dtmCurrentTimeInfo;

        } catch (Throwable t) {
            throw t;
        }

    }

    public String getCurrentDate(String dateFormat) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(cal.getTime());
    }
}