package dataStructure.Pilha;


// inversao de dados com pilha

public class ProblemaResolvido {
    public static void main(String[] args) {
        int [] numeros = {5,4,3,2,1,0};

        inverter(numeros);
    }

    private static void inverter(int[] numeros) {
        Pilha pilha = new Pilha(numeros[0]);
        
        for (int i = 1 ; i < numeros.length ; i++) {
            pilha.push(numeros[i]);
        }

        var node = pilha.pop();
        while (node != null) {
            System.out.println(node.getValue());
            node = pilha.pop();
        }
    }
}
