package studentAppTest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class CreateStudentStringPayload extends TestBase{
    @Test
    @DisplayName("Create new Student by sending a payload as string")
    void createNewStudent(){
        String payload = "{\"firstName\":\"test2\",\"lastName\":\"User\",\"email\":\"test@gmail.com\",\"programme\":\"Computer Science\",\"cources\":[\"c++\",\"java\"]}";
        given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(payload)
                .post()
                .then()
                .statusCode(201);
    }
}
