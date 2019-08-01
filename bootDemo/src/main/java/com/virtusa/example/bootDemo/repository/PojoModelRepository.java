package com.virtusa.example.bootDemo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.example.bootDemo.model.PojoModel;
@Repository
public interface PojoModelRepository extends JpaRepository<PojoModel, Long> {

}
