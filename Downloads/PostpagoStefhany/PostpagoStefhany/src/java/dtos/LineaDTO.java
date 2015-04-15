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
public class LineaDTO {


    private String linumerolinea = " ";
    private int perid = 0;
    private String linestado = " ";
    private PersonaDTO p;
    
    
    public LineaDTO() {
    }
    
    public LineaDTO(PersonaDTO per) {
        this.p = per;
    }

    /**
     * @return the linumerolinea
     */
    public String getLinumerolinea() {
        return linumerolinea;
    }

    /**
     * @param linumerolinea the linumerolinea to set
     */
    public void setLinumerolinea(String linumerolinea) {
        this.linumerolinea = linumerolinea;
    }

    /**
     * @return the perid
     */
    public int getPerid() {
        return perid;
    }

    /**
     * @param perid the perid to set
     */
    public void setPerid(int perid) {
        this.perid = perid;
    }

    /**
     * @return the linestado
     */
    public String getLinestado() {
        return linestado;
    }

    /**
     * @param linestado the linestado to set
     */
    public void setLinestado(String linestado) {
        this.linestado = linestado;
    }

   /**
     * @return the p
     */
    public PersonaDTO getP() {
        return p;
    }

    /**
     * @param p the p to set
     */
    public void setP(PersonaDTO p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return "LineaDTO " + "linumerolinea=" + linumerolinea +
                ", perid=" + perid +
                ", linestado=" + linestado +
                ", p=" + p.getPerNombre();
    }
    
    

}
