package pojo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.Courses;

import java.io.File;

import static io.restassured.RestAssured.given;

public class ValidatePostMethod {
    public static void main(String[] args) {
        // Setting base URI
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Creating a new instance of GetCourses
        GetCourses getCourses = new GetCourses();

        // Specifying the JSON file path
        File jsonFile = new File("resources/getCourse.json");

        // Making a POST request and extracting the response
        Response response = given()
                .body(jsonFile)
                .post("/posts");

        // Extracting the response body as GetCourses object
        GetCourses responseCourses = response.then()
                .extract()
                .as(GetCourses.class);
    }
}
