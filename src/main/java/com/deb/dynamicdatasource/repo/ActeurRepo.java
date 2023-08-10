package com.deb.dynamicdatasource.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.deb.dynamicdatasource.entity.Acteur;

@Repository
public interface ActeurRepo extends CrudRepository<Acteur, Long>{
	
	@Query(value = " SELECT u from  Acteur u")
	Iterable<Acteur> showacteurfull();
	
	@Query(value = " SELECT max(u.id)+1 from  Acteur u")
	Long showmaxidacteur();
	
	/* @Query(value = " SELECT u from  Acteur u where u.statustick<>0 order by u.acteurtick,u.voltick desc")
	Iterable<Acteur> showacteursau();
	
	@Query(value = " SELECT u from  Acteur u where u.statustick=1 order by u.customertick,u.voltick,u.acteurtick desc")
	Iterable<Acteur> showacteursactif();
	
	@Query(value = " SELECT u from  Acteur u where u.statustick=9 order by u.datupdtick desc,u.customertick,u.voltick,u.acteurtick desc")
	Iterable<Acteur> showacteursclose();

	@Query(value = " SELECT u from  Acteur u where u.customertick=:nomcustomer order by u.voltick,u.acteurtick desc")
	Iterable<Acteur> showacteursbycustomer(@Param("nomcustomer") Long nomcustomer); */
}
