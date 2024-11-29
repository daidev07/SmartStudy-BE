package com.project.smartstudybejava.service;

import com.project.smartstudybejava.entity.FileInfo;
import com.project.smartstudybejava.entity.NewFeed;

import java.util.List;

public interface NewFeedService {
    NewFeed postToClass(Long classId, String content, Long userId, FileInfo image);

    List<NewFeed> postToAllClasses(String content, Long userId, FileInfo image);

    List<NewFeed> getNewFeedsByClass(Long classId);
}
