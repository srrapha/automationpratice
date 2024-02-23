package steps.api;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import org.apache.http.HttpStatus;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static constants.Constants.*;
import static constants.Paths.PATH_ACTUATOR_HEALTH;
import static constants.Paths.PATH_STATUS;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static requestspecification.RequestSpecificationFactory.*;

@Listeners({ExtentITestListenerClassAdapter.class})
public class HealthCheckTest {

    @Test(groups = "healthCheck")
    public void mustReturn200HealthCheck() {
            given().
                spec(requestSpecificationHealthCheck()).
            when().
                get(PATH_ACTUATOR_HEALTH).
            then().
                spec(responseSpecification()).
                statusCode(HttpStatus.SC_OK).
                body(PATH_STATUS, is(UP));
    }

}
