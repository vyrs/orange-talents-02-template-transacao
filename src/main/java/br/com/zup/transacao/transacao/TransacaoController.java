package br.com.zup.transacao.transacao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/cartoes")
public class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    private final Logger logger = LoggerFactory.getLogger(TransacaoController.class);

    @GetMapping("/{cartaoId}")
    @Transactional(readOnly = true)
    public ResponseEntity<?> busca(@PathVariable("cartaoId") String cartaoId) {
        logger.info("Iniciando Busca de transações");

        if (!transacaoRepository.existsByCartaoId(cartaoId)) return ResponseEntity.notFound().build();

        List<Transacao> transacoes = transacaoRepository.findFirst10ByCartaoIdOrderByEfetivadaEmDesc(cartaoId);

        logger.info("Transações encontradas com sucesso!");
        return ResponseEntity.ok().body(transacoes);
    }
}
