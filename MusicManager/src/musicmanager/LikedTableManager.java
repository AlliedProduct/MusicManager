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
public class LikedTableManager implements SongManager {
    private ArrayList<String[]> likedSongs = new ArrayList<>();

    @Override
    public void addSong(String title, String artist) {
        String[] songDetails = {title, artist};
        likedSongs.add(songDetails);
    }

    @Override
    public void removeSong(int index) {
        likedSongs.remove(index);
    }

    @Override
    public void moveSongUp(int index) {
        if (index > 0) {
            String[] temp = likedSongs.get(index - 1);
            likedSongs.set(index - 1, likedSongs.get(index));
            likedSongs.set(index, temp);
        }
    }

    @Override
    public void moveSongDown(int index) {
        if (index < likedSongs.size() - 1) {
            String[] temp = likedSongs.get(index + 1);
            likedSongs.set(index + 1, likedSongs.get(index));
            likedSongs.set(index, temp);
        }
    }

    @Override
    public ArrayList<String[]> getSongs() {
        return likedSongs;
    }
}