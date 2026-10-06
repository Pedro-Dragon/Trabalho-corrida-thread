package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Podio {
    private List<String> vencedores = new ArrayList<>();

    public synchronized void registrarVencedor(String nomeCarro) {
        if (vencedores.size() < 3) {
            vencedores.add(nomeCarro);
            System.out.println(nomeCarro + "ficou em " + vencedores.size() + " ° lugar!");
        }
    }

    public void mostrarPodio() {
        System.out.println("\n === PÓDIO ===");
        for (int i = 0; i < vencedores.size(); i++) {
            System.out.println((i + 1) + "° lugar: " + vencedores.get(i));
        }
    }
}
