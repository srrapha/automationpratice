package clientcontroller;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import datafactory.ClientDataFactory;
import io.restassured.http.ContentType;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;
import static utils.ConstantsUtils.BASE_URL;

@Listeners({ExtentITestListenerClassAdapter.class})
public class RegisterClientTest {

    private static final ClientDataFactory client = new ClientDataFactory();

    @Test(groups = "funcional")
    public void mustReturn201_registerClient(){

        given()
                .log().all()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .body(client.buildClient("Joãozinho", "Silva", "M"))
                .when()
                .post(BASE_URL.concat("/client"))
                .then()
                .statusCode(SC_CREATED);

    }
}
