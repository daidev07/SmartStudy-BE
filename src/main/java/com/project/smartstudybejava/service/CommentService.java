package com.project.smartstudybejava.service;

import com.project.smartstudybejava.dto.req.CommentRequest;
import com.project.smartstudybejava.dto.res.CommentResponse;

import java.util.List;

public interface CommentService {
    CommentResponse postToNewsfeed(CommentRequest commentRequest);
    void deleteComment(Long commentId);
    List<CommentResponse> getAllCommentsByNewsFeedId(Long newsFeedId);
    boolean isCommentByUser(Long commentId, Long userId);
}
