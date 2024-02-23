package requestspecification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static constants.Paths.BASE_PATH_HEALTH_CHECK;
import static constants.Paths.BASE_PATH_URL_ZIP;


public class RequestSpecificationFactory {

    private RequestSpecificationFactory() {
    }

    private static RequestSpecBuilder getRequestBuilder() {
        return new RequestSpecBuilder()
                .setConfig(
                        RestAssuredConfig.config()
                                .logConfig(LogConfig
                                        .logConfig()
                                        .enablePrettyPrinting(true)
                                        .enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL)
                                )
                )
                .setRelaxedHTTPSValidation()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .log(LogDetail.ALL);
    }

    public static RequestSpecification requestSpecificationJson() {
        return getRequestBuilder()
                .setBaseUri(BASE_PATH_URL_ZIP)
                .build();
    }
    public static RequestSpecification requestSpecificationHealthCheck() {
        return getRequestBuilder()
                .setBaseUri(BASE_PATH_HEALTH_CHECK)
                .build();
    }

    public static RequestSpecification requestSpecificationXml() {
        return getRequestBuilder()
                .setContentType(ContentType.XML)
                .setAccept(ContentType.XML)
                .setBaseUri(BASE_PATH_URL_ZIP)
                .build();
    }

    public static ResponseSpecification responseSpecification() {
        return new ResponseSpecBuilder().log(LogDetail.ALL).build();
    }


}

