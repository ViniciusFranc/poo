package Accounts;

public class ContaDigital extends ContaFinanceira{

    private double SaldoInicial;
    
    public ContaDigital(double SaldoInicial) {
        super(SaldoInicial);
        this.SaldoInicial=SaldoInicial;
    }

    @Override
    public void ConsultarSaldo() {
        System.out.println("Valor saldo conta digital: " + Saldo);
    }

    @Override
<<<<<<< Updated upstream
    public void SaidaValor(double valor) {
        if (Saldo > valor){
        this.Saldo -= valor;
        }else{
        System.out.println("Saldo insuficiente");
=======
    public void SaidaValor(double valor) throws  SaldoInsuficienteException {
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
>>>>>>> Stashed changes
        }
    }
    }

    @Override
    public void EntradaValor(double valor) {
        this.Saldo += valor;
    }

    public double getSaldo() {
        return Saldo;
    }
}