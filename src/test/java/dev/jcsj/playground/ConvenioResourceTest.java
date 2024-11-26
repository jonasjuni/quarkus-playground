package dev.jcsj.playground;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import dev.jcsj.playground.persistence.ConveniosClientesIntegracao;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
class ConvenioResourceTest {
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

    @Test
    void testValidaMCIConvenio() {
        var request = new ConveniosClientesIntegracao();

        request.codigoMCI = 1;
        request.numeroConvenio = 111;

        given()
                .when()
                .body(request)
                .contentType(ContentType.JSON)
                .post("/convenios/valida")
                .then()
                .statusCode(200);
    }
}
