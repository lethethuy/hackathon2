package controller;

import model.Singer;
import service.SingerService;

public class SingerController {
    private SingerService singerService = new SingerService();
    public Singer[] getAll(){
        return singerService.getAllListSinger();
    }
    public Singer findById(int id){
        return singerService.findById(id);
    }
    public void delete(int id){
        singerService.delete(id);
    }
    public void save(Singer singer){
        singerService.save(singer);
    }
    public int getSize(){
        return singerService.getSize();
    }

    public int getIdMax(){
        return  singerService.getIdMax();
    }




}
