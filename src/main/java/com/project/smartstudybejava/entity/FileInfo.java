package com.project.smartstudybejava.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "files")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileInfo {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    String id;

    @Column(name = "file_name")
    String fileName;

    @Column(name = "file_folder")
    String fileFolder;

    @Column(name = "file_url")
    String fileUrl;

    @Column(name = "file_type")
    String fileType;

    @Column(name = "cloud_id")
    String cloudId;
}
