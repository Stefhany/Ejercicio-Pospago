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
public class PersonaDTO {
    private int perId = 0;
    private String perNombre = " ";
    private String perApellido = " ";
    private String perTelefonoFijo = " ";
    private String perFechaNacimiento;
    private String perCedula = " ";
    private String user = " ";
    private String clave = " ";
    private LineaDTO linea;
    

    public PersonaDTO() {
        
    }
    
    public PersonaDTO(int cc) {
        this.perId = cc;
    }
    
    public PersonaDTO(int cc, String nom) {
        this.perId = cc;
        this.perNombre = nom;
    }
    
    public PersonaDTO(String nom, String ape, String ced) {
        this.perNombre = nom;
        this.perApellido = ape;
        this.perCedula = ced;
    }
    /**
     * @return the perId
     */
    public int getPerId() {
        return perId;
    }

    /**
     * @param perId the perId to set
     */
    public void setPerId(int perId) {
        this.perId = perId;
    }

    /**
     * @return the perNombre
     */
    public String getPerNombre() {
        return perNombre;
    }

    /**
     * @param perNombre the perNombre to set
     */
    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    /**
     * @return the perApellido
     */
    public String getPerApellido() {
        return perApellido;
    }

    /**
     * @param perApellido the perApellido to set
     */
    public void setPerApellido(String perApellido) {
        this.perApellido = perApellido;
    }

    /**
     * @return the perTelefonoFijo
     */
    public String getPerTelefonoFijo() {
        return perTelefonoFijo;
    }

    /**
     * @param perTelefonoFijo the perTelefonoFijo to set
     */
    public void setPerTelefonoFijo(String perTelefonoFijo) {
        this.perTelefonoFijo = perTelefonoFijo;
    }

    /**
     * @return the perFechaNacimiento
     */
    public String getPerFechaNacimiento() {
        return perFechaNacimiento;
    }

    /**
     * @param perFechaNacimiento the perFechaNacimiento to set
     */
    public void setPerFechaNacimiento(String perFechaNacimiento) {
        this.perFechaNacimiento = perFechaNacimiento;
    }

    /**
     * @return the perCedula
     */
    public String getPerCedula() {
        return perCedula;
    }

    /**
     * @param perCedula the perCedula to set
     */
    public void setPerCedula(String perCedula) {
        this.perCedula = perCedula;
    }
    
    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }
    
    @Override
    public String toString() {
        return "PersonaDTO " + " perId = " + perId + ", perNombre = " + perNombre + ", perApellido = " + perApellido + ", perTelefonoFijo = " + perTelefonoFijo + ", perFechaNacimiento = " + perFechaNacimiento + ", perCedula = " + perCedula + ", user = " + user + ", clave = " + clave;
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
