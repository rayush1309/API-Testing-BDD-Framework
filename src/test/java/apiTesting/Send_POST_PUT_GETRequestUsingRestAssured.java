package apiTesting;

import apiTesting.file.Payload;
import apiTesting.file.ReusableMethods;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static org.hamcrest.Matchers.*;


public class Send_POST_PUT_GETRequestUsingRestAssured {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
      String response=  given().log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(Payload.RequestBody())
                .when()
                .post("/maps/api/place/add/json")
                // Response Validation --Then
                .then()
                .assertThat()
                .statusCode(200)
                .body("scope", equalTo("APP"))
                .header("Server", equalTo("Apache/2.4.52 (Ubuntu)"))
                .extract()
                .response()
                .asString();
        System.out.println(response);
        //Json Path Class ->takes the Input as String and Convert it into Json.
        //it help us to Parse Json
        JsonPath jsonPath= new JsonPath(response); //for Parsing Json
        String placeId = jsonPath.get("place_id");
        System.out.println(placeId);

        //update Place ;
        String newAddress = "6th Cross CV Raman Nagar, India";
        given()
                .log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"place_id\": \"" +
                        "" + placeId + "\",\n" +
                        "    \"address\": \"" + newAddress + "\",\n" +
                        "    \"key\": \"qaclick123\"\n" +
                        "}")
                .when()
                .put("/maps/api/place/update/json")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("msg", equalTo("Address successfully updated"));


        //Get Place
        String getPlaceResponse = given()
                .log().all()
                .queryParam("key", "qaclick123")
                .queryParam("place_id", placeId)
                .when()
                .get("/maps/api/place/get/json")
                .then()
                .assertThat()
                .log().all()
                .statusCode(200)
                .extract()
                .response()
                .asString();
        JsonPath jp=ReusableMethods.rawToJson(getPlaceResponse);
        String actualAddress= jp.getString("address");
        System.out.println(actualAddress);
        Assert.assertEquals(actualAddress,newAddress);
        // Add Place --> Update Place with New Address --> Get Place to Validate New Address is present in the Response


    }
}
