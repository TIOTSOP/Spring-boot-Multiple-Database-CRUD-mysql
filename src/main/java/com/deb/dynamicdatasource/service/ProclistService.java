package com.deb.dynamicdatasource.service;
import com.deb.dynamicdatasource.entity.Proclist;
import java.util.List;
public interface ProclistService {

	//modif du 24/05/2022
	Iterable<Proclist> showprocesslistfull();
	
	Iterable<Proclist> showprocesslistrep();
	
	Iterable<Proclist> showprocesslistrepcli();

	List <String>  showlastsav();
}
