package tuan9;

import java.time.LocalDate;
import java.util.Scanner;

public class SachGiaoKhoa extends Sach {
    private String tinhTrang; // "mới" hoặc "cũ"

    public SachGiaoKhoa() {
    }

    public SachGiaoKhoa(String maSach, LocalDate ngayNhap, double donGia, int soLuong,
                        String nhaXuatBan, String tinhTrang) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.tinhTrang = tinhTrang;
    }

    public String getTinhTrang() { return tinhTrang; }
    public void setTinhTrang(String tinhTrang) { this.tinhTrang = tinhTrang; }

    // Mới: số lượng * đơn giá; Cũ: số lượng * đơn giá * 50%
    @Override
    public double thanhTien() {
        double tien = getSoLuong() * getDonGia();
        return tinhTrang.equalsIgnoreCase("mới") ? tien : tien * 0.5;
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        while (true) {
            System.out.print("Tình trạng (1: mới, 2: cũ): ");
            String s = sc.nextLine().trim();
            if (s.equals("1")) { tinhTrang = "mới"; break; }
            if (s.equals("2")) { tinhTrang = "cũ"; break; }
            System.out.println("Chỉ nhập 1 hoặc 2.");
        }
    }

    @Override
    public void xuat() {
        System.out.println("[SÁCH GIÁO KHOA]");
        super.xuat();
        System.out.println("Tình trạng: " + tinhTrang);
        System.out.println("Thành tiền: " + String.format("%,.0f", thanhTien()));
        System.out.println("-----------------------------");
    }
}