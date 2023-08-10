package com.deb.dynamicdatasource.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.deb.dynamicdatasource.entity.Projet;

@Repository
public interface ProjetRepo extends CrudRepository<Projet, Long>{
	
	@Query(value = " SELECT u from  Projet u")
	Iterable<Projet> showprojetfull();
	
	@Query(value = " SELECT if(isnull(max(u.idprojet)),0,max(u.idprojet))+1 from  Projet u", nativeQuery = true)
	Long showmaxidprojet();
	
/* 	@Query(value = " SELECT u from  Projet u where u.idtick=:id")
	Iterable<Projet> showprojetfromtick(@Param("id") long id ); */
	
	/* @Query(value = " SELECT u from  Projet u where u.statustick<>0 order by u.acteurtick,u.voltick desc")
	Iterable<Projet> showprojetsau();
	
	@Query(value = " SELECT u from  Projet u where u.statustick=1 order by u.customertick,u.voltick,u.acteurtick desc")
	Iterable<Projet> showprojetsactif();
	
	@Query(value = " SELECT u from  Projet u where u.statustick=9 order by u.datupdtick desc,u.customertick,u.voltick,u.acteurtick desc")
	Iterable<Projet> showprojetsclose(); */
	
}
