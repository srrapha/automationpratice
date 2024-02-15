package steps.api.clientcontroller;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import dto.SimulationZipJsonDTO;
import dto.adress.RegisterAdressDTO;
import dto.client.RegisterClientDTO;
import io.restassured.http.ContentType;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.GeneralUtils;

import static constants.Constants.*;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

@Listeners({ExtentITestListenerClassAdapter.class})
public class DeleteClientTest {

    @Test(groups = "funcional")
    public void mustReturn201_deleteClientById(){

        SimulationZipJsonDTO zipJson = GeneralUtils.mustReturn200_getZipJsonWithParameter(ADRESS_ZIP);
        RegisterClientDTO registerClient = GeneralUtils.mustReturn200_registerGenericClient(ID_ONE, zipJson);

            given()
                .log().all()
                .contentType(APLICATION_JSON)
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .pathParam(ID,registerClient.getId())
            .when()
                .delete(BASE_PATH_URL_MOCK.concat(PATH_ADRESS_ID))
            .then()
                .statusCode(SC_OK);

    }

}
