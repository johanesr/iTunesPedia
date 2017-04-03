package Model;

public class Songs 
{
    private String title;
    private String artist;
    private String album;
    private byte[] image;
    private String genre;
    private int popularity;
    private int price;
    
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
}
 
    
    
   