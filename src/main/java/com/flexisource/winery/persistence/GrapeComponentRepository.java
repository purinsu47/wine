package com.flexisource.winery.persistence;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flexisource.winery.model.GrapeComponent;

public interface GrapeComponentRepository extends JpaRepository<GrapeComponent, Long>{
	
	@Query(value = "Select * from GRAPECOMPONENT e where e.wine_id = ?1", nativeQuery = true)
	Set<GrapeComponent> findAllByWineId(Long id);

}
