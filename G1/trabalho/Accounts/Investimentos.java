public class Investimentos {

    protected Double valor;
    protected double rentabilidade;
    protected String dataPayback;

    public Investimentos (Double valor, double rentabilidade,String dataPayback){
    this.rentabilidade=rentabilidade;
    this.valor=valor;
    this.dataPayback = dataPayback;
    }
}