package br.com.ifpe.meraki.api.produto;

import java.time.LocalDate;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.meraki.modelo.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {
    private Long idCategoria;
    
    private String codigo;

    private String titulo;

    private String descricao;

    private Double valor;

    public Produto build() {
        return Produto.builder()
                .codigo(codigo)
                .titulo(titulo)
                .descricao(descricao)
                .valor(valor)
                .build();
    }
}
