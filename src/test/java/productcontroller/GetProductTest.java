package productcontroller;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import dto.product.RegisterProductDTO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static utils.ConstantsUtils.BASE_URL;

@Listeners({ExtentITestListenerClassAdapter.class})
public class GetProductTest {

    @Test(groups = "funcional")
    public void deveRetornar200_getAllProducts() {

        Response response =
                    given()
                        .log().all()
                        .contentType("application/json")
                        .accept(ContentType.JSON)
                        .relaxedHTTPSValidation()
                    .when()
                        .get(BASE_URL.concat("/product"))
                    .then()
                        .statusCode(SC_OK)
                        .assertThat()
                        .body("$.size()", is(6))
                        .extract().response();

        assertThat(response.path("$.size()"), is(6));

    }

    @Test(groups = "funcional")
    public void mustReturn200_getProductById() {

        String id = "1";

        RegisterProductDTO productDTO = given()
                .log().all()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .pathParam("id", id)
            .when()
                .get(BASE_URL.concat("/product/{id}"))
            .then()
                .statusCode(SC_OK)
                .assertThat()
                .body("id", equalTo("1"))
                .extract().response().as(RegisterProductDTO.class);

        System.out.println(productDTO);

        assertThat(productDTO.getId(), equalTo(id));
        assertThat(productDTO.getInStock().toString(), true);

    }

    @Test(groups = "funcional")
    public void mustReturn404_getProductByInvalidId() {

        String id = "asd";

            given()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .pathParam("id", id)
            .when()
                .get(BASE_URL.concat("/product/{id}"))
            .then()
                .statusCode(SC_NOT_FOUND);

    }

    @Test(groups = "funcional")
    public void mustReturn200_getProductByIdAndCompareObjects() {

        String id = "1";

        RegisterProductDTO productDTO = given()
                .log().all()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .pathParam("id", id)
            .when()
                .get(BASE_URL.concat("/product/{id}"))
            .then()
                .statusCode(SC_OK)
                .assertThat()
                .body("id", equalTo("1"))
                .extract().response().as(RegisterProductDTO.class);

        RegisterProductDTO newProductDTO = given()
                .log().all()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .pathParam("id", id)
            .when()
                .get(BASE_URL.concat("/product/{id}"))
            .then()
                .statusCode(SC_OK)
                .assertThat()
                .body("id", equalTo("1"))
                .extract().response().as(RegisterProductDTO.class);
        System.out.println(productDTO);
        System.out.println(newProductDTO);

        assertThat(productDTO, samePropertyValuesAs(newProductDTO));
        assertThat(productDTO.getInStock().toString(), true);

    }
}
