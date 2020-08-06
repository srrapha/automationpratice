package productcontroller;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import datafactory.ProductDataFactory;
import dto.GenericDTO;

import io.restassured.http.ContentType;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.GeneralUtils;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;
import static utils.ConstantsUtils.BASE_URL;

@Listeners({ExtentITestListenerClassAdapter.class})
public class RegisterProductTest {

    private static final ProductDataFactory product = new ProductDataFactory();
    private static final GeneralUtils generalUtils = new GeneralUtils();

    @Test(groups = "funcional")
    public void mustReturn201_registerProduct(){

        given()
            .log().all()
            .contentType("application/json")
            .accept(ContentType.JSON)
            .relaxedHTTPSValidation()
            .body(product.buildProduct("pants1"))
            .when()
            .post(BASE_URL.concat("/product"))
            .then()
            .statusCode(SC_CREATED);

    }

    @Test(groups = "funcional")
    public void mustReturn201_registerProductAndConsultId(){

        GenericDTO generic =
                given()
                        .log().all()
                        .contentType("application/json")
                        .accept(ContentType.JSON)
                        .relaxedHTTPSValidation()
                        .body(product.buildProduct("shoes"))
                        .when()
                        .post(BASE_URL.concat("/product"))
                        .then()
                        .statusCode(SC_CREATED)
                        .extract().response().as(GenericDTO.class);

        generalUtils.mustReturn200_getGenericProductById(generic.getId());


    }
}
