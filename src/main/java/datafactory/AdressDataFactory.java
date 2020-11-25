package datafactory;

import com.github.javafaker.Faker;
import dto.adress.RegisterAdressDTO;

import static utils.ConstantsUtils.*;

public class AdressDataFactory {

    public RegisterAdressDTO buildAdress(String idClient, String name,
                                         String adress, String city,
                                         String state
    ) {
        return RegisterAdressDTO.builder()
                .id(Faker.instance().regexify(REGEX_ADRESS_ID))
                .createdAt(Faker.instance().regexify(REGEX_DATE))
                .idClient(idClient)
                .name(Faker.instance().artist().toString())
                .company("DBC Company")
                .adress(adress)
                .city(city)
                .state(state)
                .zip(ADRESS_ZIP)
                .country("Brasil")
                .aditional(Faker.instance().regexify(REGEX_ADRESS_ADICIONAL))
                .build();

    }

}
