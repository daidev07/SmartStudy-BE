package com.project.smartstudybejava.controller;

import com.project.smartstudybejava.dto.req.CommentRequest;
import com.project.smartstudybejava.dto.res.CommentResponse;
import com.project.smartstudybejava.service.CommentService;
import com.project.smartstudybejava.util.ErrorCode;
import com.project.smartstudybejava.util.ResponseData;
import com.project.smartstudybejava.util.SuccessCode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/comment")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CommentController {
    CommentService commentService;

    @PostMapping("/post-to-newsfeed")
    public ResponseData<CommentResponse> postToNewsfeed(@RequestBody CommentRequest commentRequest) {
        try {
            CommentResponse postedComment = commentService.postToNewsfeed(commentRequest);
            return ResponseData.<CommentResponse>builder()
                    .code(SuccessCode.POST_COMMENT_SUCCESSFUL.getCode())
                    .message(SuccessCode.POST_COMMENT_SUCCESSFUL.getMessage())
                    .data(postedComment)
                    .build();
        } catch (Exception e) {
            return ResponseData.<CommentResponse>builder()
                    .code(ErrorCode.POST_COMMENT_FAILED.getCode())
                    .message(ErrorCode.POST_COMMENT_FAILED.getMessage())
                    .build();
        }
    }
    @GetMapping("/get-all-by-newsfeedId/{newsFeedId}")
    public ResponseData<List<CommentResponse>> getAllCommentsByNewsFeedId(@PathVariable Long newsFeedId) {
        try {
            List<CommentResponse> comments = commentService.getAllCommentsByNewsFeedId(newsFeedId);
            return ResponseData.<List<CommentResponse>>builder()
                    .code(SuccessCode.GET_COMMENT_SUCCESSFUL.getCode())
                    .message(SuccessCode.GET_COMMENT_SUCCESSFUL.getMessage())
                    .data(comments)
                    .build();
        } catch (Exception e) {
            return ResponseData.<List<CommentResponse>>builder()
                    .code(ErrorCode.GET_COMMENT_FAILED.getCode())
                    .message(ErrorCode.GET_COMMENT_FAILED.getMessage())
                    .build();
        }
    }
    @DeleteMapping("/{commentId}")
    public ResponseData<CommentResponse> deleteComment(@PathVariable Long commentId) {
        try {
            commentService.deleteComment(commentId);
            return ResponseData.<CommentResponse>builder()
                    .code(SuccessCode.DELETE_COMMENT_SUCCESSFUL.getCode())
                    .message(SuccessCode.DELETE_COMMENT_SUCCESSFUL.getMessage())
                    .build();
        } catch (Exception e) {
            return ResponseData.<CommentResponse>builder()
                    .code(ErrorCode.DELETE_COMMENT_FAILED.getCode())
                    .message(ErrorCode.DELETE_COMMENT_FAILED.getMessage())
                    .build();
        }
    }
    @GetMapping("/is-comment-by-user")
    public ResponseData<Boolean> isCommentByUser(@RequestParam Long commentId, @RequestParam Long userId) {
        boolean isCommentByUser = commentService.isCommentByUser(commentId, userId);
        return ResponseData.<Boolean>builder()
                .code(SuccessCode.IS_COMMENT_BY_USER.getCode())
                .message(SuccessCode.IS_COMMENT_BY_USER.getMessage())
                .data(isCommentByUser)
                .build();
    }
}
