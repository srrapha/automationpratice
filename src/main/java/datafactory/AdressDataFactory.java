package datafactory;

import com.github.javafaker.Faker;
import dto.adress.RegisterAdressDTO;

import static utils.ConstantsUtils.*;

public class AdressDataFactory {

    public RegisterAdressDTO buildAdress(String idClient, String name,
                                         String adress, String city,
                                         String state, String zip,
                                         String country, String adicional
    ) {
        return RegisterAdressDTO.builder()
                .id(Faker.instance().regexify(ID))
                .createdAt(Faker.instance().regexify(DATE_RDM).concat("/2020"))
                .idClient(idClient)
                .name(name)
                .company("DBC Company")
                .adress(adress)
                .city(city)
                .state(state)
                .zip(zip)
                .country(country)
                .aditional(adicional)
                .build();

    }

}
