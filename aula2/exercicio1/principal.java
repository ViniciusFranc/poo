public class principal {

    static int[] matricula = {1,2,3,4,5,6,7,8,9,10};
    static String[] nome = {"João", "Maria", "Pedro", "Clara", "Jose", "Carla", "Fabio", "Mara", "Cesar", "Ana"};
    static int[] idade = {14,18,15,16,17,14,17,13,16,17};
    static double[] altura = {1.75,1.54,1.62,1.6,1.65,1.62,1.62,1.74,1.61,1.68};
    public static void main (String [] args){
        double mediaId = mediaIdade(idade);
        System.out.println(mediaId);

        double maisNv = maisNovos(idade);
        System.out.println(maisNv);
        }

    static double mediaIdade(int[] idade){

        long soma = 0;
        for (int i =0; i < idade.length; i++) {
            soma += idade[i];   
        }

        double media=soma/idade.length;
        return media;
        }

    static double maisNovos(int[] idade) {
        int nv1 = idade[0];
        int nv2 = idade[1];
        if (idade[nv2] > idade[nv1]){
            int tmp = nv1; 
            nv1 = nv2; 
            nv2 = tmp;
        }

        int i = 2;
        for (i=2; i < idade.length;i++) {
            if (idade[nv1] > idade[i]) {
                nv2=nv1;
                nv1=i
            }
        }


    }
}