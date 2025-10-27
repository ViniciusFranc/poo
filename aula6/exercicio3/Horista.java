public class Horista extends Colaborador{
    protected double ValorHora = 2.5d;
    protected double  horaMensal;

    public double calcularBruto() {

        double salarioBruto;

        if (horaMensal > 176){
            salarioBruto = (horaMensal * ValorHora)*1.5;

        } else {
            salarioBruto = horaMensal * ValorHora;

        }

        return salarioBruto;
    }


    public void calcularDescontos() {    }

    public void calcularLiquido() {    }


    public void registrarHoras(double h){
        horaMensal = h;
    }


    public void registrarHoras(int h, int m){
        double horas = h + (m/60);
        horaMensal= horas;
    }
}