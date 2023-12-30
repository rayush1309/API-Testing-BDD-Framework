package RequestandResponseSpecBuilder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import pojo.LoginRequest;
import pojo.LoginResponse;

import java.io.File;

import static io.restassured.RestAssured.given;

public class EcommerceAPITest {
    public static void main(String[] args) {
        try {
            LoginRequest loginRequest = new LoginRequest();
            loginRequest.setUserEmail("ayushrajmr1301@gmail.com");
            loginRequest.setUserPassword("Test@123");
            RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                    .setContentType(ContentType.JSON).build();
            RequestSpecification reqLogin = given().log().all().spec(req).body(loginRequest);
            LoginResponse loginResponse = reqLogin
                    .when()
                    .post("/api/ecom/auth/login")
                    .then().log().all()
                    .extract()
                    .response().as(LoginResponse.class);

            String token = loginResponse.getToken().toString();

            // Add product
            RequestSpecification addProductBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                    .addHeader("Authorization", token)
                    .build();
            RequestSpecification reqAddingProduct =
                    given().log().all()
                            .spec(addProductBaseReq)
                            .param("productName", "Shoes")
                            .param("productAddedBy", "659004689fd99c85e8f8bddd")
                            .param("productCategory", "household")
                            .param("productSubCategory", "shoes")
                            .param("productPrice", "31500")
                            .param("productDescription", "ADIDAS ORIGINAL")
                            .param("productFor", "men")
                            .multiPart("productImage", new File("/Users/aushraj/Documents/productImage_1650649488046.jpeg"));

            String addProductresponse = reqAddingProduct
                    .when()
                    .post("/api/ecom/product/add-product")
                    .then().log().all()
                    .extract()
                    .response()
                    .asString();

            // converting String to Json
            JsonPath jsonPath = new JsonPath(addProductresponse);

            // Correcting productId extraction
            String productId = jsonPath.getString("productId");
            System.out.println("Product ID: " + productId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
