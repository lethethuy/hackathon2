package service;

import model.Song;

public class SongService {
    private Song[] listSong = new Song[100];
    private int size;

    public int getSize() {
        return size;
    }

    public Song[] getAllListSong() {
        return listSong;

    }

    public SongService() {

    }

    public Song findById(int id) {
        for (Song song : listSong) {
            if (song != null) {
                if (song.getSongId() == id) {
                    return song;
                }
            }
        }
        return null;
    }

    public boolean save(Song singer) {
        //add
        if (findById(singer.getSongId()) == null) {
            if (size == listSong.length) {
                System.err.println("Danh sách đã đầy, vui lòng thêm mới sau");
                return false;
            } else {
                for (int i = 0; i < listSong.length; i++) {
                    if (listSong[i] == null) {
                        listSong[i] = singer;
                        break;
                    }
                }
                System.out.println("Thêm mới thành công");
                size++;
                return true;
            }
        } else {
            // update
            for (int i = 0; i < listSong.length; i++) {
                if (listSong[i] != null && listSong[i].getSongId() == singer.getSongId()) {
                    listSong[i] = singer;
                    break;
                }

            }
            System.out.println("Cập nhật thành công");
            return true;
        }
    }

    // delete
    public boolean delete(int id) {
        if (findById(id) != null) {
            for (int i = 0; i < listSong.length; i++) {
                if (listSong[i] != null && listSong[i].getSongId() == id) {
                    listSong[i] = null;
                    break;
                }
            }
            size--;
            System.out.println("Xóa thành công");
            return true;
        }
        System.out.println("Không tìm thấy sản phẩm cần xóa");
        return true;
    }

    public int getIdMax() {
        int max = 0;
        for (Song song :
                listSong) {
            if (song != null) {
                if (song.getSongId() > max) {
                    max = song.getSongId();
                }
            }
        }
        return max + 1;
    }
}
