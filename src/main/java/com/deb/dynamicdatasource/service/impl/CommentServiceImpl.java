package com.deb.dynamicdatasource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deb.dynamicdatasource.entity.Comment;
import com.deb.dynamicdatasource.repo.CommentRepo;
import com.deb.dynamicdatasource.service.CommentService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CommentServiceImpl implements CommentService{
	
	
	@Autowired
	private CommentRepo commentRepo;
	
	//modif du 24/05/2022
	@Override
    public Iterable<Comment> showcommentfull() {
        return commentRepo.showcommentfull();
    }
	
	
/* 	@Override
    public Iterable<Comment> showcommentfromtick(long id) {
        return commentRepo.showcommentfromtick(id);
    } */
	

    @Autowired
    public void setCommentRepo(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    @Override
    public Iterable<Comment> listAllComments() {
        return commentRepo.findAll();
    }

    @Override
    public Comment getCommentById(long id) {
        Comment comment=commentRepo.findById(id).orElse(null);
		return comment;
    }

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepo.save(comment);
    }

    @Override
    public void deleteComment(long id) {
        commentRepo.deleteById(id);
    }
	
// 
	 @Override
     public long showmaxidcomment() {
      return  commentRepo.showmaxidcomment();
    }
	
	
	
    @Override
    public Long showidtickfromtask(long idtask) {
     return  commentRepo.showidtickfromtask(idtask) ;
   }

   @Override
   public  Iterable<Comment> showcommentoftask(long idtask) {
    return  commentRepo.showcommentoftask(idtask) ;
  }

  @Override
  public  Iterable<Comment> showcommentperdate(String ladate) {
   return  commentRepo.showcommentperdate( ladate) ;
 }


 @Override
 public  Iterable<Comment> showcommentpercustomer(String lecustomer) {
  return  commentRepo.showcommentpercustomer( lecustomer) ;
}


 // Iterable<Comment> showcommentperdate(String ladate);

	/* @Override
    public Iterable<Comment> showcommentsau() {
        return commentRepo.showcommentsau();
    }
	
	@Override
    public Iterable<Comment> showcommentsactif() {
        return commentRepo.showcommentsactif();
    }
	
	@Override
    public Iterable<Comment> showcommentsclose() {
        return commentRepo.showcommentsclose();
    } */
	// @Override
    // public Iterable<Comment> Commentsociete(String lecodsoc) {
        // return commentRepo.Commentsociete(lecodsoc);
    // }
	
}
