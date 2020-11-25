package utils;

import datafactory.ProductDataFactory;
import dto.SimulationZipJsonDTO;
import dto.SimulationZipXmlDTO;
import dto.product.RegisterProductDTO;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static requestspecification.RequestSpecificationFactory.*;
import static utils.ConstantsUtils.*;
import static utils.ConstantsUtils.ADRESS_ZIP;

public class GeneralUtils {

    private static final ProductDataFactory product = new ProductDataFactory();

    public static RegisterProductDTO mustReturn200_getGenericProductById (String id) {

           return given()
                .log().all()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .pathParam("id", id)
            .when()
                .get(BASE_PATH_URL_MOCK.concat("/product/{id}"))
            .then()
                .log().all()
                .statusCode(SC_OK)
                .extract().response().as(RegisterProductDTO.class);

    }

    public static void mustReturn200_getAllProducts () {

             given()
                .log().all()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
            .when()
                .get(BASE_PATH_URL_MOCK.concat("/product"))
            .then()
                .log().all()
                .statusCode(SC_OK);

    }

    public static RegisterProductDTO mustReturn200_registerGenericProduct () {

        return
            given()
                .log().all()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .body(product.buildProduct())
            .when()
                .post(BASE_PATH_URL_MOCK.concat("/product"))
            .then()
                .log().all()
                .statusCode(SC_CREATED)
                .extract().response().as(RegisterProductDTO.class);

    }

    public static RegisterProductDTO mustReturn201_updateProductById(String id){

       return
            given()
                .log().all()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .body(product.buildProduct())
                .pathParam("id",id)
            .when()
                .put(BASE_PATH_URL_MOCK.concat("/product/{id}"))
            .then()
                .log().all()
                .statusCode(SC_OK)
                .extract().response().as(RegisterProductDTO.class);

    }

    public static RegisterProductDTO mustReturn200_deleteGenericProductById (String id) {

        return
            given()
                .log().all()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .pathParam("id", id)
            .when()
                .delete(BASE_PATH_URL_MOCK.concat("/product/{id}"))
            .then()
                .log().all()
                .statusCode(SC_OK)
                .extract().response().as(RegisterProductDTO.class);


    }

    public static SimulationZipJsonDTO mustReturn200_getZipJson() {

        return given()
                    .spec(requestSpecificationJson())
                    .pathParam("zip", ADRESS_ZIP)
                .when()
                    .get(PATH_URL_ZIP_JSON)
                .then()
                    .spec(responseSpecification())
                    .statusCode(SC_OK)
                    .assertThat()
                    .body("cep", equalTo(ADRESS_ZIP))
                    .extract().response().as(SimulationZipJsonDTO.class);

    }

    public static SimulationZipXmlDTO mustReturn200_getZipXml() {

        return given()
                    .spec(requestSpecificationXml())
                    .pathParam("zip", ADRESS_ZIP)
                .when()
                    .get(PATH_URL_ZIP_XML)
                .then()
                    .spec(responseSpecification())
                    .statusCode(SC_OK)
                    .extract().response().as(SimulationZipXmlDTO.class);

    }

}
