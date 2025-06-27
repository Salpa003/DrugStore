package dao;

import entity.Product;

import java.util.List;
import java.util.Optional;

public class ProductDao implements Dao<Integer, Product> {
    @Override
    public Optional<Product> get(Integer integer) {
        return Optional.empty();
    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public boolean save(Product product) {
        return false;
    }

    @Override
    public boolean update(Product product) {
        return false;
    }

}
