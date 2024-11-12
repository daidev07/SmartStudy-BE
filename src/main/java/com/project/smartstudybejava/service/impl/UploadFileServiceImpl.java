package com.project.smartstudybejava.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.project.smartstudybejava.entity.FileInfo;
import com.project.smartstudybejava.entity.Exam;
import com.project.smartstudybejava.repository.FileInfoRepository;
import com.project.smartstudybejava.service.UploadFileService;
import com.project.smartstudybejava.util.FileUploadUtil;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UploadFileServiceImpl implements UploadFileService {

    Cloudinary cloudinary;
    FileInfoRepository fileInfoRepository;
    FileUploadUtil fileUploadUtil;

    public FileInfo saveAvatar(MultipartFile avatar) throws IOException {
        if (avatar == null) {
            return null;
        }
        var file = new FileInfo();
        fileInfoRepository.save(file);

        var uploadResult = cloudinary.uploader().upload(avatar.getBytes(), fileUploadUtil.buildImageUploadParams(file));

        String fileUrl = (String) uploadResult.get("secure_url");
        String fileFormat = (String) uploadResult.get("format");

        file.setFileName(file.getId() + "." + fileFormat);
        file.setFileUrl(fileUrl);
        file.setFileFolder(FileUploadUtil.IMAGE_UPLOAD_FOLDER);
        file.setCloudId(file.getFileFolder() + "/" + file.getId());
        String fileType = file.getFileName().substring(file.getFileName().lastIndexOf(".") + 1);
        file.setFileType(fileType);
        fileInfoRepository.save(file);
        return file;
    }

}
