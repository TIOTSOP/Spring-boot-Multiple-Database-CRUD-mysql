package com.deb.dynamicdatasource.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.deb.dynamicdatasource.entity.Proclist;
import java.util.List;

@Repository
public interface ProclistRepo extends CrudRepository<Proclist, Long>{
	
	@Query(value = " SELECT u from  Proclist u")
	Iterable<Proclist> showprocesslistfull();
	
	@Query(value = " SELECT u from  Proclist u where u.proccommand like 'binlog dump'")
	Iterable<Proclist> showprocesslistrep();
	
	@Query(value = " SELECT u from  Proclist u where u.procuser like 'system user'")
	Iterable<Proclist> showprocesslistrepcli();

	@Query(value = "select concat(date,' ',heure,' ',util,' ',machine) from sauvegarde order by date desc limit 15", nativeQuery = true)
	List <String>  showlastsav();


}
