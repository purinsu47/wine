package com.flexisource.winery.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flexisource.winery.model.Wine;


@Repository
public interface WineRepository extends JpaRepository<Wine, Long>{

}
