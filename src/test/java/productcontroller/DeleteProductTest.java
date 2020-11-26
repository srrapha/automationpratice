package productcontroller;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import dto.product.RegisterProductDTO;
import io.restassured.http.ContentType;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.GeneralUtils;

import static constants.Constants.*;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

@Listeners({ExtentITestListenerClassAdapter.class})
public class DeleteProductTest {

    @Test(groups = "funcional")
    public void mustReturn200_deleteProductById(){

        RegisterProductDTO registerProduct = GeneralUtils.mustReturn200_registerGenericProduct();

            given()
                .log().all()
                .contentType(APLICATION_JSON)
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .pathParam(ID,registerProduct.getId())
            .when()
                .delete(BASE_PATH_URL_MOCK.concat(PATH_PRODUCT_ID))
            .then()
                .statusCode(SC_OK);

    }

}
