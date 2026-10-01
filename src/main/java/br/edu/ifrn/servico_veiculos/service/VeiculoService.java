package br.edu.ifrn.servico_veiculos.service;

import br.edu.ifrn.servico_veiculos.exception.VeiculoNaoEncontradoException;
import br.edu.ifrn.servico_veiculos.model.Veiculo;
import br.edu.ifrn.servico_veiculos.model.dto.request.VeiculoRequestDTO;
import br.edu.ifrn.servico_veiculos.model.dto.response.VeiculoResponseDTO;
import br.edu.ifrn.servico_veiculos.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoResponseDTO criar (VeiculoRequestDTO dto){
        Veiculo veiculo = veiculoRepository.save(toEntity(dto));

        return toResponseDTO(veiculo);
    }

    public List<Veiculo> listar(){
        return veiculoRepository.findAll();
    }

    public VeiculoResponseDTO listarPorId (Long id){
        Veiculo veiculo = veiculoRepository.findById(id).orElseThrow(() -> new VeiculoNaoEncontradoException(id));

        return toResponseDTO(veiculo);
    }

    public VeiculoResponseDTO atualizar (Long id, VeiculoRequestDTO dto){
        Veiculo veiculo = veiculoRepository.findById(id).orElseThrow(() -> new VeiculoNaoEncontradoException(id));

        veiculo.setPlaca( dto.getPlaca());
        veiculo.setModelo(dto.getModelo());
        veiculo.setAnoFabricacao(dto.getAnoFabricacao());
        veiculo.setTipo(dto.getTipo());
        veiculo.setNomeProprietario(dto.getNomeProprietario());

        Veiculo atualizado = veiculoRepository.save(veiculo);

        return toResponseDTO(atualizado);
    }

    public void deletar (Long id){
        Veiculo veiculo = veiculoRepository.findById(id).orElseThrow(() -> new VeiculoNaoEncontradoException(id));

        veiculoRepository.deleteById(id);
    }

    private Veiculo toEntity(VeiculoRequestDTO dto) {
        return new Veiculo(null, dto.getPlaca(), dto.getModelo(), dto.getAnoFabricacao(), dto.getTipo(), dto.getNomeProprietario());
    }

    private VeiculoResponseDTO toResponseDTO(Veiculo entity) {
        return new VeiculoResponseDTO(entity.getId(), entity.getPlaca(), entity.getModelo(), entity.getAnoFabricacao(), entity.getTipo(), entity.getNomeProprietario());
    }
}
