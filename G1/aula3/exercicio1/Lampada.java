
public class Lampada {
    boolean ligada;

    public void ligar(){
        if (isLigada() == false){
            ligada = true;
        } else {
            System.out.println("a lampada ja esta ligada");
        }
    }

    public void desligar(){
        if (isLigada()==true){
            ligada = false;
        } else {
            System.out.println("a lampada ja esta desligada");
        }
    }

    public boolean isLigada(){
        return ligada;
    }
}
