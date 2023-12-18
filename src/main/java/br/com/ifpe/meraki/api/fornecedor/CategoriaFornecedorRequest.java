package br.com.ifpe.meraki.api.fornecedor;

import br.com.ifpe.meraki.modelo.fornecedor.CategoriaFornecedor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaFornecedorRequest {
    private String categoria;

    public CategoriaFornecedor build() {
        return CategoriaFornecedor.builder()
                .categoria(categoria)
                .build();
    }

}
