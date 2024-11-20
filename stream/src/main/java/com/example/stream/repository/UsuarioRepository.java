package com.example.stream.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.stream.model.Usuario;
public interface UsuarioRepository extends JpaRepository<Usuario, Long> { }
