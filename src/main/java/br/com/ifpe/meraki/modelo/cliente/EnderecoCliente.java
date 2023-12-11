package br.com.ifpe.meraki.modelo.cliente;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ifpe.meraki.util.entity.EntidadeAuditavel;

public class EnderecoCliente extends EntidadeAuditavel {

   @JsonIgnore
   @ManyToOne
   private Cliente cliente;

   @Column
   private String rua;

   @Column
   private String numero;

   @Column
   private String bairro;
  
   @Column
   private String cep;

   @Column
   private String cidade;

   @Column
   private String estado;

   @Column
   private String complemento;


    
}
