import java.util.Scanner;

public class BTT5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Bài 1: Nhập n sách bằng vòng lặp
        int n;
        do {
            System.out.print("Nhập số lượng sách n (n > 0): ");
            n = sc.nextInt();
            if (n <= 0) {
                System.out.println("n phải lớn hơn 0, vui lòng nhập lại.");
            }
        } while (n <= 0);
        sc.nextLine(); // bỏ ký tự xuống dòng còn sót

        String[] maSach = new String[n];
        String[] tenSach = new String[n];
        double[] donGia = new double[n];
        int[] soLuong = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhập sách thứ " + (i + 1) + " ---");
            System.out.print("Mã sách: ");
            maSach[i] = sc.nextLine();
            System.out.print("Tên sách: ");
            tenSach[i] = sc.nextLine();
            System.out.print("Đơn giá: ");
            donGia[i] = sc.nextDouble();
            System.out.print("Số lượng: ");
            soLuong[i] = sc.nextInt();
            sc.nextLine();
        }

        // Bài 2: Tính tổng số lượng và tổng giá trị
        int tongSoLuong = 0;
        double tongGiaTri = 0;
        for (int i = 0; i < n; i++) {
            tongSoLuong += soLuong[i];
            tongGiaTri += donGia[i] * soLuong[i];
        }
        System.out.println("\n===== THỐNG KÊ =====");
        System.out.println("Tổng số lượng: " + tongSoLuong);
        System.out.printf("Tổng giá trị : %,.0f VNĐ%n", tongGiaTri);

        // Bài 3 + Bài 4: Menu lặp đến khi chọn Thoát
        int chon;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Hiển thị danh sách sách");
            System.out.println("2. Tìm sách theo mã");
            System.out.println("3. Hiển thị tổng số lượng và tổng giá trị");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    System.out.println("\n--- DANH SÁCH SÁCH ---");
                    for (int i = 0; i < n; i++) {
                        System.out.printf("%d. %s | %s | %,.0f VNĐ | SL: %d%n",
                                i + 1, maSach[i], tenSach[i], donGia[i], soLuong[i]);
                    }
                    break;
                case 2:
                    // Bài 4: Tìm sách theo mã
                    System.out.print("Nhập mã sách cần tìm: ");
                    String ma = sc.nextLine();
                    boolean timThay = false;
                    for (int i = 0; i < n; i++) {
                        if (maSach[i].equalsIgnoreCase(ma)) {
                            System.out.println("Đã tìm thấy:");
                            System.out.printf("%s | %s | %,.0f VNĐ | SL: %d%n",
                                    maSach[i], tenSach[i], donGia[i], soLuong[i]);
                            timThay = true;
                            break;
                        }
                    }
                    if (!timThay) {
                        System.out.println("Không tìm thấy sách có mã " + ma);
                    }
                    break;
                case 3:
                    System.out.println("Tổng số lượng: " + tongSoLuong);
                    System.out.printf("Tổng giá trị : %,.0f VNĐ%n", tongGiaTri);
                    break;
                case 0:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
            }
        } while (chon != 0);

        sc.close();
    }
}