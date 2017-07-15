
package ec.org.camariweb2.logicanegocio;

import ec.org.camariweb2.entidades.clsDFacturaProducto;
import ec.org.camariweb2.entidades.clsFactura;
import ec.org.camariweb2.entidades.clsProducto;
import ec.org.camariweb2.funciones.crudDFacturaProducto;
import ec.org.camariweb2.funciones.crudFactura;
import ec.org.camariweb2.funciones.crudProducto;
import java.util.ArrayList;

public class clsLnProducto {
    
    public boolean actualizaSock( int id_producto, int nuevoStock){
    boolean resultado = false;
    clsProducto prod= new clsProducto(); //declara un objeto en la clase que se llama prod en un contructo vacio
    prod = crudProducto.findbyId(id_producto); // llamamos al id de la clase producto 
    prod.setStock(prod.getStock() - nuevoStock); //para cambiar el valor del Stock //obetiene con el set //saber el valor con el get    
    resultado = crudProducto.update(prod); //aqui vamos a actualizar un valor bolean y se actualizo no sales si   
    return resultado;
    }
    
    public boolean actualizarPrecio(int id_producto, double porcentaje)
    {
        boolean resultado = false;
        clsProducto prod = new clsProducto();
        prod= crudProducto.findbyId(id_producto);
         prod.setPrecio_venta(prod.getPrecio_venta() + prod.getPrecio_venta()* porcentaje/100);
//        prod.setPrecio_venta(prod.getPrecio_venta() + 2);
        resultado= crudProducto.update(prod);
        
        return resultado;
        
        
    }
    
    public boolean actualizarPrecios(int id_producto, double porcentaje)
    {
        boolean resultado = false;

        ArrayList<clsProducto> prods = new ArrayList<>();
        prods = crudProducto.findbyAll();
        for (clsProducto prod : prods) {
            prod.setPrecio_venta(prod.getPrecio_venta() + prod.getPrecio_venta()*porcentaje/100);
            resultado = crudProducto.update(prod);
        }
        
        return resultado;
    }
    
    
    public  ArrayList<clsProducto> alectarMenor5()
    {
       ArrayList<clsProducto> alerta = new ArrayList<>();
        ArrayList<clsProducto> prods = new ArrayList<>();
        prods = crudProducto.findbyAll();
        
        for (clsProducto prod : prods) {
            if (prod.getStock() <5)
            alerta.add(prod);
            
        }
        
        return alerta;
    }
        
    
     //Por la compra de 6 productos iguales una mas gratis
    public boolean promocion() {

        boolean resultado = false;
        ArrayList<clsDFacturaProducto> detalles = new ArrayList();

        detalles = crudDFacturaProducto.findbyAll();
        for (clsDFacturaProducto detalle : detalles) {
            if (detalle.getCantidad() > 6) {
                detalle.setCantidad(detalle.getCantidad() + 1);
                resultado = crudDFacturaProducto.update(detalle);
            }
        }
        return resultado;
    }
    
    
    
    // Descuento en compras mayores a $ 100 (x cantidad)
    public boolean descuento() {

        boolean resultado = false;
        ArrayList<clsFactura> fact = new ArrayList();

        fact = crudFactura.findbyAll();
        for (clsFactura f : fact) {
            if (f.getTotal() > 99) {

                f.setTotal(f.getTotal() - (f.getTotal() * 0.10));
                resultado = crudFactura.update(f);
            }
        }
        return resultado;

    }
}
