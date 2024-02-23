package steps.api.clientcontroller;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.restassured.http.ContentType;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static constants.Constants.*;
import static constants.Paths.*;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

@Listeners({ExtentITestListenerClassAdapter.class})
public class DeleteClientTest{

    @Test(groups = "funcional")
    public void mustReturn201_deleteClientById(){


            given()
                .log().all()
                .contentType(APLICATION_JSON)
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .pathParam(ID, "1")
            .when()
                .delete(BASE_PATH_URL_MOCK.concat(PATH_CLIENT_ID))
            .then()
                .statusCode(SC_OK);

    }

}
