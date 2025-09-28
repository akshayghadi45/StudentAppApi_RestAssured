package loggingExamples;

import org.junit.jupiter.api.Test;
import studentAppTest.TestBase;

import static io.restassured.RestAssured.*;


public class LoggingResponsesValues extends TestBase {

    @Test
    public void test001(){
        System.out.println("---Printing response status from response start----");
        given()
                .params("programme", "Computer Science")
                .params("limit",1)
                .when()
                .get("/1")
                .then()
                .log()
                .status()
                .statusCode(200);
        System.out.println("---Printing response status from response end----");

    }
    @Test
    public void test002(){
        System.out.println("---Printing headers from response start----");
        given()
                .params("programme", "Computer Science")
                .params("limit",1)
                .when()
                .get("/1")
                .then()
                .log()
                .headers()
                .statusCode(200);
        System.out.println("---Printing headers from response end----");

    }

    @Test
    public void test003(){
        System.out.println("---Printing response body from response start----");
        given()
                .params("programme", "Computer Science")
                .params("limit",1)
                .when()
                .get("/1")
                .then()
                .log()
                .body()
                .statusCode(200);
        System.out.println("---Printing response body from response end----");

    }

    @Test
    public void test004(){
        System.out.println("---Printing response body from response start----");
        given()
                .params("programme", "Computer Science")
                .params("limit",1)
                .when()
                .get("/1000")
                .then()
                .log()
                .ifError()
                .statusCode(200);
        System.out.println("---Printing response body from response end----");

    }
}
