package Model;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

public class Songs extends JFrame
{   
    private int songID;
    private String title;
    private String artist;
    private String album;
    private byte[] image;
    private String genre;
    private int popularity;
    private int price;
    private Clip clip;
    public Songs(){}

    public Songs(String title, String artist, String album, byte[] image, String genre, int popularity, int price) 
    {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.image = image;
        this.genre = genre;
        this.popularity = popularity;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
     public boolean SoundClipTest(String filepath) throws IOException {
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setTitle("Test Sound Clip");
      this.setSize(300, 200);
      //this.setVisible(true);
   
      try {
         // Open an audio input stream.
         File soundFile = new File(filepath);
         AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
         // Get a sound clip resource.
         clip = AudioSystem.getClip();
         // Open audio clip and load samples from the audio input stream.
         clip.open(audioIn);
         clip.start();
          System.out.println("hello");
         if(clip.isRunning()==false)
         {
 
             return false;
         }
      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }
      return true;
   }
     public void stop()
     {
            System.out.println("dsjifjadskf");
            
            clip.stop();   // Stop the player if it is still running
            
         
      }
     
}
 
    
    
   