public abstract class ContaFinanceira {
    protected double Saldo;
    public abstract void SaidaValor(double valor);
    public abstract void EntradaValor(double valor);
    public abstract void ConsultarSaldo(double valor);

    public ContaFinanceira (double SaldoInicial){
        this.Saldo=SaldoInicial;
    }
}