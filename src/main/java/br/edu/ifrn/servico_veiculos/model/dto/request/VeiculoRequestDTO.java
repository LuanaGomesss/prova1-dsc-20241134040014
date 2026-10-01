package br.edu.ifrn.servico_veiculos.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoRequestDTO {

    @NotBlank(message = "Placa é obrigatório")
    private String placa;

    @NotBlank(message = "Modelo é obrigatório")
    private String modelo;

    @NotNull(message = "Ano de fabricação é obrigatório")
    private Integer anoFabricacao;

    @NotBlank(message = "Tipo é obrigatório")
    private String tipo;

    @NotBlank(message = "Nome do proprietario é obrigatório")
    private String nomeProprietario;
}
