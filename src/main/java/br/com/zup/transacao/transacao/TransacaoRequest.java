package br.com.zup.transacao.transacao;

import br.com.zup.transacao.transacao.estabelecimento.EstabelecimentoRequest;
import br.com.zup.transacao.transacao.cartao.CartaoRequest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoRequest {

    private String id;
    private BigDecimal valor;
    private EstabelecimentoRequest estabelecimento;
    private CartaoRequest cartao;
    private LocalDateTime efetivadaEm;

    public String getId() { return id; }

    public BigDecimal getValor() { return valor; }

    public EstabelecimentoRequest getEstabelecimento() { return estabelecimento; }

    public CartaoRequest getCartao() { return cartao; }

    public LocalDateTime getEfetivadaEm() { return efetivadaEm; }

    public Transacao toModel() {
        return new Transacao(id, valor, estabelecimento.toModel(), cartao.toModel(), efetivadaEm);
    }
}
