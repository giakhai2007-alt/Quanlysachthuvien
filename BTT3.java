import java.util.Scanner;

public class BTT3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ===== TUẦN 3: Nhập thông tin sách =====
        System.out.print("Nhập mã sách: ");
        String maSach = sc.nextLine();

        System.out.print("Nhập tên sách: ");
        String tenSach = sc.nextLine();

        System.out.print("Nhập tác giả: ");
        String tacGia = sc.nextLine();

        System.out.print("Nhập năm xuất bản: ");
        int namXuatBan = sc.nextInt();

        System.out.print("Nhập đơn giá: ");
        double donGia = sc.nextDouble();

        System.out.print("Nhập số lượng: ");
        int soLuong = sc.nextInt();

        // ===== TUẦN 4 - Bài 1: Kiểm tra hợp lệ =====
        boolean hopLe = true;
        if (donGia <= 0) {
            System.out.println("Lỗi: đơn giá phải lớn hơn 0.");
            hopLe = false;
        }
        if (soLuong < 0) {
            System.out.println("Lỗi: số lượng phải lớn hơn hoặc bằng 0.");
            hopLe = false;
        }
        if (namXuatBan < 1900 || namXuatBan > 2026) {
            System.out.println("Lỗi: năm xuất bản không hợp lệ (1900 - 2026).");
            hopLe = false;
        }
        if (!hopLe) {
            System.out.println("Sách không hợp lệ, chương trình dừng.");
            sc.close();
            return;
        }
        System.out.println("=> Sách hợp lệ.");

        // ===== TUẦN 3: Tính tiền =====
        double thanhTien = donGia * soLuong;
        double phiVanChuyen = thanhTien * 0.05;
        double tongTienNhap = thanhTien + phiVanChuyen;

        // ===== TUẦN 4 - Bài 2: Phân loại giá =====
        String loaiGia;
        if (donGia < 50000) {
            loaiGia = "Sách giá thấp";
        } else if (donGia <= 100000) {
            loaiGia = "Sách giá trung bình";
        } else if (donGia <= 200000) {
            loaiGia = "Sách giá cao";
        } else {
            loaiGia = "Sách giá đặc biệt";
        }

        // ===== TUẦN 4 - Bài 3: Phân loại tồn kho =====
        String tinhTrangKho;
        if (soLuong == 0) {
            tinhTrangKho = "Hết sách";
        } else if (soLuong <= 5) {
            tinhTrangKho = "Sắp hết";
        } else if (soLuong <= 20) {
            tinhTrangKho = "Còn ít";
        } else {
            tinhTrangKho = "Còn nhiều";
        }

        // ===== TUẦN 4 - Bài 4: switch chọn loại sách =====
        System.out.println("\nChọn loại sách:");
        System.out.println("1. Sách giáo khoa");
        System.out.println("2. Sách tham khảo");
        System.out.println("3. Sách chuyên ngành");
        System.out.println("4. Sách khác");
        System.out.print("Nhập lựa chọn (1-4): ");
        int chon = sc.nextInt();

        String loaiSach;
        switch (chon) {
            case 1:
                loaiSach = "Sách giáo khoa";
                break;
            case 2:
                loaiSach = "Sách tham khảo";
                break;
            case 3:
                loaiSach = "Sách chuyên ngành";
                break;
            case 4:
                loaiSach = "Sách khác";
                break;
            default:
                loaiSach = "Không xác định (lựa chọn không hợp lệ)";
        }

        // ===== Hiển thị kết quả =====
        System.out.println("\n===== THÔNG TIN SÁCH =====");
        System.out.println("Mã sách       : " + maSach);
        System.out.println("Tên sách      : " + tenSach);
        System.out.println("Tác giả       : " + tacGia);
        System.out.println("Năm xuất bản  : " + namXuatBan);
        System.out.printf("Đơn giá       : %,.0f VNĐ%n", donGia);
        System.out.println("Số lượng      : " + soLuong);
        System.out.printf("Thành tiền    : %,.0f VNĐ%n", thanhTien);
        System.out.printf("Phí vận chuyển: %,.0f VNĐ%n", phiVanChuyen);
        System.out.printf("Tổng tiền nhập: %,.0f VNĐ%n", tongTienNhap);
        System.out.println("Phân loại giá : " + loaiGia);
        System.out.println("Tình trạng kho: " + tinhTrangKho);
        System.out.println("Loại sách     : " + loaiSach);

        sc.close();
    }
}
