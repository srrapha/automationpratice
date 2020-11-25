package productcontroller;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.restassured.http.ContentType;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static utils.ConstantsUtils.BASE_PATH_URL_MOCK;

@Listeners({ExtentITestListenerClassAdapter.class})
public class DeleteProductTest {

    @Test(groups = "funcional")
    public void mustReturn201_deleteProductById(){

        String id = "5";

            given()
                .log().all()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .pathParam("id",id)
            .when()
                .delete(BASE_PATH_URL_MOCK.concat("/product/{id}"))
            .then()
                .statusCode(SC_OK);

    }

}
