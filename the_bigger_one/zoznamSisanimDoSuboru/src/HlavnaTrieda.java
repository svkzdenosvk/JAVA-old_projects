
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PC Zdenko Šnúrik
 *
 * program na začiatku načíta kontakty (meno, priezvisko, číslo, email), pričom
 * subor musi byť v požadovanom tvare : -na začiatku v1 (ako verzia 1, spôsobov
 * uloženia môže byť v buducnosti viac) -pod tým počet kontaktov 
 * pod tým samotné
 * kontakty pričom údaje meno a číslo sú povinné program na začiatku automaticky
 * načíta kontakty, pokial je subor v pozadovanom tvare, pokiaľ nie nenačíta
 *
 * toto je hlavná trieda programu
 *
 */
public class HlavnaTrieda {

    public static void main(String ards[]) throws IOException {
        System.out.println("Vitajte v programe.");
        //String dokument = "C:\\Users\\PC\\Desktop\\Zoznam.txt";
      String dokument ="dokument_so_zoznamom\\Zoznam.txt";
        Osoba[] pole = new Osoba[100];
        MetodyvZozname MvZ = new MetodyvZozname();
        try {
            pole = MvZ.nacitaj(dokument);
        } catch (Exception e) {
            System.out.println("Pravdepodobne bude chyba v ceste k súbu z ktorého sa koontakty majú načítať");
        }
        char q = 0;
        boolean anoNie;
        do {
            int pocet = 0;

            do {
                System.out.println("\n\nVyberte  polozku:\n  1 - výpis konktatov\n  2 - pridat kontakt\n  3 - odobrat kontakt\n  4 - upravit kontakt\n  5 - uložit konktat\n  6 - skoncit program\n\nZadaj volbu: ");

                Scanner vstup = new Scanner(System.in);
                try {
                    pocet = vstup.nextInt();
                } catch (Exception e) {
                    System.out.println("Nezadali ste celé číslo, skúste to ešte raz");
                };

            } while ((pocet > 6) || (pocet < 1));

            switch (pocet) {
                case 1:
                    MvZ.vypisKontaktov(pole);
                    break;
                case 2:
                    pole = MvZ.pridajKontakt(pole);
                    break;
                case 3:
                    pole = MvZ.odobratKontakt(pole);
                    break;
                case 4:
                    pole = MvZ.upravitKontakt(pole);
                    break;

                case 5:
                    MvZ.ulozitProgram(pole);

                    break;

                case 6:
                    MvZ.ukoncitProgram(pole);
                    break;

            }

        } while (q != 5);

    }
}
