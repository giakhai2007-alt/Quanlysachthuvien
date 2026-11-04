import java.util.ArrayList;
import java.util.Scanner;

public class BTT5 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        bai1();
        bai2();
        bai3va4();
        sc.close();
    }

    // Bài 1: Mảng int[] soLuong, nhập 5 cuốn
    static void bai1() {
        System.out.println("===== BÀI 1: MẢNG SỐ LƯỢNG =====");
        int[] soLuong = new int[5];
        for (int i = 0; i < soLuong.length; i++) {
            System.out.print("Nhập số lượng cuốn sách " + (i + 1) + ": ");
            soLuong[i] = sc.nextInt();
        }
        int tong = 0;
        int max = soLuong[0];
        System.out.println("Các số lượng đã nhập:");
        for (int sl : soLuong) {
            System.out.println(sl);
            tong += sl;
            if (sl > max) {
                max = sl;
            }
        }
        System.out.println("Tổng số lượng: " + tong);
        System.out.println("Số lượng lớn nhất: " + max);
        sc.nextLine();
    }

    // Bài 2: ArrayList<String> lưu mã sách: thêm, hiển thị, tìm, xóa
    static void bai2() {
        System.out.println("\n===== BÀI 2: ARRAYLIST MÃ SÁCH =====");
        ArrayList<String> dsMa = new ArrayList<>();
        int chon;
        do {
            System.out.println("\n1. Thêm mã  2. Hiển thị  3. Tìm  4. Xóa  0. Sang bài 3");
            System.out.print("Chọn: ");
            chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    System.out.print("Nhập mã sách: ");
                    dsMa.add(sc.nextLine());
                    break;
                case 2:
                    if (dsMa.isEmpty()) {
                        System.out.println("Danh sách trống.");
                    }
                    for (int i = 0; i < dsMa.size(); i++) {
                        System.out.println((i + 1) + ". " + dsMa.get(i));
                    }
                    break;
                case 3:
                    System.out.print("Nhập mã cần tìm: ");
                    String ma = sc.nextLine();
                    if (dsMa.contains(ma)) {
                        System.out.println("Tìm thấy ở vị trí " + (dsMa.indexOf(ma) + 1));
                    } else {
                        System.out.println("Không tìm thấy.");
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã cần xóa: ");
                    String maXoa = sc.nextLine();
                    if (dsMa.remove(maXoa)) {
                        System.out.println("Đã xóa.");
                    } else {
                        System.out.println("Không có mã này để xóa.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (chon != 0);
    }

    // Bài 3 + 4: Quản lý sách bằng ArrayList<String> và menu hoàn chỉnh
    // Mỗi phần tử là một chuỗi: "mã | tên | đơn giá | số lượng"
    static void bai3va4() {
        System.out.println("\n===== BÀI 3 + 4: QUẢN LÝ SÁCH =====");
        ArrayList<String> danhSachSach = new ArrayList<>();
        int chon;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm sách");
            System.out.println("2. Hiển thị sách");
            System.out.println("3. Tìm sách");
            System.out.println("4. Xóa sách");
            System.out.println("5. Sửa sách");
            System.out.println("6. Tính tổng số lượng");
            System.out.println("7. Tính tổng giá trị");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    danhSachSach.add(nhapSach());
                    System.out.println("Đã thêm sách.");
                    break;
                case 2:
                    if (danhSachSach.isEmpty()) {
                        System.out.println("Danh sách trống.");
                    }
                    for (int i = 0; i < danhSachSach.size(); i++) {
                        System.out.println((i + 1) + ". " + danhSachSach.get(i));
                    }
                    break;
                case 3:
                    System.out.print("Nhập mã sách cần tìm: ");
                    int viTri = timViTri(danhSachSach, sc.nextLine());
                    if (viTri >= 0) {
                        System.out.println("Tìm thấy: " + danhSachSach.get(viTri));
                    } else {
                        System.out.println("Không tìm thấy.");
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã sách cần xóa: ");
                    int viTriXoa = timViTri(danhSachSach, sc.nextLine());
                    if (viTriXoa >= 0) {
                        danhSachSach.remove(viTriXoa);
                        System.out.println("Đã xóa.");
                    } else {
                        System.out.println("Không tìm thấy.");
                    }
                    break;
                case 5:
                    System.out.print("Nhập mã sách cần sửa: ");
                    int viTriSua = timViTri(danhSachSach, sc.nextLine());
                    if (viTriSua >= 0) {
                        System.out.println("Nhập thông tin mới:");
                        danhSachSach.set(viTriSua, nhapSach());
                        System.out.println("Đã sửa.");
                    } else {
                        System.out.println("Không tìm thấy.");
                    }
                    break;
                case 6:
                    int tongSL = 0;
                    for (String s : danhSachSach) {
                        tongSL += Integer.parseInt(s.split("\\|")[3].trim());
                    }
                    System.out.println("Tổng số lượng: " + tongSL);
                    break;
                case 7:
                    double tongGT = 0;
                    for (String s : danhSachSach) {
                        String[] p = s.split("\\|");
                        tongGT += Double.parseDouble(p[2].trim()) * Integer.parseInt(p[3].trim());
                    }
                    System.out.printf("Tổng giá trị: %,.0f VNĐ%n", tongGT);
                    break;
                case 8:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (chon != 8);
    }

    static String nhapSach() {
        System.out.print("Mã sách: ");
        String ma = sc.nextLine();
        System.out.print("Tên sách: ");
        String ten = sc.nextLine();
        System.out.print("Đơn giá: ");
        double gia = sc.nextDouble();
        System.out.print("Số lượng: ");
        int sl = sc.nextInt();
        sc.nextLine();
        return ma + " | " + ten + " | " + (long) gia + " | " + sl;
    }

    static int timViTri(ArrayList<String> ds, String ma) {
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).split("\\|")[0].trim().equalsIgnoreCase(ma)) {
                return i;
            }
        }
        return -1;
    }
}