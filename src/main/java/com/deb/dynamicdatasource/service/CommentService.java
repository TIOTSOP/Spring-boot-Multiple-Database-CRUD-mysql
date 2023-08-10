package com.deb.dynamicdatasource.service;
import com.deb.dynamicdatasource.entity.Comment;

public interface CommentService {

	//modif du 24/05/2022
	Iterable<Comment> showcommentfull();
	
	Iterable<Comment> listAllComments();

    Comment getCommentById(long id);

    Comment saveComment(Comment comment);

    void deleteComment(long id);
	
	//Iterable<Comment> Commentsociete(String lecodsoc);
	long showmaxidcomment();
	
	Long showidtickfromtask(long idtask);

	Iterable<Comment> showcommentoftask(long idtask);

	Iterable<Comment> showcommentperdate(String ladate);
	Iterable<Comment> showcommentpercustomer(String lecustomer);

	/* Iterable<Comment> showcommentfromtick(long id); */

/* 	Iterable<Comment> showcommentsau();
	
	Iterable<Comment> showcommentsactif();
	
	Iterable<Comment> showcommentsclose(); */
}
