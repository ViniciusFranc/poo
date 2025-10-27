public class Comissionado extends Colaborador{
    private double valorVenda;
    protected double salarioFixo;


    public void Comissionado(){
        
    }

    public double calcularBruto() {
        double salario = valorVenda + salarioFixo;
        return salario;
        }

    public void calcularDescontos() {    }

    public void calcularLiquido() {    }

    public double registrarVenda(double v){
        valorVenda += v;
        return valorVenda;
    }

    public void registrarVenda(int qtd, double valorUn){
        double venda = qtd*valorUn;
        valorVenda = registrarVenda(venda);
    }
}