package Libros;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Libros {


    // Clase base para todos los elementos (Libro, Película, Canción, Artículo)
    private String nombre;
    private String autor;
    private String sinopsis;
    private ArrayList<String> comentarios;
    private int likes;

    public Libros(String nombre, String autor, String sinopsis) {
        this.nombre = nombre;
        this.autor = autor;
        this.sinopsis = sinopsis;
        this.comentarios = new ArrayList<>();
        this.likes = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public int getLikes() {
        return likes;
    }

    public void like() {
        likes++;
    }

    public void addComentario(String comentario) {
        comentarios.add(comentario);
    }

    public void showComentarios() {
        System.out.println("Comentarios:");
        for (String comentario : comentarios) {
            System.out.println("- " + comentario);
        }
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Autor: " + autor + ", Sinopsis: " + sinopsis + ", Likes: " + likes;
    }
}

// Clases específicas para cada tipo de elemento
class Libro extends Libros {
    public Libro(String nombre, String autor, String sinopsis) {
        super(nombre, autor, sinopsis);
    }
}

class Pelicula extends Libros {
    public Pelicula(String nombre, String autor, String sinopsis) {
        super(nombre, autor, sinopsis);
    }
}

class Cancion extends Libros {
    public Cancion(String nombre, String autor, String sinopsis) {
        super(nombre, autor, sinopsis);
    }
}

class Articulo extends Libros {
    public Articulo(String nombre, String autor, String sinopsis) {
        super(nombre, autor, sinopsis);
    }
}

// Clase para administrar los elementos y categorías
class Administrador {
    private ArrayList<Libros> items;
    private ArrayList<String> categorias;

    public Administrador() {
        this.items = new ArrayList<>();
        this.categorias = new ArrayList<>();
    }

    public void agregarItem(Libros item) {
        items.add(item);
    }

    public void agregarCategoria(String categoria) {
        categorias.add(categoria);
    }

    public void mostrarItems() {
        for (Libros item : items) {
            System.out.println(item);
        }
    }

    public void mostrarCategorias() {
        System.out.println("Categorías disponibles:");
        for (String categoria : categorias) {
            System.out.println("- " + categoria);
        }
    }

    public Libros buscarItemPorNombre(String nombre) {
        for (Libros item : items) {
            if (item.getNombre().equalsIgnoreCase(nombre)) {
                return item;
            }
        }
        return null;
    }
}