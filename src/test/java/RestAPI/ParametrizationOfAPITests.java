package RestAPI;

import apiTesting.Basetest.Payload;
import apiTesting.Basetest.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ParametrizationOfAPITests {
    @Test(dataProvider = "booksData")
    public void addBook(String isbn, String aisle) {
        RestAssured.baseURI = "http://216.10.245.166";
        String response = given().log().all()
                .header("Content-Type", "application/json")
                .body(Payload.addBook(isbn, aisle))
                .when()
                .post("/Library/Addbook.php")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .response()
                .asString();
        JsonPath js = ReusableMethods.rawToJson(response);
        String id = js.get("ID");
        System.out.println(id);


        //DELETE Book


    }
    @DataProvider(name="booksData")
    public Object[][] getData(){
        //array--> collection of Elements
        //create MultiDimensional Array--> collection of Array
        return new Object [][]{{"REST_API","01"},{"SOAP_API","02"},{"Test_API","03"}};

    }

}