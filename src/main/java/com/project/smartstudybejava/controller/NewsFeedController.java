package com.project.smartstudybejava.controller;

import com.project.smartstudybejava.entity.FileInfo;
import com.project.smartstudybejava.entity.NewsFeed;
import com.project.smartstudybejava.service.CloudinaryService;
import com.project.smartstudybejava.service.NewsFeedService;
import com.project.smartstudybejava.util.ResponseData;
import com.project.smartstudybejava.util.SuccessCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/newsfeed")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class NewsFeedController {
    NewsFeedService newsFeedService;
    CloudinaryService cloudinaryService;

    @PostMapping("/all")
    public ResponseData<NewsFeed> postToAllClasses(
            @RequestParam String content,
            @RequestParam Long userId,
            @RequestParam(required = false) MultipartFile image) throws IOException {
        FileInfo fileInfo = null;
        if (image != null && !image.isEmpty()) {
            fileInfo = cloudinaryService.saveFile(image);
        }
        NewsFeed newsFeed = newsFeedService.postToAllClasses(content, userId, fileInfo);
        return ResponseData.<NewsFeed>builder()
                .code(SuccessCode.POST_SUCCESSFUL.getCode())
                .message(SuccessCode.POST_SUCCESSFUL.getMessage())
                .data(newsFeed)
                .build();
    }
    @GetMapping
    public ResponseData<List<NewsFeed>> getAllNewsFeed() {
        List<NewsFeed> newsFeeds = newsFeedService.getAllNewsFeed();
        return ResponseData.<List<NewsFeed>>builder()
                .code(SuccessCode.GET_SUCCESSFUL.getCode())
                .message(SuccessCode.GET_SUCCESSFUL.getMessage())
                .data(newsFeeds)
                .build();
    }
}
