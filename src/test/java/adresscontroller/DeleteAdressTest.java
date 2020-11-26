package adresscontroller;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import dto.SimulationZipJsonDTO;
import dto.adress.RegisterAdressDTO;
import io.restassured.http.ContentType;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.GeneralUtils;

import static constants.Constants.*;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

@Listeners({ExtentITestListenerClassAdapter.class})
public class DeleteAdressTest {

    @Test(groups = "funcional")
    public void mustReturn201_deleteAdressById(){

        SimulationZipJsonDTO zipJson = GeneralUtils.mustReturn200_getZipJsonWithParameter(ADRESS_ZIP);
        RegisterAdressDTO registerAdress = GeneralUtils.mustReturn200_registerGenericAdress(ID_ONE, zipJson);

            given()
                .log().all()
                .contentType(APLICATION_JSON)
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .pathParam(ID,registerAdress.getId())
            .when()
                .delete(BASE_PATH_URL_MOCK.concat(PATH_ADRESS_ID))
            .then()
                .statusCode(SC_OK);

    }

}
