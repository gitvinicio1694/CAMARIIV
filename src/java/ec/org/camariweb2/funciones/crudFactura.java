/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.org.camariweb2.funciones;


import ec.org.camariweb2.accesodatos.AccesoDatos;
import ec.org.camariweb2.accesodatos.ConjuntoResultado;
import ec.org.camariweb2.accesodatos.Parametro;
import ec.org.camariweb2.entidades.clsFactura;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class crudFactura {

    public static boolean save(clsFactura factura) {

        boolean resultado = false;

        String sql = "INSERT INTO public.factura(id_cliente, fecha, subtotal, iva, total) VALUES (?,?,?,?,?)";

        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, factura.getCliente()));
        lstPar.add(new Parametro(2, factura.getFecha()));
        lstPar.add(new Parametro(3, factura.getSubtotal()));
        lstPar.add(new Parametro(4, factura.getIva()));
        lstPar.add(new Parametro(5, factura.getTotal()));

        try {
            resultado = AccesoDatos.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;

    }

    public static boolean delete(clsFactura factura) {
        boolean res = false;
        String sql = "DELETE FROM public.factura WHERE id_factura=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, factura.getId_factura()));
        try {
            res = AccesoDatos.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    public static boolean update(clsFactura factura) {
        boolean res = false;
        String sql = "UPDATE public.factura "
                + "SET id_cliente=?, fecha=?, subtotal=?, iva=?, total=? "
                + "WHERE id_factura=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, factura.getCliente()));
        lstPar.add(new Parametro(2, factura.getFecha()));
        lstPar.add(new Parametro(3, factura.getSubtotal()));
        lstPar.add(new Parametro(4, factura.getIva()));
        lstPar.add(new Parametro(5, factura.getTotal()));
        lstPar.add(new Parametro(6, factura.getId_factura()));
        

        try {
            res = AccesoDatos.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    public static ArrayList<clsFactura> findbyAll() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT id_factura, id_cliente, fecha, subtotal, iva, total "
                + "FROM public.factura";
        // Parametros vacios
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura factura = null;
            while (cres.next()) {
                factura = new clsFactura();
                factura.setId_factura(cres.getInt("id_factura"));
                factura.setCliente(crudCliente.findbyId(cres.getInt("id_cliente")));
                //factura.getCliente().setId_cliente(cres.getInt("id_cliente"));
                factura.setFecha(cres.getDate("fecha"));
                factura.setSubtotal(cres.getDouble("subtotal"));
                factura.setIva(cres.getDouble("iva"));
                factura.setTotal(cres.getDouble("total"));

                listado.add((factura));
                System.out.println("id_factura");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public  static clsFactura findbyId(clsFactura cli) {
        clsFactura factura = null;

        String sql = "SELECT id_factura, id_cliente, fecha, subtotal, iva, total "
                + "FROM public.factura  WHERE id_factura=?";

        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cli.getId_factura()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                factura = new clsFactura();
                factura.setId_factura(cres.getInt("id_factura"));
                factura.getCliente().setId_cliente(cres.getInt("idcliente"));
                factura.setFecha(cres.getDate("fecha"));
                factura.setSubtotal(cres.getDouble("subtotal"));
                factura.setIva(cres.getDouble("iva"));
                factura.setTotal(cres.getDouble("total"));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return factura;
    }
   public static clsFactura findbyId(int id_factura) {
        clsFactura factura = null;
        String sql = "SELECT id_factura, id_cliente, fecha, subtotal, total, iva  "+
                "FROM public.factura WHERE id_factura=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id_factura));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                factura = new clsFactura();
                factura.setId_factura(cres.getInt("id_factura"));
                factura.getCliente();
                factura.setFecha(cres.getDate("fecha"));
                factura.setSubtotal(cres.getDouble("subtotal"));
                factura.setTotal(cres.getDouble("total"));
                factura.setIva(cres.getDouble("iva"));
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return factura;
    }
}
