package com.coderscampus.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.coderscampus.finalproject.domain.Usuario;
import com.coderscampus.finalproject.repository.UsuarioRepository;
import com.coderscampus.finalproject.security.CustomSecurityUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  
  @Autowired
  private UsuarioRepository userRepo;
  
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    
    Usuario user = userRepo.findByUsername(username);
    
    if (user == null)
      throw new UsernameNotFoundException("Username and or password was incorrect.");
    
    return new CustomSecurityUser(user);
  }
  
}
