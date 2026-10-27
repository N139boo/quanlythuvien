package BTTUAN3;

import java.util.Scanner;
import java.time.Year;

public class bttuan3 {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private int namXB;
    private double donGia;
    private int soLuong;

    public void nhap(Scanner sc) {
        int namHienTai = Year.now().getValue();
        
        System.out.print("Nhập mã sách: ");
        this.maSach = sc.nextLine();
        
        System.out.print("Nhập tên sách: ");
        this.tenSach = sc.nextLine();
        
        System.out.print("Nhập tác giả: ");
        this.tacGia = sc.nextLine();
        
        do {
            System.out.print("Nhập năm xuất bản: ");
            this.namXB = sc.nextInt();
            if (this.namXB > namHienTai || this.namXB <= 0) {
                System.out.println("Lỗi: Năm xuất bản phải từ 1 đến " + namHienTai + ". Vui lòng nhập lại!");
            }
        } while (this.namXB > namHienTai || this.namXB <= 0);
        
        do {
            System.out.print("Nhập đơn giá: ");
            this.donGia = sc.nextDouble();
            if (this.donGia < 0) {
                System.out.println("Lỗi: Đơn giá không được âm. Vui lòng nhập lại!");
            }
        } while (this.donGia < 0);
        
        do {
            System.out.print("Nhập số lượng: ");
            this.soLuong = sc.nextInt();
            if (this.soLuong < 0) {
                System.out.println("Lỗi: Số lượng không được âm. Vui lòng nhập lại!");
            }
        } while (this.soLuong < 0);
        
        sc.nextLine(); // Xóa bộ đệm
    }

    public double tinhThanhTien() {
        return donGia * soLuong;
    }

    public double tinhPhiVanChuyen() {
        return tinhThanhTien() * 0.05;
    }

    public double tinhTongTien() {
        return tinhThanhTien() + tinhPhiVanChuyen();
    }

    public void xuat() {
        System.out.println("\n--- THÔNG TIN SÁCH ---");
        System.out.println("Mã sách: " + maSach);
        System.out.println("Tên sách: " + tenSach);
        System.out.println("Tác giả: " + tacGia);
        System.out.println("Năm xuất bản: " + namXB);
        System.out.println("Đơn giá: " + donGia + " VNĐ");
        System.out.println("Số lượng: " + soLuong);
        System.out.println("Thành tiền: " + tinhThanhTien() + " VNĐ");
        System.out.println("Phí vận chuyển: " + tinhPhiVanChuyen() + " VNĐ");
        System.out.println("Tổng tiền nhập: " + tinhTongTien() + " VNĐ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        bttuan3 sach = new bttuan3(); 
        sach.nhap(sc);                            
        sach.xuat();                            
        sc.close();
    }
}