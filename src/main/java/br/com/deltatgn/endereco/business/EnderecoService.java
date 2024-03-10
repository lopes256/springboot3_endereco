package br.com.deltatgn.endereco.business;

import br.com.deltatgn.endereco.dto.EnderecoDTO;
import br.com.deltatgn.endereco.infrastructure.client.ConsultaCEP;
import br.com.deltatgn.endereco.infrastructure.entities.Endereco;
import br.com.deltatgn.endereco.infrastructure.exceptions.ServiceException;
import br.com.deltatgn.endereco.infrastructure.repository.EnderecoRepository;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jammerson
 */
@Service
@RequiredArgsConstructor
@Log4j2
public class EnderecoService {

    private final ConsultaCEP consultaCEP;
    private final EnderecoRepository enderecoRepository;

    public EnderecoDTO consultaCEP(String cep) {
        EnderecoDTO enderecoDTO;
        if (!enderecoRepository.existsById(cep)) {
            try {
                ResponseEntity<EnderecoDTO> cepRetorno = consultaCEP.consultaCEP(cep);

                enderecoDTO = cepRetorno.getBody();
                Endereco endereco = new Endereco(enderecoDTO);
                this.salvarEndereco(endereco);
            } catch (FeignException e) {
                log.error("O CEP {} e invalido. Por favor, verifique e tente novamente.", cep);
                throw new ServiceException("O CEP fornecido e invalido. Por favor, verifique e tente novamente.", HttpStatus.BAD_REQUEST);
            } catch (ServiceException | NullPointerException e) {
                log.warn("Desculpe, nenhum resultado encontrado para o CEP especificado.");
                throw new ServiceException("Desculpe, nenhum resultado encontrado para o CEP especificado.", HttpStatus.CONFLICT);
            }

        } else {
            Endereco endereco = enderecoRepository.findById(cep)
                    .orElseThrow(() -> {
                        log.info("Nenhum resultado encontrado para o CEP {}.", cep);
                        return new ServiceException("Desculpe, nenhum resultado encontrado para o CEP especificado.");
                    });

            enderecoDTO = new EnderecoDTO(endereco);
        }

        return enderecoDTO;
    }

    public void salvarEndereco(Endereco endereco) {
        if (enderecoRepository.existsById(endereco.getCep())) {
            throw new ServiceException("Erro ao salvar o CEP: Este CEP j&aacute; est&aacute; cadastrado no sistema.");
        }

        enderecoRepository.save(endereco);
    }
}
