package Accounts;

public class Investimentos {

    protected double valor;
    protected double rentabilidade;
    protected String dataPayback;

    public Investimentos (Double valor, double rentabilidade,String dataPayback){
    this.rentabilidade=rentabilidade;
    this.valor=valor;
    this.dataPayback = dataPayback;
    }

    public double getValor() {
        return valor;
    }

    public double getRentabilidade() {
        return rentabilidade;
    }

    public String getDataPayback() {
        return dataPayback;
    }

}