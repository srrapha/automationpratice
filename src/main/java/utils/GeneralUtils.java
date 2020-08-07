package utils;

import datafactory.ProductDataFactory;
import dto.product.RegisterProductDTO;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static utils.ConstantsUtils.BASE_URL;

public class GeneralUtils {

    private static final ProductDataFactory product = new ProductDataFactory();


    public RegisterProductDTO mustReturn200_getGenericProductById (String id) {

           return given()
                .log().all()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .pathParam("id", id)
            .when()
                .get(BASE_URL.concat("/product/{id}"))
            .then()
                .log().all()
                .statusCode(SC_OK)
                .extract().response().as(RegisterProductDTO.class);

    }

    public void mustReturn200_getAllProducts () {

             given()
                .log().all()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
            .when()
                .get(BASE_URL.concat("/product"))
            .then()
                .log().all()
                .statusCode(SC_OK);

    }

    public RegisterProductDTO mustReturn200_registerGenericProduct () {

        return
            given()
                .log().all()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .body(product.buildProduct())
            .when()
                .post(BASE_URL.concat("/product"))
            .then()
                .log().all()
                .statusCode(SC_CREATED)
                .extract().response().as(RegisterProductDTO.class);

    }

    public RegisterProductDTO mustReturn201_updateProductById(String id){

       return
            given()
                .log().all()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .body(product.buildProduct())
                .pathParam("id",id)
            .when()
                .put(BASE_URL.concat("/product/{id}"))
            .then()
                .log().all()
                .statusCode(SC_OK)
                .extract().response().as(RegisterProductDTO.class);

    }

    public RegisterProductDTO mustReturn200_deleteGenericProductById (String id) {

        return
            given()
                .log().all()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .pathParam("id", id)
            .when()
                .delete(BASE_URL.concat("/product/{id}"))
            .then()
                .log().all()
                .statusCode(SC_OK)
                .extract().response().as(RegisterProductDTO.class);


    }

}
