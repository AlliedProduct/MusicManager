/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicmanager;
import java.util.ArrayList;

/**
 *
 * @author nojus
 */
public class SadTableManager implements SongManager {
    private ArrayList<String[]> sadSongs = new ArrayList<>();

    @Override
    public void addSong(String title, String artist) {
        String[] songDetails = {title, artist};
        sadSongs.add(songDetails);
    }

    @Override
    public void removeSong(int index) {
        sadSongs.remove(index);
    }

    @Override
    public void moveSongUp(int index) {
        if (index > 0) {
            String[] temp = sadSongs.get(index - 1);
            sadSongs.set(index - 1, sadSongs.get(index));
            sadSongs.set(index, temp);
        }
    }

    @Override
    public void moveSongDown(int index) {
        if (index < sadSongs.size() - 1) {
            String[] temp = sadSongs.get(index + 1);
            sadSongs.set(index + 1, sadSongs.get(index));
            sadSongs.set(index, temp);
        }
    }

    @Override
    public ArrayList<String[]> getSongs() {
        return sadSongs;
    }
}