package br.com.deltatgn.endereco.controller;

import br.com.deltatgn.endereco.business.EnderecoService;
import br.com.deltatgn.endereco.dto.EnderecoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jammerson
 */
@RestController
@RequestMapping("/consultacep")
@RequiredArgsConstructor
@Tag(name = "Consutla-CEP-api")
public class ConsultaCEPController {

    private final EnderecoService enderecoService;

    @GetMapping("/{cep}")
    @Operation(description = "Consulta cep ViaCep", method = "GET")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
        @ApiResponse(responseCode = "409", description = "Desculpe, nenhum resultado encontrado para o CEP especificado."),
        @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),})
    public ResponseEntity<EnderecoDTO> consultaCEP(@PathVariable String cep) {
        cep = cep.replace("-", "");
        return ResponseEntity.ok(enderecoService.consultaCEP(cep));
    }

}
