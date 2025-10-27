public class Circulo extends Forma implements IAreaCalculavel{

    protected float r;

    public Circulo(float r, String cor){
        this.r = r;
        this.cor = cor;
    }


    public float CalcularArea(){
        float area = 3.14f * r*r;
        return area;
    }

    public void exibir(){
        System.out.println("seu circulo é: " + cor + " a area e de: "+CalcularArea());
    }
}