package com.example.petfinder.controller.api;

import com.example.petfinder.controller.request.AddCommentRequest;
import com.example.petfinder.dto.article.CommentDto;
import com.example.petfinder.service.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("comment/{id}")
    public CommentDto findById(@PathVariable Long id) {
        return commentService.findCommentById(id);
    }

    @PostMapping("comment")
    public CommentDto addComment(@RequestBody AddCommentRequest addCommentRequest) {
        return commentService.addComment(
                addCommentRequest.getUserId(),
                addCommentRequest.getArticleId(),
                addCommentRequest.getDate(),
                addCommentRequest.getContent()
        );
    }
}
