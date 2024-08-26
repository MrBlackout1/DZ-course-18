package com.goit.restnotes.note.dto.update;

import lombok.*;

@Data
public class UpdateNoteRequest {
    private long id;
    private String title;
    private String content;
}

