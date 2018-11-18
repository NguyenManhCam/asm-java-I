/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlychung.xemay;

import hoabinh.xemay.XeMayHoaBinh;
import hanoi.xemay.XeMayHaNoi;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import xeco.info.XeMay;
import extension.myExtension.MyExtension;

/**
 *
 * @author black
 */
public class QuanLyChung {

    static Scanner input = new Scanner(System.in);
    static XeMayHaNoi xemayHN = new XeMayHaNoi();
    static XeMayHoaBinh xemayHB = new XeMayHoaBinh();
    static boolean isExit = false;

    public static void Choice() {
        do {
            String optionString = input.nextLine();
            int optionInt = 0;
            try {
                optionInt = Integer.parseInt(optionString);
            } catch (NumberFormatException e) {
//                System.out.printf("Exception: %s\n", e.getMessage());
            }
            switch (optionInt) {
                case 1:
                    case1(xemayHB);
                    break;
                case 2:
                    case2(xemayHN);
                    break;
                case 3:
                    case3(xemayHB, xemayHN);
                    break;
                case 4:
                    case4(xemayHB, xemayHN);
                    break;
                case 5:
                    case5(xemayHB, xemayHN);
                    break;
                case 6:
                    case6();
                    break;
                default:
                    System.out.print("Vui lòng nhập lại tùy chọn từ 1-6: ");
            }

        } while (!isExit);
    }

    public static void displayMenu() {
        System.out.println("1. Nhập thông tin cho n xe máy tại tỉnh Hòa Bình.");
        System.out.println("2. Nhập thông tin cho n xe máy tại tỉnh Hà Nội.");
        System.out.println("3. Sắp xếp danh sách tăng theo biển số xe.");
        System.out.println("4. Tìm kiếm thông tin xe theo biển số xe.");
        System.out.println("5. Thống kê số lượng xe đang quản lý.");
        System.out.println("6. Thoát");
        System.out.print("Tùy chọn: ");
    }

    public static void displayXeMay(XeMay xemay) {
        Locale locale = new Locale("vi", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        System.out.printf("Biển số xe: %s, ", xemay.getBienso());
        System.out.printf("Loại xe: %s, ", xemay.getLoaixe());
        System.out.printf("Màu xe: %s, ", xemay.getMauxe());
        System.out.printf("Giá tiền: %s\n", currencyFormatter.format(xemay.getGiatien()));
    }

    private static void case1(XeMayHoaBinh xemayHB) {
        xemayHB.nhap();
        MyExtension.pressAnyKeyToContinue();
        displayMenu();
    }

    private static void case2(XeMayHaNoi xemayHN) {
        xemayHN.nhap();
        MyExtension.pressAnyKeyToContinue();
        displayMenu();
    }

    private static void case3(XeMayHoaBinh xemayHB, XeMayHaNoi xemayHN) {
        if (xemayHB.totalNumber() > 0 | xemayHN.totalNumber() > 0) {
            System.out.println("Trước khi sắp xếp:");
            xemayHB.hienthi();
            xemayHN.hienthi();
            xemayHB.sortByNumber();
            xemayHN.sortByNumber();
            System.out.println("Sau khi sắp xếp:");
            xemayHB.hienthi();
            xemayHN.hienthi();
        } else {
            System.out.println("Hiện tại chưa có danh sách xe để sắp xếp!");
        }
        MyExtension.pressAnyKeyToContinue();
        displayMenu();
    }

    private static void case4(XeMayHoaBinh xemayHB, XeMayHaNoi xemayHN) {
        if (xemayHB.totalNumber() > 0 | xemayHN.totalNumber() > 0) {
            System.out.print("Nhập biển số xe cần tìm: ");
            String bienso = input.nextLine();
            XeMayHoaBinh o1 = xemayHB.findByNumber(bienso);
            if (o1 == null) {
                XeMayHaNoi o2 = xemayHN.findByNumber(bienso);
                if (o2 == null) {
                    System.out.println("Không tìm thấy xe nào!");
                } else {
                    System.out.println("Thấy 1 xe của Hà Nội:");
                    displayXeMay(o2);
                }
            } else {
                System.out.println("Thấy 1 xe của Hòa Bình:");
                displayXeMay(o1);
            }
        } else {
            System.out.println("Hiện tại chưa có danh sách xe để tìm kiếm!");
        }
        MyExtension.pressAnyKeyToContinue();
        displayMenu();
    }

    private static void case5(XeMayHoaBinh xemayHB, XeMayHaNoi xemayHN) {
        if (xemayHB.totalNumber() > 0 | xemayHN.totalNumber() > 0) {
            System.out.printf("Đang quản lý %d xe máy tại Hà Nội\n", xemayHN.totalNumber());
            System.out.printf("Đang quản lý %d xe máy tại Hòa Bình\n", xemayHB.totalNumber());
            System.out.println("Bạn có muốn xem danh sách xe máy không?");
            int answer = MyExtension.doWhileYN();
            switch (answer) {
                case 0:
                    xemayHN.hienthi();
                    xemayHB.hienthi();
                    MyExtension.pressAnyKeyToContinue();
                    displayMenu();
                    break;
                case 1:
                    displayMenu();
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("Hiện tại chưa có xe nào được quản lý!");
        }
    }

    private static void case6() {
        System.out.println("Bạn có thực sự muốn thoát không?");
        int answer = MyExtension.doWhileYN();
        switch (answer) {
            case 0:
                System.out.println("Exited!");
                isExit = true;
                break;
            case 1:
                displayMenu();
                break;
            default:
                break;
        }
    }

    public static enum OptionFormat {
        INTEGER, FLOAT, DOUBLE;
    }
}
