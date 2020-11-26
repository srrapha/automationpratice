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
    private String cep;
    @XmlPath("//xmlcep/logradouro")
    private String logradouro;
    @XmlPath("//xmlcep/complemento")
    private String complemento;
    @XmlPath("//xmlcep/bairro")
    private String bairro;
    @XmlPath("//xmlcep/localidade")
    private String localidade;
    @XmlPath("//xmlcep/uf")
    private String uf;
    @XmlPath("//xmlcep/unidade")
    private String unidade;
    @XmlPath("//xmlcep/ibge")
    private String ibge;
    @XmlPath("//xmlcep/gia")
    private String gia;

}
