import java.util.Scanner;
import java.util.Iterator;
/**
 * La clase pedido se encarga de diseñar el tipo de pedido que se desea realizar obteniendo la información del cliente y almacenandola a través de la clase Linea.
 * Esta clase genera ciertos objetos predefinidos de tipo Producto, que luego utilizaremos para indicarle al cliente que tipo de producto desea comprar.
 * También almacena dos variables de tipo String, el nombre del cliente y su dirección de envío.
 * 
 * @author (Adrian, Arturo)
 * @version (21/01/2020 v1.0)
 */
public class Pedido
{
    Scanner sc = new Scanner(System.in);
    Producto producto,bufanda, abrigo, camisa, zapatos, corbata;
    String nombre, direccionEnvio;
    Linea linea = new Linea();
    
    /**
     * Este será el método de entrada de nuestra aplicación, el método main.
     * Se encargara de generar un pedido, primero solicitandole al usuario unos datos a través de un método("nombre()") y después accediendo al menú("menu()").
     */
    public static void main(String[] args)
    {
        Pedido pedido = new Pedido();
        pedido.nombre();
        pedido.menu();
    }
    
    /**
     * Este constructor se encargará de inicializar nuestros objetos previamente definidos para nuestra tienda.
     * @param Este método no tiene parametros. 
     */
    public Pedido()
    {
        bufanda = new Producto("Bufanda", 8.3, "Lorena", 32);
        abrigo = new Producto("Abrigo", 10.2, "Paul", 30);
        camisa = new Producto("Camisa", 4.9, "Miau", 22);
        zapatos = new Producto("Zapatos", 7.9, "Paco", 33);
        corbata = new Producto("Corbata", 8.1, "Lorena", 11);
    }
    
    /**
     * Este método solicitará al usuario su nombre y su dirección a través de un Scanner.
     * @param Este metodo no tiene parametros. 
     * @return No nos devolverá ningun valor.
     */
    public void nombre()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a la tienda.");
        System.out.println("Ingrese su nombre.");
        nombre = sc.nextLine();
        
        System.out.println("Ingrese su dirección de envío:");
        direccionEnvio = sc.nextLine();
        System.out.println("Datos guardados.");
        sc.close();
    }

    /**
     * En el método menu veremos un sencillo menú que aparecera por consola en el que seleccionamos los productos a comprar.
     * @param Este método no tiene parametros. 
     * @return No nos devolverá ningun valor.
     */
    public void menu()
    {
        boolean over = true;
        while(over){
            System.out.println("-------------------------------");
            System.out.println("¿Qué producto desea comprar?");
            System.out.println("1. Bufanda");
            System.out.println("2. Abrigo.");
            System.out.println("3. Camisa.");
            System.out.println("4. Zapatos.");
            System.out.println("5. Corbata.");
            System.out.println("6. Sacar ticket.");
            System.out.println("7. Salir. ");
            System.out.println("-------------------------------");
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            switch(i)
            {
                //De los números 1-5 el programa se encargara de enviar nuestros objetos predefinidos a otro método llamado "recogerCantidad()".
                case 1: 
                recogerCantidad(bufanda);
                break;
                case 2: 
                recogerCantidad(abrigo);
                break;
                case 3: 
                recogerCantidad(camisa);
                break;
                case 4: 
                recogerCantidad(zapatos);
                break;
                case 5: 
                recogerCantidad(corbata);
                break;
                //Este método de la clase línea se encargará de imprimir los datos por pantalla, enviandole el nombre de usuario y su dirección.
                case 6:
                linea.imprimirDatos(nombre, direccionEnvio);
                break;
                //Esta línea se encarga de cerrar el bucle del menú y de cerrar la aplicación.
                case 7: 
                System.out.println("Cerrando la aplicación...");
                over = false;
                sc.close();
                break;
                default:
            }
            System.out.println();
        }
    }
    
    /**
     * Este método preguntará una cantidad a comprar al usuario y valorará si hay suficiente stock de ese producto en la tienda.
     * Luego enviará tanto el producto como la cantidad a un método de la clase Lista llamado "ingresarProducto()".
     * @param Este método tiene como parámetros un objeto de tipo Producto. 
     * @return No nos devolverá ningun valor.
     */
    public void recogerCantidad(Producto producto)
    {
        Producto prod = producto;
        int cant =0;
        Scanner sc = new Scanner(System.in);
        boolean over= true;
        do{
            System.out.println("¿Que cantidad desea comprar?");
            int cantidad = sc.nextInt();
            if(cantidad>prod.getStock())
            {
                System.out.println("No disponemos de tanta cantidad, nuestra cantidad máxima es: "+prod.getStock());
            }else if(cantidad >0 && cantidad <= prod.getStock()){
                System.out.println("Cantidad añadida correctamente a su pedido.");
                cant = cantidad;
                prod.setStock(prod.getStock()-cant);
                over = false;
            }
        } while(over);
        sc.close();
        linea.ingresarProducto(prod, cant);
    }
}
