package Accounts;

import Exceptions.*;

public class ContaCorrente extends ContaFinanceira{
    
    public ContaCorrente(double SaldoInicial) {
        super(SaldoInicial);
    }

    @Override
    public void ConsultarSaldo() {
        System.out.println("Valor saldo conta corrente: " + Saldo);
    }

    @Override
    public void SaidaValor(double valor) {
        try{
        if (Saldo > valor){
        this.Saldo -= valor;
        }else{
            throw new SaldoInsuficienteException("Saldo insuficiente para concluir a operacao.");}
        }catch(SaldoInsuficienteException msg ){
            System.out.println(msg);
        }
    }

    @Override
    public void EntradaValor(double valor) {
        this.Saldo += valor;
    }

    @Override
    public double getSaldo() {
        return Saldo;
    }
}