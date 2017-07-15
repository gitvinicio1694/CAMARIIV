/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.org.camariweb2.test;

import ec.org.camariweb2.entidades.clsDFacturaProducto;
import ec.org.camariweb2.entidades.clsFactura;
import ec.org.camariweb2.entidades.clsProducto;
import ec.org.camariweb2.funciones.crudDFacturaProducto;

public class test_dfacturaproducto {

    public static void main(String[] args) {
        clsFactura f = new clsFactura(1, null, null, 0, 0, 0);
        clsProducto p=new clsProducto(2, null, 0, 0);

        clsDFacturaProducto c = new clsDFacturaProducto(3, f, p, 5, 5);
        crudDFacturaProducto cc = new crudDFacturaProducto();

//        System.out.println("Prueba de clases");
//        System.out.println("=============================================");
//        System.out.println("contenido de la clase c");
//        System.out.println(c.toString());
//        System.out.println("=============================================");
//        System.out.println("=============================================");
//        System.out.println("INSERTANDO");
//        if (cc.save(c)) {
//            System.out.println("Guardado");
//        } else {
//            System.out.println("error!!!!");
//        }

    
//         System.out.println("Comprobando si hay datos");
//        System.out.println(cc.findbyId(c).toString());
//        System.out.println("=============================================");
//        System.out.println("=============================================");
//        System.out.println("Eliminando");
//        if (cc.delete(c)) {
//            System.out.println("eliminado");
//        } else {
//            System.out.println("no se ha podido eliminar");
//        }
//
//
//
        System.out.println("Comprobando si hay datos");
        System.out.println(cc.findbyId(c).toString());
        System.out.println("=============================================");
        System.out.println("=============================================");
        System.out.println("Actualizando");
        if (cc.update(c)) {
            System.out.println("Actualizado");
        } else {
            System.out.println("no se ha podido actualizar");
        }
    }
}