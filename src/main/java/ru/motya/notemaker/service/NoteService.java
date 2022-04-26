package ru.motya.notemaker.service;

import ru.motya.notemaker.model.Note;

import java.util.List;

public interface NoteService {

    Note findNoteById(Integer id);

    List<Note> findAll();

    Note saveNote(Note note);

    void deleteNoteById(Integer id);

}
