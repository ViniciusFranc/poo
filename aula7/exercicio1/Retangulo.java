public class Retangulo extends Forma implements IAreaCalculavel{
    protected float base, altura;

    public Retangulo(float base, float altura, String cor){
        this.base = base;
        this.altura = altura;
        this.cor = cor;
    }

    public float CalcularArea(){
        float area = base * altura;
        return area;
    }

        public void exibir(){
        System.out.println("seu retangulo é: " + cor + " a area e de: "+CalcularArea());
    }

}