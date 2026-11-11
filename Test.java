import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        // Tạo đối tượng bằng constructor đầy đủ tham số
        Sach s1 = new Sach("S001", "Lập trình Java", "Nguyễn Văn A", 2023, 10);
        System.out.println("===== SÁCH HỢP LỆ =====");
        s1.hienThiThongTin();

        // Kiểm tra setter với giá trị không hợp lệ
        System.out.println("\n===== THỬ GÁN GIÁ TRỊ KHÔNG HỢP LỆ =====");
        s1.setNamXuatBan(3000);
        s1.setSoLuong(-5);
        System.out.println("Năm xuất bản vẫn là: " + s1.getNamXuatBan());
        System.out.println("Số lượng vẫn là    : " + s1.getSoLuong());

        // Kiểm tra setter với giá trị hợp lệ
        System.out.println("\n===== THỬ GÁN GIÁ TRỊ HỢP LỆ =====");
        s1.setNamXuatBan(2024);
        s1.setSoLuong(20);
        s1.hienThiThongTin();

        // Tạo sách với dữ liệu sai ngay từ constructor
        System.out.println("\n===== TẠO SÁCH VỚI DỮ LIỆU SAI =====");
        Sach s2 = new Sach("S002", "Cấu trúc dữ liệu", "Trần Thị B", -1, -3);
        s2.hienThiThongTin();

        // Danh sách ArrayList (từ tuần 7)
        ArrayList<Sach> danhSach = new ArrayList<>();
        danhSach.add(s1);
        danhSach.add(new Sach("S003", "Cơ sở dữ liệu", "Lê Văn C", 2022, 8));
        System.out.println("\n===== DANH SÁCH SÁCH =====");
        int tong = 0;
        for (Sach s : danhSach) {
            s.hienThiThongTin();
            System.out.println("---");
            tong += s.getSoLuong();
        }
        System.out.println("Tổng số lượng: " + tong);
    }
}