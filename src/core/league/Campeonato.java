package core.league;

import core.league.game.Juego;
import core.league.game.Set;
import core.person.Jugador;
import java.util.ArrayList;

/**
 *
 * @author dgbuelvas
 */
public class Campeonato {

    private ArrayList<Juego> juegos;

    public Campeonato() {
        this.juegos = new ArrayList<>();
    }

    public boolean addJuego(Juego juego) {
        if (!juegos.contains(juego)) {
            juegos.add(juego);
            return true;
        }
        return false;
    }

    public Juego getJuego(int indice) {
        return juegos.get(indice);
    }

    public Jugador getGanador() {
        return juegos.get(juegos.size() - 1).getGanador();
    }

    public int getSetsGanados(Jugador jugador) {
        int total = 0;
        for (Juego juego : juegos) {
            total += juego.getSetsGanados(jugador);
        }
        return total;
    }

    public void showResumen() {
        for (Juego juego : juegos) {
            System.out.println("Jugador 1: " + juego.getJugador1().getNombre());
            System.out.println("Jugador 2: " + juego.getJugador2().getNombre());
            System.out.println("Juez: " + juego.getJuez().getNombre());
            int numero = 1;
            for (Set set : juego.getSets()) {
                System.out.println("Set " + numero + ": " + set.getPuntosJugador1() + " - " + set.getPuntosJugador2());
                numero++;
            }
            System.out.println("Ganador: " + juego.getGanador().getNombre());
            System.out.println();
        }
        System.out.println("El ganador del campeonato es: " + getGanador().getNombre());
        System.out.println();
    }
}
