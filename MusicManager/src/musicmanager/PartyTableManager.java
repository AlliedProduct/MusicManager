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
public class PartyTableManager implements SongManager {
    private ArrayList<String[]> partySongs = new ArrayList<>();

    @Override
    public void addSong(String title, String artist) {
        String[] songDetails = {title, artist};
        partySongs.add(songDetails);
    }

    @Override
    public void removeSong(int index) {
        partySongs.remove(index);
    }

    @Override
    public void moveSongUp(int index) {
        if (index > 0) {
            String[] temp = partySongs.get(index - 1);
            partySongs.set(index - 1, partySongs.get(index));
            partySongs.set(index, temp);
        }
    }

    @Override
    public void moveSongDown(int index) {
        if (index < partySongs.size() - 1) {
            String[] temp = partySongs.get(index + 1);
            partySongs.set(index + 1, partySongs.get(index));
            partySongs.set(index, temp);
        }
    }

    @Override
    public ArrayList<String[]> getSongs() {
        return partySongs;
    }
}
