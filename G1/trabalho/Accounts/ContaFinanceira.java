package Accounts;

import Exceptions.*;
public abstract class ContaFinanceira {
    protected double Saldo;
    public abstract void SaidaValor(double valor) throws SaldoInsuficienteException;
    public abstract void EntradaValor(double valor);
    public abstract void ConsultarSaldo();

    public ContaFinanceira (double SaldoInicial){
        this.Saldo=SaldoInicial;
    }

    public abstract double getSaldo();
}