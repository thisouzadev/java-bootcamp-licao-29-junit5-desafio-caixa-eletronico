package com.trybe.acc.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes dos métodos da classe Transacao")
class TransacaoTest {


  @Test
  @DisplayName("21 - Testa o método construtor da classe Transacao.")
  void construtorTest() {
    Transacao transacao = new Transacao(1000.0, "teste de transação");
    assertEquals(1000.0, transacao.getQuantia());

  }


  @Test
  @DisplayName("22 - Testa o método Getter do atributo quantia.")
  void getQuantiaTest() {
    Transacao transacao = new Transacao(1000.0, "teste de transação");
    assertEquals(1000.0, transacao.getQuantia());
  }

  @Test
  @DisplayName("23 - Testa o método retornar resumo transacao.")
  void retornarResumoTransacaoTest() {
    Transacao transacao = new Transacao(100.0, "teste de transação");
    assertTrue(transacao.retornarResumoTransacao().contains("teste de transação"));
  }

  @Test
  @DisplayName("24 - Testa o método instante está gerando o instante corretamente.")
  void retornarInstanteTest() {
    Transacao transacao = new Transacao(1000.0, "Depósito recebido");
    String instante = transacao.retornarInstante();
    LocalDateTime testeInstante = LocalDateTime.now();
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:MM:SS");
    String dateTimeAtualFormatado = testeInstante.format(formatador);

    assertEquals(dateTimeAtualFormatado, instante);
  }

}
