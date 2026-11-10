package BTTUAN7;
import java.util.ArrayList;
public class Test {
    public static void main(String[] args) {
        ArrayList<Sach> danhSachSach = new ArrayList<>();
        danhSachSach.add(new Sach("MK01", "Lập trình Java cơ bản", "Nguyễn Văn A", 2023, 10));
        danhSachSach.add(new Sach("MK02", "Cấu trúc dữ liệu và giải thuật", "Trần Văn B", 2022, 15));
        danhSachSach.add(new Sach("MK03", "Cơ sở dữ liệu", "Lê Văn C", 2024, 20));
        System.out.println("--- DANH SÁCH SÁCH TRONG THƯ VIỆN ---");
        for (int i = 0; i < danhSachSach.size(); i++) {
            System.out.print((i + 1) + ". ");
            danhSachSach.get(i).hienThiThongTin();
        }
    }
}