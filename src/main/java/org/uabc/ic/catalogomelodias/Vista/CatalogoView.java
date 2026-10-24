package org.uabc.ic.catalogomelodias.Vista;

import org.uabc.ic.catalogomelodias.Modelo.Genero;
//nuevo codigo agregado
import org.uabc.ic.catalogomelodias.Modelo.Melodia;

//nuevo codigo agregado
import java.util.ArrayList;
import java.util.Scanner;

public class CatalogoView {
    private Scanner leerCadenas = new Scanner(System.in);
    private Scanner leerNumeros = new Scanner(System.in);
    private String[] formatos = {"mp3", "oog", "wav"};

    public int mostrarMenu(){
        System.out.println("***MENU***");
        System.out.println("1. Registrar Melodia\n");
        System.out.println("2. Mostrar todo el catalogo\n");
        System.out.println("3. Salir\n");
        //nuevo codigo agregado
        System.out.println("4. Consultar / Buscar melodias\n");
        System.out.println("5. Eliminar melodia\n");
        System.out.println("6. Modificar / Corregir melodia\n");
        System.out.println("7. Reportes y estadisticas\n");
        System.out.println("8. Mostrar catalogo ordenado\n");
        System.out.println("Elige una opcion:");
        return leerNumeros.nextInt();
    }

    // OPCION 1: REGISTRAR MELODIA
    public String leerNombreMelodia(){
        System.out.println("Ingrese el nombre de la melodia:");
        return leerCadenas.nextLine();
    }

    public String leerCompositor(){
        System.out.println("Ingrese el nombre del compositor:");
        return leerCadenas.nextLine();
    }

    public String leerCantante(){
        System.out.println("Ingrese el nombre del cantante:");
        return leerCadenas.nextLine();
    }

    public int leerAnioMelodia(){
        System.out.println("Ingrese el año de la melodia:");
        return leerNumeros.nextInt();
    }

    public void mostrarCatalogo(String catalogo){
        System.out.println(catalogo);
    }

    public void mostrarCadena(String cadena){
        System.out.println(cadena);
    }

    public double leerPrecio(){
        System.out.println("Ingrese el precio:");
        return leerNumeros.nextDouble();
    }

    // PARA LEER Y REGRESAR EL GENERO QUE LE AGIGNAREMOS A LA MELODIA
    public String mostrarGenero(){
        Genero[] generos = Genero.values();
        int numero = 1;
        int seleccion;
        for (Genero g : Genero.values()) {
            System.out.println(numero + ". Genero: " + g);
            numero++;
        }

        System.out.println("Ingrese el genero:");
        numero = leerNumeros.nextInt();
        return generos[numero-1].toString();
    }

    // PARA LEER Y REGRESAR EL FORMATO QUE LE AGIGNAREMOS A LA MELODIA
    public String mostrarFormato(){
        int numero = 1;
        int seleccion;
        for (String g : formatos) {
            System.out.println(numero + ". Formato: " + g);
            numero++;
        }

        System.out.println("Ingrese el formato:");
        numero = leerNumeros.nextInt();
        return formatos[numero-1].toString();
    }

    //nuevo codigo agregado
    public int mostrarMenuConsultas(){
        System.out.println("***CONSULTAR / BUSCAR***");
        System.out.println("1. Buscar melodia por nombre");
        System.out.println("2. Melodias de un cantante");
        System.out.println("3. Melodias de un compositor");
        System.out.println("4. Melodias de un artista (cantante o compositor)");
        System.out.println("5. Melodias de un año");
        System.out.println("6. Melodias de un genero");
        System.out.println("0. Volver al menu principal");
        System.out.println("Elige una opcion:");
        return leerNumeros.nextInt();
    }

    public int mostrarMenuReportes(){
        System.out.println("***REPORTES Y ESTADISTICAS***");
        System.out.println("1. Valor total de la coleccion");
        System.out.println("2. Lista de cantantes");
        System.out.println("3. Numero de cantantes distintos");
        System.out.println("4. Melodias agrupadas por genero");
        System.out.println("5. Formatos y cantidad de melodias por formato");
        System.out.println("0. Volver al menu principal");
        System.out.println("Elige una opcion:");
        return leerNumeros.nextInt();
    }

    public int mostrarMenuOrden(){
        System.out.println("***ORDENAR CATALOGO POR***");
        System.out.println("1. Nombre");
        System.out.println("2. Año");
        System.out.println("3. Cantante");
        System.out.println("4. Genero");
        System.out.println("0. Volver al menu principal");
        System.out.println("Elige una opcion:");
        return leerNumeros.nextInt();
    }

    public int mostrarMenuModificar(){
        System.out.println("***QUE DATO DESEAS CORREGIR?***");
        System.out.println("1. Nombre");
        System.out.println("2. Compositor");
        System.out.println("3. Año");
        System.out.println("4. Genero");
        System.out.println("5. Cantante");
        System.out.println("6. Precio");
        System.out.println("7. Formato");
        System.out.println("0. Guardar cambios y terminar");
        System.out.println("Elige una opcion:");
        return leerNumeros.nextInt();
    }

    public String leerNombreABuscar(){
        System.out.println("Ingrese el nombre de la melodia a buscar:");
        return leerCadenas.nextLine();
    }

    public String leerCantanteABuscar(){
        System.out.println("Ingrese el nombre del cantante a buscar:");
        return leerCadenas.nextLine();
    }

    public String leerCompositorABuscar(){
        System.out.println("Ingrese el nombre del compositor a buscar:");
        return leerCadenas.nextLine();
    }

    public String leerArtistaABuscar(){
        System.out.println("Ingrese el nombre del artista (cantante o compositor) a buscar:");
        return leerCadenas.nextLine();
    }

    public int leerAnioABuscar(){
        System.out.println("Ingrese el año a buscar:");
        return leerNumeros.nextInt();
    }

    public int leerNumeroSeleccion(int max){
        int seleccion = 0;
        while (seleccion < 1 || seleccion > max) {
            System.out.println("Elige una opcion (1-" + max + "):");
            seleccion = leerNumeros.nextInt();
        }
        return seleccion;
    }

    public boolean leerConfirmacion(String mensaje){
        System.out.println(mensaje + " (s/n)");
        return leerCadenas.nextLine().trim().equalsIgnoreCase("s");
    }

    public void mostrarMelodias(ArrayList<Melodia> melodias){
        if (melodias.isEmpty()) {
            System.out.println("No se encontraron melodias.");
        } else {
            for (Melodia melodia : melodias) {
                System.out.println(melodia);
                System.out.println("-----------------------------------");
            }
            System.out.println("Total: " + melodias.size());
        }
    }

    public void mostrarListaDeTextos(String titulo, ArrayList<String> textos){
        System.out.println(titulo);
        for (String texto : textos) {
            System.out.println("- " + texto);
        }
    }
}
