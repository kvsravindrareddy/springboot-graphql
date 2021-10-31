package com.veera.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veera.entity.OrgEntity;

public interface OrgRepo extends JpaRepository<OrgEntity, Long>{
	
}
