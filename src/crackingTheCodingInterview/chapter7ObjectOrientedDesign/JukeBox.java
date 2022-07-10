package crackingTheCodingInterview.chapter7ObjectOrientedDesign;

import java.util.Queue;
import java.util.Set;

/*
Jukebox: Design a musical jukebox using object-oriented principles
 */
//Body of the problem
public class JukeBox {
    private CDPlayer cdPlayer;
    private User user;
    private Set<CD> cdCollection;
    private SongSelector ts;
    //Constructor
    public JukeBox(CDPlayer cdPlayer,
                   User user,
                   Set<CD> cdCollection,
                   SongSelector ts) {
        //....
    }
    public Song getCurrentSong() {
        return ts.getCurrentSong();
    }
}
class CDPlayer {
    private Playlist p;
    private CD c;
    //Getter en setter.
}

class SongSelector {
    Song song;
    public Song getCurrentSong() {
        return song;
    }
}

class Playlist {
    private Song song;
    private Queue<Song> queue;
    public Playlist(Song song, Queue<Song> queue) {
    }
    public Song getNextStopPlay(){
        return queue.peek();
    }
    public void queueUpSong(Song s) {
        queue.add(s);
    }
}
class CD {

}
class Song {

}

class User {
    String name;
    long ID;
    public User(String name, long ID) {
        this.name = name;
        this.ID = ID;
    }
}
