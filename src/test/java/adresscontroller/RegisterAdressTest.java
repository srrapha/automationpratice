package adresscontroller;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import datafactory.AdressDataFactory;
import dto.SimulationZipJsonDTO;
import dto.adress.RegisterAdressDTO;
import io.restassured.http.ContentType;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.GeneralUtils;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;
import static constants.Constants.*;

@Listeners({ExtentITestListenerClassAdapter.class})
public class RegisterAdressTest {

    private static final AdressDataFactory adress = new AdressDataFactory();

    @Test(groups = "funcional")
    public void mustReturn201_registerAdress(){

        SimulationZipJsonDTO adressZipJson = GeneralUtils.mustReturn200_getZipJsonWithParameter(ADRESS_ZIP);
        RegisterAdressDTO registerAdress = adress.buildAdress(ID_ONE, adressZipJson);

        given()
            .log().all()
            .contentType(APLICATION_JSON)
            .accept(ContentType.JSON)
            .relaxedHTTPSValidation()
            .body(registerAdress)
        .when()
            .post(BASE_PATH_URL_MOCK.concat(PATH_ADRESS))
        .then()
            .statusCode(SC_CREATED);

    }

}
