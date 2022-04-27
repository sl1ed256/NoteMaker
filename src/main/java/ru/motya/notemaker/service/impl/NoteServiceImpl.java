package ru.motya.notemaker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.motya.notemaker.model.Note;
import ru.motya.notemaker.repository.NoteRepository;
import ru.motya.notemaker.service.NoteService;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note findNoteById(Integer id) {
        return noteRepository.getById(id);
    }

    @Override
    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public void deleteNoteById(Integer id) {
        noteRepository.deleteById(id);
    }
}
