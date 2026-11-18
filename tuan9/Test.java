package tuan9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Sach> danhSach = new ArrayList<>();

        // Dữ liệu mẫu để thử nhanh (có thể xóa 3 dòng này)
        danhSach.add(new SachGiaoKhoa("GK01", LocalDate.of(2024, 9, 1), 50000, 10, "Giáo dục", "mới"));
        danhSach.add(new SachGiaoKhoa("GK02", LocalDate.of(2024, 9, 5), 40000, 5, "Kim Đồng", "cũ"));
        danhSach.add(new SachThamKhao("TK01", LocalDate.of(2024, 10, 1), 80000, 3, "Trẻ", 10000));

        int chon;
        do {
            System.out.println("\n===== QUẢN LÝ SÁCH THƯ VIỆN =====");
            System.out.println("1. Nhập sách giáo khoa");
            System.out.println("2. Nhập sách tham khảo");
            System.out.println("3. Xuất danh sách các loại sách");
            System.out.println("4. Tính tổng thành tiền từng loại");
            System.out.println("5. Trung bình cộng đơn giá sách tham khảo");
            System.out.println("6. Xuất sách giáo khoa của nhà xuất bản X");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            try {
                chon = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                chon = -1;
            }

            switch (chon) {
                case 1:
                    SachGiaoKhoa gk = new SachGiaoKhoa();
                    gk.nhap(sc);
                    danhSach.add(gk);
                    break;
                case 2:
                    SachThamKhao tk = new SachThamKhao();
                    tk.nhap(sc);
                    danhSach.add(tk);
                    break;
                case 3:
                    if (danhSach.isEmpty()) System.out.println("Danh sách rỗng.");
                    for (Sach s : danhSach) s.xuat();
                    break;
                case 4:
                    double tongGK = 0, tongTK = 0;
                    for (Sach s : danhSach) {
                        if (s instanceof SachGiaoKhoa) tongGK += s.thanhTien();
                        else if (s instanceof SachThamKhao) tongTK += s.thanhTien();
                    }
                    System.out.println("Tổng thành tiền sách giáo khoa: " + String.format("%,.0f", tongGK));
                    System.out.println("Tổng thành tiền sách tham khảo: " + String.format("%,.0f", tongTK));
                    break;
                case 5:
                    double tong = 0;
                    int dem = 0;
                    for (Sach s : danhSach) {
                        if (s instanceof SachThamKhao) {
                            tong += s.getDonGia();
                            dem++;
                        }
                    }
                    if (dem == 0) System.out.println("Chưa có sách tham khảo.");
                    else System.out.println("Đơn giá trung bình sách tham khảo: "
                            + String.format("%,.0f", tong / dem));
                    break;
                case 6:
                    System.out.print("Nhập nhà xuất bản X: ");
                    String x = sc.nextLine().trim();
                    boolean coSach = false;
                    for (Sach s : danhSach) {
                        if (s instanceof SachGiaoKhoa && s.getNhaXuatBan().equalsIgnoreCase(x)) {
                            s.xuat();
                            coSach = true;
                        }
                    }
                    if (!coSach) System.out.println("Không có sách giáo khoa của nhà xuất bản " + x);
                    break;
                case 0:
                    System.out.println("Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (chon != 0);
    }
}