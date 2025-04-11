package com.example.demo.Repositorys;

import com.example.demo.Models.PersonagemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonagemRepository extends JpaRepository<PersonagemModel, Long>{

}
