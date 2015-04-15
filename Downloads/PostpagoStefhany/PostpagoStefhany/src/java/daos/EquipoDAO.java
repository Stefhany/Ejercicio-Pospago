/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;


import dtos.EquipoDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utilidadesStefhany.Conectar;

/**
 *
 * @author krito
 */
public class EquipoDAO {
    CallableStatement cllstmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Connection cnn = null;
    String salida = " ";
    int resultado = 0;
    EquipoDTO edto = new EquipoDTO();
    ArrayList<EquipoDTO> equipos = new ArrayList<>();

    public EquipoDAO() {
        cnn = Conectar.getInstance();
    }

    public String insertarEquipo(EquipoDTO nuevoEquipo) {
        try {
            pstmt = cnn.prepareStatement("INSERT INTO equipo VALUES (?, ?, ?, ?, ?);");
            pstmt.setInt(1, nuevoEquipo.getEquSerial());
            pstmt.setString(2, nuevoEquipo.getLiNumeroLinea());
            pstmt.setString(3, nuevoEquipo.getEquMarca());
            pstmt.setString(4, nuevoEquipo.getEquDescripcion());
            pstmt.setString(5, nuevoEquipo.getEquEstado());
            resultado = pstmt.executeUpdate();

            if (resultado != 0) {
                salida = "El registro del equipo " + resultado + " ha sido exitoso";
            } else {
                salida = "No se pudo realizar el registro";
            }
        } catch (SQLException sqle) {
            salida = "Ha ocurrido la siguiente exepción.. " + sqle.getMessage();

        }
        return salida;
    }

    public String modificarEquipo(EquipoDTO modEquipo) {
        try {
            pstmt = cnn.prepareStatement("UPDATE equipo SET linumerolinea = ?, equmarca = ?, equdescripcion = ?, equestado = ? WHERE equserial = ?;");
            pstmt.setString(1, modEquipo.getLiNumeroLinea());
            pstmt.setString(2, modEquipo.getEquMarca());
            pstmt.setString(3, modEquipo.getEquDescripcion());
            pstmt.setString(4, modEquipo.getEquEstado());
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

    public ArrayList<EquipoDTO> listarEquipos() {
        ArrayList<EquipoDTO> listaEquipos = new ArrayList();
        try {
            pstmt = cnn.prepareStatement("SELECT equserial, linumerolinea, equmarca, equdescripcion, equestado FROM equipo;");
            rs = pstmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    EquipoDTO equipo = new EquipoDTO();
                    equipo.setEquSerial(rs.getInt("equserial"));
                    equipo.setLiNumeroLinea(rs.getString("linumerolinea"));
                    equipo.setEquMarca(rs.getString("equmarca"));
                    equipo.setEquDescripcion(rs.getString("equdescripcion"));
                    equipo.setEquEstado(rs.getString("equestado"));
                    listaEquipos.add(equipo);
                }
            } else {
                System.out.println("No se encuetran registros de categorias");
            }
        } catch (SQLException sqle) {
            System.out.println("Se ha producido esta excepción.. " + sqle.getMessage());
        }
        return listaEquipos;
    }

    public String eliminarEquipo(int id) {
        try {
            pstmt = cnn.prepareStatement("DELETE FROM equipo WHERE equserial = ?;");
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

    public EquipoDTO consultarById(int id) {
        try {
            pstmt = cnn.prepareStatement("SELECT equserial, linumerolinea, equmarca, equdescripcion, equestado FROM equipo WHERE equserial = ?;");
            rs = pstmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    edto.setEquSerial(rs.getInt("equserial"));
                    edto.setLiNumeroLinea(rs.getString("linumerolinea"));
                    edto.setEquMarca(rs.getString("equmarca"));
                    edto.setEquDescripcion(rs.getString("equdescripcion"));
                    edto.setEquEstado(rs.getString("equestado"));
                }
            } else {
                System.out.println("No hay registros... ");
            }
        } catch (SQLException sqle) {
            System.out.println("Ups! Mira lo ocurrido... " + sqle.getMessage());
        }
        return edto;
    }
    
//    public String cambiarEstado(int serialEquipo){
//        try{
//            cllstmt = cnn.prepareCall("{call sp_cambiarEstado (?,?)}");
//            cllstmt.setInt(1, serialEquipo);
//            cllstmt.registerOutParameter(2, java.sql.Types.INTEGER);
//            cllstmt.executeQuery();
//            resultado = cllstmt.getInt(2);
//            if (resultado == -1) {
//                salida = "No ha pasado nada";
//            }else if (resultado == 1) {
//                salida = "Sucedio algo en la base de datos";
//            }else{
//                salida = "Jum revisa!!";
//            }
//            
//        }catch (SQLException sqle){
//            salida = "ha ocurrido la siguiente excepción"+sqle.getMessage();
//        }
//        return salida;
//    }
    
    public String cambiarEstado(int serialEquipo){
        try{
            cllstmt = cnn.prepareCall("{call sp_estadoEquipoV2(?,?)}");
            cllstmt.setInt(1, serialEquipo);
            cllstmt.registerOutParameter(2, java.sql.Types.INTEGER);
            cllstmt.executeQuery();
            resultado = cllstmt.getInt(2);
            if (resultado == -1) {
                salida = "No ha pasado nada";
            }else if (resultado == 1) {
                salida = "Sucedio algo en la base de datos";
            }else{
                salida = "Jum revisa!!";
            }
            
        }catch (SQLException sqle){
            salida = "ha ocurrido la siguiente excepción"+sqle.getMessage();
        }
        return salida;
    }
}
