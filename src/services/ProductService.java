/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Product;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class ProductService extends ArrayList<Product> {

    public ProductService() {
        super();
    }

    public boolean isExist(Product product) {
        return this.stream().anyMatch((item) -> (item.getName().equals(product.getName())));
    }

    public boolean addAProduct(Product product) {
        if (this.isExist(product)) {
            return false;
        }
        this.add(product);
        return true;
    }
}
