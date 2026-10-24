package org.uabc.ic.catalogomelodias.Modelo;

public class Melodia {
    private String nombre;
    private String compositor;
    private int anio;
    private String genero;
    private String cantante;
    private double precio;
    private String formato;
    private int id;

    public Melodia() {
        this.nombre = "Las mananitas";
        this.compositor = "Anonimo";
        this.anio = 1900;
        this.genero = "Ranchero";
        this.cantante = "Alejandro Fernandez";
        this.precio = 123.4;
        this.formato = "mp3";
        this.id = this.hashCode();
    }

    public Melodia(String nombre, String compositor,  int anio, String genero, String cantante, double precio, String formato) {
        this.nombre = nombre;
        this.compositor = compositor;
        this.anio = anio;
        this.genero = genero;
        this.cantante = cantante;
        this.precio = precio;
        this.formato = formato;
        this.id = this.hashCode();
    }

    //sets y gets
    public String getNombre(){
        return nombre;
    }
    public String getCompositor(){
        return compositor;
    }
    public int getAnio(){
        return anio;
    }
    public String getGenero(){
        return genero;
    }
    public String getCantante(){
        return cantante;
    }
    public double getPrecio(){
        return precio;
    }
    public String getFormato(){
        return formato;
    }
    public int getId(){
        return id;
    }


    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setCompositor(String compositor){
        this.compositor = compositor;
    }
    public void setAnio(int anio){
        this.anio = anio;
    }
    public void setGenero(String genero){
        this.genero = genero;
    }
    public void setCantante(String cantante){
        this.cantante = cantante;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }
    public void setFormato(String formato){
        this.formato = formato;
    }

    public String toString() {
        return "ID: " + id +
                "\nNombre: " + nombre +
                "\nCompositor: " + compositor +
                "\nAño: " + anio +
                "\nGénero: " + genero +
                "\nCantante: " + cantante +
                "\nPrecio: $" + precio +
                "\nFormato: " + formato;
    }

    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Melodia mel = (Melodia)obj;
        return id == mel.id || (nombre.equalsIgnoreCase(mel.nombre) && cantante.equalsIgnoreCase(mel.cantante));
    }
}
