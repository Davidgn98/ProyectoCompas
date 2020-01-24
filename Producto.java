
/**
 * Esta clase recoge toda la información referente a la clase Producto.
 * @author (Arturo, Adrian)
 * @version (21/01/2020 v1.0)
 */

public class Producto
{  
    private double precio;
    private String nombre;
    private String proveedor;
    private int stock;
    
    /**
     * El constructor acepta cuatro parámetros que definirán el tipo de objeto.
     * @param (String)Nombre, (Double)Precio, (String)Proveedor y (Integer)Stock.
     */
   public Producto(String nombre, double precio, String proveedor, int stock)
   {
       this.precio=precio;
       this.nombre=nombre;
       this.proveedor=proveedor;
       this.stock=stock;
   }
   
   /**
    * Los siguientes métodos serán los getters y setters de la clase.
    */
   public String getNombre()
   {
      return this.nombre;
   }
   public double getPrecio()
   {
     return this.precio;
    }
    public void setNombre(String nom)
    {
       this.nombre=nom;
    }
    public void setPrecio(double pre)
    {
       this.precio=pre;
    }
    public String getProveedor()
    {
       return this.proveedor;
    }
    public void setProveedor(String prov)
    {
       this.proveedor=prov;
    }
    public int getStock()
    {
       return this.stock;
    }
    public void setStock(int sto)
    {
       this.stock=sto;
    }
}