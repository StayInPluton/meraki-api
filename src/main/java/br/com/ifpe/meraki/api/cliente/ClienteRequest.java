package br.com.ifpe.meraki.api.cliente;

import java.time.LocalDate;
import java.util.Arrays;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.meraki.modelo.acesso.Usuario;
import br.com.ifpe.meraki.modelo.cliente.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {
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

    @NotNull(message = "O telefone é de preenchimento obrigatório")
    @NotBlank(message = "O telefone é de preenchimento obrigatório")
    @Length(min = 8, max = 20, message = "O campo Fone tem que ter entre {min} e {max} caracteres")
    private String telefone;

    public Cliente build() {

        return Cliente.builder()
                .usuario(buildUsuario())
                .nome(nome)
                .telefone(telefone)
                .build();
    }

    public Usuario buildUsuario() {

        return Usuario.builder()
                .username(email)
                .password(senha)
                .roles(Arrays.asList(Usuario.ROLE_CLIENTE))
                .build();
    }

}