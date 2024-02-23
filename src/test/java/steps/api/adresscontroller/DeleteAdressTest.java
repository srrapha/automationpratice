package steps.api.adresscontroller;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import dto.SimulationZipJsonDTO;
import dto.adress.RegisterAdressDTO;
import io.restassured.http.ContentType;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static constants.Constants.*;
import static constants.Paths.BASE_PATH_URL_MOCK;
import static constants.Paths.PATH_ADRESS_ID;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static utils.GeneralUtils.mustReturn200GetZipJsonWithParameter;
import static utils.GeneralUtils.mustReturn200RegisterGenericAdress;

@Listeners({ExtentITestListenerClassAdapter.class})
public class DeleteAdressTest {

    @Test(groups = "funcional")
    public void mustReturn201_deleteAdressById(){

        SimulationZipJsonDTO zipJson = mustReturn200GetZipJsonWithParameter(ADRESS_ZIP);
        RegisterAdressDTO registerAdress = mustReturn200RegisterGenericAdress(zipJson);

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
