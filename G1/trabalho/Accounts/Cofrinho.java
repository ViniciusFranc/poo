public class Cofrinho extends ContaFinanceira {
    
    public Cofrinho(double SaldoInicial) {
        super(SaldoInicial);
    }

    @Override
    protected void ConsultarSaldo(double valor) {

        if (Saldo > valor){
        this.Saldo -= valor;
        }else{
        System.out.println("Saldo insuficiente");
        }
    }

    @Override
    protected void SaidaValor(double valor) {
        if (Saldo > valor){
        this.Saldo -= valor;
        }else{
        System.out.println("Saldo insuficiente");
        }
    }

    @Override
    protected void EntradaValor(double valor) {
        this.Saldo += valor;
    }
    
}