package Libros;

import java.util.Scanner;

public class TesLibros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Administrador admin = new Administrador();

        // Añadir categorías iniciales
        admin.agregarCategoria("Libros");
        admin.agregarCategoria("Películas");
        admin.agregarCategoria("Canciones");
        admin.agregarCategoria("Artículos");

        // Añadir objetos iniciales
        admin.agregarItem(new Libro("Cien Años de Soledad", "Gabriel García Márquez", "Una obra maestra de la literatura latinoamericana."));
        admin.agregarItem(new Pelicula("Inception", "Christopher Nolan", "Una película sobre los sueños y la realidad."));
        admin.agregarItem(new Cancion("Bohemian Rhapsody", "Queen", "Una de las canciones más icónicas del rock."));
        admin.agregarItem(new Articulo("El avance de la inteligencia artificial", "John Doe", "Un artículo sobre el impacto de la IA en la sociedad."));

        // Menú básico de interacción
        while (true) {
            System.out.println("\n1. Agregar nuevo libro");
            System.out.println("2. Mostrar libros");
            System.out.println("3. Agregar categoría");
            System.out.println("4. Dar me gusta a un libro");
            System.out.println("6. Mostrar comentarios de un libro");
            System.out.println("7. Mostrar categorías");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el tipo de item (Libro, Película, Canción, Artículo): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese la sinopsis: ");
                    String sinopsis = scanner.nextLine();

                    if (tipo.equalsIgnoreCase("Libro")) {
                        admin.agregarItem(new Libro(nombre, autor, sinopsis));
                    } else if (tipo.equalsIgnoreCase("Película")) {
                        admin.agregarItem(new Pelicula(nombre, autor, sinopsis));
                    } else if (tipo.equalsIgnoreCase("Canción")) {
                        admin.agregarItem(new Cancion(nombre, autor, sinopsis));
                    } else if (tipo.equalsIgnoreCase("Artículo")) {
                        admin.agregarItem(new Articulo(nombre, autor, sinopsis));
                    } else {
                        System.out.println("Tipo de item no reconocido.");
                    }
                    break;
                case 2:
                    admin.mostrarItems();
                    break;
                case 3:
                    System.out.print("Ingrese el nombre de la nueva categoría: ");
                    String categoria = scanner.nextLine();
                    admin.agregarCategoria(categoria);
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del item al que quiere dar me gusta: ");
                    String nombreLike = scanner.nextLine();
                    Libros itemLike = admin.buscarItemPorNombre(nombreLike);
                    if (itemLike != null) {
                        itemLike.like();
                        System.out.println("Me gusta agregado.");
                    } else {
                        System.out.println("Item no encontrado.");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el nombre del item al que quiere comentar: ");
                    String nombreComentario = scanner.nextLine();
                    Libros itemComentario = admin.buscarItemPorNombre(nombreComentario);
                    if (itemComentario != null) {
                        System.out.print("Ingrese su comentario: ");
                        String comentario = scanner.nextLine();
                        itemComentario.addComentario(comentario);
                        System.out.println("Comentario agregado.");
                    } else {
                        System.out.println("Item no encontrado.");
                    }
                    break;
                case 6:
                    System.out.print("Ingrese el nombre del item del que quiere ver los comentarios: ");
                    String nombreVerComentarios = scanner.nextLine();
                    Libros itemVerComentarios = admin.buscarItemPorNombre(nombreVerComentarios);
                    if (itemVerComentarios != null) {
                        itemVerComentarios.showComentarios();
                    } else {
                        System.out.println("Item no encontrado.");
                    }
                    break;
                case 7:
                    admin.mostrarCategorias();
                    break;
                case 8:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
