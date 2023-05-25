package com.coderscampus.finalproject.domain;


import jakarta.persistence.*;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Authorities implements GrantedAuthority {
  private static final long serialVersionUID = -8123526131047887755L;
  
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  
  @Column
  private String authority;
  
  @ManyToOne
  private Usuario user;
  

  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getAuthority() {
    return authority;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
  }

  // one-to-one (1-1), one-to-many (1-*), many-to-many (*-*)
  public Usuario getUser() {
    return user;
  }

  public void setUser(Usuario user) {
    this.user = user;
  }
}
