/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jancispojeny;

import java.util.Scanner;

/**
 *
 * @author PC Zdenko Šnúrik
 *
 * táto trieda je určená na výpočty :
 * -počíta sucinitiel prechodu tepla otvorovej konstrukcie 
 * -vykurovanie priestoru na teréne
 *
 * možnosť (potreba) ošetrania vstupov na číselný zápis (príp. záporné hodnoty
 * možnosť rozšíriť o ďalšie výpočty
 */
public class VypoctyAVzorce {

    public void sucinitielPrechoduTeplaOtvorovejKonstrukcie() {
        System.out.println("\nNezabudni, že desatinné čísla treba písať s bodkou, napríklad \"0.0000009\"\n ");

        double Ug;
        System.out.println("zadaj Ug ");
        Scanner vstup = new Scanner(System.in);                                 //neošetrené na číselný vstup + na slovenský zápis desatinného čísla
        String cislo3 = vstup.nextLine();
        String cislo2 = cislo3.trim();
        Ug = Double.parseDouble(cislo2);

        double Uf;
        System.out.println("zadaj Uf ");

        Scanner vstup1 = new Scanner(System.in);                                 //neošetrené na číselný vstup + na slovenský zápis desatinného čísla
        String cislo31 = vstup1.nextLine();
        String cislo21 = cislo31.trim();
        Uf = Double.parseDouble(cislo21);

        double Psi;

        System.out.println("zadaj Psi ");
        Scanner vstup11 = new Scanner(System.in);                                 //neošetrené na číselný vstup + na slovenský zápis desatinného čísla
        String cislo311 = vstup11.nextLine();
        String cislo211 = cislo311.trim();
        Psi = Double.parseDouble(cislo211);

        double b;
        System.out.println("zadaj b ");
        Scanner vstup111 = new Scanner(System.in);                                 //neošetrené na číselný vstup + na slovenský zápis desatinného čísla
        String cislo3111 = vstup111.nextLine();
        String cislo2111 = cislo3111.trim();
        b = Double.parseDouble(cislo2111);

        double h;
        System.out.println("zadaj h ");
        Scanner vstup1111 = new Scanner(System.in);                                 //neošetrené na číselný vstup + na slovenský zápis desatinného čísla
        String cislo31111 = vstup1111.nextLine();
        String cislo21111 = cislo31111.trim();
        h = Double.parseDouble(cislo21111);

        double d;

        System.out.println("zadaj d ");
        Scanner vstup11111 = new Scanner(System.in);                                //neošetrené na číselný vstup + na slovenský zápis desatinného čísla
        String cislo311111 = vstup11111.nextLine();
        String cislo211111 = cislo311111.trim();
        d = Double.parseDouble(cislo211111);

        double Af = h * d * 2 + ((b - 2 * d) * d) * 2;
        double A = b * h;
        double Lg = 2 * (h - 2 * d) + 2 * (b - 2 * d);
        double Ag = A - Af;
        double Uw = (Ug * Ag + Uf * Af + Lg * Psi) / A;

        System.out.println("Uw sa rovná " + Uw);

    }

    public void /*double*/ vykurovaniePriestoruNaTerene() {
        System.out.println("Nezabudni, že desatinné čísla treba písať s bodkou, napríklad \"0.0000009\"\n ");

        double A;
        System.out.println("zadaj - Plocha podlahy bez obv. stien - A: (m2):   ");
        Scanner vstup = new Scanner(System.in);                                 //neošetrené na číselný vstup + na slovenský zápis desatinného čísla
        String cislo3 = vstup.nextLine();
        String cislo2 = cislo3.trim();
        A = Double.parseDouble(cislo2);

        double P;
        System.out.println("zadaj - Obvod podlahy bez obv. stien - P: (m):  ");

        Scanner vstup1 = new Scanner(System.in);                                //neošetrené na číselný vstup + na slovenský zápis desatinného čísla
        String cislo31 = vstup1.nextLine();
        String cislo21 = cislo31.trim();
        P = Double.parseDouble(cislo21);

        double w;

        System.out.println("zadaj - Hrúbka obvodovej steny - w: (m):  ");
        Scanner vstup11 = new Scanner(System.in);                                 //neošetrené na číselný vstup + na slovenský zápis desatinného čísla
        String cislo311 = vstup11.nextLine();
        String cislo211 = cislo311.trim();
        w = Double.parseDouble(cislo211);

        double lambda;
        System.out.println("zadaj - Súč. tepelnej vodivosti zeminy - Lambda: (W/(m.K):  ");
        Scanner vstup111 = new Scanner(System.in);                                 //neošetrené na číselný vstup + na slovenský zápis desatinného čísla
        String cislo3111 = vstup111.nextLine();
        String cislo2111 = cislo3111.trim();
        lambda = Double.parseDouble(cislo2111);

        double Rf;
        System.out.println("zadaj - Tepelný odpor konštrukcie - Rf: (m2.K/W):  ");
        Scanner vstup1111 = new Scanner(System.in);                                 //neošetrené na číselný vstup + na slovenský zápis desatinného čísla
        String cislo31111 = vstup1111.nextLine();
        String cislo21111 = cislo31111.trim();
        Rf = Double.parseDouble(cislo21111);

        double Rsi;

        System.out.println("zadaj - Tepelný odpor pri prestupe tepla v interiéri - Rsi:  (m2.K/W):  ");
        Scanner vstup11111 = new Scanner(System.in);                                 //neošetrené na číselný vstup + na slovenský zápis desatinného čísla
        String cislo311111 = vstup11111.nextLine();
        String cislo211111 = cislo311111.trim();
        Rsi = Double.parseDouble(cislo211111);

        double Rse;

        System.out.println("zadaj - Tepelný odpor pri prestupe tepla v exteriéri - Rse:  (m2.K/W):  ");
        Scanner vstup111111 = new Scanner(System.in);                                 //neošetrené na číselný vstup + na slovenský zápis desatinného čísla
        String cislo3111111 = vstup111111.nextLine();
        String cislo2111118 = cislo3111111.trim();
        Rse = Double.parseDouble(cislo2111118);
        
        
        double B=0;
        try{
        B = A / (P * 0.5);
        System.out.println("B´ - charakteristický rozmer podlahy sa rovná : " + B + "m");
        }catch(Exception e){
        System.out.println("Obvod podlahy sa rovná nule, čiže výraz(P * 0.5) sa rovná nule a nulou nie je možné deliť!!! ");
        }
        
        double dt;
        dt = w + lambda * (Rf + Rsi + Rse);
        System.out.println("dt - ekvivalentná hrúbka podlahy  sa rovná : " + dt + "m");

        if (dt < B) {
            System.out.println("dt < B´");
        }
        if (dt > B) {
            System.out.println("dt > B´");
        }

        double U0;
        U0 = ((2 * lambda) / (3.14 * B + dt)) * Math.log((3.14 * B / dt) + 1);
        System.out.println("U0 - súčiniteľ prechodu tepla   sa rovná : " + U0 + "W/(m2.K)");

    }

    public void ukoncitProgram() {
        System.out.println("Program sa ukončuje, dúfam, že Ti program pomohol");

        System.exit(0);
       
    }
}
      
      

