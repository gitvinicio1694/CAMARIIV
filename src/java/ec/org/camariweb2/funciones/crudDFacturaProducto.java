
package ec.org.camariweb2.funciones;

import ec.org.camariweb2.accesodatos.AccesoDatos;
import ec.org.camariweb2.accesodatos.ConjuntoResultado;
import ec.org.camariweb2.accesodatos.Parametro;
import ec.org.camariweb2.entidades.clsDFacturaProducto;
import java.util.ArrayList;


public class crudDFacturaProducto {
    public static boolean save(clsDFacturaProducto dFacturaproducto){
        boolean resultado = false;
        
        String sql= "INSERT INTO public.dfacturaproducto(id_factura, id_producto, cantidad, subtotal) VALUES(?,?,?,?)";
        
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, dFacturaproducto.getFactura()));
        lstPar.add(new Parametro(2, dFacturaproducto.getProducto()));
        lstPar.add(new Parametro(3, dFacturaproducto.getCantidad()));
        lstPar.add(new Parametro(4, dFacturaproducto.getSubtotal()));
         
               
        try {
            resultado = AccesoDatos.ejecutaComando(sql, lstPar);
           }catch (Exception e){
               System.out.println(e.getMessage());
           }
        return resultado;
     }
    //ELMINAR
    public static boolean delete(clsDFacturaProducto dFacturaproducto) {
        boolean res=false;
        String sql = "DELETE FROM public.dfacturaproducto WHERE id_dfacturaproducto=? ";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, dFacturaproducto.getId_dfacturaproducto()));
        
        try {
            res= AccesoDatos.ejecutaComando(sql, lstPar);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return res;
    }
    
   //ACTUALIZAR
    public static boolean update(clsDFacturaProducto dFacturaproducto) {
        boolean res = false;
        String sql = "UPDATE public.dfacturaproducto" +
                "SET id_factura=?,id_producto=?, cantidad=?, subtotal=?," + 
                "WHERE id_dfacturaproducto=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();        
        lstPar.add(new Parametro(1,dFacturaproducto.getFactura()));
        lstPar.add(new Parametro(2,dFacturaproducto.getProducto()));
        lstPar.add(new Parametro(3,dFacturaproducto.getCantidad()));
        lstPar.add(new Parametro(4,dFacturaproducto.getSubtotal()));

        
        
        try{
            res= AccesoDatos.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            }
        return res;
    }
    
    
//SELECCIONAR
    public static ArrayList<clsDFacturaProducto> findbyAll() {
        ArrayList<clsDFacturaProducto> listado = new ArrayList<>();
        String sql = "SELECT id_dfacturaproducto, id_factura, id_producto, cantidad, subtotal "+
                "FROM public.dfacturaproducto";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsDFacturaProducto detallefactura = null;
            while (cres.next())
            {
                detallefactura = new clsDFacturaProducto();
                detallefactura.setId_dfacturaproducto(cres.getInt("id_dfacturaproducto"));
                detallefactura.setFactura(crudFactura.findbyId(cres.getInt("id_Factura")));
                detallefactura.setProducto(crudProducto.findbyId(cres.getInt("id_Producto")));
                detallefactura.setCantidad(cres.getInt("cantidad"));
                detallefactura.setSubtotal(cres.getDouble("subtotal"));
               
                listado.add((detallefactura));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
    
     public static clsDFacturaProducto findbyId(clsDFacturaProducto id_dfacturaproducto) {
        clsDFacturaProducto DFacturaProducto = null;
        String sql = "SELECT id_dfacturaproducto, id_factura, id_producto, cantidad, subtotal "+
                "FROM public.dfacturaproducto";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id_dfacturaproducto));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                DFacturaProducto = new clsDFacturaProducto();
                DFacturaProducto.setId_dfacturaproducto(cres.getInt("id_dfacturaproducto"));
                DFacturaProducto.setFactura(crudFactura.findbyId(cres.getInt("id_factura")));
                DFacturaProducto.setProducto(crudProducto.findbyId(cres.getInt("id_producto")));
                DFacturaProducto.setCantidad(cres.getInt("cantidad"));
                DFacturaProducto.setSubtotal(cres.getDouble("subtotal"));
                
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return DFacturaProducto;
    }
}

