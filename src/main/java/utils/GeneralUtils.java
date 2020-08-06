package utils;

import datafactory.ProductDataFactory;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static utils.ConstantsUtils.BASE_URL;

public class GeneralUtils {

    private static final ProductDataFactory product = new ProductDataFactory();


    public void mustReturn200_getGenericProductById (String id) {

            given()
                .log().all()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .pathParam("id", id)
            .when()
                .get(BASE_URL.concat("/product/{id}"))
            .then()
                .statusCode(SC_OK);

    }

    public void mustReturn200_registerGenericProductById (String name) {

            given()
                .log().all()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .body(product.buildProduct(name))
            .when()
                .post(BASE_URL.concat("/product"))
            .then()
                .statusCode(SC_OK);

    }

    public void mustReturn200_deleteGenericProductById (String id) {

            given()
                .log().all()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .pathParam("id", id)
            .when()
                .delete(BASE_URL.concat("/product/{id}"))
            .then()
                .statusCode(SC_OK);

    }

}
