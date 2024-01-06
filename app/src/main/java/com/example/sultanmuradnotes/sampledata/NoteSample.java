package com.example.sultanmuradnotes.sampledata;

import com.example.sultanmuradnotes.db.domain.Note;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NoteSample {
    static List<Note> notes = new ArrayList<>();


    public static List<Note> sample() {
        for (long i = 0; i < 50; i++) {
            notes.add(new Note(i, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", LocalDateTime.now(), LocalDateTime.now()));
        }

        return notes;
    }


}
