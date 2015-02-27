/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.PedidoSobreOfertaDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilidades.Conectar;

/**
 *
 * @author Mona
 */
public class PedidoSobreOfertaDAO {

    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Connection cnn = null;
    CallableStatement cllstmt = null;

    public PedidoSobreOfertaDAO() {
        cnn = Conectar.getInstance();
    }
    
    public String insertarPedidoSobreOferta(int cantidadPedida, int idOferta, String fechaSolicitud){
        int salida = 0;
        String mensaje = " ";
        try {
            String procedureOrder = "{call ps_registrarPedidov1 (?,?,?,?)}";
            cllstmt = cnn.prepareCall(procedureOrder);
            cllstmt.setInt(1, cantidadPedida);
            cllstmt.setInt(2, idOferta);
            cllstmt.setString(3, fechaSolicitud);
            cllstmt.registerOutParameter(4, java.sql.Types.INTEGER);
            cllstmt.execute();
            salida = cllstmt.getInt(4);
            
            if (salida == -1) {
                mensaje = "No ha ocurrido nada en la base de datos";
            }else if (salida == 1) {
                mensaje = "La base de datos obtuvo el registro sactisfactoriamente!";
            }else {
                mensaje = "Something was wrong!!";
            }
        }catch(SQLException sqle){
            mensaje = "Pilas! Ocurrio la siguiente excepción " + sqle.getMessage();
        }
        return mensaje;
    }
}