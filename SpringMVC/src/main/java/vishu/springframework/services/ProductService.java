package vishu.springframework.services;

import java.util.List;

import vishu.springframework.model.Product;

public interface ProductService {
	List<Product> listAllProducts();
	Product getProductById(Integer id);
	Product saveOrUpdateProduct(Product product);
	void deleteProduct(Integer id);
}
