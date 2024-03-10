package br.com.deltatgn.endereco.infrastructure.repository;

import br.com.deltatgn.endereco.infrastructure.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jammerson
 */
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, String> {
    
}
