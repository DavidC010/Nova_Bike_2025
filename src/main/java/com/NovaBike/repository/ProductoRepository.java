package com.NovaBike.repository;

import com.NovaBike.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    // No se necesita método extra por ahora
}
