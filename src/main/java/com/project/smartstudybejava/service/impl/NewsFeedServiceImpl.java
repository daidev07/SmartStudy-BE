package com.project.smartstudybejava.service.impl;

import com.project.smartstudybejava.entity.Classroom;
import com.project.smartstudybejava.entity.FileInfo;
import com.project.smartstudybejava.entity.NewsFeed;
import com.project.smartstudybejava.entity.User;
import com.project.smartstudybejava.exception.AppException;
import com.project.smartstudybejava.repository.ClassroomRepository;
import com.project.smartstudybejava.repository.NewsFeedRepository;
import com.project.smartstudybejava.repository.UserRepository;
import com.project.smartstudybejava.service.NewsFeedService;
import com.project.smartstudybejava.util.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class NewsFeedServiceImpl implements NewsFeedService {
    NewsFeedRepository newsFeedRepository;
    UserRepository userRepository;

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
        return newsFeedRepository.save(feed);
    }

    @Override
    public List<NewsFeed> getAllNewsFeed() {
        return newsFeedRepository.findAll();
    }
}
