package com.NovaBike.service;

import com.NovaBike.domain.Producto;
import com.NovaBike.repository.ProductoRepository;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private FirebaseStorageService firebaseStorageService; // 👈 AQUÍ

    @Transactional(readOnly = true)
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    
    @Transactional
    public void save(Producto producto) {
        productoRepository.save(producto);
    }

    
    @Transactional
    public void save(Producto producto, MultipartFile imageFile) {

        
        producto = productoRepository.save(producto);

        if (imageFile != null && !imageFile.isEmpty()) {
            try {
                String rutaImagen = firebaseStorageService.uploadImage(
                        imageFile,
                        "producto",
                        producto.getId()
                );
                producto.setRutaImagen(rutaImagen);
                productoRepository.save(producto);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
