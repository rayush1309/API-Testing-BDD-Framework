package apiTesting.Basetest;

public class Payload {

    public static String RequestBody(){
        return "{\n" +
                "    \"location\": {\n" +
                "        \"lat\": -38.383494,\n" +
                "        \"lng\": 33.427362\n" +
                "    },\n" +
                "    \"accuracy\": 50,\n" +
                "    \"name\": \"Ayush\",\n" +
                "    \"phone_number\": \"(+91) 983 39939 3993\",\n" +
                "    \"address\": \"HSR LayOUT\",\n" +
                "    \"types\": [\n" +
                "        \"IT park\",\n" +
                "        \"Software\"\n" +
                "    ],\n" +
                "    \"website\": \"http://google.com\",\n" +
                "    \"language\": \"French-IN\"\n" +
                "}";
    }
}
