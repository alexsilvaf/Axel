package br.com.axel.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "PRODUTO_CARRINHO")
public class ProdutoCarrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProdutoCarrinho;

    @ManyToOne
    private Carrinho carrinho;

    @Column(name = "idUsuario")
    private Integer idUsuario;
}
