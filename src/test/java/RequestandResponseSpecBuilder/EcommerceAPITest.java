package RequestandResponseSpecBuilder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import pojo.LoginRequest;
import pojo.LoginResponse;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class EcommerceAPITest {
    public static void main(String[] args) {
            LoginRequest loginRequest = new LoginRequest();
           // given().relaxedHTTPSValidation(): it API call will encounter any SSL certification it will by pass
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
                            .param("productName", "Adidas-Shoes")
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

            // extracting product id
            String productId = jsonPath.getString("productId");
            System.out.println("Product ID: " + productId);

            //65902b8b9fd99c85e8f8ea9a
         // 659031d99fd99c85e8f8efb9
        // create order
        RequestSpecification createOrderBasereq=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addHeader("Authorization", token).setContentType(ContentType.JSON).build();
        OrderDetail orderDetail= new OrderDetail();
        orderDetail.setCountry("India");
        orderDetail.setProductOrderedId(productId);
        List<OrderDetail> orderDetailList=new ArrayList<>();
        orderDetailList.add(orderDetail);
        Orders orders= new Orders();
        orders.setOrders(orderDetailList);
        RequestSpecification createOrderReq =
                given()
                .log().all()
                .spec(createOrderBasereq)
                .body(orders);
      String responseAddOrder=  createOrderReq
                .when()
                .post("/api/ecom/order/create-order")
                .then()
                .log().all()
                .extract()
                .response()
                .asString();
        System.out.println(responseAddOrder);

        //Delete
        RequestSpecification deleteOrderBaseReq = new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .addHeader("Authorization", token)
                .setContentType(ContentType.JSON)
                .build();

        RequestSpecification deleteProdReq = given()
                .log().all()
                .spec(deleteOrderBaseReq)
                .pathParam("productId", productId);

        String deleteProductResponse = deleteProdReq
                .when()
                .delete("/api/ecom/product/delete-product/{productId}")
                .then()
                .log().all()
                .extract()
                .response()
                .asString();

        JsonPath jsonPath1 = new JsonPath(deleteProductResponse);
        Assert.assertEquals("Product Deleted Successfully",jsonPath1.get("message"));








    }
}
