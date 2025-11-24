package Accounts;

public class ContaCorrente extends ContaFinanceira{
    
    private double SaldoInicial;
    
    public ContaCorrente(double SaldoInicial) {
        super(SaldoInicial);
        this.SaldoInicial=SaldoInicial;
    }

    @Override
    public void ConsultarSaldo() {
        System.out.println("Valor saldo conta corrente: " + Saldo);
    }

    @Override
    public void SaidaValor(double valor) throws  SaldoInsuficienteException{
        try{
        if (Saldo > valor){
        this.Saldo -= valor;
        }else{
            throw new SaldoInsuficienteException("Saldo insuficiente para concluir a operacao.");}
        }catch(SaldoInsuficienteException msg ){
            System.out.println(msg);
        }finally{
            if (Saldo < (SaldoInicial*0.15)){
                System.out.println("!!! Seu saldo esta abaixo de 15% do valor inicial");
        }
    }
    }

    @Override
    public void EntradaValor(double valor) {
        this.Saldo += valor;
    }

    @Override
    public double getSaldo() {
        return Saldo;
    }
}