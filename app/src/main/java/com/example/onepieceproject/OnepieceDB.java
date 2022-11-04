package com.example.onepieceproject;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Personajes.class}, version=1)
abstract class OnepieceDB extends RoomDatabase {
    private static OnepieceDB INSTANCE;

    public static OnepieceDB getDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE=
                    Room.databaseBuilder(
                            context.getApplicationContext(),
                            OnepieceDB.class,"db"
                    ).build();
        }
        return INSTANCE;
    }

    public abstract OnepieceDao getOnepieceDao();
}
