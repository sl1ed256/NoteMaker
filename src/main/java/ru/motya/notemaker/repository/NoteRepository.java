package ru.motya.notemaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.motya.notemaker.model.Note;

public interface NoteRepository extends JpaRepository<Note, Integer> {

}
