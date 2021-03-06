/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Conexion.Conection;
import daos.SolicitudDistribuidorDAO;
import dtos.SolicitudDistribuidorDTO;
import java.sql.Connection;
import java.util.LinkedList;
import utilidades.Conectar;

/**
 *
 * @author Mona
 */
public class FacadeSolicitudDistribuidor {
    private Connection cnn = null;
    private SolicitudDistribuidorDAO solicitudDao = null;
    private SolicitudDistribuidorDTO solicitudDto = null;
    
    public FacadeSolicitudDistribuidor(){
//        cnn = Conection.getConnection2();
        solicitudDao = new SolicitudDistribuidorDAO();
        solicitudDto = new SolicitudDistribuidorDTO();
        cnn = Conectar.getInstance();
    }
    
    public String insertarSolicitudDistribuidor(SolicitudDistribuidorDTO solicitud){
        return solicitudDao.insertarSolicitudDistribuidor(solicitud, cnn);
    }
    
    public LinkedList<SolicitudDistribuidorDTO> listarSolicitudesDistribuidor(){
        return solicitudDao.listarSolicitudesDistribuidor(cnn);
    }
    
    public SolicitudDistribuidorDTO byIdRequest(int id){
        return solicitudDao.byIdRequest(id, cnn);
    }
    
    public String eliminarSolicitud(int id){
        return solicitudDao.eliminarSolicitud(id, cnn);
    }
    
    public String modificarSolicitudDistribuidor(SolicitudDistribuidorDTO solicitud){
        return solicitudDao.modificarSolicitudDistribuidor(solicitud, cnn);
    }
}
