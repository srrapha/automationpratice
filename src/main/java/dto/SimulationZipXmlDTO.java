package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SimulationZipXmlDTO {


    @XmlPath("//xmlcep/cep")
    String cep;
    @XmlPath("//xmlcep/logradouro")
    String logradouro;
    @XmlPath("//xmlcep/complemento")
    String complemento;
    @XmlPath("//xmlcep/bairro")
    String bairro;
    @XmlPath("//xmlcep/localidade")
    String localidade;
    @XmlPath("//xmlcep/uf")
    String uf;
    @XmlPath("//xmlcep/unidade")
    String unidade;
    @XmlPath("//xmlcep/ibge")
    String ibge;
    @XmlPath("//xmlcep/gia")
    String gia;

}
