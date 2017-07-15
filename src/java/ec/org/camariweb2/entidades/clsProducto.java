
package ec.org.camariweb2.entidades;

public class clsProducto {
    
    
    private int _id_producto;
    private String _nombre;
    private double _stock;
    private double _precio_venta;

    public clsProducto() {
    }

    public clsProducto(int _id_producto, String _nombre, double _stock, double _precio_venta) {
        this._id_producto = _id_producto;
        this._nombre = _nombre;
        this._stock = _stock;
        this._precio_venta = _precio_venta;
    }

    public int getId_producto() {
        return _id_producto;
    }

    public void setId_producto(int _id_producto) {
        this._id_producto = _id_producto;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public double getStock() {
        return _stock;
    }

    public void setStock(double _stock) {
        this._stock = _stock;
    }

    public double getPrecio_venta() {
        return _precio_venta;
    }

    public void setPrecio_venta(double _precio_venta) {
        this._precio_venta = _precio_venta;
    }

    @Override
    public String toString() {
        return "clsProducto{" + "_id_producto=" + _id_producto + ", _nombre=" + _nombre + ", _stock=" + _stock + ", _precio_venta=" + _precio_venta + '}';
    }
    
    
}
