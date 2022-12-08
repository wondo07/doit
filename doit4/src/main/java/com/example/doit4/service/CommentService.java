package com.example.doit4.service;

import com.example.doit4.dto.CommentDto;
import com.example.doit4.dto.UpdateComment;
import com.example.doit4.entity.comment;
import com.example.doit4.entity.entity;
import com.example.doit4.mapper.CommentMapper;
import com.example.doit4.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentMapper commentMapper;
    private final CommentRepository commentRepository;

    public CommentService(CommentMapper commentMapper, CommentRepository commentRepository) {
        this.commentMapper = commentMapper;
        this.commentRepository = commentRepository;
    }

    public comment input(CommentDto commentDto) {
       comment Comment  = commentMapper.PostComment(commentDto);
       if(Comment != null){
           commentRepository.save(Comment);
       }
       return Comment;

    }


    public comment patch1(Long id, UpdateComment updateComment) {
        comment excomment = commentMapper.updateComment(updateComment);
        comment newcomment = commentRepository.findById(id).orElse(null);
        if (id!= newcomment.getId()){
            return null;
        }
        excomment.patch(newcomment);
        comment saved = commentRepository.save(excomment);
        return saved;
    }

    public List<CommentDto> get(Long articleId) {
       List<comment> Comment = commentRepository.findByAriticleId(articleId);
        System.out.println("Comment : "+Comment);
       List<CommentDto> dtos=new ArrayList<CommentDto>();
       List<CommentDto> commentDto=Comment.stream()
               .map(c->CommentDto.createCommentdto(c))
               .collect(Collectors.toList());
        System.out.println("commentDto: "+commentDto);
//        for(int i=0;i<Comment.size();i++){
//            comment c = Comment.get(i);
//            CommentDto dto = CommentDto.createdComment(c);
//            dtos.add(dto);
//        }
       return commentDto;
    }


    public List<comment> getlist() {
        List<comment> commentList=commentRepository.findAll();
        return commentList;

    }

    public comment delete(Long id) {
        comment Comment = commentRepository.findById(id).orElse(null);
        if (Comment != null){
            commentRepository.delete(Comment);
        }
        return Comment;
    }
}
