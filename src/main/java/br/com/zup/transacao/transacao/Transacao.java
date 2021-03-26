package br.com.zup.transacao.transacao;

import br.com.zup.transacao.transacao.cartao.Cartao;
import br.com.zup.transacao.transacao.estabelecimento.Estabelecimento;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    private String id;

    @Column(nullable = false)
    private BigDecimal valor;

    @Embedded
    private Estabelecimento estabelecimento;

    @OneToOne(cascade = CascadeType.MERGE)
    private Cartao cartao;

    @Column(nullable = false)
    private LocalDateTime efetivadaEm;

    /**
     * @Deprecated somente para uso do hibernate
     */
    public Transacao(){}

    public Transacao(String id, BigDecimal valor, Estabelecimento estabelecimento,
                     Cartao cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
