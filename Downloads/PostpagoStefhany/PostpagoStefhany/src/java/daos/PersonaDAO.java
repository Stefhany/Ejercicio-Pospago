/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.LineaDTO;
import dtos.PersonaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import utilidadesStefhany.Conectar;
import utilidadesStefhany.MyException;

/**
 *
 * @author krito
 */
public class PersonaDAO {

    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Connection cnn = null;
    String salida = " ";
    int resultado = 0;
    PersonaDTO pdto = new PersonaDTO();
    ArrayList<PersonaDTO> personas = new ArrayList<>();

    public PersonaDAO() {
        cnn = Conectar.getInstance();
    }

    public String insertarPersona(PersonaDTO nuevaPersona) {
        try {
            pstmt = cnn.prepareStatement("INSERT INTO persona VALUES (null, ?, ?, ?, ?, ?, ?, md5(?));");
            pstmt.setString(1, nuevaPersona.getPerNombre());
            pstmt.setString(2, nuevaPersona.getPerApellido());
            pstmt.setString(3, nuevaPersona.getPerTelefonoFijo());
            pstmt.setString(4, nuevaPersona.getPerFechaNacimiento());
            pstmt.setString(5, nuevaPersona.getPerCedula());
            pstmt.setString(6, nuevaPersona.getUser());
            pstmt.setString(7, nuevaPersona.getClave());
            resultado = pstmt.executeUpdate();

            if (resultado != 0) {
                salida = "El registro ha sido exitoso " + ", mira: " + resultado;
            } else {
                salida = "No se pudo realizar el registro";
            }
        } catch (SQLException sqle) {
            salida = "Ha ocurrido la siguiente exepción.. " + sqle.getMessage();

        }
        return salida;
    }

    public String modificarPersona(PersonaDTO modPersona) {
        try {
            pstmt = cnn.prepareStatement("UPDATE persona SET pertelefonofijo=?, clave = ? WHERE perid=?;");
            pstmt.setString(1, modPersona.getPerTelefonoFijo());
            pstmt.setString(2, modPersona.getClave());
            pstmt.setInt(3, modPersona.getPerId());
            resultado = pstmt.executeUpdate();

            if (resultado != 0) {
                salida = "La modificación  " + resultado + " se pudo realizar, exitosamente";
            } 
        } catch (SQLException sqle) {
            salida = "Ha ocurrido lo siguiente... " + sqle.getMessage();
        }
        return salida;
    }

    public ArrayList<PersonaDTO> listarPersonas() {
        ArrayList<PersonaDTO> per = new ArrayList();
        try {
            pstmt = cnn.prepareStatement("SELECT perid, pernombre, perapellido, pertelefonofijo, perfechanacimiento, percedula, user, clave FROM persona;");
            rs = pstmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    PersonaDTO pdtos = new PersonaDTO();
                    pdtos.setPerId(rs.getInt("perid"));
                    pdtos.setPerNombre(rs.getString("pernombre"));
                    pdtos.setPerApellido(rs.getString("perapellido"));
                    pdtos.setPerTelefonoFijo(rs.getString("pertelefonofijo"));
                    pdtos.setPerFechaNacimiento(rs.getString("perfechanacimiento"));
                    pdtos.setPerCedula(rs.getString("percedula"));
                    pdtos.setUser(rs.getString("user"));
                    pdtos.setClave(rs.getString("clave"));
                    per.add(pdtos);
                }
            } else {
                System.out.println("No se encuetran registros de personas");
            }
        } catch (SQLException sqle) {
            System.out.println("Se ha producido esta excepción.. " + sqle.getMessage());
        }
        return per;
    }

    public String eliminarPersona(int id) {
        try {
            pstmt = cnn.prepareStatement("DELETE FROM persona WHERE perid=?;");
            pstmt.setInt(1, id);
            resultado = pstmt.executeUpdate();

            if (resultado != 0) {
                salida = "Registro " + resultado + " eliminado. Exitosamente";
            }
        } catch (SQLException sqle) {
            salida = "Ocurrio esta excepción " + sqle.getMessage();
        }
        return salida;
    }

    public PersonaDTO validarUsuarioV2(int cedula, String pass) {
        try {
            pstmt = cnn.prepareStatement("SELECT perid, pernombre, perapellido, pertelefonofijo, "
                    + " perfechanacimiento, percedula, user, clave FROM persona WHERE percedula = ? AND clave  = MD5(?);");
            pstmt.setInt(1, cedula);
            pstmt.setString(2, pass);
            rs = pstmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    pdto.setPerId(rs.getInt("perid"));
                    pdto.setPerNombre(rs.getString("pernombre"));
                    pdto.setPerApellido(rs.getString("perapellido"));
                    pdto.setPerTelefonoFijo(rs.getString("pertelefonofijo"));
                    pdto.setPerFechaNacimiento(rs.getString("perfechanacimiento"));
                    pdto.setPerCedula(rs.getString("percedula"));
                    pdto.setUser(rs.getString("user"));
                    pdto.setClave(rs.getString("clave"));
                }
            } else {
                pdto = null;
            }
            return pdto;
        } catch (SQLException ex) {
            System.out.println("Ups! Mira lo ocurrido... " + ex.getMessage());
        }
        return pdto;
    }

    public PersonaDTO buscarPersona(int id) {
        try {

            String query = " select PERNOMBRE, PERAPELLIDO, PERCEDULA, LINUMEROLINEA from persona as p "
                    + " inner join linea as l on "
                    + " p.PERID = l.PERID; ";
            pstmt = cnn.prepareStatement(query);
            rs = pstmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    PersonaDTO pdto = new PersonaDTO("PERNOMBRE", "PERAPELLIDO", "PERCEDULA");
                    //LineaDTO lin = new LineaDTO("LINUMEROLINEA", pdto);
                }
            } else {
                System.out.println("No hay registros... ");
            }
        } catch (SQLException sqle) {
            System.out.println("Ups! Mira lo ocurrido... " + sqle.getMessage());
        }
        return pdto;
    }

    public StringBuilder validarUserName(String cedula) throws MyException {

        StringBuilder salida = new StringBuilder("");
        try {
            String validarJs = "SELECT perid, pernombre, perapellido, pertelefonofijo, "
                    + " perfechanacimiento, percedula, user, clave FROM persona WHERE percedula=?";
            pstmt = cnn.prepareStatement(validarJs);
            pstmt.setString(1, cedula);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                salida.append("La cedula '").append(cedula).append("' ya se encuentra registrada!");
            } else {
                salida.append("No se encuentra registrada");
            }

        } catch (SQLException sqle) {
            throw new MyException("Error de My SQL" + sqle.getErrorCode() + " " + sqle.getMessage());
        }
        return salida;
    }
    
    public LineaDTO validarUsuarioParaLinea(int cc) {
        LineaDTO lin = null;
        try {
            String querryValidarLinea = " select linumerolinea, perid, linestado "
                    + " from linea where perid = ?;";
            pstmt = cnn.prepareStatement(querryValidarLinea);
            pstmt.setInt(1, cc);
            rs = pstmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    PersonaDTO pdto = new PersonaDTO();
                    pdto.setPerId(rs.getInt("perid"));
                    lin = new LineaDTO(pdto);
                    lin.setLinumerolinea(rs.getString("linumerolinea"));
                    lin.setLinestado(rs.getString("linestado"));
                }
            } else {
                lin = null;
            }
            return lin;
        } catch (SQLException ex) {
            System.out.println("Ups! Mira lo ocurrido... " + ex.getMessage());
        }
        return lin;
    }
}
