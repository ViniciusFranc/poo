package Accounts;

public class Cofrinho extends ContaFinanceira {
    
    public Cofrinho(double SaldoInicial) {
        super(SaldoInicial);
    }

    @Override
    public void ConsultarSaldo() {
        System.out.println("Valor de dinheiro no Cofrinho: " + Saldo);
    }

    @Override
    public void SaidaValor(double valor) {
        if (Saldo > valor){
        this.Saldo -= valor;
        }else{
        System.out.println("Saldo insuficiente");
        }
    }

    @Override
    public void EntradaValor(double valor) {
        this.Saldo += valor;
    }
    
}