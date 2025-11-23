public class ContaDigital extends ContaFinanceira{

    public ContaDigital(double SaldoInicial) {
        super(SaldoInicial);
    }

    @Override
    public void ConsultarSaldo(double valor) {

        if (Saldo > valor){
        this.Saldo -= valor;
        }else{
        System.out.println("Saldo insuficiente");
        }
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