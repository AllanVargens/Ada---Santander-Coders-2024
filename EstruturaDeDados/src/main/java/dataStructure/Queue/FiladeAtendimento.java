package dataStructure.Queue;

import java.util.Random;

// programa java que simule uma fila de atendimento onde cada cliente sera atendido um por um
public class FiladeAtendimento {
    public static void main(String[] args) {
        int n = 5; // quantidade de clientes
        var random = new Random();
        int cliente = random.nextInt(101);

        Queue fila = new Queue(cliente);

        System.out.println("Chegou o cliente: " + cliente);

        // Simula a chegada dos clientes

        for (int i = 2; i < n; i++) {
            cliente = random.nextInt(101);
            System.out.println("Chegou o cliente: " + cliente);
            fila.enqueue(cliente);
        }

        // Atendimento

        var node = fila.dequeue();
        while (node != null) {
            System.out.println("Atendido ao cliente: " + node.getValue());
            node = fila.dequeue();
        }
    }
}
