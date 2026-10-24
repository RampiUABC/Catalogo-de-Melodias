package org.uabc.ic.catalogomelodias.Modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Catalogo {
    private ArrayList<Melodia> canciones = new ArrayList<>();

    public Catalogo() {
        this.canciones = new ArrayList<>();
    }

    public boolean registrarMelodia(Melodia obj) {
        boolean bandera = false;
        if(canciones != null) {
            for (Melodia melodia : canciones) {
                bandera = melodia.equals(obj);
                if (bandera)
                    break;
            }
        }
        if (!bandera)
            canciones.add(obj);
        return bandera; // Retorna true si se registró con éxito
    }

    public void crearObjetoMelodia(String nombre, String compositor,  int anio, String genero, String cantante, double precio, String formato){
        registrarMelodia(new Melodia(nombre,compositor,anio,genero,cantante,precio,formato));
    }

    public String mostrarTodasLasMelodias() {
        StringBuilder sb = new StringBuilder();
        for (Melodia melodia : canciones) {
            sb.append(melodia);
            sb.append("\n-----------------------------------\n");
        }
        return sb.toString();
    }

    public ArrayList<String> obtenerTodosLosGeneros() {
        ArrayList<String> generos = (ArrayList<String>) canciones.stream().map(Melodia::getGenero)
                .distinct()
                .collect(Collectors.toList());
        return generos;
    }

    public HashSet<String> obtenerTodosLosGenerosIterativo() {
        HashSet<String> generos = new HashSet();
        for (Melodia cancion : canciones) {
            generos.add(cancion.getGenero());
        }
        return generos;
    }

    public ArrayList<Melodia> melodiasPorCompositor(String compositor) {
        ArrayList<Melodia> resultado = new ArrayList<>();
        if(compositor == null) return resultado;
        for (Melodia melodia : canciones) {
            if(melodia.getCompositor() != null && melodia.getCompositor().equalsIgnoreCase(compositor)){
                resultado.add(melodia);
            }
        }
        return resultado;
    }

    //nuevo codigo agregado
    public ArrayList<Melodia> buscarPorNombre(String nombre) {
        ArrayList<Melodia> resultado = new ArrayList<>();
        if (nombre == null) return resultado;
        for (Melodia melodia : canciones) {
            if (melodia.getNombre().equalsIgnoreCase(nombre.trim())) {
                resultado.add(melodia);
            }
        }
        return resultado;
    }

    public boolean eliminarMelodia(Melodia melodia) {
        return canciones.remove(melodia);
    }

    public boolean modificarMelodia(Melodia melodia, String nombre, String compositor, int anio, String genero, String cantante, double precio, String formato) {
        for (Melodia otra : canciones) {
            if (otra != melodia && otra.getNombre().equalsIgnoreCase(nombre) && otra.getCantante().equalsIgnoreCase(cantante)) {
                return false;
            }
        }
        melodia.setNombre(nombre);
        melodia.setCompositor(compositor);
        melodia.setAnio(anio);
        melodia.setGenero(genero);
        melodia.setCantante(cantante);
        melodia.setPrecio(precio);
        melodia.setFormato(formato);
        return true;
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Melodia melodia : canciones) {
            total += melodia.getPrecio();
        }
        return total;
    }

    public ArrayList<String> obtenerCantantesUnicos() {
        HashSet<String> cantantes = new HashSet<>();
        for (Melodia melodia : canciones) {
            cantantes.add(melodia.getCantante());
        }
        return new ArrayList<>(cantantes);
    }

    public int contarCantantesDistintos() {
        return obtenerCantantesUnicos().size();
    }

    public ArrayList<Melodia> melodiasPorCantante(String cantante) {
        ArrayList<Melodia> resultado = new ArrayList<>();
        if (cantante == null) return resultado;
        for (Melodia melodia : canciones) {
            if (melodia.getCantante().equalsIgnoreCase(cantante.trim())) {
                resultado.add(melodia);
            }
        }
        return resultado;
    }

    public ArrayList<Melodia> melodiasPorArtista(String artista) {
        ArrayList<Melodia> resultado = new ArrayList<>();
        if (artista == null) return resultado;
        for (Melodia melodia : canciones) {
            if (melodia.getCantante().equalsIgnoreCase(artista.trim()) || melodia.getCompositor().equalsIgnoreCase(artista.trim())) {
                resultado.add(melodia);
            }
        }
        return resultado;
    }

    public ArrayList<Melodia> melodiasPorGenero(String genero) {
        ArrayList<Melodia> resultado = new ArrayList<>();
        if (genero == null) return resultado;
        for (Melodia melodia : canciones) {
            if (melodia.getGenero().equalsIgnoreCase(genero.trim())) {
                resultado.add(melodia);
            }
        }
        return resultado;
    }

    public ArrayList<String> contarMelodiasPorFormato() {
        HashSet<String> formatos = new HashSet<>();
        for (Melodia melodia : canciones) {
            formatos.add(melodia.getFormato().toLowerCase());
        }
        ArrayList<String> resultado = new ArrayList<>();
        for (String formato : formatos) {
            int cantidad = 0;
            for (Melodia melodia : canciones) {
                if (melodia.getFormato().equalsIgnoreCase(formato)) {
                    cantidad++;
                }
            }
            resultado.add(formato.toUpperCase() + ": " + cantidad);
        }
        return resultado;
    }

    public ArrayList<Melodia> melodiasPorAnio(int anio) {
        ArrayList<Melodia> resultado = new ArrayList<>();
        for (Melodia melodia : canciones) {
            if (melodia.getAnio() == anio) {
                resultado.add(melodia);
            }
        }
        return resultado;
    }

    public ArrayList<Melodia> obtenerMelodiasOrdenadas(int criterio) {
        ArrayList<Melodia> ordenada = new ArrayList<>(canciones);
        if (criterio == 1) {
            ordenada.sort((a, b) -> a.getNombre().compareToIgnoreCase(b.getNombre()));
        } else if (criterio == 2) {
            ordenada.sort((a, b) -> a.getAnio() - b.getAnio());
        } else if (criterio == 3) {
            ordenada.sort((a, b) -> a.getCantante().compareToIgnoreCase(b.getCantante()));
        } else if (criterio == 4) {
            ordenada.sort((a, b) -> a.getGenero().compareToIgnoreCase(b.getGenero()));
        }
        return ordenada;
    }
}
