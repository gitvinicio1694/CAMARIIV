
package ec.org.camariweb2.controlador;

import ec.org.camariweb2.entidades.clsCliente;
import ec.org.camariweb2.funciones.crudCliente;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class cCliente {
    
    private List<clsCliente> Lista;
    private clsCliente newCliente; //Cuando ingrese un cliente numero 
    private clsCliente selectedCliente; // cuando selecione un cliente para borrar o actualizar
   
    public cCliente() {
        newCliente = new clsCliente();
        cargarDatos();
        
    }
     
        private void cargarDatos(){
    
        Lista = crudCliente.findbyAll();
    }

        
        
        public void insertar(){
            if (crudCliente.save(newCliente)){ //esta linea guarda el cliente
                newCliente = new clsCliente(); //prepara el constructor de un posible nuevo cliente
                cargarDatos();                  //refresca el datagrid con los cambios (Aparece el nuevo cliente)
                //mostrar mensaj  
            }
            else
            {
                //mostrar mensaje de no guardado
            }
        }
        
        public void eliminar ()
        {
            if(crudCliente.delete(selectedCliente)){
                    newCliente = new clsCliente();
                    cargarDatos();
                }
            else{
            }
        }
        
        
        public void actualizar ()
        {
            if(crudCliente.update(selectedCliente)){
                    newCliente = new clsCliente();
                    cargarDatos();
                }
            else{
            }
        }

    public List<clsCliente> getLista() {
        return Lista;
    }

    public void setLista(List<clsCliente> Lista) {
        this.Lista = Lista;
    }

    public clsCliente getNewCliente() {
        return newCliente;
    }

    public void setNewCliente(clsCliente newCliente) {
        this.newCliente = newCliente;
    }

    public clsCliente getSelectedCliente() {
        return selectedCliente;
    }

    public void setSelectedCliente(clsCliente selectedCliente) {
        this.selectedCliente = selectedCliente;
    }

    
}
