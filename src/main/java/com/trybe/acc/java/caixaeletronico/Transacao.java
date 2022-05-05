package com.trybe.acc.java.caixaeletronico;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {
  protected double quantia;
  protected String instante;
  protected String descricao;
  Conta conta;

  /**
   * Construtor da classe Transacao.
   */
  public Transacao(double quantia, String descricao) {
    this.quantia = quantia;
    this.descricao = descricao;
    this.instante = this.retornarInstante();
  }

  /**
   * Método getQuantia.
   * 
   */
  public double getQuantia() {
    return quantia;
  }

  /**
   * Método Responsável por retornar o instante da transação.
   */
  public String retornarInstante() {
    LocalDateTime dataHoraAtual = LocalDateTime.now();
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:MM:SS");

    return dataHoraAtual.format(formatador);
  }

  /**
   * Método responsável pelo resumo da transação.
   */
  public String retornarResumoTransacao() {
    return this.instante + " ------- " + this.descricao + ": R$ " + this.quantia;
  }


}

