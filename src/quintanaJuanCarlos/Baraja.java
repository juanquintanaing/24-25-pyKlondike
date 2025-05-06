
class Baraja {

    private static final int MAXIMO_CARTAS = 52;
    private final Carta[] CARTAS = new Carta[MAXIMO_CARTAS];
    private int numeroCartas = MAXIMO_CARTAS;

    public Baraja() {
        for (int palo = 1; palo <= 4; palo++) {
            for (int valor = 1; valor <= 13; valor++) {
                CARTAS[(palo - 1) * 13 + (valor - 1)] = new Carta(palo, valor);
            }
        }
    }

    public void barajar() {
        for (int i = 0; i < CARTAS.length; i++) {
            int randomIndex = (int) (Math.random() * CARTAS.length);
            Carta temp = CARTAS[i];
            CARTAS[i] = CARTAS[randomIndex];
            CARTAS[randomIndex] = temp;
        }
    }

    public Carta sacarCarta() {
        if (numeroCartas > 0) {
            Carta carta = CARTAS[numeroCartas - 1];
            numeroCartas--;
            return carta;
        } else {
            return null;
        }
    }

    public Carta[] sacarCarta(int numeroCartas) {
        if (numeroCartas > this.numeroCartas) {
            numeroCartas = this.numeroCartas;
        }
        Carta[] cartas = new Carta[numeroCartas];
        for (int i = 0; i < numeroCartas; i++) {
            cartas[i] = sacarCarta();
        }
        return cartas;
    }

    public void ponerCarta(Carta[] cartas) {
        for (Carta carta : cartas) {
            if (numeroCartas < MAXIMO_CARTAS) {
                this.CARTAS[numeroCartas] = carta;
                numeroCartas++;
            } else {
                System.out.println("La baraja está llena. No se pueden añadir más cartas.");
            }
        }
    }

    public boolean estaVacio() {
        return numeroCartas == 0;
    }

    public void mostrar() {
        getUltimaCarta().mostrar();
    }

    private Carta getUltimaCarta() {
        return CARTAS[numeroCartas - 1];
    }

}
