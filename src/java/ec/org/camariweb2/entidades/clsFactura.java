
package ec.org.camariweb2.entidades;

import java.util.Date;

public class clsFactura {
    
    private int _id_factura;
    private clsCliente _cliente;
    private Date _fecha;
    private double _subtotal;
    private double _iva;
    private double _total;

    public clsFactura() {
    }

    public clsFactura(int _id_factura, clsCliente _cliente, Date _fecha, double _subtotal, double _iva, double _total) {
        this._id_factura = _id_factura;
        this._cliente = _cliente;
        this._fecha = _fecha;
        this._subtotal = _subtotal;
        this._iva = _iva;
        this._total = _total;
    }

    public int getId_factura() {
        return _id_factura;
    }

    public void setId_factura(int _id_factura) {
        this._id_factura = _id_factura;
    }

    public clsCliente getCliente() {
        return _cliente;
    }

    public void setCliente(clsCliente _cliente) {
        this._cliente = _cliente;
    }

    public Date getFecha() {
        return _fecha;
    }

    public void setFecha(Date _fecha) {
        this._fecha = _fecha;
    }

    public double getSubtotal() {
        return _subtotal;
    }

    public void setSubtotal(double _subtotal) {
        this._subtotal = _subtotal;
    }

    public double getIva() {
        return _iva;
    }

    public void setIva(double _iva) {
        this._iva = _iva;
    }

    public double getTotal() {
        return _total;
    }

    public void setTotal(double _total) {
        this._total = _total;
    }

    @Override
    public String toString() {
        return "clsFactura{" + "_id_factura=" + _id_factura + ", _cliente=" + _cliente + ", _fecha=" + _fecha + ", _subtotal=" + _subtotal + ", _iva=" + _iva + ", _total=" + _total + '}';
    }

   
   
}
