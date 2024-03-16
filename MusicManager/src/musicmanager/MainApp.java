/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package musicmanager;

/**
 *
 * @author nojus
 */
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JOptionPane;
import java.util.regex.PatternSyntaxException;



public class MainApp implements SongManager {
    private ArrayList<String[]> likedSongs = new ArrayList<>();
    private ArrayList<String[]> partySongs = new ArrayList<>();
    private ArrayList<String[]> sadSongs = new ArrayList<>();
// all the methods for the liked playlist
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
// all the methods for the party playlist
        public ArrayList<String[]> getPartySongs() {
        return partySongs;
        }
    
    public void addPartySong(String title, String artist) {
        String[] songDetails = {title, artist};
        partySongs.add(songDetails);
    }

    public void removePartySong(int index) {
        partySongs.remove(index);
    }

    public void movePartySongUp(int index) {
        if (index > 0) {
            String[] temp = partySongs.get(index - 1);
            partySongs.set(index - 1, partySongs.get(index));
            partySongs.set(index, temp);
        }
    }

    public void movePartySongDown(int index) {
        if (index < partySongs.size() - 1) {
            String[] temp = partySongs.get(index + 1);
            partySongs.set(index + 1, partySongs.get(index));
            partySongs.set(index, temp);
        }
    }
// all the methods for the sad playlist
    public void addSadSong(String title, String artist) {
        String[] songDetails = {title, artist};
        sadSongs.add(songDetails);
    }

    public void removeSadSong(int index) {
        sadSongs.remove(index);
    }

    public void moveSadSongUp(int index) {
        if (index > 0) {
            String[] temp = sadSongs.get(index - 1);
            sadSongs.set(index - 1, sadSongs.get(index));
            sadSongs.set(index, temp);
        }
    }

    public void moveSadSongDown(int index) {
        if (index < sadSongs.size() - 1) {
            String[] temp = sadSongs.get(index + 1);
            sadSongs.set(index + 1, sadSongs.get(index));
            sadSongs.set(index, temp);
        }
    }

    public ArrayList<String[]> getSadSongs() {
        return sadSongs;
    }
    
         public void addSadSong(String[] songDetails) {
        sadSongs.add(songDetails);
    }
         
          public void addPartySong(String[] songDetails) {
        partySongs.add(songDetails);
    }        
    //function to get the last song
    public String[] getLastLikedSong() {
        if (!likedSongs.isEmpty()) {
            return likedSongs.get(likedSongs.size() - 1);
        } else {
            return null;
        }
}
    // functions to add the last song to the corresponding playlist
       public void addLastLikedSongToParty() {
        if (!likedSongs.isEmpty()) {
            String[] lastSong = likedSongs.get(likedSongs.size() - 1);
            partySongs.add(lastSong);
        }
    }

    public void addLastLikedSongToSad() {
        if (!likedSongs.isEmpty()) {
            String[] lastSong = likedSongs.get(likedSongs.size() - 1);
            sadSongs.add(lastSong);
        }
    }

    //function that searches the tables & able to "search ahead" e.g "hea" will show songs that have hea in them like heaven
    public void searchTable(JTable table, String query) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        try {
            RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter(query, 0);
            sorter.setRowFilter(rowFilter);
        } catch (PatternSyntaxException e) {
            JOptionPane.showMessageDialog(null, "Invalid search pattern.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    //counts the no of songs in each playlist
    public int countLikedSongs() {
    return likedSongs.size();
}

public int countPartySongs() {
    return partySongs.size();
}

public int countSadSongs() {
    return sadSongs.size();
}

//function that lists all the songs in a playlist
private void listAllSongs(ArrayList<String[]> songs, String playlistName) {
    StringBuilder sb = new StringBuilder();
    for (String[] song : songs) {
        sb.append(song[0]).append(" - ").append(song[1]).append("\n");
    }
    JOptionPane.showMessageDialog(null, sb.toString(), "List of " + playlistName, JOptionPane.INFORMATION_MESSAGE);
}
//lists the songs in each playlist
public void listAllLikedSongs() {
    listAllSongs(likedSongs, "Liked Songs");
}

public void listAllPartySongs() {
    listAllSongs(partySongs, "Party Songs");
}

public void listAllSadSongs() {
    listAllSongs(sadSongs, "Sad Songs");
}

//getter for the selected song i na table
public String getSelectedSong(JTable table) {
    int selectedRow = table.getSelectedRow();
    if (selectedRow != -1) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        return model.getValueAt(selectedRow, 0).toString();
    }
    return "No song selected";
}

// no time to add testing
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MainApp mainApp = new MainApp();
        
        Menu Menu = new Menu(mainApp);
        
        Menu.setVisible(true);
    }
    
}