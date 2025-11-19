public class CartaoCredito extends ContaFinanceira{
  public CartaoCredito(double SaldoInicial) {
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