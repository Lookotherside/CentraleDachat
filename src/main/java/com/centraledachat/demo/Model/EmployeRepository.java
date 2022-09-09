package com.centraledachat.demo.Model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


  @Repository public interface EmployeRepository extends
  CrudRepository<Employe,Long> { }
 
