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
    private int loaiSach; // Bài 4: Loại sách (1. SGK, 2. Tham khảo, 3. Chuyên ngành, 4. Khác)

    public void nhap(Scanner sc) {
        int namHienTai = Year.now().getValue();
        
        System.out.print("Nhap ma sach: ");
        this.maSach = sc.nextLine();
        
        System.out.print("Nhap ten sach: ");
        this.tenSach = sc.nextLine();
        
        System.out.print("Nhap tac gia: ");
        this.tacGia = sc.nextLine();
        
        // Bài 1: Kiểm tra năm xuất bản hợp lệ
        do {
            System.out.print("Nhap nam xuat ban: ");
            this.namXB = sc.nextInt();
            if (this.namXB > namHienTai || this.namXB <= 0) {
                System.out.println("Loi: Nam xuat ban phai tu 1 den " + namHienTai + ". Vui long nhap lai!");
            }
        } while (this.namXB > namHienTai || this.namXB <= 0);
        
        // Bài 1: Kiểm tra đơn giá > 0
        do {
            System.out.print("Nhap don gia (> 0): ");
            this.donGia = sc.nextDouble();
            if (this.donGia <= 0) {
                System.out.println("Loi: Don gia phai lon hon 0. Vui long nhap lai!");
            }
        } while (this.donGia <= 0);
        
        // Bài 1: Kiểm tra số lượng >= 0
        do {
            System.out.print("Nhap so luong (>= 0): ");
            this.soLuong = sc.nextInt();
            if (this.soLuong < 0) {
                System.out.println("Loi: So luong khong duoc am. Vui long nhap lai!");
            }
        } while (this.soLuong < 0);
        
        // Bài 4: Dùng switch chọn loại sách
        System.out.println("--- CHON LOAI SACH ---");
        System.out.println("1. Sach giao khoa");
        System.out.println("2. Sach tham khao");
        System.out.println("3. Sach chuyen nganh");
        System.out.println("4. Sach khac");
        do {
            System.out.print("Nhap lua chon (1-4): ");
            this.loaiSach = sc.nextInt();
            if (loaiSach < 1 || loaiSach > 4) {
                System.out.println("Loi: Lua chon khong hop le. Vui long chon tu 1 den 4!");
            }
        } while (loaiSach < 1 || loaiSach > 4);
        
        sc.nextLine(); // Xoa bo dem
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

    // Bài 2: Phân loại giá
    public String phanLoaiGia() {
        if (donGia < 50000) {
            return "Sach gia thap";
        } else if (donGia <= 100000) {
            return "Sach gia trung binh";
        } else if (donGia <= 200000) {
            return "Sach gia cao";
        } else {
            return "Sach gia dac biet";
        }
    }

    // Bài 3: Phân loại tồn kho
    public String phanLoaiTonKho() {
        if (soLuong == 0) {
            return "Het sach";
        } else if (soLuong <= 5) {
            return "Sap het";
        } else if (soLuong <= 20) {
            return "Con it";
        } else {
            return "Con nhieu";
        }
    }

    // Bài 4: Lấy tên loại sách bằng switch-case
    public String getTenLoaiSach() {
        switch (loaiSach) {
            case 1: return "Sach giao khoa";
            case 2: return "Sach tham khao";
            case 3: return "Sach chuyen nganh";
            case 4: return "Sach khac";
            default: return "Khong xac dinh";
        }
    }

    public void xuat() {
        System.out.println("\n===================================");
        System.out.println("     THONG TIN CHI TIET SACH");
        System.out.println("===================================");
        System.out.println("Ma sach       : " + maSach);
        System.out.println("Ten sach      : " + tenSach);
        System.out.println("Tac gia       : " + tacGia);
        System.out.println("Loai sach     : " + getTenLoaiSach());
        System.out.println("Nam xuat ban  : " + namXB);
        System.out.println("Don gia       : " + donGia + " VND (" + phanLoaiGia() + ")");
        System.out.println("So luong      : " + soLuong + " (" + phanLoaiTonKho() + ")");
        System.out.println("-----------------------------------");
        System.out.println("Thanh tien    : " + tinhThanhTien() + " VND");
        System.out.println("Phi van chuyen: " + tinhPhiVanChuyen() + " VND");
        System.out.println("TONG TIEN NHAP: " + tinhTongTien() + " VND");
        System.out.println("===================================");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        bttuan3[] danhSachSach = null; // Mảng lưu danh sách các cuốn sách
        int n = 0;
        int choice;

        do {
            System.out.println("\n========================================");
            System.out.println("          MENU QUAN LY THU VIEN         ");
            System.out.println("========================================");
            System.out.println("1. Nhap danh sach n cuon sach");
            System.out.println("2. Hien thi danh sach va tinh tong so luong, tong gia tri");
            System.out.println("3. Tim kiem sach theo ma sach");
            System.out.println("4. Thoat chuong trinh");
            System.out.println("========================================");
            System.out.print("Nhap lua chon cua ban (1-4): ");
            choice = sc.nextInt();
            sc.nextLine(); // Xóa bộ đệm

            if (choice == 1) {
                System.out.print("Nhap so luong sach (n): ");
                n = sc.nextInt();
                sc.nextLine(); // Xóa bộ đệm
                danhSachSach = new bttuan3[n];
                
                for (int i = 0; i < n; i++) {
                    System.out.println("\n--- Nhap thong tin cuon sach thu " + (i + 1) + " ---");
                    danhSachSach[i] = new bttuan3();
                    danhSachSach[i].nhap(sc);
                }
                System.out.println("=> Da nhap thanh cong " + n + " cuon sach!");

            } else if (choice == 2) {
                if (danhSachSach == null || n == 0) {
                    System.out.println("Loi: Danh sach sach dang trong! Vui long nhap menu 1 truoc.");
                } else {
                    int tongSoLuongTatCa = 0;
                    double tongGiaTriTatCa = 0;

                    System.out.println("\n========== DANH SACH THU VIEN ==========");
                    for (int i = 0; i < n; i++) {
                        danhSachSach[i].xuat();
                        tongSoLuongTatCa += danhSachSach[i].soLuong;
                        tongGiaTriTatCa += danhSachSach[i].tinhTongTien();
                    }

                    System.out.println("\n========================================");
                    System.out.println("TONG KET THU VIEN:");
                    System.out.println("- Tong so luong sach: " + tongSoLuongTatCa);
                    System.out.println("- Tong gia tri sach (bao gồm phí VC): " + tongGiaTriTatCa + " VND");
                    System.out.println("========================================");
                }

            } else if (choice == 3) {
                if (danhSachSach == null || n == 0) {
                    System.out.println("Loi: Danh sach sach dang trong! Vui long nhap menu 1 truoc.");
                } else {
                    System.out.print("Nhap ma sach can tim: ");
                    String maTimKiem = sc.nextLine();
                    boolean found = false;

                    for (int i = 0; i < n; i++) {
                        if (danhSachSach[i].maSach.trim().equalsIgnoreCase(maTimKiem.trim())) {
                            System.out.println("=> Tim thay sach!");
                            danhSachSach[i].xuat();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("=> Khong tim thay sach co ma: " + maTimKiem);
                    }
                }

            } else if (choice == 4) {
                System.out.println("Cam on ban da su dung chuong trinh. Tam biet!");

            } else {
                System.out.println("Loi: Lua chon khong hop le! Vui long chon tu 1 den 4.");
            }

        } while (choice != 4);

        sc.close();
    }
} // <-- Dấu này đóng class bttuan3