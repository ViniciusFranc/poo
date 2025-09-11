public class CalcularMedia {
    public static void main (String[] args) {
        aluno vinicius = new aluno();
        vinicius.Nome="Vinicius";
        vinicius.g1=9.5f;
        vinicius.g2=8.9f;
        vinicius.calcularMedia();
        System.out.println(vinicius.media);


        aluno cassoleta = new aluno();
        cassoleta.Nome="Cassol";
        cassoleta.g1=1.0f;
        cassoleta.g2=4.9f;
        cassoleta.calcularMedia();
        System.out.println(cassoleta.media);


    }
}       