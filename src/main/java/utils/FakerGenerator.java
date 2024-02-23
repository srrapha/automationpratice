package utils;


import static constants.Constants.*;
import static constants.Regex.*;

public class FakerGenerator extends GeneralUtils{

    public static String getId() { return brFk.regexify(REGEX_RAMDOM_ID); }
    public static String getCurrenceDate() { return brFk.date().birthday(0,1).toString(); }
    public static String getProduct() { return brFk.app().name(); }
    public static String getQuantity() { return brFk.regexify(REGEX_QUANTITY); }
    public static String getName() { return brFk.dragonBall().character(); }
    public static String getLastName() { return brFk.name().lastName(); }
    public static String getGender() {return brFk.regexify(REGEX_GENDER_CLIENT); }
    public static String getMail() {return brFk.internet().emailAddress(); }
    public static String getAvatar() {return PRODUCT_AVATAR + getId().concat(EXTENSAO_IMAGEM); }
}
