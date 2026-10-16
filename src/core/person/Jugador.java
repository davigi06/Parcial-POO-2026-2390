package core.person;

import core.league.game.Juego;
import java.util.ArrayList;

/**
 *
 * @author dgbuelvas
 */
public class Jugador extends Persona {

    private int sueldo;
    private ArrayList<Juego> juegos;

    public Jugador(String nombre, int sueldo) {
        super(nombre);
        this.sueldo = sueldo;
        this.juegos = new ArrayList<>();
    }

    public boolean addJuego(Juego juego) {
        if (!juegos.contains(juego)) {
            juegos.add(juego);
            return true;
        }
        return false;
    }
}
