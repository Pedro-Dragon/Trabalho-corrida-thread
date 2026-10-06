package Modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Placar {
    private Map<String, Double> posicoes = new HashMap<>();

    public synchronized void atualizar(String nomeCarro, double distancia) {
        posicoes.put(nomeCarro, distancia);
        mostrarPlacar();
    }

    public void mostrarPlacar() {
        System.out.println("\n === PLACAR ===");
        List<Map.Entry<String, Double>> ordenados = posicoes.entrySet().stream()
                .sorted(((c1, c2) -> Double.compare(c2.getValue(), c1.getValue())))
                .toList();

        for (int i = 0; i < ordenados.size(); i++) {
            Map.Entry<String, Double> entry = ordenados.get(i);
            int posicao = i + 1;
            System.out.println(posicao + "º lugar: " + entry.getKey() +
                    " -> " + String.format("%.2f", entry.getValue()) + " metros");
        }

        System.out.println("====================\n");
    }
}
