
package ec.org.camariweb2.funciones;

import ec.org.camariweb2.accesodatos.AccesoDatos;
import ec.org.camariweb2.accesodatos.ConjuntoResultado;
import ec.org.camariweb2.accesodatos.Parametro;
import ec.org.camariweb2.entidades.clsFactura;
import java.util.ArrayList;


public class clsReportes {
    
   
    //listado de todos los clientes con compras mayores a 100
    //mostrar la no factura, fecha, total y el nombre del cliente 
    public static ArrayList<clsFactura> clienteFacturaMayorMil() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT " +
                    "  factura.id_cliente, " +
                    "  factura.id_factura, " +
                    "  factura.fecha, " +
                    "  factura.total, " +
                    "  cliente.ruc, " +
                    "  cliente.id_cliente" +
                    "FROM " +
                    "  public.cliente, INNER JOIN" +
                    "  public.factura" +
                    "ON" +
                    "  cliente.id = factura.\"id_cliente\"" +
                    "ORDER BY " +
                    "  cliente.nombre ASC";
        

        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura factura = null;
            while (cres.next())
            {
                factura = new clsFactura();
                factura.setId_factura(cres.getInt("id_factura"));
                 factura.setFecha(cres.getDate("fecha"));
                factura.setTotal(cres.getDouble("total"));
                
               
                listado.add((factura));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
     
    //TRABAJO EN CLASES
    
    //1.-MOSTRR LA SUMA COMPRAS POR CADA CLIENTE
    
    public static ArrayList<clsFactura> sumaCompraPorCliente() { 
    ArrayList<clsFactura> listado = new ArrayList<>(); 
    String sql = "SELECT\n" +
                    "\"public\".cliente.\"id_cliente\",\n" +
                    "\"public\".cliente.ruc,\n" +
                    "\"public\".cliente.nombre,\n" +
                    "Sum(\"public\".factura.total) AS \"Total\"\n" +
                    "FROM\n" +
                    "\"public\".cliente\n" +
                    "INNER JOIN \"public\".factura ON \"public\".factura.id_cliente = \"public\".cliente.\"id_cliente\"\n" +
                    "GROUP BY\n" +
                    "\"public\".cliente.\"id_cliente\",\n" +
                    "\"public\".cliente.ruc,\n" +
                    "\"public\".cliente.nombre"; 

        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura fac = null;
            while (cres.next())
            {
                fac = new clsFactura();
                fac.setTotal(cres.getDouble("total"));
                //fac.setIdcliente(crudCliente.findbyid(cres.getInt("id")));                
                listado.add((fac));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;

    }
    
    //2.- NUMERO DE COMPRAS QUE HIZO EL CLIENTE 
    
    public static ArrayList<clsFactura> numeroCompraCliente() { 
    ArrayList<clsFactura> listado = new ArrayList<>(); 
    String sql = "SELECT " 
        + "\"public\".cliente.nombre, " 
        + "Count(\"public\".factura.\"id_factura\") AS \"Numero de compras\" " 
        + "FROM " 
        + "\"public\".cliente, INNER JOIN" 
        + "\"public\".factura" 
        + "ON" 
        + "\"public\".factura.id_cliente = \"public\".cliente.\"id_cliente\"" 
        + "GROUP BY" 
        + "\"public\".cliente.nombre"; 
    ArrayList<Parametro> lstPar = new ArrayList<>(); 
    try { 
    ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar); 
    clsFactura factura = null; 
    while (cres.next()) { 
        factura = new clsFactura(); 
        factura.setId_factura(cres.getInt("id_cliente")); 
        factura.setCliente(crudCliente.findbyId(cres.getInt("id_cliente"))); 
        
        listado.add((factura)); 
    } 
    } catch (Exception e) { 
    System.out.println(e.getMessage()); 
    } 
    return listado; 
} 
   
    //3.- NUMERO DE COMPRAS Y TOTAL 
    public static ArrayList<clsFactura> numeroComprasTotal() { 
    ArrayList<clsFactura> listado = new ArrayList<>(); 
    String sql = "SELECT\n" +
                    "\"public\".cliente.\"id_cliente\",\n" +
                    "\"public\".cliente.ruc,\n" +
                    "\"public\".cliente.nombre,\n" +
                    "Count(\"public\".factura.id_factura) AS \"Total_Facturas\"\n" +
                    "FROM\n" +
                    "\"public\".factura\n" +
                    "INNER JOIN \"public\".cliente ON \"public\".factura.id_cliente = \"public\".cliente.\"id_cliente\"\n" +
                    "GROUP BY\n" +
                    "\"public\".cliente.\"id_cliente\",\n" +
                    "\"public\".cliente.ruc,\n" +
                    "\"public\".cliente.nombre"; 
     ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura fac = null;
            while (cres.next())
            {
                fac = new clsFactura();
                fac.setId_factura(cres.getInt("Total_Facturas"));
                fac.setCliente(crudCliente.findbyId(cres.getInt("id_cliente")));                
                listado.add((fac));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    //4.-cliente que mas a gastado
    
    
     public static ArrayList<clsFactura> clientemasgasto() { 
    ArrayList<clsFactura> listado = new ArrayList<>(); 
    String sql = "SELECT\n" +
                    "\"public\".cliente.\"id_cliente\",\n" +
                    "\"public\".cliente.ruc,\n" +
                    "\"public\".cliente.nombre,\n" +
                    "Count(\"public\".factura.id_factura) AS \"N° Facturas\",\n" +
                    "Sum(\"public\".factura.total) AS valor\n" +
                    "FROM\n" +
                    "\"public\".cliente\n" +
                    "INNER JOIN \"public\".factura ON \"public\".factura.id_cliente = \"public\".cliente.\"id_cliente\"\n" +
                    "GROUP BY\n" +
                    "\"public\".cliente.\"id_cliente\",\n" +
                    "\"public\".cliente.ruc,\n" +
                    "\"public\".cliente.nombre\n" +
                    "ORDER BY\n" +
                    "\"N° Facturas\" DESC\n" +
                    "LIMIT 1"; 
    
    ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura fac = null;
            while (cres.next())
            {
                fac = new clsFactura();
                fac.setId_factura(cres.getInt("N° Facturas"));
                fac.setCliente(crudCliente.findbyId(cres.getInt("id")));
                fac.setTotal(cres.getDouble("valor"));
                listado.add((fac));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
    
        //5.- CLIENTE QUE MENOS A COMPRADO
   public static ArrayList<clsFactura> cliemenosCompra() { 
        ArrayList<clsFactura> listado = new ArrayList<>(); 
        String sql ="SELECT\n" +
                    "\"public\".cliente.\"id_cliente\",\n" +
                    "\"public\".cliente.ruc,\n" +
                    "\"public\".cliente.nombre,\n" +
                    "Count(\"public\".factura.id_factura) AS \"N° Facturas\",\n" +
                    "Sum(\"public\".factura.total) AS valor\n" +
                    "FROM\n" +
                    "\"public\".cliente\n" +
                    "INNER JOIN \"public\".factura ON \"public\".factura.id_cliente = \"public\".cliente.\"id_cliente\"\n" +
                    "GROUP BY\n" +
                    "\"public\".cliente.\"id_cliente\",\n" +
                    "\"public\".cliente.ruc,\n" +
                    "\"public\".cliente.nombre\n" +
                    "ORDER BY\n" +
                    "\"N° Facturas\" ASc\n" +
                    "LIMIT 1";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura fac = null;
            while (cres.next())
            {
                fac = new clsFactura();
                fac.setId_factura(cres.getInt("N° Facturas"));
                fac.setCliente(crudCliente.findbyId(cres.getInt("id")));
                fac.setTotal(cres.getDouble("valor"));
                listado.add((fac));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
    
    
    
    //6.- EL PROMEDIO DE COMPRAS 
    public static ArrayList<clsFactura> promedioCompra() { 
        ArrayList<clsFactura> listado = new ArrayList<>(); 
        String sql = "SELECT " 
                    + "AVG(\"public\".factura.total) as Promedio " 
                    + "FROM " 
                    + "\"public\".factura"; 
        ArrayList<Parametro> lstPar = new ArrayList<>(); 
        try { 
        ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar); 
        clsFactura factura = null; 
        while (cres.next()) { 
        factura = new clsFactura(); 
        factura.setTotal(cres.getInt("total")); 
        listado.add((factura)); 
        } 
        } catch (Exception e) { 
    System.out.println(e.getMessage()); 
    } 
    return listado; 
    }

    
    //7.-PRODUCTO QUE MAS SE VENDE
     public static ArrayList<clsFactura> promasvendido() { 
        ArrayList<clsFactura> listado = new ArrayList<>(); 
        String sql = "SELECT\n" +
        "Sum(\"public\".dfacturaproducto.cantidad) AS \"Cantidad\",\n" +
        "\"public\".producto.nombre,\n" +
        "Sum(\"public\".dfacturaproducto.subtotal) AS \"Valor\",\n" +
        "\"public\".producto.id_producto\n" +
        "FROM\n" +
        "\"public\".producto\n" +
        "INNER JOIN \"public\".dfacturaproducto ON \"public\".dfacturaproducto.id_producto = \"public\".producto.\"id_producto\"\n" +
        "GROUP BY\n" +
        "\"public\".producto.nombre,\n" +
        "\"public\".producto.id_producto\n" +
        "ORDER BY\n" +
        "\"Cantidad\" DESC\n" +
        "LIMIT 1";  
    
            ArrayList<Parametro> lstPar = new ArrayList<>(); 
        try { 
        ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar); 
        clsFactura factura = null; 
        while (cres.next()) { 
        factura = new clsFactura(); 
        factura.setTotal(cres.getInt("total")); 
        listado.add((factura)); 
        } 
        } catch (Exception e) { 
    System.out.println(e.getMessage()); 
    } 
    return listado;  
}
     
     
         //8.-El_producto_que_menos_se_vende
     public static ArrayList<clsFactura> promenosvendido() { 
        ArrayList<clsFactura> listado = new ArrayList<>(); 
        String sql = "SELECT\n" +
        "Sum(\"public\".dfacpro.cantidad) AS \"Cantidad\",\n" +
        "\"public\".producto.nombre,\n" +
        "Sum(\"public\".dfacpro.subtotal) AS \"Valor\"\n" +
        "FROM\n" +
        "\"public\".producto\n" +
        "INNER JOIN \"public\".dfacpro ON \"public\".dfacpro.idproducto = \"public\".producto.\"id\"\n" +
        "GROUP BY\n" +
        "\"public\".producto.nombre\n" +
        "ORDER BY\n" +
        "\"Cantidad\" ASC\n" +
        "LIMIT 1";  
    
            ArrayList<Parametro> lstPar = new ArrayList<>(); 
        try { 
        ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar); 
        clsFactura factura = null; 
        while (cres.next()) { 
        factura = new clsFactura(); 
        factura.setTotal(cres.getInt("total")); 
        listado.add((factura)); 
        } 
        } catch (Exception e) { 
    System.out.println(e.getMessage()); 
    } 
    return listado;  
     
}
            //9.-Ventas por producto
     public static ArrayList<clsFactura> ventasxproducto() { 
        ArrayList<clsFactura> listado = new ArrayList<>(); 
        String sql = "SELECT\n" +
"Sum(\"public\".dfacpro.cantidad) AS \"Cantidad\",\n" +
"\"public\".producto.nombre,\n" +
"Sum(\"public\".dfacpro.subtotal) AS \"Valor\"\n" +
"FROM\n" +
"\"public\".producto\n" +
"INNER JOIN \"public\".dfacpro ON \"public\".dfacpro.idproducto = \"public\".producto.\"id\"\n" +
"GROUP BY\n" +
"\"public\".producto.nombre";  
    
            ArrayList<Parametro> lstPar = new ArrayList<>(); 
        try { 
        ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar); 
        clsFactura factura = null; 
        while (cres.next()) { 
        factura = new clsFactura(); 
        factura.setTotal(cres.getInt("total")); 
        listado.add((factura)); 
        } 
        } catch (Exception e) { 
    System.out.println(e.getMessage()); 
    } 
    return listado;  
       
}
}