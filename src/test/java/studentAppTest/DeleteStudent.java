package studentAppTest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static  io.restassured.RestAssured.*;

public class DeleteStudent extends TestBase {
    @Test
    @DisplayName("Delete Student by id")
    public void testDeleteStudent() {
        given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .delete("/101")
                .then()
                .statusCode(204);
    }
}
