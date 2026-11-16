package BTTUAN7;
import java.util.ArrayList;
public class Test {
    public static void main(String[] args) {
        ArrayList<Sach> danhSachSach = new ArrayList<>();
        danhSachSach.add(new Sach("MS01", "Lập trình Java cơ bản", "Nguyễn Văn A", 2023, 10));
        danhSachSach.add(new Sach("MS02", "Cấu trúc dữ liệu và giải thuật", "Trần Văn B", 2022, 15));
        danhSachSach.add(new Sach("MS03", "Cơ sở dữ liệu", "Lê Văn C", 2024, 20));
        System.out.println("--- DANH SÁCH SÁCH TRONG THƯ VIỆN ---");
        for (int i = 0; i < danhSachSach.size(); i++) {
            System.out.print((i + 1) + ". ");
            danhSachSach.get(i).hienThiThongTin();
        }
    }
}
// Kiểm tra getter / setter và ràng buộc dữ liệu
        Sach s1 = danhSachSach.get(0);
        System.out.println("\n--- KIỂM TRA GETTER / SETTER ---");
        System.out.println("Tiêu đề sách 1: " + s1.getTieuDe());

        s1.setNamXuatBan(2099); // Thử giá trị không hợp lệ
        s1.setSoLuong(-5);      // Thử số lượng âm
        s1.setSoLuong(15);      // Thử giá trị hợp lệ

        System.out.println("Sau khi cập nhật sách 1:");
        s1.hienThiThongTin();