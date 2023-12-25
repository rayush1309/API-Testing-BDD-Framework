package RestAPI;
import apiTesting.Basetest.Payload;
import apiTesting.Basetest.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DynamicJson {
    @Test
    public void addBook(){
        RestAssured.baseURI="http://216.10.245.166";
        String response=given().log().all()
                .header("Content-Type","application/json")
                .body(Payload.addBook("REST_API","101"))
                .when()
                .post("/Library/Addbook.php")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .response()
                .asString();
        JsonPath js= ReusableMethods.rawToJson(response);
        String id= js.get("ID");
        System.out.println(id);


        //DELETE Book








    }
}
