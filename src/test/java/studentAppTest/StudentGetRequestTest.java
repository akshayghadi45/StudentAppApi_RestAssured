package studentAppTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;


public class StudentGetRequestTest extends TestBase{

    @Test
    public void getAllStudents(){
        RequestSpecification requestSpec = RestAssured.given();
        Response response = requestSpec.get("http://localhost:8085/student/list");
        response.prettyPrint();
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);

        given()
                .when()
                .get("/list")
                .then()
                .statusCode(200);

    }

    @Test
    @DisplayName("Get Single CS Student from the list")
    public void getSingleCSStudent() {
        Response response = given()
                //query params can also be provided with a map
                .queryParam("programme", "Computer Science")
                .queryParam("limit", 1)
                .when()
                .get("/list");

        response.prettyPrint();
    }

    @Test
    @DisplayName("Get Single CS Student from the list")

    public void getStudentById(){
        Response response = given()
                .pathParam("id", 1)
                .when()
                .get("/{id}");
        response.prettyPrint();
    }
}
