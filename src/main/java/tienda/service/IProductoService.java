package tienda.service;

import java.util.List;

import tienda.models.Producto;

public interface IProductoService {
	public List<Producto> listarProducto();
	public Producto buscarProducto(Long id);
	public void eliminarProducto(Long id);
	public Producto agregar(Producto producto);

}
