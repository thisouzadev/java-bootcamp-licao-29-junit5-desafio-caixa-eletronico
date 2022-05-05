package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;

public class Conta {
  public String tipoConta;
  public String idConta;
  public PessoaCliente pessoaCliente;

  ArrayList<Transacao> transacoes = new ArrayList<Transacao>();

  /**
   * Construtor da classe Conta.
   */
  public Conta(String tipoConta, PessoaCliente pessoaCliente, Banco banco) {
    this.tipoConta = tipoConta;
    this.idConta = banco.gerarNumeroNovaConta();
    this.pessoaCliente = pessoaCliente;
  }

  /**
   * Método adicionar Transacao.
   * 
   */
  public void adicionarTransacao(double quantia, String descricao) {
    Transacao transacao = new Transacao(quantia, descricao);
    transacoes.add(transacao);
  }

  /**
   * Método retornarSaldo.
   * 
   */
  public double retornarSaldo() {
    double saldo = 0;

    for (Transacao transacao : transacoes) {
      saldo += transacao.getQuantia();
    }
    return saldo;
  }

  /**
   * Método retornar Resumo Conta.
   * 
   */
  public String retornarResumoConta() {
    String numeroConta = String.valueOf(this.idConta);
    String quantiaTotal = "R$" + String.valueOf(this.retornarSaldo());
    String tipo = this.tipoConta;

    return numeroConta + " : " + quantiaTotal + " : " + tipo;
  }

  /**
   * Método retornar Extrato.
   * 
   */
  public String retornarExtrato() {
    String titulo = "Extrato da conta " + this.idConta + "\n";

    for (Transacao transacao : transacoes) {
      titulo = titulo + transacao.retornarResumoTransacao() + "\n";
    }
    return titulo;
  }

  public String getIdConta() {
    return idConta;
  }

  public PessoaCliente getPessoaCliente() {
    return pessoaCliente;
  }
}
