
package ec.org.camariweb2.entidades;


public class clsCliente {
    
    private int _id_cliente;
    private String _ruc;
    private String _nombre;
    private String _direccion;

    public clsCliente() {
    }

    public clsCliente(int _id_cliente, String _ruc, String _nombre, String _direccion) {
        this._id_cliente = _id_cliente;
        this._ruc = _ruc;
        this._nombre = _nombre;
        this._direccion = _direccion;
    }

    public String getDireccion() {
        return _direccion;
    }

    public void setDireccion(String _direccion) {
        this._direccion = _direccion;
    }

    public String getRuc() {
        return _ruc;
    }

    public void setRuc(String _ruc) {
        this._ruc = _ruc;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public int getId_cliente() {
        return _id_cliente;
    }

    public void setId_cliente(int _id_cliente) {
        this._id_cliente = _id_cliente;
    }

    @Override
    public String toString() {
        return "clsCliente{" + "_id_cliente=" + _id_cliente + ", _ruc=" + _ruc + ", _nombre=" + _nombre + ", _direccion=" + _direccion + '}';
    }
    
    
}
