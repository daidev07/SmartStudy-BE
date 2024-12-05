package com.project.smartstudybejava.util;

import com.cloudinary.utils.ObjectUtils;
import com.project.smartstudybejava.entity.FileInfo;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component

public class FileUploadUtil {
    public static final String IMAGE_UPLOAD_FOLDER = "user-avatars";
    public static final String AUDIO_UPLOAD_FOLDER = "audio-files";

    public Map<String, Object> buildImageUploadParams(FileInfo file) {
        if (file == null || file.getId() == null)
            throw new RuntimeException("CAN NOT UPLOAD FILE");

        String publicId = String.format("%s/%s", IMAGE_UPLOAD_FOLDER, file.getId());

        return ObjectUtils.asMap(
                "public_id", publicId,
                "overwrite", true,
                "resource_type", "image"
        );
    }
    public Map<String, Object> buildAudioUploadParams(FileInfo file) {
        if (file == null || file.getId() == null)
            throw new RuntimeException("CAN NOT UPLOAD FILE");

        String publicId = String.format("%s/%s", AUDIO_UPLOAD_FOLDER, file.getId());

        return ObjectUtils.asMap(
                "public_id", publicId,
                "overwrite", true,
                "resource_type", "auto"
        );
    }

}
