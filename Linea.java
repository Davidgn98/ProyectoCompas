import java.util.HashMap;
import java.util.Iterator;
import java.text.DecimalFormat;
/**
 * Esta clase generará un HashMap, como clave tendrá Producto y como valor tendrá la cantidad solicitada por el usuario.
 * Se encargará de añadir más combinaciones al HashMap así como de imprimir el resultado de la consulta por pantalla.
 * @author(Arturo, Adrian)
 * @version (21/01/2020 v1.0)
 */
public class Linea
{  
    private Producto producto;
    private int cantidad;
    private HashMap<Producto, Integer>mapa=new HashMap<Producto, Integer>();
    
    //Esta clase tendrá un constructor vacio
    public Linea()
    {
    }

    /**
     * Los siguientes métodos serán los getters y setters de la clase.
     */
    public Producto getProducto()
    {
        return this.producto;
    }
    public int getCantidad()
    {
        return this.cantidad;
    }
    public void setProducto(Producto pro)
    {
        this.producto=pro;
    }
    public void setCantidad(int can)
    {
        this.cantidad=can;
    }
    public HashMap<Producto, Integer> getHashMap()
    {
        return mapa;
    } 

    /**
     * Permite ingresar un elemento al HashMap.
     * @param Me pide un objeto de tipo Producto y un entero que será su cantidad.
     * @return no retorna nada.
     */
    public void ingresarProducto(Producto producto, int cantidad)
    {
        mapa.put(producto, cantidad);
    }

    /**
     * Este método se encargará de imprimir los datos por pantalla de la información del pedido total que ha realizado el usuario.
     * El método itera sobre el keySet() de nuestro HashMap y devuelve de cada clave(que es de tipo Producto) su información accediendo a los métodos de su clase.
     * @param Obtiene como parámetros el nombre y la dirección de tipo String.
     * @return El método no devolverá nada.
     */
    public void imprimirDatos(String nombre, String direccion)
    {
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println();
        System.out.println("La información del pedido es la siguiente: ");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Nombre\t\t\tPrecio\t\tProveedor\t\tCantidad");
        for(Producto p : mapa.keySet())
        {
            System.out.println(p.getNombre()+"\t\t\t"+p.getPrecio()+"\t\t"+p.getProveedor()+"\t\t\t"+mapa.get(p));
        }
        System.out.println("-------------------------------------------------------------------");
    
        double precioTotal =0.0;
        for(Producto p : mapa.keySet())
        {
            precioTotal += p.getPrecio();
        }
        System.out.println("El precio total será: "+ df.format(precioTotal) + "€");
        System.out.println("El producto será enviado a la dirección: "+direccion+"."+ "\nCuyo propietario es: "+nombre+"." );
    }

}

