package com.unideportes.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.unideportes.models.ProductoModel;
import com.unideportes.services.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
@RequestMapping("/producto")
public class ProductoController {
    
    @Autowired
    ProductoService productoService;

    @GetMapping()
    public ArrayList<ProductoModel>obtenerListaProductos(){
        return productoService.obtenerProductos();
    }

    @PostMapping()
    public ProductoModel guardarProductoNuevo(@RequestBody ProductoModel producto){
        return productoService.guardarProducto(producto);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarProducto(@PathVariable("id") String id){
        if(productoService.eliminarProducto(id)){
            return "Se ha eliminado el producto con Id: " +id;
        }else{
            return "No existe el producto con Id: "+id;
        }
    }

    @GetMapping(path = "/{id}")
    public Optional<ProductoModel> obtenerProductoPorId(@PathVariable("id") String id){
        return productoService.obtenerPorId(id);
    }

    @GetMapping(path = "/nombre/{nombre}")
    public ArrayList<ProductoModel> obtenerProductoPorNombre(@PathVariable("nombre") String nombre){
        return productoService.obtenerPorNombre(nombre);
    }

    @GetMapping(path = "/categoria/{categoria}")
    public ArrayList<ProductoModel> obtenerProductoPorcategoria(@PathVariable("categoria") String categoria){
        return productoService.obtenerPorCategoria(categoria);
    }

    @GetMapping(path = "/stock/{stock}")
    public ArrayList<ProductoModel> obtenerPorstock(@PathVariable("stock") int stock){
        return productoService.obtenerPorStock(stock);
    }

}
