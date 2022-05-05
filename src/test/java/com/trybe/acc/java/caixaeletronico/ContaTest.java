package com.trybe.acc.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Teste da classe Conta")
class ContaTest {

  @Test
  @DisplayName("6 - Testa o construtor da classe conta.")
  void construtorTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente("Thiago Souza", "146.398.197-00", "123456789");
    Conta conta = new Conta("Poupança", pessoaCliente, banco);

    assertNotNull(conta);
    assertEquals("146.398.197-00", pessoaCliente.getCpf());
    assertEquals("123456789", pessoaCliente.getSenha());
  }

  @Test
  @DisplayName("7 - Testa o método adicionar transação e retornar saldo da conta.")
  void adicionarTransacaoTestRetornarSaldoTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente("Thiago Souza", "146.398.197-00", "123456789");
    Conta conta = new Conta("Poupança", pessoaCliente, banco);
    conta.adicionarTransacao(100.0, "Depósito recebido");
    assertEquals(100.0, conta.retornarSaldo());
  }

  @Test
  @DisplayName("8 - Testa o método retornar resumo está retornando uma string com os valores corretamente.")
  void retornarResumoContaTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente =
        banco.adicionarPessoaCliente("Thiago Souza", "Poupança", "146.398.197-00", "123456789");
    Conta conta = new Conta("Poupança", pessoaCliente, banco);

    conta.adicionarTransacao(1000.0, "Depósito recebido");

    String resumo = conta.getIdConta() + " : R$" + 1000.00 + " : " + "Poupança";

    assertEquals(conta.retornarResumoConta(), resumo);
  }

  @Test
  @DisplayName("9 - Testa o método retornar extrato está imprimindo os valores corretamente.")
  void retornarExtratoTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente =
        banco.adicionarPessoaCliente("Thiago Souza", "Poupança", "146.398.197-00", "123456789");
    Conta conta = new Conta("Poupança", pessoaCliente, banco);
    Transacao transacao = new Transacao(1000.0, "Depósito recebido");
    conta.adicionarTransacao(1000.0, "Depósito recebido");
    conta.retornarExtrato();

    assertEquals(conta.retornarExtrato(), "Extrato da conta " + conta.getIdConta() + "\n"
        + transacao.retornarResumoTransacao() + "\n");
  }

  @Test
  @DisplayName("10 - Testa o método Getter do atributo idConta está retornando.")
  void getIdContaTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente("Thiago Souza", "146.398.197-00", "123456789");
    Conta conta = new Conta("Poupança", pessoaCliente, banco);

    assertNotNull(conta.getIdConta());
    assertEquals(10, conta.getIdConta().length());
  }

  @Test
  @DisplayName("11 - Testa o método método Getter do atributo pessoaCliente está retornando.")
  void getPessoaClienteTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente("Thiago Souza", "146.398.197-00", "123456789");
    Conta conta = new Conta("Poupança", pessoaCliente, banco);
    pessoaCliente.adicionarConta(conta);

    assertNotNull(conta.getPessoaCliente());
    assertEquals(pessoaCliente, conta.getPessoaCliente());
  }

}
