package org.uabc.ic.catalogomelodias.Controlador;

import org.uabc.ic.catalogomelodias.Modelo.Catalogo;
//nuevo codigo agregado
import org.uabc.ic.catalogomelodias.Modelo.Melodia;
import org.uabc.ic.catalogomelodias.Vista.CatalogoView;

//nuevo codigo agregado
import java.util.ArrayList;

public class Controlador {
    private Catalogo modelo;
    private CatalogoView vista;

    public Controlador(Catalogo modelo, CatalogoView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        int opcion = 0;
        while (opcion != 3) {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1: vista.mostrarCadena("Registrar una melodia nueva: ");
                    String nm = vista.leerNombreMelodia();
                    String co = vista.leerCompositor();
                    int am = vista.leerAnioMelodia();
                    String ge = vista.mostrarGenero();
                    String ca = vista.leerCantante();
                    double pr = vista.leerPrecio();
                    String fo = vista.mostrarFormato();

                    modelo.crearObjetoMelodia(nm,co,am,ge,ca,pr,fo);

                    break;
                case 2: vista.mostrarCadena(modelo.mostrarTodasLasMelodias());
                    break;
                //nuevo codigo agregado
                case 4: menuConsultas();
                    break;
                case 5: eliminarMelodia();
                    break;
                case 6: modificarMelodia();
                    break;
                case 7: menuReportes();
                    break;
                case 8: mostrarCatalogoOrdenado();
                    break;
                case 3: vista.mostrarCadena("ADIOS");
            }
        }
    }

    //nuevo codigo agregado
    private void menuConsultas() {
        int op = -1;
        while (op != 0) {
            op = vista.mostrarMenuConsultas();
            switch (op) {
                case 1: vista.mostrarMelodias(modelo.buscarPorNombre(vista.leerNombreABuscar()));
                    break;
                case 2: vista.mostrarMelodias(modelo.melodiasPorCantante(vista.leerCantanteABuscar()));
                    break;
                case 3: vista.mostrarMelodias(modelo.melodiasPorCompositor(vista.leerCompositorABuscar()));
                    break;
                case 4: vista.mostrarMelodias(modelo.melodiasPorArtista(vista.leerArtistaABuscar()));
                    break;
                case 5: vista.mostrarMelodias(modelo.melodiasPorAnio(vista.leerAnioABuscar()));
                    break;
                case 6: vista.mostrarMelodias(modelo.melodiasPorGenero(vista.mostrarGenero()));
                    break;
            }
        }
    }

    private void eliminarMelodia() {
        Melodia seleccionada = seleccionarMelodia(vista.leerNombreABuscar());
        if (seleccionada != null) {
            vista.mostrarCadena(seleccionada.toString());
            if (vista.leerConfirmacion("Seguro que deseas eliminar esta melodia?")) {
                modelo.eliminarMelodia(seleccionada);
                vista.mostrarCadena("Melodia eliminada.");
            } else {
                vista.mostrarCadena("Eliminacion cancelada.");
            }
        }
    }

    private void modificarMelodia() {
        Melodia melodia = seleccionarMelodia(vista.leerNombreABuscar());
        if (melodia != null) {
            String nombre = melodia.getNombre();
            String compositor = melodia.getCompositor();
            int anio = melodia.getAnio();
            String genero = melodia.getGenero();
            String cantante = melodia.getCantante();
            double precio = melodia.getPrecio();
            String formato = melodia.getFormato();

            vista.mostrarCadena("Datos actuales:\n" + melodia);
            int op = -1;
            while (op != 0) {
                op = vista.mostrarMenuModificar();
                switch (op) {
                    case 1: nombre = vista.leerNombreMelodia();
                        break;
                    case 2: compositor = vista.leerCompositor();
                        break;
                    case 3: anio = vista.leerAnioMelodia();
                        break;
                    case 4: genero = vista.mostrarGenero();
                        break;
                    case 5: cantante = vista.leerCantante();
                        break;
                    case 6: precio = vista.leerPrecio();
                        break;
                    case 7: formato = vista.mostrarFormato();
                        break;
                }
            }

            if (modelo.modificarMelodia(melodia, nombre, compositor, anio, genero, cantante, precio, formato)) {
                vista.mostrarCadena("Melodia actualizada:\n" + melodia);
            } else {
                vista.mostrarCadena("No se guardaron los cambios: ya existe otra melodia con ese nombre y cantante.");
            }
        }
    }

    private void menuReportes() {
        int op = -1;
        while (op != 0) {
            op = vista.mostrarMenuReportes();
            switch (op) {
                case 1: vista.mostrarCadena("Valor total de la coleccion: $" + modelo.calcularValorTotal());
                    break;
                case 2: vista.mostrarListaDeTextos("Cantantes en la coleccion:", modelo.obtenerCantantesUnicos());
                    break;
                case 3: vista.mostrarCadena("Cantantes distintos: " + modelo.contarCantantesDistintos());
                    break;
                case 4:
                    for (String genero : modelo.obtenerTodosLosGeneros()) {
                        vista.mostrarCadena("=== " + genero + " ===");
                        vista.mostrarMelodias(modelo.melodiasPorGenero(genero));
                    }
                    break;
                case 5: vista.mostrarListaDeTextos("Melodias por formato:", modelo.contarMelodiasPorFormato());
                    break;
            }
        }
    }

    private void mostrarCatalogoOrdenado() {
        int op = vista.mostrarMenuOrden();
        if (op >= 1 && op <= 4) {
            vista.mostrarMelodias(modelo.obtenerMelodiasOrdenadas(op));
        }
    }

    private Melodia seleccionarMelodia(String nombre) {
        ArrayList<Melodia> coincidencias = modelo.buscarPorNombre(nombre);
        if (coincidencias.isEmpty()) {
            vista.mostrarCadena("No se encontro ninguna melodia con ese nombre.");
            return null;
        }
        if (coincidencias.size() == 1) {
            return coincidencias.get(0);
        }
        vista.mostrarCadena("Hay varias melodias con ese nombre:");
        for (int i = 0; i < coincidencias.size(); i++) {
            vista.mostrarCadena((i + 1) + ". " + coincidencias.get(i).getNombre() + " - " + coincidencias.get(i).getCantante());
        }
        int seleccion = vista.leerNumeroSeleccion(coincidencias.size());
        return coincidencias.get(seleccion - 1);
    }
}
