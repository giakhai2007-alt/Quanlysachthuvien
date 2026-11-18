package tuan9;

import java.time.LocalDate;
import java.util.Scanner;

public class SachThamKhao extends Sach {
    private double thue;

    public SachThamKhao() {
    }

    public SachThamKhao(String maSach, LocalDate ngayNhap, double donGia, int soLuong,
                        String nhaXuatBan, double thue) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.thue = thue;
    }

    public double getThue() { return thue; }
    public void setThue(double thue) {
        if (thue >= 0) this.thue = thue;
        else System.out.println("Thuế không được âm.");
    }

    // Thành tiền = số lượng * đơn giá + thuế
    @Override
    public double thanhTien() {
        return getSoLuong() * getDonGia() + thue;
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        while (true) {
            System.out.print("Thuế: ");
            try {
                double t = Double.parseDouble(sc.nextLine().trim());
                if (t >= 0) { thue = t; break; }
            } catch (NumberFormatException e) { }
            System.out.println("Thuế không hợp lệ, nhập lại.");
        }
    }

    @Override
    public void xuat() {
        System.out.println("[SÁCH THAM KHẢO]");
        super.xuat();
        System.out.println("Thuế: " + String.format("%,.0f", thue));
        System.out.println("Thành tiền: " + String.format("%,.0f", thanhTien()));
        System.out.println("-----------------------------");
    }
}