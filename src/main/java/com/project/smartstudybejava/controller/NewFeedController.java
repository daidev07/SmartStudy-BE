package com.project.smartstudybejava.controller;

import com.project.smartstudybejava.entity.FileInfo;
import com.project.smartstudybejava.entity.NewFeed;
import com.project.smartstudybejava.service.CloudinaryService;
import com.project.smartstudybejava.service.NewFeedService;
import com.project.smartstudybejava.util.ResponseData;
import com.project.smartstudybejava.util.SuccessCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/newfeed")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class NewFeedController {
    NewFeedService newFeedService;
    CloudinaryService cloudinaryService;
    @PostMapping("/class/{classId}")
    public ResponseData<NewFeed> postToClass(
            @PathVariable Long classId,
            @RequestParam String content,
            @RequestParam Long userId,
            @RequestParam(required = false) MultipartFile image) throws IOException {
        FileInfo fileInfo = null;
        if (image != null && !image.isEmpty()) {
            fileInfo = cloudinaryService.saveFile(image);
        }
        NewFeed newFeed = newFeedService.postToClass(classId, content, userId, fileInfo);
        return ResponseData.<NewFeed>builder()
                .code(SuccessCode.POST_SUCCESSFUL.getCode())
                .message(SuccessCode.POST_SUCCESSFUL.getMessage())
                .data(newFeed)
                .build();
    }

    @PostMapping("/all")
    public ResponseData<List<NewFeed>> postToAllClasses(
            @RequestParam String content,
            @RequestParam Long userId,
            @RequestParam(required = false) MultipartFile image) throws IOException {
        FileInfo fileInfo = null;
        if (image != null && !image.isEmpty()) {
            fileInfo = cloudinaryService.saveFile(image);
        }
        List<NewFeed> newFeeds = newFeedService.postToAllClasses(content, userId, fileInfo);
        return ResponseData.<List<NewFeed>>builder()
                .code(SuccessCode.POST_SUCCESSFUL.getCode())
                .message(SuccessCode.POST_SUCCESSFUL.getMessage())
                .data(newFeeds)
                .build();
    }

    @GetMapping("/class/{classId}")
    public ResponseData<List<NewFeed>> getNewFeedsByClass(@PathVariable Long classId) {
        List<NewFeed> newFeeds = newFeedService.getNewFeedsByClass(classId);
        return ResponseData.<List<NewFeed>>builder()
                .code(SuccessCode.GET_SUCCESSFUL.getCode())
                .message(SuccessCode.GET_SUCCESSFUL.getMessage())
                .data(newFeeds)
                .build();
    }
}
