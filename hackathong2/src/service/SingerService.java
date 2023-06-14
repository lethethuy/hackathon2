package service;

import model.Singer;

public class SingerService {
    private Singer[] listSinger = new Singer[100];
    private int size;

    public int getSize() {
        return size;
    }

    public Singer[] getAllListSinger() {
        return listSinger;

    }

    public SingerService() {

    }

    public Singer findById(int id) {
        for (Singer singer : listSinger) {
            if (singer != null) {
                if (singer.getSingerId() == id) {
                    return singer;
                }
            }
        }
        return null;
    }

    public boolean save(Singer singer) {
        //add
        if (findById(singer.getSingerId()) == null) {
            if (size == listSinger.length) {
                System.err.println("Danh sách đã đầy, vui lòng thêm mới sau");
                return false;
            } else {
                for (int i = 0; i < listSinger.length; i++) {
                    if (listSinger[i] == null) {
                        listSinger[i] = singer;
                        break;
                    }
                }
                System.out.println("Thêm mới thành công");
                size++;
                return true;
            }
        } else {
            // update
            for (int i = 0; i < listSinger.length; i++) {
                if (listSinger[i] != null && listSinger[i].getSingerId() == singer.getSingerId()) {
                    listSinger[i] = singer;
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
            for (int i = 0; i < listSinger.length; i++) {
                if (listSinger[i] != null && listSinger[i].getSingerId() == id) {
                    listSinger[i] = null;
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
        for (Singer singer :
                listSinger) {
            if (singer != null) {
                if (singer.getSingerId() > max) {
                    max = singer.getSingerId();
                }
            }
        }
        return max + 1;
    }
}
