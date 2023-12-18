package br.com.ifpe.meraki.api.fornecedor;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    @NotNull(message = "O nome é de preenchimento obrigatório")
    @NotBlank(message = "O nome é de preenchimento obrigatório")
    private String nome;

    @NotNull(message = "O email é de preenchimento obrigatório")
    @NotBlank(message = "O email é de preenchimento obrigatório")
    private String email;

    @NotNull(message = "A senha é de preenchimento obrigatório")
    @NotBlank(message = "A senha é de preenchimento obrigatório")
    private String senha;

    @NotNull(message = "O telefone é de preenchimento obrigatório")
    @NotBlank(message = "O telefone é de preenchimento obrigatório")
    private String telefone;

    public Fornecedor build() {

        return Fornecedor.builder()
                .nome(nome)
                .email(email)
                .senha(senha)
                .telefone(telefone)
                .build();
    }

}
