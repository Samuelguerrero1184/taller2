package model;

public class Order {

    private int id;
    private long fecha;
    private boolean pago;
    private long fecha_pago;
    private String identificacion;

    public Order() {
    }

    public Order(int id, long fecha, boolean pago, long fecha_pago, String identificacion) {
        this.id = id;
        this.fecha = fecha;
        this.pago = pago;
        this.fecha_pago = fecha_pago;
        this.identificacion = identificacion;
    }

    public Order(int id, long fecha, boolean pago, String identificacion) {
        this.id = id;
        this.fecha = fecha;
        this.pago = pago;
        this.identificacion = identificacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getFecha() {
        return fecha;
    }

    public void setFecha(long fecha) {
        this.fecha = fecha;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public long getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(long fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}
