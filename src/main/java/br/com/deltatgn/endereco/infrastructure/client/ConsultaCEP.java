package br.com.deltatgn.endereco.infrastructure.client;

import br.com.deltatgn.endereco.dto.EnderecoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Jammerson
 */
@FeignClient(value = "viacep-api", url = "${endereco-api.url:#{null}}")
public interface ConsultaCEP {

    @GetMapping("/{cep}/json")
    ResponseEntity<EnderecoDTO> consultaCEP(@PathVariable String cep);
//    https://viacep.com.br/ws/01001000/json/

}
