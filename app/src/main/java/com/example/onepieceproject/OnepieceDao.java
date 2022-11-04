package com.example.onepieceproject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface OnepieceDao {
    @Query("select * from  Personajes")
    LiveData<List<Personajes>> getPersonajes();

    @Insert
    void addPersonaje(Personajes personajes);

    @Delete
    void deletePersosonaje(Personajes personajes);

    @Query("DELETE FROM Personajes")
    void deletePersonajes();
}
