package studentAppTest;

import io.restassured.http.ContentType;
import org.example.model.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class CreateStudentPOJOPayload extends TestBase {
    @Test
    @DisplayName("Create new Student by sending a payload as string")
    void createNewStudent(){
        Student student = new Student();
        student.setFirstName("test3");
        student.setLastName("User3");
        student.setEmail("test33@gmail.com");
        student.setProgramme("Computer Science");
        student.setCources(List.of("c++","java"));

        given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(student)
                .post()
                .then()
                .statusCode(201);
    }
}
