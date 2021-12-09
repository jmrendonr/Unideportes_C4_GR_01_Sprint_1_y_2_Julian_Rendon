package com.unideportes.repositories;

import java.util.ArrayList;

import com.unideportes.models.ProductoModel;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoRepository extends MongoRepository<ProductoModel, String>{
    
    ArrayList<ProductoModel>findByNombre(String nombre);

    ArrayList<ProductoModel>findByCategoria(String categoria);

    ArrayList<ProductoModel>findByStockLessThanEqual(int stock);
}
