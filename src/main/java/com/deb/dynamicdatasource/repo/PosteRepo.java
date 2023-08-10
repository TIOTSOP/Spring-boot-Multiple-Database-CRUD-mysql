package com.deb.dynamicdatasource.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.query.Procedure;
import com.deb.dynamicdatasource.entity.Poste;

@Repository
public interface PosteRepo extends CrudRepository<Poste, String>{
	
	@Query(value = " SELECT u from  Poste u")
	Iterable<Poste> showpostefull();
	
	@Query(value = " SELECT max(u.id)+1 from  Poste u")
	Long showmaxidposte();
	
	// @Modifying
	// @Query(value = "update poste u set u.obscpu='A' WHERE u.id ='01' :numpos",nativeQuery=true)
	 // @Query(value = "update poste u set u.obscpu='A' WHERE u.obscpu='V'",nativeQuery=true)
	 // void deverouilleid(@Param("numpos") Long numpos); 
	 
	  @Query(value = "CALL procdeverouilleid(:numpos,:action);", nativeQuery = true)
	 String  deverouilleid(@Param("numpos") String numpos,@Param("action") String action);


	 
}
