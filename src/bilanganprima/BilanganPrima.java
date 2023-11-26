/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bilanganprima;

import java.util.Scanner;

/**
 *
 * @author muhammadrydwan
 */
public class BilanganPrima {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner input = new Scanner(System.in);

        boolean isProgramRunning = true;

        while (isProgramRunning) {
            try {
                System.out.print("Input sebuah angka bulat: ");
                int angka = input.nextInt();

                if (angka > 1 && isPrimeNumber(angka)) {
                    System.out.println(angka + " adalah bilangan prima");
                } else {
                    System.out.println(angka + " bukan angka prima karena bisa dibagi " + factorsOtherThanOneAndItself(angka));
                }

                // Prompt untuk mengulangi program
                boolean promptRestartProgram = true;
                while (promptRestartProgram) {
                    try {
                        System.out.println("Jalankan kembali program? (y/n): ");
                        String inputUser = input.next(); // Menggunakan next() agar hanya membaca satu kata
                        if (inputUser.equalsIgnoreCase("y")) {
                            promptRestartProgram = false;
                        } else if (inputUser.equalsIgnoreCase("n")) {
                            promptRestartProgram = false;
                            isProgramRunning = false;
                        } else {
                            System.out.println("Pilihan tidak valid. Masukkan 'y' untuk ya atau 'n' untuk tidak.");
                        }
                    } catch (Exception e) {
                        System.out.println("Input tidak valid");
                        input.nextLine(); 
                    }
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Input harus berupa angka bulat. Silahkan coba lagi.");
                input.nextLine();
            }
        }
        input.close();
    }
    
    // Method untuk memeriksa apakah suatu angka adalah bilangan prima
    private static boolean isPrimeNumber(int angka) {
        for (int i = 2; i <= Math.sqrt(angka); i++) {
            if (angka % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Method untuk mendapatkan faktor selain 1 dan dirinya sendiri
    private static String factorsOtherThanOneAndItself(int angka) {
        StringBuilder faktor = new StringBuilder();

        /**
         * Loop dimulai dari 2 (karena faktor 1 tidak dimasukkan) hingga setengah dari nilai angka.
         * Karena tidak mungkin ada faktor yang lebih besar dari setengah dari nilai angka, kecuali angka itu sendiri.
         */
        for (int i = 2; i <= angka / 2; i++) {
            if (angka % i == 0) {
                faktor.append(i).append(", ");
            }
        }

        if (faktor.length() > 0) {
            faktor.delete(faktor.length() - 2, faktor.length());
            return faktor.toString();
        } else {
            return "Tidak ada faktor selain 1 dan " + angka;
        }
    }
    
}
