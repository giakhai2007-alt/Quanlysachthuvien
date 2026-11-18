package tuan9;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

// Lớp cha: chứa các thông tin chung của mọi loại sách
public abstract class Sach {
    protected static final DateTimeFormatter DINH_DANG = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private String maSach;
    private LocalDate ngayNhap;
    private double donGia;
    private int soLuong;
    private String nhaXuatBan;

    public Sach() {
    }

    public Sach(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
        this.maSach = maSach;
        this.ngayNhap = ngayNhap;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.nhaXuatBan = nhaXuatBan;
    }

    public String getMaSach() { return maSach; }
    public void setMaSach(String maSach) { this.maSach = maSach; }

    public LocalDate getNgayNhap() { return ngayNhap; }
    public void setNgayNhap(LocalDate ngayNhap) { this.ngayNhap = ngayNhap; }

    public double getDonGia() { return donGia; }
    public void setDonGia(double donGia) {
        if (donGia >= 0) this.donGia = donGia;
        else System.out.println("Đơn giá không được âm.");
    }

    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) {
        if (soLuong >= 0) this.soLuong = soLuong;
        else System.out.println("Số lượng không được âm.");
    }

    public String getNhaXuatBan() { return nhaXuatBan; }
    public void setNhaXuatBan(String nhaXuatBan) { this.nhaXuatBan = nhaXuatBan; }

    // Mỗi loại sách tự tính thành tiền theo công thức riêng
    public abstract double thanhTien();

    public void nhap(Scanner sc) {
        System.out.print("Mã sách: ");
        maSach = sc.nextLine().trim();

        while (true) {
            System.out.print("Ngày nhập (dd/MM/yyyy): ");
            try {
                ngayNhap = LocalDate.parse(sc.nextLine().trim(), DINH_DANG);
                break;
            } catch (Exception e) {
                System.out.println("Ngày không hợp lệ, nhập lại.");
            }
        }

        while (true) {
            System.out.print("Đơn giá: ");
            try {
                double d = Double.parseDouble(sc.nextLine().trim());
                if (d >= 0) { donGia = d; break; }
            } catch (NumberFormatException e) { }
            System.out.println("Đơn giá không hợp lệ, nhập lại.");
        }

        while (true) {
            System.out.print("Số lượng: ");
            try {
                int n = Integer.parseInt(sc.nextLine().trim());
                if (n >= 0) { soLuong = n; break; }
            } catch (NumberFormatException e) { }
            System.out.println("Số lượng không hợp lệ, nhập lại.");
        }

        System.out.print("Nhà xuất bản: ");
        nhaXuatBan = sc.nextLine().trim();
    }

    public void xuat() {
        System.out.println("Mã sách: " + maSach);
        System.out.println("Ngày nhập: " + ngayNhap.format(DINH_DANG));
        System.out.println("Đơn giá: " + String.format("%,.0f", donGia));
        System.out.println("Số lượng: " + soLuong);
        System.out.println("Nhà xuất bản: " + nhaXuatBan);
    }
}