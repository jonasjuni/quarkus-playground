package dev.jcsj.playground;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ConvenioResourceTest {
    @Test
    void testGetNumeroConvenio() {
        given()
                .when().get("/convenios/111")
                .then()
                .statusCode(200)
                .body(
                        "name", is("TJSP"));
    }

    @Test
    void testListConvenio() {
        given()
                .when().get("/convenios")
                .then()
                .statusCode(200);
    }
}
