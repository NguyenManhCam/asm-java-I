/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoi.xemay;

import extension.myExtension.MyExtension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import quanlychung.xemay.QuanLyChung;
import xeco.info.XeMay;

/**
 *
 * @author black
 */
public class XeMayHaNoi extends XeMay {

    int n;
    ArrayList<XeMayHaNoi> DanhSachXeMayHN = new ArrayList<>();

    public XeMayHaNoi() {
    }

    public XeMayHaNoi(String bienso, String loaixe, String mauxe, float giatien) {
        super(bienso, loaixe, mauxe, giatien);
    }

    @Override
    public void nhap() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập vào số lượng xe máy thành phố Hà Nội mà bạn cần nhập: ");
        boolean isLoop1 = false;
        do {
            try {
                if (isLoop1) {
                    System.out.print("Nhập lại: ");
                }
                n = (int)MyExtension.numberFormat(QuanLyChung.OptionFormat.INTEGER);
                isLoop1 = false;
            } catch (NumberFormatException e) {
                System.out.println("Bạn phải nhập vào một số tự nhiên!");
                isLoop1 = true;
            }
        } while (isLoop1);

        for (int i = 0; i < n; i++) {
            System.out.printf("Nhập vào thông tin của xe máy thứ %d:\n", i + 1);
            System.out.print("Biển số: ");
            String bienso = input.nextLine();
            System.out.print("Loại xe: ");
            String loaixe = input.nextLine();
            System.out.print("Màu xe: ");
            String mauxe = input.nextLine();
            System.out.print("Giá tiền: ");
            float giatien = (float)MyExtension.numberFormat(QuanLyChung.OptionFormat.FLOAT);
            DanhSachXeMayHN.add(new XeMayHaNoi(bienso, loaixe, mauxe, giatien));
        }
    }

    @Override
    public void hienthi() {
        int size = totalNumber();
        if (size == 0) {
            System.out.println("Hiện tại không có xe máy nào của thủ đô Hà Nội được quản lý!");
        } else {
            System.out.printf("Danh sách xe máy Hà Nội: (%d xe)\n", size);
            for (int i = 0; i < size; i++) {
                System.out.printf("Thông tin xe máy thứ %d:\n", i + 1);
                QuanLyChung.displayXeMay(DanhSachXeMayHN.get(i));
            }
        }
    }

    public void sortByNumber() {
        Collections.sort(DanhSachXeMayHN, (XeMayHaNoi o1, XeMayHaNoi o2) -> o1.getBienso().compareTo(o2.getBienso()));
    }

    public XeMayHaNoi findByNumber(String bienso) {
        for (XeMayHaNoi xemayHN : DanhSachXeMayHN) {
            if (xemayHN.getBienso().equals(bienso)) {
                return xemayHN;
            }
        }
        return null;
    }

    public int totalNumber() {
        return DanhSachXeMayHN.size();
    }
}
