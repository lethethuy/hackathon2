package run;

import Config.Config;
import controller.SingerController;
import controller.SongController;
import model.Singer;
import model.Song;

public class Main {
    private static SongController songController = new SongController();
    private static SingerController singerController = new SingerController();

    public static void main(String[] args) {
        while (true) {
            System.out.println("************************MUSIC_MANAGEMENT*************************");
            System.out.println("1. Quản lý ca sĩ");
            System.out.println("2. Quản lý bài hát");
            System.out.println("3. Tìm kiếm bài hát");
            System.out.println("4. Thoát");
            int choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    // Quản lý ca sĩ
                    singerAdmin();
                    break;
                case 2:
                    // Quản lý bài hát
                    songAdmin();
                    break;
                case 3:
                    // Tìm kiếm bài hát
                    // TODO: Thêm mã xử lý tìm kiếm bài hát
                    break;
                case 4:
                    // Thoát
                    System.exit(0);
                    break;
                default:
                    System.err.println("Nhập số từ 1 đến 4");
            }
        }
    }

    public static void singerAdmin() {
        while (true) {
            System.out.println("**********************SINGER-MANAGEMENT*************************");
            System.out.println("1. Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới");
            System.out.println("2. Hiển thị danh sách tất cả ca sĩ đã lưu trữ");
            System.out.println("3. Thay đổi thông tin ca sĩ theo mã id");
            System.out.println("4. Xóa ca sĩ theo mã id");
            System.out.println("5. Thoát");

            int choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    // Số lượng ca sĩ cần thêm
                    updateAddSinger();
                    break;
                case 2:
                    displayAllSingers();
                    break;
                case 3:
                    updateSinger();
                    break;
                case 4:
                    deleteSinger();
                    break;
                case 5:
                    return;
                default:
                    System.err.println("Nhập số từ 1 đến 5");
            }
        }
    }

    public static void updateAddSinger() {
        System.out.println("Nhập vào số lượng ca sĩ cần thêm");
        int n = Config.scanner().nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin thứ " + (i + 1));
            Singer singer = new Singer();
            int id = singerController.getIdMax();
            System.out.println("Id: " + id);
            singer.setSingerId(id);
            System.out.println("Nhập tên ca sĩ");
            singer.setSingerName(Config.scanner().nextLine());
            System.out.println("Nhập tuổi ca sĩ");
            singer.setAge(Config.scanner().nextInt());
            System.out.println("Nhập quốc tịch");
            singer.setNationality(Config.scanner().nextLine());
            System.out.println("Nhập giới tính (true/false)");
            singer.setGender(Config.scanner().nextBoolean());
            System.out.println("Nhập thể loại");
            singer.setGenre(Config.scanner().nextLine());
            // Lưu vào danh sách ca sĩ
            singerController.save(singer);
        }
    }

    public static void displayAllSingers() {
        if (singerController.getSize() == 0) {
            System.err.println("Danh sách trống");
        } else {
            for (Singer singer : singerController.getAll()) {
                if (singer != null) {
                    System.out.println(singer);
                }
            }
        }
    }

    public static void updateSinger() {
        System.out.println("Nhập vào id ca sĩ cần sửa");
        int id = Config.scanner().nextInt();
        Singer singerEdit = singerController.findById(id);
        if (singerEdit == null) {
            System.err.println("Id không tồn tại");
            return;
        }
        // Cho phép người dùng sửa
        System.out.println("Nhập tên ca sĩ mới");
        singerEdit.setSingerName(Config.scanner().nextLine());
        System.out.println("Nhập tuổi ca sĩ mới");
        singerEdit.setAge(Config.scanner().nextInt());
        System.out.println("Nhập quốc tịch mới");
        singerEdit.setNationality(Config.scanner().nextLine());
        System.out.println("Nhập giới tính mới (true/false)");
        singerEdit.setGender(Config.scanner().nextBoolean());
        System.out.println("Nhập thể loại mới");
        singerEdit.setGenre(Config.scanner().nextLine());
        // Lưu thay đổi
        singerController.save(singerEdit);
    }

    public static void deleteSinger() {
        System.out.println("Nhập vào id ca sĩ cần xóa");
        int id = Config.scanner().nextInt();
        singerController.delete(id);
    }

    public static void songAdmin() {
        while (true) {
            System.out.println("**********************SONG-MANAGEMENT*************************");
            System.out.println("1. Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới");
            System.out.println("2. Hiển thị danh sách tất cả bài hát đã lưu trữ");
            System.out.println("3. Thay đổi thông tin bài hát theo mã id");
            System.out.println("4. Xóa bài hát theo mã id");
            System.out.println("5. Thoát");

            int choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    // Số lượng bài hát cần thêm
                    updateAddSong();
                    break;
                case 2:
                    displayAllSongs();
                    break;
                case 3:
                    updateSong();
                    break;
                case 4:
                    deleteSong();
                    break;
                case 5:
                    return;
                default:
                    System.err.println("Nhập số từ 1 đến 5");
            }
        }
    }

    public static void updateAddSong() {
        System.out.println("Nhập vào số lượng bài hát cần thêm");
        int n = Config.scanner().nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin bài hát thứ " + (i + 1));
            Song song = new Song();
            int id = songController.getIdMax();
            System.out.println("Id: " + id);
            song.setSongId(id);
            System.out.println("Nhập tên bài hát");
            song.setSongName(Config.scanner().nextLine());
            System.out.println("Nhập mô tả");
            song.setDescription(Config.scanner().nextLine());
            System.out.println("Nhập tên ca sĩ");
            song.setSinger(Config.scanner().nextLine());
            System.out.println("Nhập tên nhạc sĩ");
            song.setSongWriter(Config.scanner().nextLine());
            System.out.println("Nhập ngày tạo (theo định dạng dd/MM/yyyy)");
            String dateStr = Config.scanner().nextLine();
            System.out.println("Nhập trạng thái bài hát (true/false)");
            song.setSongStatus(Config.scanner().nextBoolean());
            // Lưu vào danh sách bài hát
            songController.save(song);
        }
    }

    public static void displayAllSongs() {
        if (songController.getSize() == 0) {
            System.err.println("Danh sách trống");
        } else {
            for (Song song : songController.getAll()) {
                if (song != null) {
                    System.out.println(song);
                }
            }
        }
    }

    public static void updateSong() {
        System.out.println("Nhập vào id bài hát cần sửa");
        int id = Config.scanner().nextInt();
        Song songEdit = songController.findById(id);
        if (songEdit == null) {
            System.err.println("Id không tồn tại");
            return;
        }
        // Cho phép người dùng sửa
        System.out.println("Nhập tên bài hát mới");
        songEdit.setSongName(Config.scanner().nextLine());
        System.out.println("Nhập mô tả mới");
        songEdit.setDescription(Config.scanner().nextLine());
        System.out.println("Nhập tên ca sĩ mới");
        songEdit.setSinger(Config.scanner().nextLine());
        System.out.println("Nhập tên nhạc sĩ mới");
        songEdit.setSongWriter(Config.scanner().nextLine());
        System.out.println("Nhập ngày tạo mới ");
        String dateStr = Config.scanner().nextLine();
        System.out.println("Nhập trạng thái bài hát mới (true/false)");
        songEdit.setSongStatus(Config.scanner().nextBoolean());
        // Lưu thay đổi
        songController.save(songEdit);
    }

    public static void deleteSong() {
        System.out.println("Nhập vào id bài hát cần xóa");
        int id = Config.scanner().nextInt();
        songController.delete(id);
    }
}
