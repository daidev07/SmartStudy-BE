package com.project.smartstudybejava.service;

import com.project.smartstudybejava.dto.req.CommentRequest;
import com.project.smartstudybejava.dto.res.CommentResponse;

public interface CommentService {
    CommentResponse postToNewsfeed(CommentRequest commentRequest);
    void deleteComment(Long commentId);
    CommentResponse getAllCommentsByNewsFeedId(Long newsFeedId);
}
