
package ec.org.camariweb2.controlador;


import ec.org.camariweb2.entidades.clsProducto;
import ec.org.camariweb2.funciones.crudProducto;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class cProducto {
    
    private List<clsProducto> Lista;
    private clsProducto newProducto; //Cuando ingrese un producto nuevo 
    private clsProducto selectedProducto; // cuando selecione un Producto para borrar o actualizar

    public cProducto() {
        newProducto = new clsProducto();
        cargarDatos();
        
    }
    
     private void cargarDatos(){
    
        Lista = crudProducto.findbyAll();
    }

        public void insertar(){
            if (crudProducto.save(newProducto)){ //esta linea guarda el cliente
                newProducto = new clsProducto(); //prepara el constructor de un posible nuevo cliente
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
            if(crudProducto.delete(selectedProducto)){
                    newProducto = new clsProducto();
                    cargarDatos();
                }
            else{
                
            }
            }
        
        public void actualizar ()
        {
             if(crudProducto.update(selectedProducto)){
                               
                    newProducto = new clsProducto();
                    cargarDatos();
                }
             else{
                 
             }
        }

    public List<clsProducto> getLista() {
        return Lista;
    }

    public void setLista(List<clsProducto> Lista) {
        this.Lista = Lista;
    }

    public clsProducto getNewProducto() {
        return newProducto;
    }

    public void setNewProducto(clsProducto newProducto) {
        this.newProducto = newProducto;
    }

    public clsProducto getSelectedProducto() {
        return selectedProducto;
    }

    public void setSelectedProducto(clsProducto selectedProducto) {
        this.selectedProducto = selectedProducto;
    }
        
}
