package com.aarkay.todopriority;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    //this line is to satisfy the singleton requirements.ensures there is only one instance of the class.
    private static NoteDatabase instance;

    public abstract NoteDAO noteDAO();

    public static synchronized NoteDatabase getInstance(Context context){
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),NoteDatabase.class,
                    "note_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}