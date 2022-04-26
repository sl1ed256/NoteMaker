package ru.motya.notemaker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.motya.notemaker.model.Note;
import ru.motya.notemaker.repository.UserRepository;
import ru.motya.notemaker.service.NoteService;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private final UserRepository userRepository;

    @Autowired
    public NoteServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Note findNoteById(Integer id) {
        return userRepository.getById(id);
    }

    @Override
    public List<Note> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Note saveNote(Note note) {
        return userRepository.save(note);
    }

    @Override
    public void deleteNoteById(Integer id) {
        userRepository.deleteById(id);
    }
}
