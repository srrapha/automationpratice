package datafactory;

import com.github.javafaker.Faker;
import dto.SimulationZipJsonDTO;
import dto.adress.RegisterAdressDTO;

import static constants.Constants.*;

public class AdressDataFactory {

    public RegisterAdressDTO buildAdress(String idClient, SimulationZipJsonDTO dataAdress
    ) {
        return RegisterAdressDTO.builder()
                .id(Faker.instance().regexify(REGEX_ADRESS_ID))
                .createdAt(Faker.instance().regexify(REGEX_DATE))
                .idClient(idClient)
                .name(Faker.instance().artist().toString())
                .company(COMPANY)
                .adress(dataAdress.getLogradouro())
                .city(dataAdress.getLocalidade())
                .state(dataAdress.getUf())
                .zip(ADRESS_ZIP)
                .country(COUNTRY)
                .aditional(Faker.instance().regexify(REGEX_ADRESS_ADICIONAL))
                .build();

    }

}
