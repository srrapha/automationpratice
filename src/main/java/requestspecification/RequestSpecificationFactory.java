package requestspecification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;


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

    public static io.restassured.specification.RequestSpecification requestSpecificationJson() {
        return getRequestBuilder().build();
    }

    public static io.restassured.specification.RequestSpecification requestSpecificationXml() {
        return getRequestBuilder()
                .setContentType(ContentType.XML)
                .setAccept(ContentType.XML)
                .build();
    }

    public static ResponseSpecification responseSpecification() {
        return new ResponseSpecBuilder().log(LogDetail.ALL).build();
    }

}

