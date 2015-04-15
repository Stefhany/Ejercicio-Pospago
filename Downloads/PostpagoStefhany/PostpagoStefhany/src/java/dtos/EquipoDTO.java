/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author krito
 */
public class EquipoDTO {

    private int equSerial = 0;
    private String liNumeroLinea = " ";
    private String equMarca = " ";
    private String equDescripcion = " ";
    private String equEstado = " ";
    private LineaDTO linea;

    public EquipoDTO() {
    }
    
    public EquipoDTO(LineaDTO linea) {
        this.linea = linea;
    }
    /**
     * @return the equSerial
     */
    public int getEquSerial() {
        return equSerial;
    }

    /**
     * @param equSerial the equSerial to set
     */
    public void setEquSerial(int equSerial) {
        this.equSerial = equSerial;
    }

    /**
     * @return the liNumeroLinea
     */
    public String getLiNumeroLinea() {
        return liNumeroLinea;
    }

    /**
     * @param liNumeroLinea the liNumeroLinea to set
     */
    public void setLiNumeroLinea(String liNumeroLinea) {
        this.liNumeroLinea = liNumeroLinea;
    }

    /**
     * @return the equMarca
     */
    public String getEquMarca() {
        return equMarca;
    }

    /**
     * @param equMarca the equMarca to set
     */
    public void setEquMarca(String equMarca) {
        this.equMarca = equMarca;
    }

    /**
     * @return the equDescripcion
     */
    public String getEquDescripcion() {
        return equDescripcion;
    }

    /**
     * @param equDescripcion the equDescripcion to set
     */
    public void setEquDescripcion(String equDescripcion) {
        this.equDescripcion = equDescripcion;
    }

    /**
     * @return the equEstado
     */
    public String getEquEstado() {
        return equEstado;
    }

    /**
     * @param equEstado the equEstado to set
     */
    public void setEquEstado(String equEstado) {
        this.equEstado = equEstado;
    }

    @Override
    public String toString() {
        return "EquipoDTO{" + "equSerial=" + equSerial + ", liNumeroLinea=" + liNumeroLinea + ", equMarca=" + equMarca + ", equDescripcion=" + equDescripcion + ", equEstado=" + equEstado + '}';
    }

    /**
     * @return the linea
     */
    public LineaDTO getLinea() {
        return linea;
    }

    /**
     * @param linea the linea to set
     */
    public void setLinea(LineaDTO linea) {
        this.linea = linea;
    }

}
