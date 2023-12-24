package apiTesting.Basetest;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {
    public static JsonPath rawToJson(String response){
        JsonPath jsonPath = new JsonPath(response);//convert String to Json
        return jsonPath;


    }
}
