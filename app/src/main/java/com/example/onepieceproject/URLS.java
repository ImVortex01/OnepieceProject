package com.example.onepieceproject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class URLS {
    private final String link = "https://";

    ArrayList<Personajes> getPersonajes() {
        String url = "https://csutehrxkcpulfjnpetn.supabase.co/rest/v1/characters?apikey=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImNzdXRlaHJ4a2NwdWxmam5wZXRuIiwicm9sZSI6ImFub24iLCJpYXQiOjE2NjY2OTY0MDcsImV4cCI6MTk4MjI3MjQwN30.3dcvKkVhknOGPqqk1ffNxwqRqCMVQFaztybkQCou0g0";
        try {
            String result = HttpUtils.get(url);
            JSONArray json = new JSONArray(result);
            ArrayList<Personajes> personajes = new ArrayList<>();
            for (int i = 0; i < json.length(); i++) {
                JSONObject personajeJson = json.getJSONObject(i);
                Personajes personaje = new Personajes();
                //Anadir datos al objeto personaje
                personaje.setName(personajeJson.getString("name"));
                personaje.setRace(personajeJson.getString("race"));
                personaje.setAge(personajeJson.getInt("age"));
                personaje.setHeight(personajeJson.getInt("height"));
                personaje.setDevilfruit(personajeJson.getString("devilfruit"));
                personaje.setUserimg(personajeJson.getString("userimg"));
                personaje.setDfimage(personajeJson.getString("dfimage"));
                personajes.add(personaje);

            }
            return personajes;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }//array

    ArrayList<Personajes> getPersonajes2() {
        String url = "https://csutehrxkcpulfjnpetn.supabase.co/rest/v1/characters?apikey=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImNzdXRlaHJ4a2NwdWxmam5wZXRuIiwicm9sZSI6ImFub24iLCJpYXQiOjE2NjY2OTY0MDcsImV4cCI6MTk4MjI3MjQwN30.3dcvKkVhknOGPqqk1ffNxwqRqCMVQFaztybkQCou0g0";
        try {
            String result = HttpUtils.get(url);
            JSONArray json = new JSONArray(result);
            ArrayList<Personajes> personajes = new ArrayList<>();
            for (int i = 0; i < json.length(); i++) {
                JSONObject personajeJson = json.getJSONObject(i);
                Personajes personaje = new Personajes();
                //Anadir datos al objeto personaje
                if (personajeJson.getString("devilfruit").equals("---")) {

                } else {
                    personaje.setName(personajeJson.getString("name"));
                    personaje.setRace(personajeJson.getString("race"));
                    personaje.setAge(personajeJson.getInt("age"));
                    personaje.setHeight(personajeJson.getInt("height"));
                    personaje.setDevilfruit(personajeJson.getString("devilfruit"));
                    personaje.setUserimg(personajeJson.getString("userimg"));
                    personaje.setDfimage(personajeJson.getString("dfimage"));
                    personajes.add(personaje);
                }
            }
            return personajes;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }//array
}//class
