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

    @Test
    @DisplayName("Get address of the store with zip 55901")
    public void getAddressOfStoreWithZip() {
        List<String> addressList = validatableResponse.extract().path("data.findAll{it.zip=='55901'}.address");
        System.out.println(addressList);

    }

    @Test
    @DisplayName("Get All the info of store with max and min id")
    public void getStoreMaxAndMinId(){
        HashMap<String,Object> storeMax = validatableResponse.extract().path("data.max{it.id}");
        System.out.println(storeMax);
        HashMap<String,Object>  storeMin = validatableResponse.extract().path("data.min{it.id}");
        System.out.println(storeMin);

    }

    @Test
    @DisplayName("Get all store states with ids less than 10")
    public void getAllStoreStatesWithIdsLessThanTen(){
        List<String> states = validatableResponse.extract().path("data.findAll{it.id<10}.state");
        System.out.println(states);
    }

    @Test
    @DisplayName("Get all the service name for all the stores")
    public void getAllServiceNames(){
        List<String> serviceNames = validatableResponse.extract().path("data.services.findAll{it.name}name");
        System.out.println(serviceNames);
    }

}
