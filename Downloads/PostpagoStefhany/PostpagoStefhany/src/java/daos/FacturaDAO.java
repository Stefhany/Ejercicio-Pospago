/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.FacturaDTO;
import dtos.LineaDTO;
import dtos.PersonaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import utilidadesStefhany.Conectar;

/**
 *
 * @author krito
 */
public class FacturaDAO {

    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Connection cnn = null;
    String salida = " ";
    int resultado = 0;
    FacturaDTO fadto = new FacturaDTO();
    ArrayList<FacturaDTO> facturas = new ArrayList<>();

    public FacturaDAO() {
        cnn = Conectar.getInstance();
    }

    public String insertarFactura(FacturaDTO nuevaFactura) {
        try {
            pstmt = cnn.prepareStatement("INSERT INTO factura VALUES (null, ?, ?, ?);");
            pstmt.setString(1, nuevaFactura.getLiNumeroLinea());
            pstmt.setString(2, nuevaFactura.getFacFechaEmision());
            pstmt.setFloat(3, nuevaFactura.getFacValor());
            resultado = pstmt.executeUpdate();

            if (resultado != 0) {
                salida = "El registro de la factura " + resultado + " ha sido exitoso";
            } else {
                salida = "No se pudo realizar el registro";
            }
        } catch (SQLException sqle) {
            salida = "Ha ocurrido la siguiente exepción.. " + sqle.getMessage();

        }
        return salida;
    }

    public String modificarFactura(FacturaDTO modFactura) {
        try {
            pstmt = cnn.prepareStatement("UPDATE factura SET linumerolinea = ?, facfechaemision = ?, facvalor = ? WHERE facnumero = ?;");
            pstmt.setString(1, modFactura.getLiNumeroLinea());
            pstmt.setString(2, modFactura.getFacFechaEmision());
            pstmt.setFloat(3, modFactura.getFacValor());
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

    public ArrayList<FacturaDTO> listarFacturas() {
        try {
            pstmt = cnn.prepareStatement("SELECT facnumero as fac, linumerolinea, facfechaemision, facvalor FROM factura;");
            rs = pstmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    fadto.setFacNumero(rs.getInt("fac"));
                    fadto.setLiNumeroLinea(rs.getString("linumerolinea"));
                    fadto.setFacFechaEmision(rs.getString("facfechaemision"));
                    fadto.setFacValor(rs.getFloat("facvalor"));
                    facturas.add(fadto);
                }
            } else {
                System.out.println("No se encuetran registros de categorias");
            }
        } catch (SQLException sqle) {
            System.out.println("Se ha producido esta excepción.. " + sqle.getMessage());
        }
        return facturas;
    }

    public String eliminarFactura(int id) {
        try {
            pstmt = cnn.prepareStatement("DELETE FROM factura WHERE facnumero = ?;");
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

    public FacturaDTO consultarByIdFactura(int id) {
        try {
            pstmt = cnn.prepareStatement("SELECT facnumero as fac, linumerolinea, facfechaemision, facvalor FROM factura WHERE equserial = ?;");
            rs = pstmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    fadto.setFacNumero(rs.getInt("fac"));
                    fadto.setLiNumeroLinea(rs.getString("linumerolinea"));
                    fadto.setFacFechaEmision(rs.getString("facfechaemision"));
                    fadto.setFacValor(rs.getFloat("facvalor"));
                }
            } else {
                System.out.println("No hay registros... ");
            }
        } catch (SQLException sqle) {
            System.out.println("Ups! Mira lo ocurrido... " + sqle.getMessage());
        }
        return fadto;
    }

    public FacturaDTO consultarByFactura(int id) {
        FacturaDTO fact = null;
        try {
            pstmt = cnn.prepareStatement(" select PERNOMBRE, PERAPELLIDO, PERCEDULA, LINUMEROLINEA from persona "
                    + " inner join linea on "
                    + " persona.PERID = linea.PERID;");
            rs = pstmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    PersonaDTO p = new PersonaDTO();
                    p.setPerNombre(rs.getString("pernombre"));
                    p.setPerApellido(rs.getString("perapellido"));
                    p.setPerCedula(rs.getString("percedula"));
                    LineaDTO lin = new LineaDTO(p);
                    lin.setLinumerolinea(rs.getString("LINUMEROLINEA"));
                    fact = new FacturaDTO(lin);
                }
            } else {
                System.out.println("No hay registros... ");
            }
        } catch (SQLException sqle) {
            System.out.println("Ups! Mira lo ocurrido... " + sqle.getMessage());
        }
        return fact;
    }

    public LinkedList<FacturaDTO> consultarFiltro(String filtro) {
        LinkedList<FacturaDTO> listaFiltro = new LinkedList();
        try {
            String querryFiltro = " select facnumero, f.linumerolinea, facfechaemision, facvalor, percedula, pernombre "
                    + " from factura f inner join linea l on f.linumerolinea = l.linumerolinea "
                    + " inner join persona p on l.perid = p.perid " + filtro;
            pstmt = cnn.prepareStatement(querryFiltro);
            rs = pstmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    PersonaDTO p = new PersonaDTO(rs.getInt("percedula"), rs.getString("pernombre"));
                    LineaDTO lin = new LineaDTO(p);
                    FacturaDTO f = new FacturaDTO(lin);
                    f.setFacNumero(rs.getInt("facnumero"));
                    f.setLiNumeroLinea(rs.getString("linumerolinea"));
                    f.setFacFechaEmision(rs.getString("facfechaemision"));
                    f.setFacValor(rs.getInt("facvalor"));
                    listaFiltro.add(f);
                }
            }
        } catch (SQLException sqle) {
            salida = "Mira lo que ocurrio! " + sqle.getMessage() + " y " + sqle.getSQLState();
        }
        return listaFiltro;
    }

}
