package tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tienda.models.Producto;
import tienda.service.IProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/listar")
	public List<Producto> listar(){
		return productoService.listarProducto();
	}
	
	@GetMapping("ver/{id}")
	public Producto detalle(@PathVariable Long id) {
		return productoService.buscarProducto(id);
	}
	
	@DeleteMapping("delete/{id}")
	public void eliminar(@PathVariable Long id) {
		productoService.eliminarProducto(id);
	}
	
	@PostMapping("/add")
	public Producto add(@RequestBody Producto producto) {
		return productoService.agregar(producto);
	}
	
	@PutMapping("/update")
	public Producto update(@RequestBody Producto producto, @PathVariable Long id) {
		Producto productoUpdate = null;
		Producto productoActual = null;
		
		productoActual = productoService.buscarProducto(id);
		productoActual.setNombre(producto.getNombre());
		productoActual.setPrecio(producto.getPrecio());
		return productoUpdate=productoService.agregar(productoActual);
		
	}
	
	
	

}
