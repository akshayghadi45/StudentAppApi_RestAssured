package studentAppTest;

import com.github.javafaker.Faker;
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
        Faker fake = new Faker();
        Student student = new Student();
        student.setFirstName(fake.name().firstName());
        student.setLastName(fake.name().lastName());
        student.setEmail(fake.internet().emailAddress());
        student.setProgramme(fake.commerce().department());
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
