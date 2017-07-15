/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.org.camariweb2.controlador;

import ec.org.camariweb2.entidades.clsDFacturaProducto;
import ec.org.camariweb2.funciones.crudDFacturaProducto;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped

public class cDfacturaproducto {
     private List<clsDFacturaProducto> Lista;
    private clsDFacturaProducto newDFacturaProducto; //Cuando ingrese un producto nuevo 
    private clsDFacturaProducto selectedDFacturapProducto; // cuando selecione un Producto para borrar o actualizar

    public cDfacturaproducto() {
        
        newDFacturaProducto= new clsDFacturaProducto();
        cargarDatos();
    }
    
     private void cargarDatos(){
    
        Lista = crudDFacturaProducto.findbyAll();
    }

     public void insertar(){
            if (crudDFacturaProducto.save(newDFacturaProducto)){ //esta linea guarda el cliente
                newDFacturaProducto = new clsDFacturaProducto(); //prepara el constructor de un posible nuevo cliente
                cargarDatos();                  //refresca el datagrid con los cambios (Aparece el nuevo cliente)
                //mostrar mensaje
                
            }
            else
            {
                //mostrar mensaje de no guardado
            }
        }
        
        public void eliminar ()
        {
            if(crudDFacturaProducto.delete(selectedDFacturapProducto)){
                                 
                    newDFacturaProducto = new clsDFacturaProducto();
                    cargarDatos();
                }
            else{
                
            }
        }
        
        
        public void actualizar ()
        {
             if(crudDFacturaProducto.update(selectedDFacturapProducto)){
                                   
                    newDFacturaProducto = new clsDFacturaProducto();
                    cargarDatos();
                }
             else
             {
            }
        }

    public List<clsDFacturaProducto> getLista() {
        return Lista;
    }

    public void setLista(List<clsDFacturaProducto> Lista) {
        this.Lista = Lista;
    }

    public clsDFacturaProducto getNewDFacturaProducto() {
        return newDFacturaProducto;
    }

    public void setNewDFacturaProducto(clsDFacturaProducto newDFacturaProducto) {
        this.newDFacturaProducto = newDFacturaProducto;
    }

    public clsDFacturaProducto getSelectedDFacturapProducto() {
        return selectedDFacturapProducto;
    }

    public void setSelectedDFacturapProducto(clsDFacturaProducto selectedDFacturapProducto) {
        this.selectedDFacturapProducto = selectedDFacturapProducto;
    }

    @Override
    public String toString() {
        return "cDfacturaproducto{" + "Lista=" + Lista + ", newDFacturaProducto=" + newDFacturaProducto + ", selectedDFacturapProducto=" + selectedDFacturapProducto + '}';
    }
        
        
}
