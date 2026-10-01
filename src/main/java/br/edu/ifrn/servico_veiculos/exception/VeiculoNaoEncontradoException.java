package br.edu.ifrn.servico_veiculos.exception;

public class VeiculoNaoEncontradoException extends RuntimeException {
    public VeiculoNaoEncontradoException(Long id) {
        super("Veiculo não encontrado" + id);
    }
}
