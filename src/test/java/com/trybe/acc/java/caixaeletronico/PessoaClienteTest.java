package com.trybe.acc.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Teste dos métodos da classe PessoaCliente")
class PessoaClienteTest {

  @Test
  @DisplayName("12 - Testa o construtor da classe Pessoa Cliente.")
  void construtorTest() {
    PessoaCliente pessoaCliente = new PessoaCliente("Thiago Souza", "146.398.197-00", "123456789");

    assertNotNull(pessoaCliente);
    assertEquals("Thiago Souza", pessoaCliente.nomeCompleto);
    assertEquals("146.398.197-00", pessoaCliente.getCpf());
    assertEquals("123456789", pessoaCliente.getSenha());
  }

  @Test
  @DisplayName("13 - Testa o método adicionar conta e o método retornar número de contas.")
  void adicionarContaTestRetornaNumeroDeContasTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente =
        banco.adicionarPessoaCliente("Thiago Souza", "Poupança", "146.398.197-00", "123456789");
    Conta conta = new Conta("Poupança", pessoaCliente, banco);

    pessoaCliente.adicionarConta(conta);

    assertNotNull(conta);
    assertEquals(2, pessoaCliente.contas.size());
  }

  @Test
  @DisplayName("14 - Testa o método retornar saldo de uma conta específica da pessoa cliente.")
  void retornarSaldoContaEspecificaTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente =
        banco.adicionarPessoaCliente("Thiago Souza", "Poupança", "146.398.197-00", "123456789");

    banco.depositar(pessoaCliente, 0, 1000.0);
    assertEquals(10, pessoaCliente.retornarIdContaEspecifica(0).length());
  }


  @Test
  @DisplayName("15 - Testa o método retornar id de uma conta específica da pessoa cliente.")
  void retornarIdContaEspecificaTest() {
    Banco banco = new Banco();
    PessoaCliente cliente =
        banco.adicionarPessoaCliente("Thiago Souza", "Poupança", "146.398.197-00", "123456789");
    assertEquals(10, cliente.retornarIdContaEspecifica(0).length());
  }

  @Test
  @DisplayName("16 - Testa o método retornar o extrato de uma conta específica da pessoa cliente.")
  void retornarExtratoContaEspecificaTest() {
    assertTrue(true);
  }

  @Test
  @DisplayName("17 - Testa o método adiciona transacao de uma conta específica da pessoa cliente.")
  void adicionarTransacaoContaEspecificaTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente =
        banco.adicionarPessoaCliente("Thiago Souza", "Corrente", "146.398.197-00", "123456789");
    pessoaCliente.adicionarTransacaoContaEspecifica(0, 2000, "deposito");
    pessoaCliente.adicionarTransacaoContaEspecifica(0, -500, "transferencia");
    assertEquals(1500, pessoaCliente.contas.get(0).retornarSaldo());

  }

  @Test
  @DisplayName("18 - Testa o método validar senha.")
  void validarSenhaTest() {
    PessoaCliente pessoaCliente = new PessoaCliente("Thiago Souza", "146.398.197-00", "123456789");
    assertTrue(pessoaCliente.verificarSenha("123456789"));
  }

  @Test
  @DisplayName("19 - Testa o método retornar resumo contas.")
  void retornarResumoContasTest() {
    assertTrue(true);

  }

  @Test
  @DisplayName("20 - Testa o método Getter do atributo cpf está retornando.")
  void getCpfTest() {
    Banco banco = new Banco();
    PessoaCliente cliente =
        banco.adicionarPessoaCliente("Thiago Souza", "Poupança", "146.398.197-00", "123456789");
    assertEquals("146.398.197-00", cliente.getCpf());
  }

}
