package core.league;

import core.person.Juez;
import core.person.Jugador;
import java.util.ArrayList;

/**
 *
 * @author dgbuelvas
 */
public class LigaTenis {

    private ArrayList<Campeonato> campeonatos;
    private ArrayList<Juez> jueces;
    private ArrayList<Jugador> jugadores;

    public LigaTenis() {
        this.campeonatos = new ArrayList<>();
        this.jueces = new ArrayList<>();
        this.jugadores = new ArrayList<>();
    }

    public boolean addCampeonato(Campeonato campeonato) {
        if (!campeonatos.contains(campeonato)) {
            campeonatos.add(campeonato);
            return true;
        }
        return false;
    }

    public boolean addJuez(Juez juez) {
        if (!jueces.contains(juez)) {
            jueces.add(juez);
            return true;
        }
        return false;
    }

    public boolean addJugador(Jugador jugador) {
        if (!jugadores.contains(jugador)) {
            jugadores.add(jugador);
            return true;
        }
        return false;
    }

    public Campeonato getCampeonato(int indice) {
        return campeonatos.get(indice);
    }

    public Juez getJuez(int indice) {
        return jueces.get(indice);
    }

    public Jugador getJugador(int indice) {
        return jugadores.get(indice);
    }

    public void calcSetsGanadosJugadoresCampeonato(int indice) {
        Campeonato campeonato = campeonatos.get(indice);
        for (Jugador jugador : jugadores) {
            System.out.println("El jugador: " + jugador.getNombre() + " gano " + campeonato.getSetsGanados(jugador) + " sets en el campeonato");
        }
    }
}
