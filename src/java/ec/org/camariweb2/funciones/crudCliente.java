package ec.org.camariweb2.funciones;

import ec.org.camariweb2.accesodatos.AccesoDatos;
import ec.org.camariweb2.accesodatos.ConjuntoResultado;
import ec.org.camariweb2.accesodatos.Parametro;
import ec.org.camariweb2.entidades.clsCliente;
import java.util.ArrayList;


public class crudCliente {
    public static boolean save(clsCliente micliente){
        boolean resultado = false;
        
        String sql = "INSERT INTO public.cliente(ruc, nombre, direccion) VALUES(?,?,?)";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, micliente.getRuc()));
        lstPar.add(new Parametro(2, micliente.getNombre()));
        lstPar.add(new Parametro(3, micliente.getDireccion()));
                
               
        try {
            resultado = AccesoDatos.ejecutaComando(sql, lstPar);
           }catch (Exception e){
               System.out.println(e.getMessage());
           }
        return resultado;
     }
    //ELMINAR
    public static boolean delete(clsCliente micliente) {
        boolean res=false;
        String sql = "DELETE FROM public.cliente WHERE id_cliente=? ";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,micliente.getId_cliente()));
        
        try {
            res= AccesoDatos.ejecutaComando(sql, lstPar);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return res;
    }
    
   //ACTUALIZAR
    public static boolean update(clsCliente micliente) {
        boolean res = false;
        String sql = "UPDATE public.cliente SET ruc=?,nombre=?, direccion=? WHERE id_cliente=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();        
        lstPar.add(new Parametro(1,micliente.getRuc()));
        lstPar.add(new Parametro(2,micliente.getNombre()));
        lstPar.add(new Parametro(3,micliente.getDireccion()));     
        lstPar.add(new Parametro(4,micliente.getId_cliente()));   
        try{
            res= AccesoDatos.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            }
        return res;
    }
    
    
//SELECCIONAR
    public static ArrayList<clsCliente> findbyAll() {
        ArrayList<clsCliente> listado = new ArrayList<>();
        String sql = "SELECT id_cliente,ruc, nombre, direccion "+
                "FROM public.cliente";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsCliente micliente = null;
            while (cres.next())
            {
                micliente = new clsCliente();
                 micliente.setId_cliente(cres.getInt("id_cliente"));
                 micliente.setRuc(cres.getString("ruc"));
                 micliente.setNombre(cres.getString("nombre"));
                 micliente.setDireccion(cres.getString("direccion"));
               
                listado.add(( micliente));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    
    }
    
     public static clsCliente findbyId(clsCliente cli) {
        clsCliente cliente = null;

        String sql = "SELECT id_cliente, ruc, nombre, direccion "
                + "FROM public.cliente  WHERE id_cliente=?";

        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cli.getId_cliente()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                cliente = new clsCliente();
                cliente.setId_cliente(cres.getInt("id_cliente"));
                cliente.setNombre(cres.getString("nombre"));
                cliente.setRuc(cres.getString("ruc"));
                cliente.setDireccion(cres.getString("direccion"));
                
             

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cliente;
    }

     
        public static clsCliente findbyId(int id_cliente) {
        clsCliente cliente = null;
        String sql = "SELECT id_cliente, ruc,nombre, direccion  "+
                "FROM public.cliente WHERE id_cliente=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id_cliente));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                cliente = new clsCliente();
                cliente.setId_cliente(cres.getInt("id_cliente"));
                 cliente.setRuc(cres.getString("ruc"));
                cliente.setNombre(cres.getString("nombre"));
                cliente.setDireccion(cres.getString("direccion"));
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cliente;
    }
}

    
