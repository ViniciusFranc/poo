public class CalculadoraCientifica extends CalculadoraBase{
    public double somar(double d1, double d2){
        double soma = d1+d2;
        return soma;
    }

    public int somar(int n1, int n2){
        int soma = super.somar(n1, n2);
        return soma;
    }

    public String somar(String s1, String s2){
        String soma = s1 + s2;
        return soma;
    }
}