public abstract class ContaFinanceira {
    protected double Saldo;
    protected abstract void debito();
    protected abstract void credito();
    protected abstract void transferencia();

    public ContaFinanceira (double SaldoInicial){
        this.Saldo=SaldoInicial;
    }
}