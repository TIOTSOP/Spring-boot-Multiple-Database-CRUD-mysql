package com.deb.dynamicdatasource.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.deb.dynamicdatasource.entity.Comment;

@Repository
public interface CommentRepo extends CrudRepository<Comment, Long>{
	
	@Query(value = " SELECT u from  Comment u")
	Iterable<Comment> showcommentfull();
	
	@Query(value = " SELECT if(isnull(max(u.idcomment)),0,max(u.idcomment))+1 from  Comment u", nativeQuery = true)
	Long showmaxidcomment();
	
	@Query(value = " SELECT v.idtick  from Comment u left join task v on u.idtask=v.idtask where u.idtask=:idtask limit 1", nativeQuery = true)
	Long showidtickfromtask(@Param("idtask") long idtask);

	//select * from comment where mid(datecom,1,10)='2023-04-11';
	@Query(value = " select * from comment where mid(datecom,1,10)=:ladate", nativeQuery = true)
	Iterable<Comment> showcommentperdate(@Param("ladate") String ladate);

	@Query(value = " select a.* from (comment a inner join task b on a.idtask=b.idtask) inner join ticket c on b.idtick=c.idtick where c.customertick =:lecustomer", nativeQuery = true)
	Iterable<Comment> showcommentpercustomer(@Param("lecustomer") String lecustomer);



	@Query(value = " SELECT u from  Comment u where u.idtask=:idtask")
	Iterable<Comment> showcommentoftask(@Param("idtask") long idtask);
;

/* 	@Query(value = " SELECT u from  Comment u where u.idtick=:id")
	Iterable<Comment> showcommentfromtick(@Param("id") long id ); */
	
	/* @Query(value = " SELECT u from  Comment u where u.statustick<>0 order by u.acteurtick,u.voltick desc")
	Iterable<Comment> showcommentsau();
	
	@Query(value = " SELECT u from  Comment u where u.statustick=1 order by u.customertick,u.voltick,u.acteurtick desc")
	Iterable<Comment> showcommentsactif();
	
	@Query(value = " SELECT u from  Comment u where u.statustick=9 order by u.datupdtick desc,u.customertick,u.voltick,u.acteurtick desc")
	Iterable<Comment> showcommentsclose(); */
	
}
