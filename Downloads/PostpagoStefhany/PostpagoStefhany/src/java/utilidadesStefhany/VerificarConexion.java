    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidadesStefhany;

import daos.AuditoriaDAO;
import daos.EquipoDAO;
import daos.FacturaDAO;
import daos.LineaDAO;
import daos.PersonaDAO;
import dtos.AuditoriaDTO;
import dtos.EquipoDTO;
import dtos.FacturaDTO;
import dtos.LineaDTO;
import dtos.PersonaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author COOPAVA
 */
public class VerificarConexion {

    public static void main(String[] args) {

        Connection cnn = Conectar.getInstance();
        PreparedStatement pstmt;
        ResultSet rs;

//        try {
//            pstmt = cnn.prepareStatement("SELECT perid, pernombre, perapellido FROM persona");
//            rs = pstmt.executeQuery();
//            System.out.println("ID   " + "Nombre   " + "Apellido  " + "Telefono  " + "FechaNaci            " + "Cedula  ");
//            while (rs.next()) {
//                System.out.println(rs.getInt("perid") + "  " + rs.getString("pernombre") + "  " + rs.getString("perapellido"));
//            }
//
//        } catch (SQLException ex) {
//            System.out.println("Error de MYSQL" + ex);
//
//        } catch (Exception e) {
//            System.out.println("Error en la ejecución e:"
//                    + " " + e.getMessage());
//        } finally {
//
//        }
//       
//        try {
//            pstmt = cnn.prepareStatement("SELECT facnumero as fac, linumerolinea, facfechaemision, facvalor FROM factura;");
//            rs = pstmt.executeQuery();
//            System.out.println("FAC         "+ " Número de línea    ");
//            if (rs != null) {
//                while (rs.next()) {
//                    System.out.println(rs.getInt("fac") + " " + rs.getString("linumerolinea"));
//                    
//                }
//            } else {
//                System.out.println("No se encuetran registros de categorias");
//            }
//        } catch (SQLException sqle) {
//            System.out.println("Se ha producido esta excepción.. " + sqle.getMessage());
//        }catch (Exception e) {
//            System.out.println("Error en la ejecución e:"
//                    + " " + e.getMessage());
//        } finally {
//
//        }
        
//        EquipoDAO edao = new EquipoDAO();
//        System.out.println(edao.cambiarEstado(3466));
        
//        PersonaDAO pdao = new PersonaDAO();
       
//        pdto.setPerId(1013);
//        pdto.setPerNombre("Janneth");
//        pdto.setPerApellido("Rincón Duarte");
//        pdto.setPerTelefonoFijo("5453451");
//        pdto.setPerFechaNacimiento("31-octubre-1981");
//        pdto.setPerCedula("78908234");
//        pdto.setUser("Nata");
//        pdto.setClave("nata123");
//        System.out.println(pdao.insertarPersona(pdto));
        
//        LineaDAO lindao = new LineaDAO();
//        LineaDTO lin = new LineaDTO(pdto);
//        lin.setLinumerolinea("3112346547");
//        lin.setPerid(1016);
//        lin.setLinestado("ACTIVA");
//        System.out.println(lindao.insertarLinea(lin));
//       
//       EquipoDAO edao = new EquipoDAO();
//        EquipoDTO edto = new EquipoDTO();
//        edto.setEquSerial(3434);
//        edto.setLiNumeroLinea("1111");
//        edto.setEquMarca("LG");
//        edto.setEquDescripcion("Acer");
//        edto.setEquEstado("Reportado");
//        System.out.println(edao.insertarEquipo(edto));
        
//        
//        PersonaDAO sol = new PersonaDAO();
//        ArrayList<PersonaDTO> listaSalida = new ArrayList();
//        listaSalida = (ArrayList<PersonaDTO>) sol.listarPersonas();
//        System.out.println("Id \t Nombre ");
//        for (PersonaDTO pro : listaSalida) {
//            System.out.println(pro.getPerApellido()+ " \t" + pro.getPerCedula()+ pro.getPerFechaNacimiento());
//        }
        
//        LineaDAO edao = new LineaDAO();
//        System.out.println(edao.insertarLinea("900234",1005,"ACTIVA"));
//        LineaDAO lin = new LineaDAO();
//        System.out.println(lin.consultarById(3453534));
        
//        AuditoriaDAO sol = new AuditoriaDAO();
//        LinkedList<AuditoriaDTO> listaSalida = new LinkedList();
//        listaSalida = (LinkedList<AuditoriaDTO>) sol.consultar();
//        for (AuditoriaDTO a : listaSalida) {
//            System.out.println("nvjdsnv");
//            System.out.println(a.getAccion());
//        }
        
        LineaDAO l = new LineaDAO();
        System.out.println(l.registrarLinea("1111", 1012, "Activa"));
    }

}
