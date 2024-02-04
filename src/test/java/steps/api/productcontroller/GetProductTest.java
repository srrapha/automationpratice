package steps.api.productcontroller;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import dto.product.RegisterProductDTO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static constants.Constants.*;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Listeners({ExtentITestListenerClassAdapter.class})
public class GetProductTest {

    @Test(groups = "funcional")
    public void mustReturn200_getAllProducts() {

        Response response =
                    given()
                        .log().all()
                        .contentType(APLICATION_JSON)
                        .accept(ContentType.JSON)
                        .relaxedHTTPSValidation()
                    .when()
                        .get(BASE_PATH_URL_MOCK.concat(PATH_PRODUCT))
                    .then()
                        .statusCode(SC_OK)
                        .assertThat()
                        .body("$.size()", is(12))
                        .extract().response();

        assertThat(response.path("$.size()"), greaterThan(1));

    }

    @Test(groups = "funcional")
    public void mustReturn200_getProductById() {

        RegisterProductDTO productDTO = given()
                .log().all()
                .contentType(APLICATION_JSON)
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .pathParam(ID, ID_ONE)
            .when()
                .get(BASE_PATH_URL_MOCK.concat(PATH_PRODUCT_ID))
            .then()
                .statusCode(SC_OK)
                .assertThat()
                .body(ID, equalTo(ID_ONE))
                .extract().response().as(RegisterProductDTO.class);

        System.out.println(productDTO);

        assertThat(productDTO.getId(), equalTo(ID_ONE));
        assertThat(productDTO.getInStock().toString(), IN_STOCK_PRODUCT);

    }

    @Test(groups = "funcional")
    public void mustReturn404_getProductByInvalidId() {

            given()
                .contentType(APLICATION_JSON)
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .pathParam(ID, INVALID_ID)
            .when()
                .get(BASE_PATH_URL_MOCK.concat(PATH_PRODUCT_ID))
            .then()
                .statusCode(SC_NOT_FOUND);

    }

    @Test(groups = "funcional")
    public void mustReturn200_getProductByIdAndCompareObjects() {

        RegisterProductDTO productDTO =
            given()
                .log().all()
                .contentType(APLICATION_JSON)
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .pathParam(ID, ID_ONE)
            .when()
                .get(BASE_PATH_URL_MOCK.concat(PATH_PRODUCT_ID))
            .then()
                .statusCode(SC_OK)
                .assertThat()
                .body(ID, equalTo(ID_ONE))
                .extract().response().as(RegisterProductDTO.class);

        RegisterProductDTO newProductDTO = given()
                .log().all()
                .contentType(APLICATION_JSON)
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .pathParam(ID, ID_ONE)
            .when()
                .get(BASE_PATH_URL_MOCK.concat(PATH_PRODUCT_ID))
            .then()
                .statusCode(SC_OK)
                .assertThat()
                .body(ID, equalTo(ID_ONE))
                .extract().response().as(RegisterProductDTO.class);
        System.out.println(productDTO);
        System.out.println(newProductDTO);

        assertThat(productDTO, samePropertyValuesAs(newProductDTO));
        assertThat(productDTO.getInStock().toString(), IN_STOCK_PRODUCT);

    }
}
