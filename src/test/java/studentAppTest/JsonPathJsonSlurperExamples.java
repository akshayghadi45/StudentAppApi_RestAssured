package studentAppTest;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.List;

public class JsonPathJsonSlurperExamples {

    public static ValidatableResponse validatableResponse;
    @BeforeAll
    public static void init(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        //RestAssured.basePath = "/stores";
        validatableResponse = RestAssured.given().when().get("/stores").then();
    }
    @BeforeEach
    public void beforeEach(){
        System.out.println("before each");
        System.out.println(" ");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("after each");
        System.out.println(" ");
    }

    @Test
    public void getTotal(){
        int total = validatableResponse.extract().path("total");
        System.out.println("total: "+total);
    }
    @Test
    public void getFirstStoreName(){
        String storeName = validatableResponse.extract().path("data[0].name");
        System.out.println(storeName);
    }

    @Test
    public void getIdOfFirstServices(){
        int id = validatableResponse.extract().path("data[0].services[0].id");
        System.out.println("id: "+id);
    }

    @Test
    @DisplayName("Find Store with zip 55901")
    public void findStoreWithZip(){
        List<String> zipList = validatableResponse.extract().path("data.findAll{it.zip=='55901'}.name");
        System.out.println(zipList);
    }

}
