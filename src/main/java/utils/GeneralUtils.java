package utils;

import com.github.javafaker.Faker;
import datafactory.AdressDataFactory;
import datafactory.ClientDataFactory;
import datafactory.OrderDataFactory;
import datafactory.ProductDataFactory;
import dto.SimulationZipJsonDTO;
import dto.SimulationZipXmlDTO;
import dto.adress.RegisterAdressDTO;
import dto.client.RegisterClientDTO;
import dto.product.RegisterProductDTO;
import io.restassured.http.ContentType;

import java.util.Locale;

import static constants.Paths.*;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static requestspecification.RequestSpecificationFactory.*;
import static constants.Constants.*;
import static constants.Constants.ADRESS_ZIP;

public class GeneralUtils {
    private GeneralUtils(){}

    public static final ProductDataFactory product = new ProductDataFactory();
    public static final AdressDataFactory adress = new AdressDataFactory();
    public static final ClientDataFactory client = new ClientDataFactory();
    public static final OrderDataFactory order = new OrderDataFactory();
    public static final Faker brFk = new Faker(new Locale("pt-BR"));

    public static RegisterProductDTO mustReturn200GetGenericProductById(String id) {

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

    public static void mustReturn200GetAllProducts() {

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

    public static RegisterProductDTO mustReturn200RegisterGenericProduct() {

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

    public static RegisterAdressDTO mustReturn200RegisterGenericAdress(
                        SimulationZipJsonDTO dataAdress) {

        return     given()
                        .log().all()
                        .contentType(APLICATION_JSON)
                        .accept(ContentType.JSON)
                        .relaxedHTTPSValidation()
                        .body(adress.buildAdress(dataAdress))
                    .when()
                        .post(BASE_PATH_URL_MOCK.concat(PATH_ADRESS))
                    .then()
                        .log().all()
                        .statusCode(SC_CREATED)
                        .extract().response().as(RegisterAdressDTO.class);

    }

    public static RegisterClientDTO mustReturn200RegisterGenericClient( SimulationZipJsonDTO dataClient) {

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


    public static RegisterProductDTO mustReturn201UpdateProductById(String id){

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

    public static RegisterProductDTO mustReturn200DeleteGenericProductById(String id) {

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

    public static RegisterAdressDTO mustReturn200GetGenericAdressById(String id) {

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



    public static RegisterAdressDTO mustReturn200DeleteGenericAdressById(String id) {

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

    public static SimulationZipJsonDTO mustReturn200GetZipJson() {

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

    public static SimulationZipJsonDTO mustReturn200GetZipJsonWithParameter(String zip) {

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

    public static SimulationZipXmlDTO mustReturn200GetZipXml() {

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
