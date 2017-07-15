
package ec.org.camariweb2.entidades;


public class clsDFacturaProducto {
    
    
    private int _id_dfacturaproducto;
    private clsFactura _factura;
    private clsProducto _producto;
    private int _cantidad;
    private double _subtotal;

    public clsDFacturaProducto() {
    }

    public clsDFacturaProducto(int _id_dfacturaproducto, clsFactura _factura, clsProducto _producto, int _cantidad, double _subtotal) {
        this._id_dfacturaproducto = _id_dfacturaproducto;
        this._factura = _factura;
        this._producto = _producto;
        this._cantidad = _cantidad;
        this._subtotal = _subtotal;
    }

    public int getId_dfacturaproducto() {
        return _id_dfacturaproducto;
    }

    public void setId_dfacturaproducto(int _id_dfacturaproducto) {
        this._id_dfacturaproducto = _id_dfacturaproducto;
    }

    public clsFactura getFactura() {
        return _factura;
    }

    public void setFactura(clsFactura _factura) {
        this._factura = _factura;
    }

    public clsProducto getProducto() {
        return _producto;
    }

    public void setProducto(clsProducto _producto) {
        this._producto = _producto;
    }

    public int getCantidad() {
        return _cantidad;
    }

    public void setCantidad(int _cantidad) {
        this._cantidad = _cantidad;
    }

    public double getSubtotal() {
        return _subtotal;
    }

    public void setSubtotal(double _subtotal) {
        this._subtotal = _subtotal;
    }

    @Override
    public String toString() {
        return "clsDFacturaProducto{" + "_id_dfacturaproducto=" + _id_dfacturaproducto + ", _factura=" + _factura + ", _producto=" + _producto + ", _cantidad=" + _cantidad + ", _subtotal=" + _subtotal + '}';
    }

    
}