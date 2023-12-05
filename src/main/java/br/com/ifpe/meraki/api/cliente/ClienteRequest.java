package br.com.ifpe.meraki.api.cliente;

import java.time.LocalDate;
import java.util.Arrays;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

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

    @NotBlank(message = "O e-mail é de preenchimento obrigatório")
    @Email
    private String email;

    @NotBlank(message = "A senha é de preenchimento obrigatório")
    private String password;

    private String nome;

    private String senha;

    private String regiao;

    private String telefone;

    public Cliente build() {

        return Cliente.builder()
                .usuario(buildUsuario())
                .nome(nome)
                .email(email)
                .senha(senha)
                .regiao(regiao)
                .build();
    }

      public Usuario buildUsuario() {
	
	return Usuario.builder()
		.username(email)
		.password(password)
		.roles(Arrays.asList(Usuario.ROLE_CLIENTE))
		.build();
    }


}