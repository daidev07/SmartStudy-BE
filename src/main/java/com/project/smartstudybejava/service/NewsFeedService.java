package com.project.smartstudybejava.service;

import com.project.smartstudybejava.entity.FileInfo;
import com.project.smartstudybejava.entity.NewsFeed;

import java.util.List;

public interface NewsFeedService {
    NewsFeed postToClass(Long classId, String content, Long userId, FileInfo image);

    List<NewsFeed> postToAllClasses(String content, Long userId, FileInfo image);

    List<NewsFeed> getNewFeedsByClass(Long classId);
}
