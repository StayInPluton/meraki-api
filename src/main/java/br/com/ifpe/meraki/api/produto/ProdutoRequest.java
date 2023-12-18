package br.com.ifpe.meraki.api.produto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    @NotNull(message = "Selecione uma Categoria")
    @NotBlank(message = "Selecione uma Categoria")
    private Long idCategoria;

    @NotNull(message = "Preencha o codigo do produto")
    @NotBlank(message = "Preencha o codigo do produto")
    private String codigo;

    @NotNull(message = "Preencha o titulo do produto")
    @NotBlank(message = "Preencha o titulo do produto")
    private String titulo;

    @NotNull(message = "Preencha a descrição do produto")
    @NotBlank(message = "Preencha a descrição do produto")
    private String descricao;
    
    @NotNull(message = "Preencha o valor do produto")
    @NotBlank(message = "Preencha o valor do produto")
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
