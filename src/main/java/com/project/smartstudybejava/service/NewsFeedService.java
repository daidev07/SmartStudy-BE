package com.project.smartstudybejava.service;

import com.project.smartstudybejava.entity.FileInfo;
import com.project.smartstudybejava.entity.NewsFeed;

import java.util.List;

public interface NewsFeedService {
    NewsFeed postToAllClasses(String content, Long userId, FileInfo image);
    List<NewsFeed> getAllPermittedNewsFeed();
    List<NewsFeed> getAllNotPermitNewsFeed();
    boolean isPostByUser(Long postId, Long userId);
    NewsFeed permitPost(Long postId);
    void deletePost(Long postId);
}
