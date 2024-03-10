package br.com.deltatgn.endereco.dto;

import br.com.deltatgn.endereco.infrastructure.entities.Endereco;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Jammerson
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class EnderecoDTO {

    @JsonProperty(value = "cep")
    private String cep;

    @JsonProperty(value = "logradouro")
    private String logradouro;

    @JsonProperty(value = "complemento")
    private String complemento;

    @JsonProperty(value = "bairro")
    private String bairro;

    @JsonProperty(value = "localidade")
    private String localidade;

    @JsonProperty(value = "uf")
    private String uf;

    @JsonProperty(value = "ibge")
    private Long ibge;

    @JsonProperty(value = "gia")
    private Long gia;

    @JsonProperty(value = "ddd")
    private Integer ddd;

    @JsonProperty(value = "siafi")
    private Long siafi;

    public EnderecoDTO(Endereco endereco) {
        this.cep = endereco.getCep().replace("-", "");
        this.logradouro = endereco.getLogradouro();
        this.complemento = endereco.getComplemento();
        this.bairro = endereco.getBairro();
        this.localidade = endereco.getLocalidade();
        this.uf = endereco.getUf();
        this.ibge = endereco.getIbge();
        this.gia = endereco.getGia();
        this.ddd = endereco.getDdd();
        this.siafi = endereco.getSiafi();
    }

}
