package Accounts;

import Exceptions.*;
public class Cofrinho extends ContaFinanceira {
    
    public Cofrinho(double SaldoInicial) {
        super(SaldoInicial);
    }

    @Override
    public void ConsultarSaldo() {
        System.out.println("Valor de dinheiro no Cofrinho: " + Saldo);
    }

    @Override
    public void SaidaValor(double valor) throws SaldoInsuficienteException {
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