package productcontroller;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import datafactory.ProductDataFactory;
import io.restassured.http.ContentType;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static utils.ConstantsUtils.BASE_URL;

@Listeners({ExtentITestListenerClassAdapter.class})
public class UpdateProductTest {

    private static final ProductDataFactory product = new ProductDataFactory();

    @Test(groups = "funcional")
    public void mustReturn201_updateProductById(){

        String id = "5";

           given()
                .log().all()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .body(product.buildProduct())
                .pathParam("id",id)
            .when()
                .put(BASE_URL.concat("/product/{id}"))
            .then()
                .statusCode(SC_OK);

    }


}
