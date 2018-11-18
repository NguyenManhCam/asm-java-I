/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extension.myExtension;

import java.io.IOException;
import java.util.Scanner;
import quanlychung.xemay.QuanLyChung;

/**
 *
 * @author black
 */
public class MyExtension {

    static Scanner input = new Scanner(System.in);

    public static void pressAnyKeyToContinue() {
        System.out.println("Nhấn phím bất kỳ để tiếp tục...");
        try {
            System.in.read();
        } catch (IOException e) {
            System.out.printf("Exception: %s\n", e.getMessage());
        }
    }

    public static int doWhileYN() {
        System.out.print("Nhấn Y/y nếu có, N/n nếu không: ");
        boolean isLoop;
        do {
            char answer = input.next().charAt(0);
            switch (Character.toLowerCase(answer)) {
                case 'y':
                    return 0;
                case 'n':
                    return 1;
                default:
                    isLoop = true;
                    System.out.print("Nhập lại: ");
                    break;
            }
        } while (isLoop);
        return -1;
    }

    public static Number numberFormat(QuanLyChung.OptionFormat option) {
//        OptionFormat optionFormat = OptionFormat.values()[option];
        boolean isLoop = false;
        do {
            String inputString = input.nextLine();
            try {
                switch (option) {
                    case INTEGER:
                        return Integer.parseInt(inputString);
                    case FLOAT:
                        return Float.parseFloat(inputString);
                    case DOUBLE:
                        return Double.parseDouble(inputString);
                    default:
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.printf("Bạn cần nhập vào đúng kiểu dữ liệu %s!\n", option);
                isLoop = true;
                System.out.print("Nhập lại: ");
            }
        } while (isLoop);
        return null;
    }
}
