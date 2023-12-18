package br.com.ifpe.meraki.modelo.cliente;

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
@Table(name = "EnderecoCliente")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoCliente extends EntidadeAuditavel {

   @JsonIgnore
   @ManyToOne
   private Cliente cliente;

   @Column(nullable = true, length = 100)
   private String rua;

   @Column(nullable = true, length = 100)
   private String numero;

   @Column(nullable = true, length = 100)
   private String bairro;

   @Column(nullable = true, length = 100)
   private String cep;

   @Column(nullable = true, length = 100)
   private String cidade;

   @Column(nullable = true, length = 100)
   private String estado;

   @Column(nullable = true, length = 100)
   private String complemento;

}
