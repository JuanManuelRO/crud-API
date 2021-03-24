package tienda.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tienda.dao.IProductoDao;
import tienda.models.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired //INYECCION DE DEPENDENCIAS
	private IProductoDao productoDao;
	
	
	
	@Override
	public List<Producto> listarProducto() {
		// TODO Auto-generated method stub
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	@Transactional 
	public Producto buscarProducto(Long id) {
		// TODO Auto-generated method stub
		return productoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional 
	public void eliminarProducto(Long id) {
		// TODO Auto-generated method stub
		productoDao.deleteById(id);
	}

	@Override
	@Transactional 
	public Producto agregar(Producto producto) {
		// TODO Auto-generated method stub
		return productoDao.save(producto);
	}

}
