package studentAppTest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static  io.restassured.RestAssured.*;

public class TestBase {
    @BeforeAll
    public static  void init(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8085;
        RestAssured.basePath = "/student";
    }
}
