package steps.api;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static constants.Paths.*;
import static io.restassured.RestAssured.given;
import static io.restassured.internal.matcher.xml.XmlXsdMatcher.matchesXsdInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static requestspecification.RequestSpecificationFactory.responseSpecification;
import static constants.Constants.*;

@Listeners({ExtentITestListenerClassAdapter.class})
public class ContractsTest {

    @Test(groups = "contract")
    public void mustReturn200ClientContract() {

            given()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
            .when()
                .get("http://5f2700420824d8001655ee0b.mockapi.io/api/v1/client")
            .then()
                .spec(responseSpecification())
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("json_schema/clientContract.json"));

    }

    @Test(groups = "contract")
    public void mustReturn200ProductContract() {

            given()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
            .when()
                .get("http://5f2700420824d8001655ee0b.mockapi.io/api/v1/product")
            .then()
                .spec(responseSpecification())
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("json_schema/productContract.json"));

    }

    @Test(groups = "contract")
    public void mustReturn200AdressContract() {

            given()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
            .when()
            .get("http://5f2700420824d8001655ee0b.mockapi.io/api/v1/adress")
            .then()
                .spec(responseSpecification())
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("json_schema/adressContract.json"));

    }

    @Test(groups = "contract")
    public void mustReturn200ZipJsonContract() {

        given()
                .contentType(APLICATION_JSON)
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .pathParam(ZIP,ADRESS_ZIP)
            .when()
                .get(BASE_PATH_URL_ZIP.concat(PATH_URL_ZIP_JSON))
            .then()
                .spec(responseSpecification())
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("json_schema/simulationZip.json"));

    }

    @Test(groups = "contract")
    public void mustReturn200ZipXmlContract() {

        given()
                .contentType(APLICATION_XML)
                .accept(ContentType.XML)
                .relaxedHTTPSValidation()
                .pathParam(ZIP, ADRESS_ZIP)
            .when()
                .get(BASE_PATH_URL_ZIP.concat(PATH_URL_ZIP_XML))
            .then()
                .spec(responseSpecification())
                .statusCode(HttpStatus.SC_OK)
                .body(matchesXsdInClasspath("xml_schema/simulationZip.xml"));

    }

}
