package steps.api.realcontroller;

import dto.SimulationZipJsonDTO;
import dto.SimulationZipXmlDTO;
import org.testng.annotations.Test;
import utils.GeneralUtils;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static requestspecification.RequestSpecificationFactory.*;
import static constants.Constants.*;

public class SimulationCorreios {

    @Test(groups = "funcional")
    public void mustReturn200_getZipJson() {

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

    @Test(groups = "funcional")
    public void mustReturn200_getZipXml() {

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

    @Test(groups = "funcional")
    public void mustReturn200_getAbstractZipJson() {

        assertThat(GeneralUtils.mustReturn200_getZipJson().getCep(), equalTo(ADRESS_ZIP));

    }

    @Test(groups = "funcional")
    public void mustReturn200_getAbstractZipXml() {

        assertThat(GeneralUtils.mustReturn200_getZipXml().getCep(), equalTo(ADRESS_ZIP));

    }

}
