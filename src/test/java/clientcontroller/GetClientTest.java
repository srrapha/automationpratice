package clientcontroller;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import dto.client.RegisterClientDTO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static utils.ConstantsUtils.BASE_URL;

@Listeners({ExtentITestListenerClassAdapter.class})
public class GetClientTest {


    @Test(groups = "funcional")
    public void deveRetornar200_getAllClient() {

        Response response =
                given()
                        .log().all()
                        .contentType("application/json")
                        .accept(ContentType.JSON)
                        .relaxedHTTPSValidation()
                        .when()
                        .get(BASE_URL.concat("/client"))
                        .then()
                        .statusCode(SC_OK)
                        .assertThat()
                        .body("$.size()", is(2))
                        .extract().response();

        assertThat(response.path("$.size()"), is(2));

    }

    @Test(groups = "funcional")
    public void deveRetornar200_getClientById() {

        String id = "1";

        RegisterClientDTO clientDTO = given()
                .log().all()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .pathParam("id", id)
                .when()
                .get(BASE_URL.concat("/client/{id}"))
                .then()
                .statusCode(SC_OK)
                .assertThat()
                .body("id", equalTo("1"))
                .extract().response().as(RegisterClientDTO.class);

        System.out.println(clientDTO);

        assertThat(clientDTO.getId(), equalTo(id));


    }

    @Test(groups = "funcional")
    public void deveRetornar404_getClientByLargeId() {

        String id = "1000000000000";

        given()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .pathParam("id", id)
                .when()
                .get(BASE_URL.concat("/client/{id}"))
                .then()
                .statusCode(SC_NOT_FOUND);

    }

    @Test(groups = "funcional")
    public void deveRetornar200_getClientByIdAndCompareObjects() {


        String id = "1";

        RegisterClientDTO clientDTO = given()
                .log().all()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .pathParam("id", id)
                .when()
                .get(BASE_URL.concat("/client/{id}"))
                .then()
                .statusCode(SC_OK)
                .assertThat()
                .body("id", equalTo("1"))
                .extract().response().as(RegisterClientDTO.class);

        RegisterClientDTO newClientDTO = given()
                .log().all()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .relaxedHTTPSValidation()
                .pathParam("id", id)
                .when()
                .get(BASE_URL.concat("/client/{id}"))
                .then()
                .statusCode(SC_OK)
                .assertThat()
                .body("id", equalTo("1"))
                .extract().response().as(RegisterClientDTO.class);
        System.out.println(clientDTO);
        System.out.println(newClientDTO);

        assertThat(clientDTO, samePropertyValuesAs(newClientDTO));


    }


}
