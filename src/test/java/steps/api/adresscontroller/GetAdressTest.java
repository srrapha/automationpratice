package steps.api.adresscontroller;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import dto.adress.RegisterAdressDTO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static constants.Paths.*;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static requestspecification.RequestSpecificationFactory.requestSpecificationJson;
import static requestspecification.RequestSpecificationFactory.responseSpecification;
import static constants.Constants.*;

@Listeners({ExtentITestListenerClassAdapter.class})
public class GetAdressTest {

    @Test(groups = "funcional")
    public void mustReturn200_getAllAdress() {

        Response response =
             given()
                 .spec(requestSpecificationJson())
            .when()
                .get(BASE_PATH_URL_MOCK.concat(PATH_ADRESS))
            .then()
                 .spec(responseSpecification())
                .statusCode(SC_OK)
                .assertThat()
                .body("company[0]", Matchers.is(COMPANY))
                .body("$.size()", is(2))
                .extract().response();

        assertThat(response.path("company[0]"), is(COMPANY));
        assertThat(response.path("$.size()"), is(2));

    }

    @Test(groups = "funcional")
    public void mustReturn200_getAdressById() {

        RegisterAdressDTO adressDTO =
            given()
                .spec(requestSpecificationJson())
                .pathParam(ID, ID_ONE)
            .when()
                .get(BASE_PATH_URL_MOCK.concat(PATH_ADRESS_ID))
            .then()
                .spec(responseSpecification())
                .statusCode(SC_OK)
                .assertThat()
                .body(ID, equalTo(ID_ONE))
                .extract().response().as(RegisterAdressDTO.class);

        System.out.println(adressDTO);

        assertThat(adressDTO.getId(), equalTo(ID_ONE));

    }

    @Test(groups = "funcional")
    public void mustReturn404_getAdressByNotFoundId() {

            given()
                .log().all()
                .contentType(APLICATION_JSON)
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .pathParam(ID, ADRESS_ID_NOT_FOUND)
            .when()
                .get(BASE_PATH_URL_MOCK.concat(PATH_ADRESS_ID))
            .then()
                .statusCode(SC_NOT_FOUND);

    }

}
