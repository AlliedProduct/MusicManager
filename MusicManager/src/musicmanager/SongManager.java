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
public interface SongManager {
    void addSong(String title, String artist);
    void removeSong(int index);
    void moveSongUp(int index);
    void moveSongDown(int index);
    ArrayList<String[]> getSongs();
}
