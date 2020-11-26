package constants;


public class Constants {

    private Constants() {
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

    public static final String REGEX_ADRESS_ID = "[0-9]{4}";
    public static final String REGEX_CLIENT_ID = "[0-9]{4}";
    public static final String REGEX_ORDER_ID = "[0-9]{4}";
    public static final String REGEX_PRODUCT_ID = "[0-9]{4}";
    public static final String REGEX_DATE = "[0-2]{2}\\/[0-2]{2}\\/\\2\\0\\2\\0";
    public static final String REGEX_EMAIL_CLIENT = "[a-z]{8}";
    public static final String REGEX_QUANTITY = "[0-9]{3}";
    public static final String REGEX_PRODUCT_NAME = "[A-Z]{5}";
    public static final String REGEX_ADRESS_ADICIONAL = "[A-Z]{6}";
    public static final String REGEX_LAST_NAME_CLIENT  = "[A-Z]{6}";
    public static final String REGEX_GENDER_CLIENT  = "[A-Z]{6}";

    public static final String SUFIXO_EMAIL = "@email.com";
    public static final String DATE_BIRTH_CLIENT = "01/01/1990";
    public static final String PASSWORD_CLIENT = "####";
    public static final String PRODUCT_AVATAR = "https://s3.amazonaws.com/uifaces/faces/twitter/erwanhesry/";
    public static final String EXTENSAO_IMAGEM = ".jpg";
    public static final String ADRESS_ZIP = "91350-110";
    public static final String ID_ONE = "1";
    public static final String ID_FIVE = "5";
    public static final String MAX_ID = "1000000000000";
    public static final String INVALID_ID = "asd";

    public static final String ADRESS_ID_NOT_FOUND = "100";
    public static final String COMPANY = "DBC Company";
    public static final String COUNTRY = "Brasil";
    public static final String UP = "UP";
    public static final String ZIP = "zip";
    public static final String ID = "id";
    public static final String APLICATION_JSON = "application/json";
    public static final String APLICATION_XML = "application/xml";


    public static final boolean NEWSLETTER_CLIENT = true;
    public static final boolean IN_STOCK_PRODUCT = true;

}
