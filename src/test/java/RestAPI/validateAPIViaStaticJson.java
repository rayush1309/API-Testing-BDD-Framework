package RestAPI;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class validateAPIViaStaticJson {
    /*
    // given: all input details
    //when - submit all the API - resource , Http Methos
    //Then - Validate the Response
    // content of the file(json) to String -> content of file can convert to Byte--> Byte data to String
     */
    @Test
    public void apiTestviaJsonFile() throws IOException {
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        // Read the content of the JSON file as a String
        String jsonContent = new String(Files.readAllBytes(Paths.get("resources/addPlace.json")));

        String response = given().log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(jsonContent) // Use the String content instead of bytes
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
    }

}
