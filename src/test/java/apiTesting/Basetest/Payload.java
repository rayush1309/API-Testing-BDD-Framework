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
    public static  String coursePrice(){
        return "{\n" +
                "  \"dashboard\": {\n" +
                "    \"purchaseAmount\": 910,\n" +
                "    \"website\": \"rahulshettyacademy.com\"\n" +
                "  },\n" +
                "  \"courses\": [\n" +
                "    {\n" +
                "      \"title\": \"Selenium Java\",\n" +
                "      \"price\": 50,\n" +
                "      \"copies\": 6\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Core Java\",\n" +
                "      \"price\": 40,\n" +
                "      \"copies\": 4\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"REST API\",\n" +
                "      \"price\": 45,\n" +
                "      \"copies\": 10\n" +
                "    }\n" +
                "  ]\n" +
                "}\n";
    }
    public static String addBook(){
        String addBookRequestBody= "{\n" +
                "    \"name\": \"REST API Automation with Java\",\n" +
                "    \"isbn\": \"test\",\n" +
                "    \"aisle\": \"28788\",\n" +
                "    \"author\": \"Ayush Raj\"\n" +
                "}";
        return addBookRequestBody;
    }
}
