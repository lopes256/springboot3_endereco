package br.com.deltatgn.endereco.infrastructure.entities;

import br.com.deltatgn.endereco.dto.EnderecoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Jammerson
 */
@Entity
@Table(name = "endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1516712415322368600L;

    @Id
    @Column(length = 8, nullable = false)
    private String cep;

    @Column(length = 200)
    private String logradouro;

    @Column(length = 50)
    private String complemento;

    @Column(length = 60)
    private String bairro;

    @Column(length = 150)
    private String localidade;

    @Column(length = 2)
    private String uf;

    private Long ibge;

    private Long gia;

    private Integer ddd;

    private Long siafi;

    public Endereco(EnderecoDTO endereco) {
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
