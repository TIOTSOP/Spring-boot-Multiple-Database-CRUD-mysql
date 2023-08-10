package com.deb.dynamicdatasource.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.deb.dynamicdatasource.entity.SARALData;

@Repository
public interface SARALDataRepo extends CrudRepository<SARALData, Long>{

}
