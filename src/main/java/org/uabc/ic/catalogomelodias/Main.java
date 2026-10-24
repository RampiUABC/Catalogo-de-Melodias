package org.uabc.ic.catalogomelodias;

import org.uabc.ic.catalogomelodias.Controlador.Controlador;
import org.uabc.ic.catalogomelodias.Modelo.Catalogo;
import org.uabc.ic.catalogomelodias.Vista.CatalogoView;

public class Main {
    public static void main(String[] args) {
        Catalogo modelo = new Catalogo();
        //canciones para catalogo
        modelo.crearObjetoMelodia("Sentimental", "Joan Sebastian", 2002, "RANCHERA", "Joan Sebastian", 25.0, "mp3");
        modelo.crearObjetoMelodia("Eres todo todo", "Jose Luis Delgado", 1981, "RANCHERA", "Fidencio Ayala", 20.0, "wav");
        modelo.crearObjetoMelodia("Frances Limon", "Marciano Cantero", 2002, "ROCK", "Los Enanitos Verdes", 30.0, "mp3");
        CatalogoView vista = new CatalogoView();
        Controlador controlador = new Controlador(modelo, vista);

        controlador.iniciar();
    }
}