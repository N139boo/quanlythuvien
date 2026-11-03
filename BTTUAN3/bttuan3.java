package BTTUAN3;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.Year;

public class bttuan3 {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private int namXB;
    private double donGia;
    private int soLuong;
    private int loaiSach; // 1. SGK, 2. Tham khảo, 3. Chuyên ngành, 4. Khác

    public void nhap(Scanner sc) {
        int namHienTai = Year.now().getValue();
        
        System.out.print("Nhap ma sach: ");
        this.maSach = sc.nextLine();
        
        System.out.print("Nhap ten sach: ");
        this.tenSach = sc.nextLine();
        
        System.out.print("Nhap tac gia: ");
        this.tacGia = sc.nextLine();
        
        do {
            System.out.print("Nhap nam xuat ban: ");
            this.namXB = sc.nextInt();
            if (this.namXB > namHienTai || this.namXB <= 0) {
                System.out.println("Loi: Nam xuat ban phai tu 1 den " + namHienTai + ". Vui long nhap lai!");
            }
        } while (this.namXB > namHienTai || this.namXB <= 0);
        
        do {
            System.out.print("Nhap don gia (> 0): ");
            this.donGia = sc.nextDouble();
            if (this.donGia <= 0) {
                System.out.println("Loi: Don gia phai lon hon 0. Vui long nhap lai!");
            }
        } while (this.donGia <= 0);
        
        do {
            System.out.print("Nhap so luong (>= 0): ");
            this.soLuong = sc.nextInt();
            if (this.soLuong < 0) {
                System.out.println("Loi: So luong khong duoc am. Vui long nhap lai!");
            }
        } while (this.soLuong < 0);
        
        System.out.println("--- CHON LOAI SACH ---");
        System.out.println("1. Sach giao khoa");
        System.out.println("2. Sach tham khao");
        System.out.println("3. Sach chuyen nganh");
        System.out.println("4. Sach khac");
        do {
            System.out.print("Nhap lua chon (1-4): ");
            this.loaiSach = sc.nextInt();
            if (loaiSach < 1 || loaiSach > 4) {
                System.out.println("Loi: Lua chon khong hop le! Vui long chon tu 1 den 4!");
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

    public String getTenLoaiSach() {
        if (loaiSach == 1) return "Sach giao khoa";
        else if (loaiSach == 2) return "Sach tham khao";
        else if (loaiSach == 3) return "Sach chuyen nganh";
        else if (loaiSach == 4) return "Sach khac";
        else return "Khong xac dinh";
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
        ArrayList<bttuan3> danhSachSach = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n==================================================");
            System.out.println("            MENU QUAN LY THU VIEN (ARRAYLIST)     ");
            System.out.println("==================================================");
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi danh sach sach");
            System.out.println("3. Tim sach theo ma sach");
            System.out.println("4. Xoa sach theo ma sach");
            System.out.println("5. Sua thong tin sach theo ma sach");
            System.out.println("6. Tinh tong so luong sach");
            System.out.println("7. Tinh tong gia tri sach");
            System.out.println("8. Thoat");
            System.out.println("==================================================");
            System.out.print("Nhap lua chon cua ban (1-8): ");
            choice = sc.nextInt();
            sc.nextLine(); // Xóa bộ đệm

            if (choice == 1) {
                System.out.println("\n--- THEM SACH MOI ---");
                bttuan3 sachMoi = new bttuan3();
                sachMoi.nhap(sc);
                danhSachSach.add(sachMoi);
                System.out.println("=> Them sach thanh cong!");

            } else if (choice == 2) {
                if (danhSachSach.isEmpty()) {
                    System.out.println("Loi: Thu vien chua co cuon sach nao!");
                } else {
                    System.out.println("\n========== DANH SACH THU VIEN (" + danhSachSach.size() + " cuon) ==========");
                    for (int i = 0; i < danhSachSach.size(); i++) {
                        System.out.println("Sach thu " + (i + 1) + ":");
                        danhSachSach.get(i).xuat();
                    }
                }

            } else if (choice == 3) {
                if (danhSachSach.isEmpty()) {
                    System.out.println("Loi: Thu vien trong!");
                } else {
                    System.out.print("Nhap ma sach can tim: ");
                    String maTim = sc.nextLine();
                    boolean found = false;
                    for (bttuan3 s : danhSachSach) {
                        if (s.maSach.trim().equalsIgnoreCase(maTim.trim())) {
                            System.out.println("=> Tim thay sach!");
                            s.xuat();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("=> Khong tim thay sach co ma: " + maTim);
                    }
                }

            } else if (choice == 4) {
                if (danhSachSach.isEmpty()) {
                    System.out.println("Loi: Thu vien trong!");
                } else {
                    System.out.print("Nhap ma sach can xoa: ");
                    String maXoa = sc.nextLine();
                    boolean removed = false;
                    for (int i = 0; i < danhSachSach.size(); i++) {
                        if (danhSachSach.get(i).maSach.trim().equalsIgnoreCase(maXoa.trim())) {
                            danhSachSach.remove(i);
                            System.out.println("=> Xoa thanh cong sach co ma: " + maXoa);
                            removed = true;
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("=> Khong tim thay ma sach de xoa!");
                    }
                }

            } else if (choice == 5) {
                if (danhSachSach.isEmpty()) {
                    System.out.println("Loi: Thu vien trong!");
                } else {
                    System.out.print("Nhap ma sach can sua: ");
                    String maSua = sc.nextLine();
                    boolean updated = false;
                    for (int i = 0; i < danhSachSach.size(); i++) {
                        if (danhSachSach.get(i).maSach.trim().equalsIgnoreCase(maSua.trim())) {
                            System.out.println("=> Nhap lai thong tin moi cho sach co ma: " + maSua);
                            bttuan3 sachSua = new bttuan3();
                            sachSua.nhap(sc);
                            danhSachSach.set(i, sachSua);
                            System.out.println("=> Cap nhat thong tin thanh cong!");
                            updated = true;
                            break;
                        }
                    }
                    if (!updated) {
                        System.out.println("=> Khong tim thay ma sach de sua!");
                    }
                }

            } else if (choice == 6) {
                if (danhSachSach.isEmpty()) {
                    System.out.println("Loi: Thu vien trong!");
                } else {
                    int tongSoLuong = 0;
                    for (bttuan3 s : danhSachSach) {
                        tongSoLuong += s.soLuong;
                    }
                    System.out.println("=> Tong so luong tat ca cac sach trong thu vien: " + tongSoLuong);
                }

            } else if (choice == 7) {
                if (danhSachSach.isEmpty()) {
                    System.out.println("Loi: Thu vien trong!");
                } else {
                    double tongGiaTri = 0;
                    for (bttuan3 s : danhSachSach) {
                        tongGiaTri += s.tinhTongTien();
                    }
                    System.out.println("=> Tong gia tri tat ca cac sach (da bao gom phi VC): " + tongGiaTri + " VND");
                }

            } else if (choice == 8) {
                System.out.println("Cam on ban da su dung chuong trinh. Tam biet!");

            } else {
                System.out.println("Loi: Lua chon khong hop le! Vui long chon tu 1 den 8.");
            }

        } while (choice != 8);

        sc.close();
    }
}