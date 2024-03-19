package steps.api.realcontroller;

import dto.SimulationZipJsonDTO;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import static constants.Constants.ADRESS_ZIP;
import static constants.Constants.ZIP;
import static constants.Paths.PATH_CEP;
import static constants.Paths.PATH_URL_ZIP_JSON;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static requestspecification.RequestSpecificationFactory.requestSpecificationJson;
import static requestspecification.RequestSpecificationFactory.responseSpecification;

public class CorreiosTest {
    private SimulationZipJsonDTO responseJson = new SimulationZipJsonDTO();
    @Dado("ter a ciencia do cep do cliente")
    public void ter_a_ciencia_do_cep_do_cliente() {
        System.out.println("CEP: "+ADRESS_ZIP);
    }

    @Quando("requisitar os dados de endereco do cliente")
    public void requisitar_os_dados_de_endereco_do_cliente() {
        responseJson =
                given()
                        .spec(requestSpecificationJson())
                        .pathParam(ZIP, ADRESS_ZIP)
                        .when()
                        .get(PATH_URL_ZIP_JSON)
                        .then()
                        .spec(responseSpecification())
                        .statusCode(SC_OK)
                        .assertThat()
                        .body(PATH_CEP, equalTo(ADRESS_ZIP))
                        .extract().response().as(SimulationZipJsonDTO.class);

    }

    @Entao("verificar o retorno das informacoes com sucesso")
    public void verificar_o_retorno_das_informacoes_com_sucesso() {
        System.out.println(responseJson);
    }

    @E("validar o numero do cep enviado")
    public void validar_o_numero_do_cep_enviado() {
        assertThat(responseJson.getCep(), equalTo(ADRESS_ZIP));
    }
}
