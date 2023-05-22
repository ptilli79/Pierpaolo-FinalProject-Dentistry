package com.coderscampus.finalproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coderscampus.finalproject.domain.Usuario;


import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

	Usuario findByUsername(String username);
    //Optional<Usuario> findUsuarioByUsername(String username);

    //@Query("select u from User u"
    //	      + " left join fetch u.authorities"
    //	      + " where u.username = :username")
    //	  Usuario findByUsername(String username);
}

