package codegym.service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> map = new HashMap<>();
    static {
        map.put(1, new Product(1, "iPhone", "iPhoneX", 10000000));
        map.put(2, new Product(2, "Nokia", "Nokia 8", 17000000));
        map.put(3, new Product(3, "Oppo", "Find 9", 12500000));
        map.put(4, new Product(4, "SamSung", "Note 9", 26000000));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public Product findById(int id) {
        return map.get(id);
    }

    @Override
    public void save(Product product) {
        map.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        map.put(id, product);
    }

    @Override
    public void remove(int id) {
        map.remove(id);
    }
}
