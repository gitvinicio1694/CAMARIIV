package ec.org.camariweb2.accesodatos;

import java.sql.*;
import java.util.*; 

public class AccesoDatos {

    public static boolean ejecutaComando(String comando, ArrayList<Parametro> parametros) throws Exception
    {
        boolean respuesta=false;
        PreparedStatement ptrs=null; 
        Connection con=null; 
        try {            
            Class.forName(Global.DRIVER);
            try {
                con = DriverManager.getConnection(Global.URL,Global.USER,Global.PASS);
                ptrs = con.prepareStatement(comando);
                for (Parametro parametro : parametros) {
                    ptrs.setObject(parametro.getPosicion(), parametro.getValor());
                }
                int i= ptrs.executeUpdate();
                if(i>0)
                    respuesta=true;
                ptrs.close();
                ptrs=null;
            } catch (SQLException exConec) {
                throw exConec;
            }
            finally
            {             
                try{
                    if(con!=null)
                    {
                        if(!(con.isClosed()))
                            con.close();
                        con=null;
                    }
                }catch(Exception ex)
                {throw ex;}
            }
        }

        catch (ClassNotFoundException exCarga) {
            throw  exCarga;
        }

        return respuesta;
    }

    public static int ejecutaComandoReturn(String comando, ArrayList<Parametro> parametros) throws Exception
    {
        int respuesta=0;
        PreparedStatement ptrs=null; 
        Connection con=null; 
        try {            
            Class.forName(Global.DRIVER);
            try {
                con = DriverManager.getConnection(Global.URL,Global.USER,Global.PASS);
                ptrs = con.prepareStatement(comando);
                for (Parametro parametro : parametros) {
                    ptrs.setObject(parametro.getPosicion(), parametro.getValor());
                }
                ResultSet rs = ptrs.executeQuery();
                if(rs.next()){
                    respuesta = rs.getInt(1);
                    
                    //Borrar el siguiente bloque que sirve para pruebas
                    System.out.println("1: " + rs.getString(1));
                    System.out.println("2: " + rs.getString(2));
                    System.out.println("3: " + rs.getString(3));
                    System.out.println("4: " + rs.getString(4));
                    System.out.println("5: " + rs.getString(5));
                    System.out.println("6: " + rs.getString(6));
                         
		}
                ptrs.close();
                ptrs=null;
            } catch (SQLException exConec) {
                throw exConec;
            }
            finally
            {             
                try{
                    if(con!=null)
                    {
                        if(!(con.isClosed()))
                            con.close();
                        con=null;
                    }
                }catch(Exception ex)
                {throw ex;}
            }
        }

        catch (ClassNotFoundException exCarga) {
            throw  exCarga;
        }

        return respuesta;
    }

    public static ConjuntoResultado ejecutaQuery(String query) throws Exception 
    {            
        ResultSet rs = null;
        PreparedStatement pst=null;
        ConjuntoResultado conj= new ConjuntoResultado();
        Connection con=null;
        try {
            Class.forName(Global.DRIVER);
            try {
                con = DriverManager.getConnection(Global.URL,Global.USER,Global.PASS);
                pst = con.prepareStatement(query);
                rs = pst.executeQuery();
                conj.Fill(rs);
                rs.close();
                pst.close();
                rs=null;
                pst=null;
            } catch (SQLException exConec) {
                throw  exConec;
            }
            finally
            {
                try{
                    if(con!=null)
                    {
                        if(!(con.isClosed()))
                        con.close();
                    con=null;
                }
                }catch(Exception ex)
                {throw ex;}
            }
        }
        catch (ClassNotFoundException exCarga) {
            throw  exCarga;
        }
        return conj;
    }

    public static ConjuntoResultado ejecutaQuery(String query, ArrayList<Parametro> parametros) throws Exception
    {            
        ResultSet rs = null;
        PreparedStatement ptrs=null;
        ConjuntoResultado conj= new ConjuntoResultado();
        Connection con=null;
        try {
        Class.forName(Global.DRIVER);
            try {
                String url=Global.URL;
                 con = DriverManager.getConnection(url,Global.USER,Global.PASS);
               ptrs = con.prepareStatement(query);
                for (Parametro parametro : parametros) {
                    ptrs.setObject(parametro.getPosicion(), parametro.getValor());
                }
                rs = ptrs.executeQuery();
                conj.Fill(rs);
                rs.close();
                ptrs.close();
                rs=null;
                ptrs=null;
            } catch (SQLException exConec) {
              throw  exConec;
            }
         finally
         {  
            try{
                    if(con!=null)
             {
                 if(!(con.isClosed()))
                    con.close();
                 con=null;
             }
            }catch(Exception ex)
            {throw ex;}
         }
        }
        catch (ClassNotFoundException exCarga) {
            throw  exCarga;
        }
        return conj;
    }
}
