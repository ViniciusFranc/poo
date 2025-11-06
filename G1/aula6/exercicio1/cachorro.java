public class cachorro extends Animal{

    public cachorro(String nome){
        super(nome);
    }

    public void emitirSom(){
        System.out.println(nome + " au au");
    }
}