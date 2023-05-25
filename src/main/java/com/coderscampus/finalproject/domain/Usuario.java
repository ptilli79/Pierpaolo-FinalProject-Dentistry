package com.coderscampus.finalproject.domain;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String password;
    @Enumerated(EnumType.STRING)
    
    private RolUsuario usuarioRole;
    
    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="user")
    private Set<Authorities> authorities = new HashSet<>();
    
  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RolUsuario getUsuarioRole() {
        return usuarioRole;
    }

    public void setUsuarioRole(RolUsuario usuarioRole) {
        this.usuarioRole = usuarioRole;
    }
    
    public Set<Authorities> getAuthorities() {
      return authorities;
    }
    public void setAuthorities(Set<Authorities> authorities) {
      this.authorities = authorities;
    }
}