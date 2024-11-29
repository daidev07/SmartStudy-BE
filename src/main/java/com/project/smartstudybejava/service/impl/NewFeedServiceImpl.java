package com.project.smartstudybejava.service.impl;

import com.project.smartstudybejava.entity.Classroom;
import com.project.smartstudybejava.entity.FileInfo;
import com.project.smartstudybejava.entity.NewFeed;
import com.project.smartstudybejava.entity.User;
import com.project.smartstudybejava.exception.AppException;
import com.project.smartstudybejava.repository.ClassroomRepository;
import com.project.smartstudybejava.repository.NewFeedRepository;
import com.project.smartstudybejava.repository.UserRepository;
import com.project.smartstudybejava.service.NewFeedService;
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
public class NewFeedServiceImpl implements NewFeedService {
    NewFeedRepository newFeedRepository;
    ClassroomRepository classroomRepository;
    UserRepository userRepository;

    public NewFeed postToClass(Long classId, String content, Long userId, FileInfo image) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND.getCode(),
                        ErrorCode.USER_NOT_FOUND.getMessage()));

        Classroom classroom = classroomRepository.findById(classId)
                .orElseThrow(() -> new AppException(ErrorCode.CLASSROOM_NOT_FOUND.getCode(),
                        ErrorCode.CLASSROOM_NOT_FOUND.getMessage()));

        NewFeed newFeed = new NewFeed();
        newFeed.setContent(content);
        newFeed.setUser(user);
        newFeed.setClassroom(classroom);
        if (image != null) {
            newFeed.setImageUrl(image.getFileUrl());
        }
        newFeed.setPostedAt(LocalDateTime.now());
        newFeed.setLikes(0L);

        return newFeedRepository.save(newFeed);
    }

    public List<NewFeed> postToAllClasses(String content, Long userId, FileInfo image) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND.getCode(),
                        ErrorCode.USER_NOT_FOUND.getMessage()));

        List<Classroom> classrooms = classroomRepository.findAll();
        List<NewFeed> feeds = new ArrayList<>();

        for (Classroom classroom : classrooms) {
            NewFeed newFeed = new NewFeed();
            newFeed.setContent(content);
            newFeed.setUser(user);
            newFeed.setClassroom(classroom);
            if (image != null) {
                newFeed.setImageUrl(image.getFileUrl());
            }
            newFeed.setPostedAt(LocalDateTime.now());
            newFeed.setLikes(0L);
            feeds.add(newFeedRepository.save(newFeed));
        }

        return feeds;
    }

    @Override
    public List<NewFeed> getNewFeedsByClass(Long classId) {
        return newFeedRepository.findByClassroomId(classId);
    }
}
