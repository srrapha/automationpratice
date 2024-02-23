package steps.api.realcontroller;

import dto.SimulationZipJsonDTO;
import dto.SimulationZipXmlDTO;
import org.testng.annotations.Test;
import utils.GeneralUtils;

import static constants.Paths.*;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static requestspecification.RequestSpecificationFactory.*;
import static constants.Constants.*;

public class SimulationCorreiosTest {

    @Test(groups = "functional")
    public void mustReturn200GetZipJson() {

        SimulationZipJsonDTO responseJson =
                given()
                    .spec(requestSpecificationJson())
                    .pathParam(ZIP, ADRESS_ZIP)
                .when()
                    .get(PATH_URL_ZIP_JSON)
                .then()
                    .spec(responseSpecification())
                    .statusCode(SC_OK)
                    .assertThat()
                    .body(PATH_CEP, equalTo(ADRESS_ZIP))
                    .extract().response().as(SimulationZipJsonDTO.class);

        System.out.println(responseJson);
        assertThat(responseJson.getCep(), equalTo(ADRESS_ZIP));

    }

    @Test(groups = "functional")
    public void mustReturn200GetZipXml() {

        SimulationZipXmlDTO responseXml =
                given()
                    .spec(requestSpecificationXml())
                    .pathParam("zip", ADRESS_ZIP)
                .when()
                    .get(PATH_URL_ZIP_XML)
                .then()
                    .spec(responseSpecification())
                    .statusCode(SC_OK)
                    .extract().response().as(SimulationZipXmlDTO.class);

        System.out.println(responseXml);
        assertThat(responseXml.getCep(), equalTo(ADRESS_ZIP));

    }

    @Test(groups = "functional")
    public void mustReturn200GetAbstractZipJson() {

        assertThat(GeneralUtils.mustReturn200GetZipJson().getCep(), equalTo(ADRESS_ZIP));

    }

    @Test(groups = "functional")
    public void mustReturn200GetAbstractZipXml() {

        assertThat(GeneralUtils.mustReturn200GetZipXml().getCep(), equalTo(ADRESS_ZIP));

    }

}
