import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class SortetListFromFile {

    ArrayList<Song> songsList = new ArrayList<Song>();


    private void addSong(String lineFromFile) {
        String[] token = lineFromFile.split("/");
        Song aSong = new Song(token[0], token[1], token[2], token[3]);
        songsList.add(aSong);
    }

    private void getSongs() {
        String line = null;
        try {
            File file = new File("ListOfSongs.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                addSong(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void go() {
        getSongs();
        System.out.println(songsList);
        SongComparator songCompare = new SongComparator();
        TreeSet<Song> songSet = new TreeSet<Song>(songCompare);
        songSet.addAll(songsList);
        System.out.println(songSet);
    }

    private class SongComparator implements Comparator<Song> {

        public int compare(Song o1, Song o2) {
            return (o1.getTitle().compareTo(o2.getTitle()));
        }
    }

    public static void main(String[] args) {
        new SortetListFromFile().go();
    }

}
