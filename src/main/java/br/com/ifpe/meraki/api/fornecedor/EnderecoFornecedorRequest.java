package br.com.ifpe.meraki.api.fornecedor;

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
    private String rua;

    private String numero;

    private String bairro;

    private String cep;

    private String cidade;

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
