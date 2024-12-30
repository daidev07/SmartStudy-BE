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
    ClassroomRepository classroomRepository;
    UserRepository userRepository;

    public NewsFeed postToClass(Long classId, String content, Long userId, FileInfo image) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND.getCode(),
                        ErrorCode.USER_NOT_FOUND.getMessage()));

        Classroom classroom = classroomRepository.findById(classId)
                .orElseThrow(() -> new AppException(ErrorCode.CLASSROOM_NOT_FOUND.getCode(),
                        ErrorCode.CLASSROOM_NOT_FOUND.getMessage()));

        NewsFeed newsFeed = new NewsFeed();
        newsFeed.setContent(content);
        newsFeed.setUser(user);
        newsFeed.setClassroom(classroom);
        if (image != null) {
            newsFeed.setImageFile(image.getFileUrl());
        }
        newsFeed.setPostedAt(LocalDateTime.now());
        newsFeed.setLikes(0L);

        return newsFeedRepository.save(newsFeed);
    }

    public List<NewsFeed> postToAllClasses(String content, Long userId, FileInfo image) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND.getCode(),
                        ErrorCode.USER_NOT_FOUND.getMessage()));

        List<Classroom> classrooms = classroomRepository.findAll();
        List<NewsFeed> feeds = new ArrayList<>();

        for (Classroom classroom : classrooms) {
            NewsFeed newsFeed = new NewsFeed();
            newsFeed.setContent(content);
            newsFeed.setUser(user);
            newsFeed.setClassroom(classroom);
            if (image != null) {
                newsFeed.setImageFile(image.getFileUrl());
            }
            newsFeed.setPostedAt(LocalDateTime.now());
            newsFeed.setLikes(0L);
            feeds.add(newsFeedRepository.save(newsFeed));
        }

        return feeds;
    }

    @Override
    public List<NewsFeed> getNewFeedsByClass(Long classId) {
        return newsFeedRepository.findByClassroomId(classId);
    }
}
