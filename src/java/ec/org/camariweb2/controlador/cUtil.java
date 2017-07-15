
package ec.org.camariweb2.controlador;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public class cUtil {
    
    public static void addSuccessMessage(String msgtit, String msgdet){
        FacesMessage facesMsg= new FacesMessage(FacesMessage.SEVERITY_INFO, msgtit, msgdet);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }
    
    public static void addFatalMessage(String msgtit, String msgdet){
        FacesMessage facesMsg= new FacesMessage(FacesMessage.SEVERITY_INFO, msgtit, msgdet);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }
    
    public static void addWarningMessage(String msgtit, String msgdet){
        FacesMessage facesMsg= new FacesMessage(FacesMessage.SEVERITY_INFO, msgtit, msgdet);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }
    
    
    
    
}
