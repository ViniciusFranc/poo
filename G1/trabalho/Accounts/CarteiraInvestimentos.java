public class CarteiraInvestimentos extends ContaFinanceira{
    
      public CarteiraInvestimentos(double SaldoInicial) {
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