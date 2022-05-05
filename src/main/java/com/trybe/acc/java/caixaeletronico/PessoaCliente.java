package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;

public class PessoaCliente {
  public String nomeCompleto;
  protected String cpf;
  protected String senha;
  ArrayList<Conta> contas = new ArrayList<Conta>();

  /**
   * Construtor da classe PessoaCliente.
   */
  public PessoaCliente(String nome, String cpf, String senha) {
    this.nomeCompleto = nome;
    this.cpf = cpf;
    this.senha = senha;

    System.out
        .println("Nova pessoa cliente " + this.nomeCompleto + " com CPF: " + this.cpf + " criada!");
  }

  /**
   * Método adicionar Conta.
   * 
   */
  public void adicionarConta(Conta conta) {
    this.contas.add(conta);
  }

  /**
   * Método retorna Numero De Contas.
   * 
   */
  public int retornaNumeroDeContas() {
    return this.contas.size();
  }

  /**
   * Método retornar Saldo Conta Especifica.
   * 
   */
  public double retornarSaldoContaEspecifica(int indice) {
    return this.contas.get(indice).retornarSaldo();
  }

  /**
   * Método retornar Id Conta Especifica.
   * 
   */
  public String retornarIdContaEspecifica(int indice) {
    return this.contas.get(indice).getIdConta();
  }

  /**
   * Método retornar Extrato Conta Especifica.
   * 
   */
  public String retornarExtratoContaEspecifica(int indice) {
    return contas.get(indice).retornarExtrato();
  }

  /**
   * Método adicionar Transacao Conta Especifica.
   * 
   */
  public void adicionarTransacaoContaEspecifica(int indice, double quantia, String descricao) {
    this.contas.get(indice).adicionarTransacao(quantia, descricao);
  }

  /**
   * Método verificar Senha.
   * 
   */
  public boolean verificarSenha(String senha) {
    return this.senha.equals(senha);
  }

  /**
   * Método getCpf.
   * 
   */
  public String getCpf() {
    return cpf;
  }

  /**
   * Método getSenha.
   * 
   */
  public String getSenha() {
    return senha;
  }

}
