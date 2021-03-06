/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Conexion.Conection;
import daos.ProductoDAO;
import dtos.ProductoDTO;
import java.sql.Connection;
import java.util.List;
import utilidades.Conectar;
import utilidades.MyException;

/**
 *
 * @author Mona
 */
public class FacadeProductos {
    private Connection cnn = null;
    private ProductoDTO productDto = null;
    private ProductoDAO productDao = null;
    
    public FacadeProductos(){
//        cnn = Conection.getConnection2();
        productDto = new ProductoDTO();
        productDao = new ProductoDAO();
        cnn = Conectar.getInstance();
    }
    
    public String registrarProducto(ProductoDTO productDto){
        return productDao.insertarProducto(productDto, cnn);
    }
    
    public String actualizarProducto(ProductoDTO productDto){
        return productDao.modificarProducto(productDto, cnn);
    }
    
    public String eliminarProducto(int id){
        return productDao.eliminarProducto(id, cnn);
    }
    
    public List<ProductoDTO> listarAllProducts() throws MyException{
        return productDao.listarAllProductos(cnn);
    }
    
    public ProductoDTO consultarByIdProduct(int id) throws MyException{
        return productDao.consultarByIdProduct(id, cnn);
    }
}
