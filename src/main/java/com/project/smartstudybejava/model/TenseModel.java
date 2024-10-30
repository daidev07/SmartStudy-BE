package com.project.smartstudybejava.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TenseModel {
    Integer id;
    String title;
    String recognitionWord;
    String use;
    String recipe;
}
