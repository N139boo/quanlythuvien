package BTTUAN7;

import java.time.LocalDate;

public class Sach {
    // Yêu cầu 1: Khai báo thuộc tính private
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;

    // Constructor mặc định (nên có thêm nếu cần tạo rỗng rồi set sau)
    public Sach() {
    }

    // Yêu cầu 4: Constructor có tham số đầy đủ
    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        setNamXuatBan(namXuatBan);
        setSoLuong(soLuong);
    }

    // Yêu cầu 2: Getters & Setters
    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    // Yêu cầu 3: Kiểm tra năm xuất bản hợp lệ (ví dụ từ năm 1000 đến năm hiện tại)
    public void setNamXuatBan(int namXuatBan) {
        int currentYear = LocalDate.now().getYear();
        if (namXuatBan >= 1000 && namXuatBan <= currentYear) {
            this.namXuatBan = namXuatBan;
        } else {
            System.out.println("Năm xuất bản không hợp lệ (" + namXuatBan + "). Giữ nguyên giá trị hiện tại: " + this.namXuatBan);
        }
    }

    public int getSoLuong() {
        return soLuong;
    }

    // Yêu cầu 3: Đảm bảo số lượng không âm
    public void setSoLuong(int soLuong) {
        if (soLuong >= 0) {
            this.soLuong = soLuong;
        } else {
            System.out.println("Số lượng không được âm (" + soLuong + "). Giữ nguyên giá trị hiện tại: " + this.soLuong);
        }
    }

    // Phương thức hiển thị thông tin sách
    public void hienThiThongTin() {
        System.out.println("Mã sách: " + maSach
                + " | Tiêu đề: " + tieuDe
                + " | Tác giả: " + tacGia
                + " | Năm XB: " + namXuatBan
                + " | Số lượng: " + soLuong);
    }
}