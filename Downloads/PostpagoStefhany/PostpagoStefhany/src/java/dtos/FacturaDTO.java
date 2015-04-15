/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.sql.Date;

/**
 *
 * @author krito
 */
public class FacturaDTO {
    private int facNumero = 0;
    private String liNumeroLinea = " ";
    private String facFechaEmision;
    private float facValor = 0;
    private PersonaDTO persona;
    private LineaDTO linea;
    
    
    public FacturaDTO() {
    }
    
    public FacturaDTO(LineaDTO lin) {
        this.linea = lin;
    }
    
    /**
     * @return the facNumero
     */
    public int getFacNumero() {
        return facNumero;
    }

    /**
     * @param facNumero the facNumero to set
     */
    public void setFacNumero(int facNumero) {
        this.facNumero = facNumero;
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
     * @return the facFechaEmision
     */
    public String getFacFechaEmision() {
        return facFechaEmision;
    }

    /**
     * @param facFechaEmision the facFechaEmision to set
     */
    public void setFacFechaEmision(String facFechaEmision) {
        this.facFechaEmision = facFechaEmision;
    }

    /**
     * @return the facValor
     */
    public float getFacValor() {
        return facValor;
    }

    /**
     * @param facValor the facValor to set
     */
    public void setFacValor(float facValor) {
        this.facValor = facValor;
    }

    @Override
    public String toString() {
        return "FacturaDTO " + " facNumero = " + facNumero + ", liNumeroLinea = " + liNumeroLinea + ", facFechaEmision = " + facFechaEmision + ", facValor = " + facValor;
    }

    /**
     * @return the persona
     */
    public PersonaDTO getPersona() {
        return persona;
    }

    /**
     * @param persona the persona to set
     */
    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
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
