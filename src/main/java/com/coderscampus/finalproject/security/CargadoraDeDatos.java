package com.coderscampus.finalproject.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.coderscampus.finalproject.domain.RolUsuario;
import com.coderscampus.finalproject.domain.Usuario;
import com.coderscampus.finalproject.repository.UsuarioRepository;

@Component
public class CargadoraDeDatos implements ApplicationRunner {
	
    @Autowired
    UsuarioRepository loadUsuarioRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
        String pass="kiwi";
        String passHash=passwordEncoder.encode(pass);
        Usuario usuario= new Usuario();
        usuario.setNombre("Valen");
        usuario.setUsername("valen@gmail.com");
        usuario.setPassword(passHash);
        usuario.setUsuarioRole(RolUsuario.ROLE_USER);
        loadUsuarioRepository.save(usuario);

        Usuario admin= new Usuario();
        admin.setNombre("Fiu");
        admin.setUsername("fiu@gmail.com");
        admin.setPassword(passHash);
        admin.setUsuarioRole(RolUsuario.ROLE_ADMIN);
        loadUsuarioRepository.save(admin);
    }
}
