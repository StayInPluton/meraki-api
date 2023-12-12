package br.com.ifpe.meraki.modelo.fornecedor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ifpe.meraki.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "EnderecoFornecedor")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoFornecedor extends EntidadeAuditavel {

    @JsonIgnore
    @ManyToOne
    private Fornecedor fornecedor;

    @Column(nullable = false, length = 100)
    private String rua;

    @Column(nullable = false, length = 50)
    private String numero;

    @Column(nullable = false, length = 100)
    private String bairro;

    @Column(nullable = false, length = 100)
    private String cep;

    @Column(nullable = false, length = 100)
    private String cidade;

    @Column(nullable = false, length = 100)
    private String estado;

    @Column(nullable = true, length = 100)
    private String complemento;

}
