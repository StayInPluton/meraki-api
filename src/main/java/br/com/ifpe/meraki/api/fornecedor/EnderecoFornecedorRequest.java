package br.com.ifpe.meraki.api.fornecedor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.ifpe.meraki.modelo.fornecedor.EnderecoFornecedor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoFornecedorRequest {
    @NotNull(message = "Preencha a rua")
    @NotBlank(message = "Preencha a rua")
    private String rua;

    @NotNull(message = "Preencha o numero")
    @NotBlank(message = "Preencha o numero")
    private String numero;

    @NotNull(message = "Preencha o bairro")
    @NotBlank(message = "Preencha o bairro")
    private String bairro;

    @NotNull(message = "Preencha o CEP")
    @NotBlank(message = "Preencha o CEP")
    private String cep;

    @NotNull(message = "Preencha a cidade")
    @NotBlank(message = "Preencha a cidade")
    private String cidade;

    @NotNull(message = "Preencha o estado")
    @NotBlank(message = "Preencha o estado")
    private String estado;

    private String complemento;

    public EnderecoFornecedor build() {
        return EnderecoFornecedor.builder()
                .rua(rua)
                .numero(numero)
                .bairro(bairro)
                .cep(cep)
                .cidade(cidade)
                .estado(estado)
                .complemento(complemento)
                .build();
    }
}
