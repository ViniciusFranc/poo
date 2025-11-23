package Accounts;

public class ContaCorrente extends ContaFinanceira{
    
    public ContaCorrente(double SaldoInicial) {
        super(SaldoInicial);
    }

    @Override
    public void ConsultarSaldo() {
        System.out.println("Valor total do portfolio: " + Saldo);
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