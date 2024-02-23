package constants;

import utils.Assistant;

import java.io.IOException;

public class Paths {

    private Paths(){}
    public static final String ENV;

    static {
        try {
            ENV = Assistant.getConfigPropertiesValues("src", "env");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static final String BASE_PATH_URL_MOCK = "http://5f2700420824d8001655ee0b.mockapi.io/api/v1";
    public static final String BASE_PATH_HEALTH_CHECK = "http://0.0.0.0:3000";
    public static final String BASE_PATH_URL_ZIP = "https://viacep.com.br/ws";
    public static final String PATH_URL_ZIP_JSON = "/{zip}/json";
    public static final String PATH_URL_ZIP_XML = "/{zip}/xml";
    public static final String PATH_ACTUATOR_HEALTH = "/actuator/health";
    public static final String PATH_STATUS = "status";
    public static final String PATH_CEP = "cep";
    public static final String PATH_PRODUCT_ID = "/product/{id}";
    public static final String PATH_PRODUCT = "/product";
    public static final String PATH_ADRESS = "/adress";
    public static final String PATH_ADRESS_ID = "/adress/{id}";
    public static final String PATH_CLIENT = "/client";
    public static final String PATH_CLIENT_ID = "/client/{id}";
}
