package com.instalacioncamaras.repository;

import com.instalacioncamaras.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad Cliente.
 * Extiende JpaRepository para proporcionar operaciones CRUD automáticamente.
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // No es necesario definir métodos adicionales, JpaRepository proporciona métodos estándar como:
    // save(), findById(), findAll(), deleteById(), etc.
}

