package br.com.ifpe.meraki.api.fornecedor;

import java.time.LocalDate;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.meraki.modelo.fornecedor.Fornecedor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class FornecedorRequest {
    private String nome;

    private String email;

    private String senha;

    private String regiao;

    private String telefone;

    public Fornecedor build() {

        return Fornecedor.builder()
                .nome(nome)
                .email(email)
                .senha(senha)
                .regiao(regiao)
                .telefone(telefone)
                .build();
    }


}
