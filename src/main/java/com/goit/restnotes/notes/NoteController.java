package com.goit.restnotes.notes;

import com.goit.restnotes.notes.dto.create.CreateNoteRequest;
import com.goit.restnotes.notes.dto.create.CreateNoteResponse;
import com.goit.restnotes.notes.dto.delete.DeleteNoteResponse;
import com.goit.restnotes.notes.dto.get.GetUserNotesResponse;
import com.goit.restnotes.notes.dto.update.UpdateNoteRequest;
import com.goit.restnotes.notes.dto.update.UpdateNoteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteController {
    private final NoteService noteService;

    @PostMapping
    public CreateNoteResponse create(Principal principal, @RequestBody CreateNoteRequest request) {
        return noteService.create(principal.getName(), request);
    }

    @GetMapping
    public GetUserNotesResponse getUserNotes(Principal principal) {
        return noteService.getUserNotes(principal.getName());
    }

    @PatchMapping
    public UpdateNoteResponse update(Principal principal, @RequestBody UpdateNoteRequest request) {
        return noteService.update(principal.getName(), request);
    }

    @DeleteMapping
    public DeleteNoteResponse delete(Principal principal, @RequestParam(name = "id") long id) {
        return noteService.delete(principal.getName(), id);
    }
}

