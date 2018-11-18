/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoabinh.xemay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import quanlychung.xemay.QuanLyChung;
import xeco.info.XeMay;
import extension.myExtension.MyExtension;

/**
 *
 * @author black
 */
public class XeMayHoaBinh extends XeMay {

    int n;
    ArrayList<XeMayHoaBinh> DanhSachXeMayHB = new ArrayList<>();

    public XeMayHoaBinh() {
    }

    public XeMayHoaBinh(String bienso, String loaixe, String mauxe, float giatien) {
        super(bienso, loaixe, mauxe, giatien);
    }

    @Override
    public void nhap() {
        System.out.print("Nhập vào số lượng xe máy tỉnh hòa bình mà bạn cần nhập: ");
        Scanner input = new Scanner(System.in);
        n = (int)MyExtension.numberFormat(QuanLyChung.OptionFormat.INTEGER);
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
            DanhSachXeMayHB.add(new XeMayHoaBinh(bienso, loaixe, mauxe, giatien));
        }
    }

    @Override
    public void hienthi() {
        int size = totalNumber();
        if (size == 0) {
            System.out.println("Hiện tại không có xe máy nào của tỉnh Hòa Bình được quản lý!");
        } else {
            System.out.printf("Danh sách xe máy Hòa Bình: (%d xe)\n", size);
            for (int i = 0; i < size; i++) {
                System.out.printf("Thông tin xe máy thứ %d:\n", i + 1);
                QuanLyChung.displayXeMay(DanhSachXeMayHB.get(i));
            }
        }
    }

    public void sortByNumber() {
        Collections.sort(DanhSachXeMayHB, (XeMayHoaBinh o1, XeMayHoaBinh o2) -> o1.getBienso().compareTo(o2.getBienso()));
    }

    public XeMayHoaBinh findByNumber(String bienso) {
        for (XeMayHoaBinh xemayHB : DanhSachXeMayHB) {
            if (xemayHB.getBienso().equals(bienso)) {
                return xemayHB;
            }
        }
        return null;
    }

    public int totalNumber() {
        return DanhSachXeMayHB.size();
    }
}
