package steps.api.clientcontroller;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import datafactory.ClientDataFactory;
import io.restassured.http.ContentType;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static constants.Constants.*;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;

@Listeners({ExtentITestListenerClassAdapter.class})
public class RegisterClientTest {

    private static final ClientDataFactory client = new ClientDataFactory();

    @Test(groups = "funcional")
    public void mustReturn201_registerClient(){

            given()
                .log().all()
                .contentType(APLICATION_JSON)
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .body(client.buildClient())
            .when()
                .post(BASE_PATH_URL_MOCK.concat(PATH_CLIENT))
            .then()
                .statusCode(SC_CREATED);

    }
}
