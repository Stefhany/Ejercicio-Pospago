/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author Mona
 */
public class AuditoriaDTO {
    private String usuario = "";
    private String numLinea = "";
    private String accion = "";
    private String fecha = "";

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the numLinea
     */
    public String getNumLinea() {
        return numLinea;
    }

    /**
     * @param numLinea the numLinea to set
     */
    public void setNumLinea(String numLinea) {
        this.numLinea = numLinea;
    }

    /**
     * @return the accion
     */
    public String getAccion() {
        return accion;
    }

    /**
     * @param accion the accion to set
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "AuditoriaDTO " + "usuario=" + usuario
                + ", numLinea=" + numLinea
                + ", accion=" + accion
                + ", fecha=" + fecha;
    }
    
    
}
