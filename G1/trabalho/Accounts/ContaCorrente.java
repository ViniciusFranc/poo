public class ContaCorrente extends ContaFinanceira{
      public ContaCorrente(double SaldoInicial) {
        super(SaldoInicial);
    }

    @Override
    protected void transferencia() {
    }

    @Override
    protected void credito() {
    }

    @Override
    protected void debito() {
    }
    
}