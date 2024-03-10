package br.com.deltatgn.endereco.infrastructure.exceptions;

/**
 *
 * @author Jammerson
 */
public class RecordNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -8118209321600275026L;

    public RecordNotFoundException() {
        super("Nenhum registro encontrado!");
    }

    public RecordNotFoundException(String message) {
        super(message);
    }

}
