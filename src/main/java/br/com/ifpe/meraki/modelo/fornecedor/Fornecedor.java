package br.com.ifpe.meraki.modelo.fornecedor;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Where;
import java.util.List;

import br.com.ifpe.meraki.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Fornecedor")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Fornecedor extends EntidadeAuditavel {

    @OneToMany(mappedBy = "fornecedor", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<EnderecoFornecedor> enderecos;

    @Column (nullable = false, length = 100)
    private String nome;

    @Column (nullable = false, length = 100)
    private String email;

    @Column (nullable = false, length = 100)
    private String senha;

    @Column (nullable = false, length = 100)
    private String telefone;

}
