package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;
import java.util.Random;

public class Banco {
  ArrayList<PessoaCliente> pessoasClientes = new ArrayList<PessoaCliente>();
  ArrayList<Conta> contas = new ArrayList<Conta>();

  /**
   * Método por gerar número da nova conta.
   */
  public String gerarNumeroNovaConta() {
    Random random = new Random();
    String novaConta = "";
    for (int index = 0; index < 10; index++) {
      Integer numeroConta = random.nextInt(10);
      novaConta = novaConta.concat(String.valueOf(numeroConta));
    }
    return novaConta;
  }

  /**
   * Método por adicionar pessoa cliente.
   * 
   */
  public PessoaCliente adicionarPessoaCliente(String nome, String tipoConta, String cpf,
      String senha) {
    PessoaCliente pessoaCliente = new PessoaCliente(nome, cpf, senha);
    Conta conta = new Conta(tipoConta, pessoaCliente, this);
    pessoasClientes.add(pessoaCliente);

    contas.add(conta);
    pessoaCliente.adicionarConta(conta);

    return pessoaCliente;
  }

  /**
   * Método por gerenciar o login.
   * 
   */
  public PessoaCliente pessoaClienteLogin(String cpf, String senha) {
    PessoaCliente pessoaCliente = null;

    for (PessoaCliente cliente : pessoasClientes) {
      if (cliente.getCpf().equals(cpf) && cliente.getSenha().equals(senha)) {
        pessoaCliente = cliente;
      }
    }
    return pessoaCliente;
  }

  public void adicionarConta(Conta conta) {
    this.contas.add(conta);
  }

  /**
   * Método por depositar.
   * 
   */
  public void depositar(PessoaCliente pessoaCliente, int daConta, double quantia) {
    Conta conta = this.contas.get(daConta);
    conta.adicionarTransacao(quantia, "Depósito recebido");
  }

  /**
   * Método por sacar.
   * 
   */
  public void sacar(PessoaCliente pessoaCliente, int daConta, double quantia) {
    Conta conta = this.contas.get(daConta);
    conta.adicionarTransacao(-quantia, "Saque efetuado");
  }

  /**
   * Método por transferir fundos.
   * 
   */
  public void transferirFundos(PessoaCliente pessoaCliente, int daConta, int paraConta,
      double quantia) {
    pessoaCliente.contas.get(daConta).adicionarTransacao(-quantia, "Transferência efetuada");
    pessoaCliente.contas.get(paraConta).adicionarTransacao(quantia, "Transferência recebida");
  }

}
