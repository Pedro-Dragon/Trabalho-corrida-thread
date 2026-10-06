package Modelo;

public class Carro implements Runnable{
    private String nome;
    private Double distanciaTotalCorrida;
    private Double distanciaPercorrida;
    private Podio podio;
    private Placar placar;

    public Carro (String nome, Double distanciaTotalCorrida, Podio podio, Placar placar) {
        this.nome = nome;
        this.distanciaTotalCorrida = distanciaTotalCorrida;
        this.distanciaPercorrida = 0.0;
        this.podio = podio;
        this.placar = placar;
    }

    @Override
    public void run() {
        while (distanciaPercorrida < distanciaTotalCorrida) {
            double incremento = 10 + Math.random() * 40;
            distanciaPercorrida += incremento;

            if(distanciaPercorrida > distanciaTotalCorrida) {
                distanciaPercorrida = distanciaTotalCorrida;
            }

            System.out.println(nome + " andou " + String.format("%.2f", incremento) +
                    " metros e já percorreu " + String.format("%.2f", distanciaPercorrida) +
                    " de " + distanciaTotalCorrida + "metros"
            );

            placar.atualizar(nome, distanciaPercorrida);

            // pausa entre 100 e 500ms
            try {
                long pausa = 100 + (long)(Math.random() * 400);
                Thread.sleep(pausa);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // pit stop
            try {
                if (distanciaPercorrida >= distanciaTotalCorrida/ 2 && Math.random() < 0.3) {
                    System.out.println(nome + "está no pit stop");
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nome + " cruzou a linha de chegada!");
        podio.registrarVencedor(nome);
    }
}
