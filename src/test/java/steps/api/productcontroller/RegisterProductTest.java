package steps.api.productcontroller;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import datafactory.ProductDataFactory;
import dto.GenericDTO;

import io.restassured.http.ContentType;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.GeneralUtils;

import static constants.Paths.BASE_PATH_URL_MOCK;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;

@Listeners({ExtentITestListenerClassAdapter.class})
public class RegisterProductTest {

    private static final ProductDataFactory product = new ProductDataFactory();

    @Test(groups = "funcional")
    public void mustReturn201RegisterProduct(){

        given()
            .log().all()
            .contentType("application/json")
            .accept(ContentType.JSON)
            .relaxedHTTPSValidation()
            .body(product.buildProduct())
        .when()
            .post(BASE_PATH_URL_MOCK.concat("/product"))
        .then()
            .statusCode(SC_CREATED);

    }

    @Test(groups = "funcional")
    public void mustReturn201RegisterProductAndConsultId(){

        GenericDTO generic =
                given()
                        .log().all()
                        .contentType("application/json")
                        .accept(ContentType.JSON)
                        .relaxedHTTPSValidation()
                        .body(product.buildProduct())
                        .when()
                        .post(BASE_PATH_URL_MOCK.concat("/product"))
                        .then()
                        .statusCode(SC_CREATED)
                        .extract().response().as(GenericDTO.class);

        GeneralUtils.mustReturn200GetGenericProductById(generic.getId());

    }
}
