package adresscontroller;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import dto.adress.RegisterAdressDTO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static requestspecification.RequestSpecificationFactory.requestSpecificationJson;
import static requestspecification.RequestSpecificationFactory.responseSpecification;
import static utils.ConstantsUtils.BASE_URL;

@Listeners({ExtentITestListenerClassAdapter.class})
public class GetAdressTest {

    @Test(groups = "funcional")
    public void mustReturn200_getAllAdress() {

        Response response =
             given()
                 .spec(requestSpecificationJson())
            .when()
                .get("http://5f2700420824d8001655ee0b.mockapi.io/api/v1/adress")
            .then()
                 .spec(responseSpecification())
                .statusCode(SC_OK)
                .assertThat()
                .body("company[0]", Matchers.is("DBC Company"))
                .body("$.size()", is(2))
                .extract().response();

        assertThat(response.path("company[0]"), is("DBC Company"));
        assertThat(response.path("$.size()"), is(2));

    }

    @Test(groups = "funcional")
    public void mustReturn200_getAdressById() {

        String id = "1";

        RegisterAdressDTO adressDTO = given()
                .spec(requestSpecificationJson())
                .pathParam("id", id)
            .when()
                .get(BASE_URL.concat("/adress/{id}"))
            .then()
                .spec(responseSpecification())
                .statusCode(SC_OK)
                .assertThat()
                .body("id", equalTo("1"))
                .extract().response().as(RegisterAdressDTO.class);

        System.out.println(adressDTO);

        assertThat(adressDTO.getId(), equalTo(id));

    }

    @Test(groups = "funcional")
    public void mustReturn404_getAdressByNotFoundId() {

        String id = "100";

            given()
                .log().all()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .pathParam("id", id)
            .when()
                .get(BASE_URL.concat("/adress/{id}"))
            .then()
                .statusCode(SC_NOT_FOUND);

    }

}
