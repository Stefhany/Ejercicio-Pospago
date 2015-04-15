/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.LineaDTO;
import dtos.PersonaDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utilidadesStefhany.Conectar;
import utilidadesStefhany.MyException;

/**
 *
 * @author krito
 */
public class LineaDAO {

    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Connection cnn = null;
    String salida = " ";
    int resultado = 0;
    LineaDTO lindto = new LineaDTO();
    ArrayList<LineaDTO> lineas = new ArrayList<>();
    CallableStatement cllstmt = null;

    public LineaDAO() {
        cnn = Conectar.getInstance();
    }

    public String insertarLinea(LineaDTO nuevaLinea) {
        try {
            pstmt = cnn.prepareStatement("INSERT INTO linea VALUES (?, ?, ?);");
            pstmt.setString(1, nuevaLinea.getLinumerolinea());
            pstmt.setInt(2, nuevaLinea.getPerid());
            pstmt.setString(3, nuevaLinea.getLinestado());
            resultado = pstmt.executeUpdate();

            if (resultado != 0) {
                salida = "El registro de la línea " + resultado + " ha sido exitoso";
            } else {
                salida = "No se pudo realizar el registro";
            }
        } catch (SQLException sqle) {
            salida = "Ha ocurrido la siguiente exepción.. " + sqle.getMessage();

        }
        return salida;
    }

    public String modificarLinea(LineaDTO modLinea) {
        try {
            pstmt = cnn.prepareStatement("UPDATE linea SET linestado = ? WHERE linumerolinea = ?;");
            pstmt.setString(1, modLinea.getLinestado());
            pstmt.setString(2, modLinea.getLinumerolinea());
            resultado = pstmt.executeUpdate();

            if (resultado != 0) {
                salida = "La modificación  " + resultado + " se pudo realizar, exitosamente";
            } else {
                salida = "No se pudo realizar la modificación";
            }
        } catch (SQLException sqle) {
            salida = "Ha ocurrido lo siguiente... " + sqle.getMessage();
        }
        return salida;
    }

    public ArrayList<LineaDTO> listarLineas() {
        ArrayList<LineaDTO> listaLineas = new ArrayList<>();
        try {
            pstmt = cnn.prepareStatement("SELECT linumerolinea as id, perid, linestado FROM linea;");
            rs = pstmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    LineaDTO lin = new LineaDTO();
                    lin.setLinumerolinea(rs.getString("id"));
                    lin.setPerid(rs.getInt("perid"));
                    lin.setLinestado(rs.getString("linestado"));
                    listaLineas.add(lin);
                }
            } else {
                System.out.println("No se encuetran registros de categorias");
            }
        } catch (SQLException sqle) {
            System.out.println("Se ha producido esta excepción.. " + sqle.getMessage());
        }
        return listaLineas;
    }

    public String eliminarLinea(int id) {
        try {
            pstmt = cnn.prepareStatement("DELETE FROM linea WHERE linumerolinea = ?;");
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

    public LineaDTO consultarById(int id) {
        LineaDTO l = null;
        try {
            pstmt = cnn.prepareStatement(" SELECT linumerolinea, linestado, l.perid, pernombre "
                    + " FROM linea l "
                    + " inner join persona p "
                    + " on l.perid = p.perid "
                    + " WHERE linumerolinea = ?;");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    PersonaDTO p = new PersonaDTO();
                    p.setPerNombre(rs.getString("pernombre"));
                    l = new LineaDTO(p);
                    l.setLinumerolinea(rs.getString("linumerolinea"));
                    l.setPerid(rs.getInt("perid"));
                    l.setLinestado(rs.getString("linestado"));
                }
            } else {
                System.out.println("No hay registros... ");
            }
        } catch (SQLException sqle) {
            System.out.println("Ups! Mira lo ocurrido... " + sqle.getMessage());
        }
        return l;
    }

    public StringBuilder validarIdUser(int cc) throws MyException {

        StringBuilder salida = new StringBuilder("");
        try {

            pstmt = cnn.prepareStatement("SELECT LINUMEROLINEA, perid, LINESTADO FROM linea WHERE perid=?;");
            pstmt.setInt(1, cc);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                salida.append("El usuario con el id ").append(cc).append("' ya se encuentra registrada!");
            } else {
                salida.append("El usuario no se encuentra registrado");
            }

        } catch (SQLException sqle) {
            throw new MyException("Error de My SQL" + sqle.getErrorCode() + " " + sqle.getMessage());
        }
        return salida;
    }

    public LineaDTO validarUsuario(int cc) {
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

    public String insertarLinea(String numero, int cc, String estado) {
        String sal = "";
        String mensaje = "";
        try {
            cllstmt = cnn.prepareCall("{call ps_validarCedulaV2 (?,?,?,?)}");
            cllstmt.setString(1, numero);
            cllstmt.setInt(2, cc);
            cllstmt.setString(3, estado);
            cllstmt.registerOutParameter(4, java.sql.Types.VARCHAR);
            cllstmt.execute();
            sal = cllstmt.getString(4);

            if ("Registrado".equals(sal)) {
                mensaje = "Revisa la base de datos";
            } else {
                mensaje = "El usuario no se encuentra registrado";
            }
        } catch (SQLException sqle) {
            mensaje = "Pilas! Ocurrio la siguiente excepción " + sqle.getMessage();
        }
        return mensaje;
    }
    
//    public String cambiarEstado(int lineanumero){
//         String sal = "";
//         String msj = "";
//        try{
//            cllstmt = cnn.prepareCall("{call sp_estadoEquipoV2(?,?)}");
//            cllstmt.setInt(1, lineanumero);
//            cllstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
//            cllstmt.executeQuery();
//            sal = cllstmt.getString(2);
//            if ("linEstado".equals(sal)) {
//                msj = "Cambio a activa";
//            }else if ("linEstado".equals(sal)) {
//                msj = "Cambio a suspendida";
//            }else{
//                msj = "Jum revisa no se que paso!!";
//            }
//            
//        }catch (SQLException sqle){
//            msj = "ha ocurrido la siguiente excepción"+sqle.getMessage();
//        }
//        return msj;
//    }
    
    public String registrarLinea(String numero, int cc, String estado) {
        int sal = 0;
        String mensaje = "";
        try {
            cllstmt = cnn.prepareCall("{call ps_registrarLineaV10 (?,?,?,?)}");
            cllstmt.setString(1, numero);
            cllstmt.setInt(2, cc);
            cllstmt.setString(3, estado);
            cllstmt.registerOutParameter(4, java.sql.Types.INTEGER);
            cllstmt.execute();
            sal = cllstmt.getInt(4);

            if (sal == 1) {
                mensaje = "Registro exitoso en la base de datos";
            } else if (sal == 2) {
                mensaje = "El usuario tiene más de dos líneas";
            }else {
                mensaje = "No se que paso";
            }
        } catch (SQLException sqle) {
            mensaje = "Pilas! Ocurrio la siguiente excepción " + sqle.getMessage();
        }
        return mensaje;
    }
}
