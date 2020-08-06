import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import org.apache.http.HttpStatus;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static utils.ConstantsUtils.BASE_HEALTH;

@Listeners({ExtentITestListenerClassAdapter.class})
public class HealthCheckTest {


    @Test(groups = "healthcheck")
    public void deveRetornar200_clientHealthCheck() {

        given()
                .contentType("application/json")
                .when()
                .get(BASE_HEALTH.concat("/clientcheck/actuator/health"))
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("status", is("UP"));

    }

    @Test(groups = "healthcheck")
    public void deveRetornar200_productHealthCheck() {

        given()
                .contentType("application/json")
                .when()
                .get(BASE_HEALTH.concat("/productcheck/actuator/health"))
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("status", is("UP"));

    }

    @Test(groups = "healthcheck")
    public void deveRetornar200_adressHealthCheck() {

        given()
                .contentType("application/json")
                .when()
                .get(BASE_HEALTH.concat("/adresscheck/actuator/health"))
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("status", is("UP"));

    }


}
