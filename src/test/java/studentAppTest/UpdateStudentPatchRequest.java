package studentAppTest;
import com.github.javafaker.Faker;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.example.model.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UpdateStudentPatchRequest extends TestBase{

    @Test
    @DisplayName("Update Student patch ")
    public void updateStudentPatch(){
        Faker fake = new Faker();
        Student student =new Student();
        student.setEmail(fake.internet().emailAddress());

        given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(student)
                .patch("/101")
                .then()
                .statusCode(200);
    }
}
