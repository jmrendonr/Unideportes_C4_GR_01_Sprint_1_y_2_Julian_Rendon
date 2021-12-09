package com.unideportes.services;

import java.util.ArrayList;
import java.util.Optional;

import com.unideportes.models.ProductoModel;
import com.unideportes.repositories.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    public ArrayList<ProductoModel> obtenerProductos(){
        return (ArrayList<ProductoModel>) productoRepository.findAll();
    }

    public ProductoModel guardarProducto(ProductoModel producto){
        return productoRepository.save(producto);
    }

    public boolean eliminarProducto (String id){
        if(productoRepository.existsById(id)){
            return true;
        }else{
            return false;
        }

    }

    public Optional<ProductoModel> obtenerPorId(String id){
        return productoRepository.findById(id);
    }

    public ArrayList<ProductoModel> obtenerPorNombre(String nombre){
        return productoRepository.findByNombre(nombre);
    }

    public ArrayList<ProductoModel> obtenerPorCategoria(String categoria){
        return productoRepository.findByCategoria(categoria);
    }
    
    public ArrayList<ProductoModel> obtenerPorStock(int stock){
        return productoRepository.findByStockLessThanEqual(stock);
    }
    
}
