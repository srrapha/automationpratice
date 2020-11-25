import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import org.apache.http.HttpStatus;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static requestspecification.RequestSpecificationFactory.*;

@Listeners({ExtentITestListenerClassAdapter.class})
public class HealthCheckTest {

    @Test(groups = "healthCheck")
    public void deveRetornar200_healthCheck() {
        given().
                when().
                spec(requestSpecificationJson()).
                get("/actuator/health").
                then().
                spec(responseSpecification()).
                statusCode(HttpStatus.SC_OK).
                body("status", is("UP"));
    }

}
