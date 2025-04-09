package com.example.demo.Repositorys;

import com.example.demo.Models.ItemMagicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemMagicoRepository extends JpaRepository<ItemMagicoModel, Long>{

}
