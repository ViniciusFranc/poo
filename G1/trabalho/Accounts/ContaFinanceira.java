public abstract class ContaFinanceira {
    protected double Saldo;
    protected abstract void SaidaValor(double valor);
    protected abstract void EntradaValor(double valor);
    protected abstract void ConsultarSaldo(double valor);

    public ContaFinanceira (double SaldoInicial){
        this.Saldo=SaldoInicial;
    }
}