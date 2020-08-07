package realcontroller;

import dto.SimulationZipJsonDTO;
import dto.SimulationZipXmlDTO;
import org.awaitility.Awaitility;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static requestspecification.RequestSpecificationFactory.*;

public class SimulationCorreios {


    @Test(groups = "funcional")
    public void mustReturn200_getZipJson() {

        String zip = "91350-110";

        SimulationZipJsonDTO responseJson = given()
                .spec(requestSpecificationJson())
                .pathParam("zip", zip)
                .when()
                .get("https://viacep.com.br/ws/{zip}/json")
                .then()
                .spec(responseSpecification())
                .statusCode(SC_OK)
                .assertThat()
                .body("cep", equalTo(zip))
                .extract().response().as(SimulationZipJsonDTO.class);

        System.out.println(responseJson);
        assertThat(responseJson.getCep(), equalTo(zip));


    }

    @Test(groups = "funcional")
    public void mustReturn200_getZipXml() {

        String zip = "91350-110";

        SimulationZipXmlDTO responseXml = given()
                .spec(requestSpecificationXml())
                .pathParam("zip", zip)
                .when()
                .get("https://viacep.com.br/ws/{zip}/xml")
                .then()
                .spec(responseSpecification())
                .statusCode(SC_OK)
                .extract().response().as(SimulationZipXmlDTO.class);

        System.out.println(responseXml);
        assertThat(responseXml.getCep(), equalTo(zip));

    }


}
