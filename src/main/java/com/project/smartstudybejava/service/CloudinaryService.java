package com.project.smartstudybejava.service;


import com.project.smartstudybejava.entity.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CloudinaryService {
    FileInfo saveFile(MultipartFile file) throws IOException;
}
