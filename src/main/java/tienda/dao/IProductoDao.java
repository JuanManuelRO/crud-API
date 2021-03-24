package tienda.dao;

import org.springframework.data.repository.CrudRepository;

import tienda.models.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long>{

}
