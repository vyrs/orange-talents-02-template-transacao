package br.com.zup.transacao.transacao.cartao;

public class CartaoRequest {

    private String id;
    private String email;

    public String getId() { return id; }

    public String getEmail() { return email; }

    public Cartao toModel() {
        return new Cartao(id, email);
    }
}
