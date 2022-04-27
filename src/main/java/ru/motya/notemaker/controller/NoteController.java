package ru.motya.notemaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.motya.notemaker.exception.NoteNotFoundException;
import ru.motya.notemaker.model.Note;
import ru.motya.notemaker.service.impl.NoteServiceImpl;

import javax.validation.Valid;
import java.util.List;

@Controller
public class NoteController {

    private final NoteServiceImpl noteService;

    @Autowired
    public NoteController(NoteServiceImpl noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/notes")
    public String findAll(Model model) {
        List<Note> notes = noteService.findAll();
        model.addAttribute("notes", notes);
        return "notes-list";
    }

    @GetMapping("/note-create")
    public String createNoteForm(Note note) {
        return "note-create";
    }

    @PostMapping("/note-create")
    public String createNote(@Valid Note note, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/note-create";
        }
        noteService.saveNote(note);
        return "redirect:/notes";
    }

    @GetMapping("/note-delete/{id}")
    public String deleteNote(@PathVariable("id") Integer id) {
        if (noteService.findNoteById(id).equals(null)) {
            throw new NoteNotFoundException("id" + id);
        }
        noteService.deleteNoteById(id);
        return "redirect:/notes";
    }

    @GetMapping("note-update/{id}")
    public String updateNoteForm(@PathVariable("id") Integer id, Model model) {
        Note note = noteService.findNoteById(id);
        model.addAttribute("note", note);
        return "/note-update";
    }

    @PostMapping("/note-update")
    public String updateNote(@Valid Note note, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/note-update";
        }
        noteService.saveNote(note);
        return "redirect:/notes";
    }
}
