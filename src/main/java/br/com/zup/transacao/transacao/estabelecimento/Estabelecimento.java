package br.com.zup.transacao.transacao.estabelecimento;

import javax.persistence.*;

@Embeddable
public class Estabelecimento {

    @Column(nullable = false)
    private String estabelecimentoNome;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String endereco;

    /**
     * @Deprecated somente para uso do hibernate
     */
    public Estabelecimento() {}

    public Estabelecimento(String nome, String cidade, String endereco) {
        this.estabelecimentoNome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return estabelecimentoNome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }
}
