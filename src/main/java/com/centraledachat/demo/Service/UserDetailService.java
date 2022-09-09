package com.centraledachat.demo.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
/*
 * import org.springframework.security.core.GrantedAuthority; import
 * org.springframework.security.core.authority.SimpleGrantedAuthority; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.transaction.annotation.Transactional;
 */

/*
 * import com.centraledachat.demo.Model.Employe; import
 * com.centraledachat.demo.Model.EmployeRepository; import
 * com.centraledachat.demo.Model.Role;
 */

/*
 * public class UserDetailService implements UserDetailsService {
 * 
 * @Autowired private EmployeRepository userRepository;
 * 
 * @Override
 * 
 * @Transactional(readOnly = true) public UserDetails loadUserByUsername(String
 * Nom) { Employe user = userRepository.findByUsername(Nom); if (user == null)
 * throw new UsernameNotFoundException(Nom);
 * 
 * Set<GrantedAuthority> grantedAuthorities = new HashSet<>(); for (Role role :
 * user.getRoles()){ grantedAuthorities.add(new
 * SimpleGrantedAuthority(role.getName())); }
 * 
 * return new
 * org.springframework.security.core.userdetails.User(user.getNom(),user.
 * getMot_de_Passe(),grantedAuthorities); } }
 */