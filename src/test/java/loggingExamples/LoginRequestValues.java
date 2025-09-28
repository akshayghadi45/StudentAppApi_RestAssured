package loggingExamples;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import org.example.model.Student;
import org.junit.jupiter.api.Test;
import studentAppTest.TestBase;

import java.util.List;

import static io.restassured.RestAssured.*;

public class LoginRequestValues extends TestBase {

    /// This test will print all the request headers
    @Test
    public void test001(){
        System.out.println("---Priting headers start----");
        given()
                .log()
                .headers()
                .when()
                .get("/1")
                .then()
                .statusCode(200);
        System.out.println("---Priting headers end----");

    }

    /// This test will print all the request params
    @Test
    public void test002(){
        System.out.println("---Priting params start----");
        given()
                .params("programme", "Computer Science")
                .params("limit",1)
                .log()
                .params()
                .when()
                .get("/1")
                .then()
                .statusCode(200);
        System.out.println("---Priting params end----");

    }

    @Test
    public void test003(){

        Faker fake = new Faker();
        Student student = new Student();
        student.setFirstName(fake.name().firstName());
        student.setLastName(fake.name().lastName());
        student.setEmail(fake.internet().emailAddress());
        student.setProgramme(fake.commerce().department());
        student.setCources(List.of("c++","java"));

        System.out.println("------Printing body start-------");
        given()
                .when()
                .contentType(ContentType.JSON)
                .log()
                .body()
                .when()
                .body(student)
                .post()
                .then()
                .statusCode(201);
        System.out.println("------Printing body Ends-------");
    }

    @Test
    public void test004(){

        Faker fake = new Faker();
        Student student = new Student();
        student.setFirstName(fake.name().firstName());
        student.setLastName(fake.name().lastName());
        student.setEmail(fake.internet().emailAddress());
        student.setProgramme(fake.commerce().department());
        student.setCources(List.of("c++","java"));

        System.out.println("------Printing All details start-------");
        given()
                .when()
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .body(student)
                .post()
                .then()
                .statusCode(201);
        System.out.println("------Printing all details Ends-------");
    }

    @Test
    public void test005(){

        Faker fake = new Faker();
        Student student = new Student();
        student.setFirstName(fake.name().firstName());
        student.setLastName(fake.name().lastName());
        student.setEmail(fake.internet().emailAddress());
        student.setProgramme(fake.commerce().department());
        student.setCources(List.of("c++","java"));
        System.out.println("---Priting All only if test fails start----");

        given()
                .when()
                .contentType(ContentType.JSON)
                .log()
                .ifValidationFails()
                .when()
                .body(student)
                .post()
                .then()
                .statusCode(201);
        System.out.println("------Priting All only if test fails-------");
    }


}
