package com.deb.dynamicdatasource.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.deb.dynamicdatasource.entity.AryabhataData;

@Repository
public interface AryabhataDataRepo extends CrudRepository<AryabhataData, Long>{

}
