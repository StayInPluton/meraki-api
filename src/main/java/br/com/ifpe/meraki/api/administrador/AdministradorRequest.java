package br.com.ifpe.meraki.api.administrador;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.ifpe.meraki.modelo.administrador.Administrador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdministradorRequest {
    @NotNull(message = "O Nome é de preenchimento obrigatório")
    @NotBlank(message = "O Nome é de preenchimento obrigatório")
    @Length(max = 100, message = "O Nome deverá ter no máximo {max} caracteres")
    private String nome;

    @NotNull(message = "O Email é de preenchimento obrigatório")
    @NotBlank(message = "O Email é de preenchimento obrigatório")
    @Email
    private String email;

    @NotNull(message = "A senha é de preenchimento obrigatório")
    @NotBlank(message = "A Senha é de preenchimento obrigatório")
    private String senha;

    @NotNull(message = "Necessario codigo de indentificação")
    @NotBlank(message = "Necessario codigo de indentificação")
    private String indentificacao;

    public Administrador build() {
        return Administrador.builder()
                .nome(nome)
                .email(email)
                .senha(senha)
                .indentificacao(indentificacao)
                .build();
    }

}
