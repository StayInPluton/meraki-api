package br.com.ifpe.meraki.api.cliente;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    private String nome;

    private String email;

    private String senha;

    private String regiao;

    private String telefone;

    public Cliente build() {

        return Cliente.builder()
                .nome(nome)
                .email(email)
                .senha(senha)
                .build();
    }

}