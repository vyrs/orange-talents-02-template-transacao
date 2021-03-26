package br.com.zup.transacao.kafka;

import br.com.zup.transacao.transacao.Transacao;
import br.com.zup.transacao.transacao.TransacaoRepository;
import br.com.zup.transacao.transacao.TransacaoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class ListenerDeTransacao {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoRequest request) {
        System.out.println("------------------------------------------");
        System.out.println("Processando nova transação!");
        Transacao transacao = request.toModel();
        transacaoRepository.save(transacao);
        System.out.println("Terminou processamento!");
    }
}
