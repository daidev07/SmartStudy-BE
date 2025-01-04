package com.project.smartstudybejava.service.impl;

import com.project.smartstudybejava.dto.req.CommentRequest;
import com.project.smartstudybejava.dto.res.CommentResponse;
import com.project.smartstudybejava.dto.res.UserResDTO;
import com.project.smartstudybejava.entity.Comment;
import com.project.smartstudybejava.exception.AppException;
import com.project.smartstudybejava.repository.CommentRepository;
import com.project.smartstudybejava.repository.NewsFeedRepository;
import com.project.smartstudybejava.repository.UserRepository;
import com.project.smartstudybejava.service.CommentService;
import com.project.smartstudybejava.util.ErrorCode;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CommentServiceImpl implements CommentService {

    NewsFeedRepository newsFeedRepository;
    CommentRepository commentRepository;
    UserRepository userRepository;

    @Override
    public CommentResponse postToNewsfeed(CommentRequest commentRequest) {
        Comment comment = new Comment();
        comment.setContent(commentRequest.getContent());
        comment.setNewsFeed(newsFeedRepository.findById(commentRequest.getNewsfeedId())
                .orElseThrow(() -> new AppException(ErrorCode.NEWSFEED_NOT_FOUND.getCode(),
                        ErrorCode.NEWSFEED_NOT_FOUND.getMessage())));
        comment.setUser(userRepository.findById(commentRequest.getUserId())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND.getCode(),
                        ErrorCode.USER_NOT_FOUND.getMessage())));
        comment.setCreatedAt(LocalDateTime.now());
        comment.setCommentLikes(0L);
        commentRepository.save(comment);
        return CommentResponse.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt().toString())
                .userResponse(UserResDTO.builder()
                        .id(comment.getUser().getId())
                        .name(comment.getUser().getName())
                        .classroom(comment.getUser().getClassroom())
                        .avatarUrl(comment.getUser().getAvatarFile())
                        .build())
                .build();
    }
    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
    @Override
    public CommentResponse getAllCommentsByNewsFeedId(Long newsFeedId) {
        Comment comment = commentRepository.findAllByNewsFeedId(newsFeedId);
        return CommentResponse.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt().toString())
                .userResponse(UserResDTO.builder()
                        .id(comment.getUser().getId())
                        .name(comment.getUser().getName())
                        .classroom(comment.getUser().getClassroom())
                        .avatarUrl(comment.getUser().getAvatarFile())
                        .build())
                .build();
    }
}
