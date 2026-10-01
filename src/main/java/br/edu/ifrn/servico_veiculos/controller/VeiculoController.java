package br.edu.ifrn.servico_veiculos.controller;

import br.edu.ifrn.servico_veiculos.model.Veiculo;
import br.edu.ifrn.servico_veiculos.model.dto.request.VeiculoRequestDTO;
import br.edu.ifrn.servico_veiculos.model.dto.response.VeiculoResponseDTO;
import br.edu.ifrn.servico_veiculos.service.VeiculoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/veiculos")
@RequiredArgsConstructor
public class VeiculoController {

    private final VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<VeiculoResponseDTO> criar (@Valid @RequestBody VeiculoRequestDTO dto) {
        VeiculoResponseDTO veiculo = veiculoService.criar(dto);
        URI uri = URI.create("/veiculos/" + veiculo.getId());
        return ResponseEntity.created(uri).body(veiculo);
    }

    @GetMapping
    public List<Veiculo> listar(){
        return veiculoService.listar();
    }

    @GetMapping("/{id}")
    public VeiculoResponseDTO listarPorId (@PathVariable Long id){
        return veiculoService.listarPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> atualizar (@PathVariable Long id, @Valid @RequestBody VeiculoRequestDTO dto){
        VeiculoResponseDTO veiculo = veiculoService.atualizar(id, dto);
        return ResponseEntity.ok(veiculo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (@PathVariable Long id){
        veiculoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
