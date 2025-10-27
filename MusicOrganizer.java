import java.util.ArrayList;
import java.util.Arrays;

/**
 * A class to hold details of audio files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 7.3
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<>();
        player = new MusicPlayer();
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename, String artist)
    {
        files.add(filename + "by" + " " + artist);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(validIndex(index)) {
            int i = files.size();
            for(String filename : files){
                int position = files.size() - i;
                System.out.println(position + ": " + filename);
            }
        }
    }
    
    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles()
    {
        for(int i = 0; i < files.size(); i++){
            System.out.println(files.get(i));
        }
    }
    
    public void artistSongSample(String artistName){
        boolean matchFound = false;
        for(String filename: files){
            if(filename.contains(artistName)){
                System.out.println(filename);
                player.playSample(filename);
                matchFound = true;
            }
            if(matchFound == false){
                System.out.println("No such song by" + " " + artistName + " " + "was found in the list!");
            }
        }
    }    
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(validIndex(index)) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        if(validIndex(index)) {
            String filename = files.get(index);
            player.startPlaying(filename);
        }
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     * Play a file in the collection. Only return once playing has finished.
     * @param index The index of the file to be played.
     */
    public void playAndWait(int index)
    {
        if(validIndex(index)) {
            String filename = files.get(index);
            player.playSample(filename);
        }
    }

    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index)
    {
        // The return value.
        // Set according to whether the index is valid or not.
        boolean valid;
        
        if(index < 0) {
            System.out.println("Index cannot be negative: " + index);
            valid = false;
        }
        else if(index >= files.size()) {
            System.out.println("Index is too large: " + index);
            valid = false;
        }
        else {
            valid = true;
        }
        return valid;
    }
    public void exerciseTwentyFive(){
        int[] numbers = {67, 15, 76, 72, 6, 7};
        System.out.println(Arrays.toString(numbers));
        
        Arrays.sort(numbers);
        System.out.println("Sorted numbers:" + Arrays.toString(numbers));
        
        int[] subArray = Arrays.copyOfRange(numbers, 0, 5);
        System.out.println("Range 0-5" + Arrays.toString(subArray));
        
        
        
    }
}
