import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        // Yêu cầu 3: tạo đối tượng từ lớp Sach
        Sach s1 = new Sach("S001", "Lập trình Java", "Nguyễn Văn A", 2023, 10);
        System.out.println("===== YÊU CẦU 3: MỘT ĐỐI TƯỢNG SÁCH =====");
        s1.hienThiThongTin();

        // Yêu cầu 4: tạo và quản lý danh sách Sach bằng ArrayList
        ArrayList<Sach> danhSach = new ArrayList<>();
        danhSach.add(s1);
        danhSach.add(new Sach("S002", "Cấu trúc dữ liệu", "Trần Thị B", 2021, 5));
        danhSach.add(new Sach("S003", "Cơ sở dữ liệu", "Lê Văn C", 2022, 8));

        // Hiển thị danh sách
        System.out.println("\n===== YÊU CẦU 4: DANH SÁCH SÁCH =====");
        for (int i = 0; i < danhSach.size(); i++) {
            System.out.println("--- Sách thứ " + (i + 1) + " ---");
            danhSach.get(i).hienThiThongTin();
        }

        // Tìm sách theo mã
        System.out.println("\n===== TÌM SÁCH MÃ S002 =====");
        boolean timThay = false;
        for (Sach s : danhSach) {
            if (s.getMaSach().equalsIgnoreCase("S002")) {
                s.hienThiThongTin();
                timThay = true;
                break;
            }
        }
        if (!timThay) {
            System.out.println("Không tìm thấy sách.");
        }

        // Xóa sách theo mã
        System.out.println("\n===== XÓA SÁCH MÃ S003 =====");
        danhSach.removeIf(s -> s.getMaSach().equalsIgnoreCase("S003"));
        System.out.println("Số sách còn lại: " + danhSach.size());

        // Tính tổng số lượng
        int tongSoLuong = 0;
        for (Sach s : danhSach) {
            tongSoLuong += s.getSoLuong();
        }
        System.out.println("Tổng số lượng sách: " + tongSoLuong);
    }
}