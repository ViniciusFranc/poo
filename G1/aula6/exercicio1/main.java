public class main{
    public static void main(String[] args) {
        Animal[] animais = { new cachorro("cusco"), new gato("gato")};
        
        for (Animal a : animais){
            a.emitirSom();
        }
    }
}