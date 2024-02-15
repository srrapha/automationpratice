package utils;

import datafactory.AdressDataFactory;
import datafactory.ClientDataFactory;
import datafactory.ProductDataFactory;
import dto.SimulationZipJsonDTO;
import dto.SimulationZipXmlDTO;
import dto.adress.RegisterAdressDTO;
import dto.client.RegisterClientDTO;
import dto.product.RegisterProductDTO;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static requestspecification.RequestSpecificationFactory.*;
import static constants.Constants.*;
import static constants.Constants.ADRESS_ZIP;

public class GeneralUtils {

    private GeneralUtils(){}
    private static final ProductDataFactory product = new ProductDataFactory();
    private static final AdressDataFactory adress = new AdressDataFactory();
    private static final ClientDataFactory client = new ClientDataFactory();

    public static RegisterProductDTO mustReturn200_getGenericProductById (String id) {

           return given()
                        .log().all()
                        .contentType(APLICATION_JSON)
                        .accept(ContentType.JSON)
                        .relaxedHTTPSValidation()
                        .pathParam(ID, id)
                    .when()
                        .get(BASE_PATH_URL_MOCK.concat(PATH_PRODUCT_ID))
                    .then()
                        .log().all()
                        .statusCode(SC_OK)
                        .extract().response().as(RegisterProductDTO.class);

    }

    public static void mustReturn200_getAllProducts () {

             given()
                .log().all()
                .contentType(APLICATION_JSON)
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
            .when()
                .get(BASE_PATH_URL_MOCK.concat(PATH_PRODUCT))
            .then()
                .log().all()
                .statusCode(SC_OK);

    }

    public static RegisterProductDTO mustReturn200_registerGenericProduct () {

        return
            given()
                .log().all()
                .contentType(APLICATION_JSON)
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .body(product.buildProduct())
            .when()
                .post(BASE_PATH_URL_MOCK.concat(PATH_PRODUCT))
            .then()
                .log().all()
                .statusCode(SC_CREATED)
                .extract().response().as(RegisterProductDTO.class);

    }

    public static RegisterAdressDTO mustReturn200_registerGenericAdress (
                        String idClient, SimulationZipJsonDTO dataAdress) {

        return     given()
                        .log().all()
                        .contentType(APLICATION_JSON)
                        .accept(ContentType.JSON)
                        .relaxedHTTPSValidation()
                        .body(adress.buildAdress(idClient, dataAdress))
                    .when()
                        .post(BASE_PATH_URL_MOCK.concat(PATH_ADRESS))
                    .then()
                        .log().all()
                        .statusCode(SC_CREATED)
                        .extract().response().as(RegisterAdressDTO.class);

    }

    public static RegisterClientDTO mustReturn200_registerGenericClient (
            String idClient, SimulationZipJsonDTO dataClient) {

        return     given()
                .log().all()
                .contentType(APLICATION_JSON)
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .body(client.buildClient())
                .when()
                .post(BASE_PATH_URL_MOCK.concat(PATH_CLIENT))
                .then()
                .log().all()
                .statusCode(SC_CREATED)
                .extract().response().as(RegisterClientDTO.class);

    }


    public static RegisterProductDTO mustReturn201_updateProductById(String id){

       return
            given()
                .log().all()
                .contentType(APLICATION_JSON)
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .body(product.buildProduct())
                .pathParam(ID,id)
            .when()
                .put(BASE_PATH_URL_MOCK.concat(PATH_PRODUCT_ID))
            .then()
                .log().all()
                .statusCode(SC_OK)
                .extract().response().as(RegisterProductDTO.class);

    }

    public static RegisterProductDTO mustReturn200_deleteGenericProductById (String id) {

        return
            given()
                .log().all()
                .contentType(APLICATION_JSON)
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .pathParam(ID, id)
            .when()
                .delete(BASE_PATH_URL_MOCK.concat(PATH_PRODUCT_ID))
            .then()
                .log().all()
                .statusCode(SC_OK)
                .extract().response().as(RegisterProductDTO.class);


    }

    public static RegisterAdressDTO mustReturn200_getGenericAdressById (String id) {

        return
                given()
                        .log().all()
                        .contentType(APLICATION_JSON)
                        .accept(ContentType.JSON)
                        .relaxedHTTPSValidation()
                        .pathParam(ID, id)
                        .when()
                        .get(BASE_PATH_URL_MOCK.concat(PATH_ADRESS_ID))
                        .then()
                        .log().all()
                        .statusCode(SC_OK)
                        .extract().response().as(RegisterAdressDTO.class);


    }



    public static RegisterAdressDTO mustReturn200_deleteGenericAdressById (String id) {

        return
                given()
                        .log().all()
                        .contentType(APLICATION_JSON)
                        .accept(ContentType.JSON)
                        .relaxedHTTPSValidation()
                        .pathParam(ID, id)
                        .when()
                        .delete(BASE_PATH_URL_MOCK.concat(PATH_ADRESS_ID))
                        .then()
                        .log().all()
                        .statusCode(SC_OK)
                        .extract().response().as(RegisterAdressDTO.class);


    }

    public static SimulationZipJsonDTO mustReturn200_getZipJson() {

        return given()
                    .spec(requestSpecificationJson())
                    .pathParam(ZIP, ADRESS_ZIP)
                .when()
                    .get(PATH_URL_ZIP_JSON)
                .then()
                    .spec(responseSpecification())
                    .statusCode(SC_OK)
                    .extract().response().as(SimulationZipJsonDTO.class);

    }

    public static SimulationZipJsonDTO mustReturn200_getZipJsonWithParameter(String zip) {

        return given()
                    .spec(requestSpecificationJson())
                    .pathParam(ZIP, zip)
                .when()
                    .get(PATH_URL_ZIP_JSON)
                .then()
                    .spec(responseSpecification())
                    .statusCode(SC_OK)
                    .extract().response().as(SimulationZipJsonDTO.class);

    }

    public static SimulationZipXmlDTO mustReturn200_getZipXml() {

        return given()
                    .spec(requestSpecificationXml())
                    .pathParam(ZIP, ADRESS_ZIP)
                .when()
                    .get(PATH_URL_ZIP_XML)
                .then()
                    .spec(responseSpecification())
                    .statusCode(SC_OK)
                    .extract().response().as(SimulationZipXmlDTO.class);

    }

}
