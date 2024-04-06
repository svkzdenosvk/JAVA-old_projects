
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PC Zdenko Šnúrik trieda s konštruktormi kontaktov
 *
 */
public class Osoba {

    public String meno;
    public String priezvisko;
    public String cislo;
    public String email;

    public Osoba() {
        String firstName;
        String firstN;
        int pocet2;
        do {
            System.out.println("zadaj krstné meno ");
            Scanner sc = new Scanner(System.in);
            firstN = sc.nextLine();
            firstName = firstN.trim();

            pocet2 = firstName.length();

        } while (pocet2 < 1);

        System.out.println("zadaj priezvisko");
        Scanner vstup = new Scanner(System.in);
        String secondN = vstup.nextLine();
        String secondName = secondN.trim();

        char kontrola = 'q';
        String cislo2;
        do {
            System.out.println("zadaj číslo");

            Scanner vstup1 = new Scanner(System.in);

            String cislo3 = vstup1.nextLine();
            cislo2 = cislo3.trim();

            for (int h = 0; h < cislo2.length(); h++) {
                kontrola = cislo2.charAt(h);
                if (kontrola != ('1') && kontrola != ('2') && kontrola != ('3') && kontrola != ('4') && kontrola != ('5') && kontrola != ('0') && kontrola != ('6') && kontrola != ('7') && kontrola != ('8') && kontrola != ('9') && kontrola != (' ')) {
                    System.out.println("Nezadali ste vhodné číslo, skúste to ešte raz");
                    break;
                }
            }
        } while (kontrola != ('1') && kontrola != ('2') && kontrola != ('3') && kontrola != ('4') && kontrola != ('5') && kontrola != ('0') && kontrola != ('6') && kontrola != ('7') && kontrola != ('8') && kontrola != ('9') && kontrola != (' '));

        System.out.println("zadaj email");
        Scanner vstup2 = new Scanner(System.in);
        String emailN = vstup2.nextLine();
        String email1 = emailN.trim();

        this.meno = firstName;
        this.priezvisko = secondName;
        this.cislo = cislo2;
        this.email = email1;

    }

    public Osoba(String meno, String priezvisko, String cislo, String email) {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.cislo = cislo;
        this.email = email;
    }

    public Osoba(String meno, String cislo) {
        this.meno = meno;
        this.cislo = cislo;

    }

}
