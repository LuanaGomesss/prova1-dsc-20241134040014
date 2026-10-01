package br.edu.ifrn.servico_veiculos.repository;

import br.edu.ifrn.servico_veiculos.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    List<Veiculo> findByPlaca(String placa);
    List<Veiculo> findPlacaAndIdNot(String placa, Long id);
    List<Veiculo> findByTipo(String tipo);
}
