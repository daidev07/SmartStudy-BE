package com.project.smartstudybejava.service.impl;

import com.project.smartstudybejava.entity.Classroom;
import com.project.smartstudybejava.entity.FileInfo;
import com.project.smartstudybejava.entity.NewsFeed;
import com.project.smartstudybejava.entity.User;
import com.project.smartstudybejava.enumeration.ERole;
import com.project.smartstudybejava.exception.AppException;
import com.project.smartstudybejava.repository.ClassroomRepository;
import com.project.smartstudybejava.repository.CommentRepository;
import com.project.smartstudybejava.repository.NewsFeedRepository;
import com.project.smartstudybejava.repository.UserRepository;
import com.project.smartstudybejava.service.NewsFeedService;
import com.project.smartstudybejava.util.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class NewsFeedServiceImpl implements NewsFeedService {
    NewsFeedRepository newsFeedRepository;
    UserRepository userRepository;
    CommentRepository commentRepository;

    public NewsFeed postToAllClasses(String content, Long userId, FileInfo image) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND.getCode(),
                        ErrorCode.USER_NOT_FOUND.getMessage()));

        NewsFeed feed = new NewsFeed();
        feed.setContent(content);
        feed.setImageFile(image != null ? image.getFileUrl() : null);
        feed.setPostedAt(LocalDateTime.now());
        feed.setUser(user);
        feed.setLikes(0L);
        feed.setPosted(!user.getRole().equals(ERole.STUDENT));
        return newsFeedRepository.save(feed);
    }

    @Override
    public List<NewsFeed> getAllPermittedNewsFeed() {
        return newsFeedRepository.findAllByIsPostedTrue();
    }
    @Override
    public List<NewsFeed> getAllNotPermitNewsFeed() {
        return newsFeedRepository.findAllByIsPostedFalse();
    }

    @Override
    public boolean isPostByUser(Long postId, Long userId) {
        return newsFeedRepository.existsByIdAndUserId(postId, userId);
    }

    @Override
    public NewsFeed permitPost(Long postId) {
        NewsFeed newsFeed = newsFeedRepository.findById(postId)
                .orElseThrow(() -> new AppException(ErrorCode.NEWSFEED_NOT_FOUND.getCode(),
                        ErrorCode.NEWSFEED_NOT_FOUND.getMessage()));
        newsFeed.setPosted(true);

        return newsFeedRepository.save(newsFeed);
    }

    @Override
    @Transactional
    public void deletePost(Long postId) {
        NewsFeed newsFeed = newsFeedRepository.findById(postId)
                .orElseThrow(() -> new AppException(ErrorCode.NEWSFEED_NOT_FOUND.getCode(),
                        ErrorCode.NEWSFEED_NOT_FOUND.getMessage()));
        commentRepository.deleteAllByNewsFeedId(postId);
        newsFeedRepository.delete(newsFeed);
    }
}
