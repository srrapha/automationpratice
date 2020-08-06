import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.internal.matcher.xml.XmlXsdMatcher.matchesXsdInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static requestspecification.RequestSpecificationFactory.responseSpecification;
import static utils.ConstantsUtils.*;

@Listeners({ExtentITestListenerClassAdapter.class})
public class ContractsTest {

    @Test(groups = "contract")
    public void deveRetornar200_clientContract() {

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
    public void deveRetornar200_productContractFailed() {

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
    public void deveRetornar200_adressContract() {

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
    public void deveRetornar200_zipContract() {

        String zip = "91350110";

        given()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .pathParam("zip",zip)
            .when()
                .get(BASE_URL_ZIP.concat("/{zip}/json"))
            .then()
                .spec(responseSpecification())
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("json_schema/simulationZip.json"));

    }

    @Test(groups = "contract")
    public void deveRetornar200_zipXmlContract() {

        String zip = "91350110";

        given()
                .contentType("application/xml")
                .accept(ContentType.XML)
                .relaxedHTTPSValidation()
                .pathParam("zip",zip)
            .when()
                .get(BASE_URL_ZIP.concat("/{zip}/xml"))
            .then()
                .spec(responseSpecification())
                .statusCode(HttpStatus.SC_OK)
                .body(matchesXsdInClasspath("xml_schema/simulationZip.xml"));

    }

}
