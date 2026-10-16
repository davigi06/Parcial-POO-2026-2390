package core.league.game;

import core.person.Juez;
import core.person.Jugador;
import java.util.ArrayList;

/**
 *
 * @author dgbuelvas
 */
public class Juego {

    private Jugador jugador1;
    private Jugador jugador2;
    private Juez juez;
    private Juego juegoPrevio1;
    private Juego juegoPrevio2;
    private Juego juegoSiguiente;
    private ArrayList<Set> sets;

    public Juego(Jugador jugador1, Jugador jugador2, Juez juez) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.juez = juez;
        this.sets = new ArrayList<>();
        jugador1.addJuego(this);
        jugador2.addJuego(this);
        juez.addJuego(this);
    }

    public Juego(Juego juegoPrevio1, Juego juegoPrevio2, Juez juez) {
        this(juegoPrevio1.getGanador(), juegoPrevio2.getGanador(), juez);
        this.juegoPrevio1 = juegoPrevio1;
        this.juegoPrevio2 = juegoPrevio2;
        juegoPrevio1.juegoSiguiente = this;
        juegoPrevio2.juegoSiguiente = this;
    }

    public boolean addSets(Set... nuevos) {
        boolean agregado = false;
        for (Set set : nuevos) {
            if (!sets.contains(set)) {
                sets.add(set);
                agregado = true;
            }
        }
        return agregado;
    }

    public int getSetsGanados(Jugador jugador) {
        int total = 0;
        for (Set set : sets) {
            if (jugador == jugador1 && set.getPuntosJugador1() > set.getPuntosJugador2()) {
                total++;
            }
            if (jugador == jugador2 && set.getPuntosJugador2() > set.getPuntosJugador1()) {
                total++;
            }
        }
        return total;
    }

    public Jugador getGanador() {
        int sets1 = getSetsGanados(jugador1);
        int sets2 = getSetsGanados(jugador2);
        if (sets1 > sets2) {
            return jugador1;
        }
        if (sets2 > sets1) {
            return jugador2;
        }
        return null;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public Juez getJuez() {
        return juez;
    }

    public ArrayList<Set> getSets() {
        return sets;
    }
}
