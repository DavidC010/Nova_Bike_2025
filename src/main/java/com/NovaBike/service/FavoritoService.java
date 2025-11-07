package com.NovaBike.service;

import com.NovaBike.domain.Producto;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Service;

@Service

public class FavoritoService {
 
    private final List<Integer> favoritos = new ArrayList<>();
 
    public void toggleFavorito(Integer idProducto) {

        if (favoritos.contains(idProducto)) {

            favoritos.remove(idProducto);

        } else {

            favoritos.add(idProducto);

        }

    }
 
    public boolean esFavorito(Integer idProducto) {

        return favoritos.contains(idProducto);

    }
 
    public List<Integer> getFavoritos() {

        return favoritos;

    }

}