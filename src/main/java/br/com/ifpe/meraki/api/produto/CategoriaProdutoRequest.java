package br.com.ifpe.meraki.api.produto;

import br.com.ifpe.meraki.modelo.produto.CategoriaProduto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaProdutoRequest {
    private String nome;

    public CategoriaProduto build() {
        return CategoriaProduto.builder()
                .nome(nome)
                .build();
    }
}
