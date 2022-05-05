package com.trybe.acc.java.caixaeletronico;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes para a classe Banco")
class BancoTest {

  @Test
  @DisplayName("1 - Testa o gerador de número único para nova conta.")
  void gerarNumeroNovaContaTest() {
    Banco banco = new Banco();
    assertEquals(10, banco.gerarNumeroNovaConta().length(), banco.gerarNumeroNovaConta());
  }

  @Test
  @DisplayName("2 - Testa o método adicionar pessoa cliente retorna o objeto pessoa cliente.")
  void adicionarPessoaClienteTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente =
        banco.adicionarPessoaCliente("Thiago Souza", "Corrente", "146.398.197-00", null);
    assertNotNull(pessoaCliente);
  }

  @Test
  @DisplayName("3 - Testa o método login da pessoa cliente retorna o objeto pessoa cliente corretamente.")
  void pessoaClienteLoginTest() {
    Banco banco = new Banco();
    banco.adicionarPessoaCliente("Thiago Souza", null, "146.398.197-00", "123456789");
    PessoaCliente pessoaCliente = banco.pessoaClienteLogin("146.398.197-00", "123456789");
    assertNotNull(pessoaCliente);
  }

  @Test
  @DisplayName("4 - Testa se o método transferir fundos está transferindo corretamente.")
  void depositarTestTransferirFundosTestmostrarExtratoTest() {
    Banco banco = new Banco();
    banco.adicionarPessoaCliente("Thiago Souza", "Poupança", "146.398.197-00", "123456789");
    PessoaCliente pessoaCliente = banco.pessoaClienteLogin("146.398.197-00", "123456789");
    Conta conta = new Conta("Poupança", pessoaCliente, banco);

    pessoaCliente.adicionarConta(conta);

    banco.depositar(pessoaCliente, 0, 1000.0);
    banco.transferirFundos(pessoaCliente, 0, 1, 500.0);

    assertEquals(500.0, pessoaCliente.contas.get(0).retornarSaldo());
    assertEquals(500.0, pessoaCliente.contas.get(1).retornarSaldo());
  }

  @Test
  @DisplayName("5 - Testa se o método sacar está funcionando corretamente.")
  void depositarTestSacarTestMostrarExtratoTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente =
        banco.adicionarPessoaCliente("Thiago Souza", "Poupança", "146.398.197-00", "123456789");
    Conta conta1 = new Conta("Poupança", pessoaCliente, banco);
    pessoaCliente.adicionarConta(conta1);
    banco.depositar(pessoaCliente, 0, 1000.0);
    banco.sacar(pessoaCliente, 0, 100.0);
    assertEquals(900.0, pessoaCliente.contas.get(0).retornarSaldo());
  }

}
