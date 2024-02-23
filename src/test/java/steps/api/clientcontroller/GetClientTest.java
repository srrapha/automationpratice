package steps.api.clientcontroller;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import dto.client.RegisterClientDTO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.GeneralUtils;


import static io.restassured.RestAssured.*;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static constants.Constants.*;

@Listeners({ExtentITestListenerClassAdapter.class})
public class GetClientTest extends GeneralUtils {


    @Test(groups = "funcional")
    public void deveRetornar200_getAllClient() {

        Response response =
                    given()
                        .log().all()
                        .contentType(APLICATION_JSON)
                        .accept(ContentType.JSON)
                        .relaxedHTTPSValidation()
                    .when()
                        .get(BASE_PATH_URL_MOCK.concat(PATH_CLIENT))
                    .then()
                        .statusCode(SC_OK)
                        .assertThat()
                        .body("$.size()", is(2))
                        .extract().response();

        assertThat(response.path("$.size()"), is(2));

    }

    @Test(groups = "funcional")
    public void deveRetornar200_getClientById() {

        RegisterClientDTO clientDTO =
                given()
                    .log().all()
                    .contentType(APLICATION_JSON)
                    .accept(ContentType.JSON)
                    .relaxedHTTPSValidation()
                    .pathParam(ID, ID_ONE)
                .when()
                    .get(BASE_PATH_URL_MOCK.concat(PATH_CLIENT_ID))
                .then()
                    .statusCode(SC_OK)
                    .assertThat()
                    .body(ID, equalTo(ID_ONE))
                    .extract().response().as(RegisterClientDTO.class);

        System.out.println(clientDTO);

        assertThat(clientDTO.getId(), equalTo(ID_ONE));


    }

    @Test(groups = "funcional")
    public void deveRetornar404_getClientByLargeId() {

            given()
                .contentType(APLICATION_JSON)
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .pathParam(ID, MAX_ID)
            .when()
                .get(BASE_PATH_URL_MOCK.concat(PATH_CLIENT_ID))
            .then()
                .statusCode(SC_NOT_FOUND);

    }

    @Test(groups = "funcional")
    public void deveRetornar200_getClientByIdAndCompareObjects() {

        RegisterClientDTO clientDTO =
                given()
                    .log().all()
                    .contentType(APLICATION_JSON)
                    .accept(ContentType.JSON)
                    .relaxedHTTPSValidation()
                    .pathParam(ID, ID_ONE)
                .when()
                    .get(BASE_PATH_URL_MOCK.concat(PATH_CLIENT_ID))
                .then()
                    .statusCode(SC_OK)
                    .assertThat()
                    .body(ID, equalTo(ID_ONE))
                    .extract().response().as(RegisterClientDTO.class);

        RegisterClientDTO newClientDTO =
                given()
                    .log().all()
                    .contentType(APLICATION_JSON)
                    .accept(ContentType.JSON)
                    .relaxedHTTPSValidation()
                    .pathParam(ID, ID_ONE)
                .when()
                    .get(BASE_PATH_URL_MOCK.concat(PATH_CLIENT_ID))
                .then()
                    .statusCode(SC_OK)
                    .assertThat()
                    .body(ID, equalTo(ID_ONE))
                    .extract().response().as(RegisterClientDTO.class);
        System.out.println(clientDTO);
        System.out.println(newClientDTO);

        assertThat(clientDTO, samePropertyValuesAs(newClientDTO));

    }

}
