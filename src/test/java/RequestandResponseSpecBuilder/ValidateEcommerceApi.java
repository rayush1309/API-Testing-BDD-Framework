package RequestandResponseSpecBuilder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.LoginRequest;
import pojo.LoginResponse;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ValidateEcommerceApi {

    private static final String BASE_URL = "https://rahulshettyacademy.com";
    private static String authToken;
    private static String productId;
    private static String orderId;

    @BeforeClass
    public void setup() {
        login();
        productId = addProduct();
        orderId = createOrder(productId);
    }

    @Test
    public void testDeleteProduct() {
        deleteProduct(productId);
    }

    private void login() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserEmail("ayushrajmr1301@gmail.com");
        loginRequest.setUserPassword("Test@123");

        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType(ContentType.JSON)
                .build();

        LoginResponse loginResponse = given().log().all().spec(req).body(loginRequest)
                .when().post("/api/ecom/auth/login")
                .then().log().all().extract().as(LoginResponse.class);

        authToken = loginResponse.getToken().toString();
    }

    private String addProduct() {
        File imageFile = new File("/Users/aushraj/Documents/productImage_1650649488046.jpeg");

        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .addHeader("Authorization", authToken)
                .build();

        Response response = given().log().all().spec(req)
                .param("productName", "Adidas-Shoes")
                .param("productAddedBy", "659004689fd99c85e8f8bddd")
                .param("productCategory", "household")
                .param("productSubCategory", "shoes")
                .param("productPrice", "31500")
                .param("productDescription", "ADIDAS ORIGINAL")
                .param("productFor", "men")
                .multiPart("productImage", imageFile)
                .when().post("/api/ecom/product/add-product");

        String productId = response.then().log().all().extract().path("productId");

        System.out.println("Product ID: " + productId);
        return productId;
    }

    private String createOrder(String productId) {
        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .addHeader("Authorization", authToken)
                .setContentType(ContentType.JSON)
                .build();

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setCountry("India");
        orderDetail.setProductOrderedId(productId);

        List<OrderDetail> orderDetailList = new ArrayList<>();
        orderDetailList.add(orderDetail);

        Orders orders = new Orders();
        orders.setOrders(orderDetailList);

        Response response = given().log().all().spec(req).body(orders)
                .when().post("/api/ecom/order/create-order");

        String orderId = response.then().log().all().extract().path("orderId");

        System.out.println("Order ID: " + orderId);
        return orderId;
    }

    private void deleteProduct(String productId) {
        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .addHeader("Authorization", authToken)
                .setContentType(ContentType.JSON)
                .build();

        Response response = given().log().all().spec(req)
                .pathParam("productId", productId)
                .when().delete("/api/ecom/product/delete-product/{productId}");

        JsonPath jsonPath = response.then().log().all().extract().jsonPath();
        Assert.assertEquals("Product Deleted Successfully", jsonPath.getString("message"));
    }
}
