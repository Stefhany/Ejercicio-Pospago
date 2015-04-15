/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.AuditoriaDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import utilidadesStefhany.Conectar;

/**
 *
 * @author Mona
 */
public class AuditoriaDAO {
    CallableStatement cllstmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Connection cnn = null;
    
    public AuditoriaDAO() {
        cnn = Conectar.getInstance();
    }
    public LinkedList<AuditoriaDTO> consultar() {
        AuditoriaDTO a = null;
        LinkedList audi = new LinkedList();
        try {
            pstmt = cnn.prepareStatement("SELECT * FROM auditoria;");
            rs = pstmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    a = new AuditoriaDTO();
                    a.setUsuario(rs.getString("usuario"));
                    a.setNumLinea(rs.getString("numLinea"));
                    a.setAccion(rs.getString("accion"));
                    a.setFecha(rs.getString("fecha"));
                    audi.add(a);
                }
            } else {
                System.out.println("No hay registros... ");
            }
        } catch (SQLException sqle) {
            System.out.println("Ups! Mira lo ocurrido... " + sqle.getMessage());
        }
        return audi;
    }
}
