package controller;

import model.Song;
import service.SongService;

public class SongController {
    private SongService songService = new SongService();
    public Song[] getAll(){
        return songService.getAllListSong();
    }
    public Song findById(int id){
        return songService.findById(id);
    }
    public void delete(int id){
        songService.delete(id);
    }
    public void save(Song Song){
        songService.save(Song);
    }
    public int getSize(){
        return songService.getSize();
    }

    public int getIdMax(){
        return  songService.getIdMax();
    }
}
