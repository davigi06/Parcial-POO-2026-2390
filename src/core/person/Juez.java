package core.person;

import core.league.game.Juego;
import java.util.ArrayList;

/**
 *
 * @author dgbuelvas
 */
public class Juez extends Persona {

    private int edad;
    private ArrayList<Juego> juegos;

    public Juez(String nombre, int edad) {
        super(nombre);
        this.edad = edad;
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
