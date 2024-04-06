
import java.util.Scanner;
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Exception;
import java.lang.Error;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PC Zdenko Šnúrik
 *
 * táto trieda obsahuje metódy využívné hlavnou triedou
 */
public class MetodyvZozname {

    public int nacitajPocetKontaktov(Osoba[] pole) {
        int pocetKontaktov = 0;
        for (int i = 0; i < pole.length; i++) {
            if (pole[i] == null) {
                continue;
            }
            pocetKontaktov += 1;
        }
        return pocetKontaktov;
    }

    public Osoba[] nacitaj(String dokument) {
        Osoba[] pole2 = new Osoba[100];
        Osoba[] pole9 = new Osoba[100];
        boolean ide = true;

        int k = 0;
        try {
            BufferedReader in = new BufferedReader(new FileReader(dokument));
            String str;

            str = in.readLine();

            if (str.trim().equalsIgnoreCase("v1")) {
                str = in.readLine();
                char kontrola = 'q';
                if (str.trim().charAt(0) == ('0') | str.trim().charAt(0) == ('1') | str.trim().charAt(0) == '2' | str.trim().charAt(0) == '3' | str.trim().charAt(0) == '4' | str.trim().charAt(0) == '5' | str.trim().charAt(0) == '6' | str.trim().charAt(0) == '7' | str.trim().charAt(0) == '8' | str.trim().charAt(0) == '9') {
                    String str2 = str.trim();

                    for (int h = 0; h < str2.length(); h++) {
                        kontrola = str2.charAt(h);
                        if (kontrola != ('1') && kontrola != ('2') && kontrola != ('3') && kontrola != ('4') && kontrola != ('5') && kontrola != ('0') && kontrola != ('6') && kontrola != ('7') && kontrola != ('8') && kontrola != ('9')) {
                            System.out.println("Počet kontaktov nie je zobrazené v adekvátnej podobe, preto program nenačíta kontakty");
                            Osoba[] pole3 = new Osoba[100];
                            return pole3;

                        }

                    }
                    int porovnania = Integer.parseInt(str2);
                    while ((str = in.readLine()) != null) {

                        if (str.indexOf("|") == -1) {
                            continue;
                        }

                        int velkost = 4;

                        String[] rozdelene = new String[4];

                        String[] rozdelene2 = str.split("[|]");

                        for (int d = 0; d < rozdelene2.length; d++) {
                            rozdelene[d] = rozdelene2[d];
                        }
                        ;
                        if (rozdelene[1] == null) {
                            rozdelene[1] = "";
                        }

                        if (rozdelene[3] == null) {
                            rozdelene[3] = " ";
                        }

                        String meno5;

                        String priezvisko5;
                        String cislo5;
                        String email5;

                        meno5 = rozdelene[0];
                        if (meno5.equalsIgnoreCase("")) {
                            System.out.println("Meno nie je v požadovanom tvare, preto sa súbor nenačíta!");
                            return pole9;
                        }
                        priezvisko5 = rozdelene[1];
                        cislo5 = rozdelene[2];
                        if (cislo5.equalsIgnoreCase("")) {
                            System.out.println("Cislo nie je v požadovanom tvare, preto sa súbor nenačíta!");
                            return pole9;
                        }
                        for (int h = 0; h < cislo5.length(); h++) {
                            kontrola = cislo5.charAt(h);
                            if (kontrola != ('1') && kontrola != ('2') && kontrola != ('3') && kontrola != ('4') && kontrola != ('5') && kontrola != ('0') && kontrola != ('6') && kontrola != ('7') && kontrola != ('8') && kontrola != ('9') && kontrola != (' ')) {
                                System.out.println("Číslo nie je v požadovanom tvare, súbor sa nenačíta");
                                return pole9;
                            }
                        }
                        email5 = rozdelene[3];

                        Osoba pridelovana = new Osoba(meno5, priezvisko5, cislo5, email5);

                        pole2[k] = pridelovana;
                        k += 1;

                    }
                    if (kontrolaPrazdnehoPola(pole2)) {
                        System.out.println("Nenačítali sa žiadne kontakty,pretože subor neobsahoval žiadne kontakty.");
                        return pole9;
                    }
                    int mnozstvo2 = 0;
                    for (int i = 0; i < pole2.length; i++) {
                        if (pole2[i] == null) {
                            continue;
                        }
                        mnozstvo2 += 1;
                    }
                    if (mnozstvo2 != porovnania) {
                        System.out.println("Súbor nie je v požadovanom stave(počet kontaktov nesedí s reálnym počtom), súbor sa nenačítal");
                        return pole9;
                    };
                    return pole2;
                } else {
                    System.out.println("Súbor nie je v požadovanom tvare, nebude načítaný, preto program nenačíta kontakty");
                    Osoba[] pole4 = new Osoba[100];
                    return pole4;
                }
            } else {
                System.out.println("Súbor nie je v požadovanom tvare,  preto program nenačíta kontakty");
                Osoba[] pole5 = new Osoba[100];
                return pole5;
            }
        } catch (IOException e) {
        } catch (Exception f) {
            System.out.println("Kontakty nie sú v požadovanom stave, súbor sa nenačítal");
        } catch (Error r) {
            return pole9;
        }

        return pole9;
    }

    public boolean ulozitProgram(Osoba[] pole) throws IOException {
        try {
            MetodyvZozname MvZ = new MetodyvZozname();

            int mnozstvo = 0;
        //    BufferedWriter out2 = new BufferedWriter(new FileWriter("C:\\Users\\PC\\Desktop\\Zoznam.txt"));
        BufferedWriter out2 = new BufferedWriter(new FileWriter("dokument_so_zoznamom\\Zoznam.txt"));
            out2.write("v1\n");
            for (int i = 0; i < pole.length; i++) {
                if (pole[i] == null) {
                    continue;
                } else {
                    mnozstvo += 1;
                }
            }
            out2.write("" + mnozstvo + "");

            for (int i = 0; i < pole.length; i++) {
                if (pole[i] == null) {
                    continue;
                }
                out2.write("\n" + pole[i].meno + "|" + pole[i].priezvisko + "|" + pole[i].cislo + "|" + pole[i].email);
            }
            out2.flush();
            out2.close();
            System.out.println("Kontakty sa ulozili do súboru.");
        } catch (Exception e) {
            System.out.println("Nastala chyba pri uložení súboru, pravdepodobne bude problém s cestou k nemu, skontroluj kod, alebo vytvor dokument.");
            return false;
        }
        return true;
    }

    public boolean kontrolaPrazdnehoPola(Osoba[] pole) {
        for (int t = 0; t < pole.length; t++) {
            if (pole[t] != null) {
                return false;
            }
        }
        return true;
    }

    public void vypisKontaktov(Osoba[] pole) {
        if (kontrolaPrazdnehoPola(pole)) {
            System.out.println("Zoznam je prázdny.");
        } else {
            System.out.println("V zozname sa nachádzajú nasledovné kontakty :");

            for (int i = 0; i < pole.length; i++) {
                if (pole[i] == null) {
                    continue;
                }
                System.out.println(pole[i].meno + " " + pole[i].priezvisko + " " + pole[i].cislo + " " + pole[i].email);
            }

        }
    }

    public boolean existuje(Osoba[] pole, Osoba z) {

        for (int i = 0; i < pole.length; i++) {
            if (pole[i] == null) {
                continue;
            }
            if ((pole[i].meno.equalsIgnoreCase(z.meno)) && (pole[i].priezvisko.equalsIgnoreCase(z.priezvisko)) && (pole[i].cislo.equalsIgnoreCase(z.cislo)) && (pole[i].email.equalsIgnoreCase(z.email))) {
                return true;
            }
        }
        return false;
    }

    public Osoba[] vyhladaj(Osoba[] pole) {
        int pocet = 0;
        do {
            System.out.println("Podľa čoho chcete hľadať? Stlačte príslušnú voľbu: ");
            System.out.println("  1 - podľa mena\n  2 - podľa priezviska\n  3 - podľa čísla\n  4 - podľa emailu\n\nZadaj volbu: ");
            Scanner vstup = new Scanner(System.in);
            try {
                pocet = vstup.nextInt();
            } catch (Exception e) {
                System.out.println("Nezadali ste celé číslo, skúste to ešte raz");
            };
        } while ((pocet > 4) || (pocet < 1));

        Osoba[] novePole = new Osoba[pole.length];

        switch (pocet) {
            case 1:
                System.out.println("zadaj krstné meno ");
                Scanner sc = new Scanner(System.in);
                String firstN = sc.nextLine();
                String firstName = firstN.trim();
                for (int i = 0; i < pole.length; i++) {
                    if (pole[i] == null) {
                        continue;
                    }
                    if (pole[i].meno.equalsIgnoreCase(firstName)) {
                        novePole[i] = pole[i];
                    }
                }
                break;
            case 2:
                System.out.println("zadaj priezvisko");
                Scanner vstup = new Scanner(System.in);
                String secondN = vstup.nextLine();
                String secondName = secondN.trim();
                for (int i = 0; i < pole.length; i++) {
                    if (pole[i] == null) {
                        continue;
                    }
                    if (pole[i].priezvisko.equalsIgnoreCase(secondName)) {
                        novePole[i] = pole[i];
                    }
                }
                break;
            case 3:
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
                            System.out.println("Nezadali ste vhodné číslo, číslo bude nahradené číslicou \"0\"");
                        }
                    }
                } while (kontrola != ('1') && kontrola != ('2') && kontrola != ('3') && kontrola != ('4') && kontrola != ('5') && kontrola != ('0') && kontrola != ('6') && kontrola != ('7') && kontrola != ('8') && kontrola != ('9') && kontrola != (' '));

                for (int i = 0; i < pole.length; i++) {
                    if (pole[i] == null) {
                        continue;
                    }
                    if (pole[i].cislo.equalsIgnoreCase(cislo2));
                    novePole[i] = pole[i];
                }
                break;
            case 4:
                System.out.println("zadaj email");
                Scanner vstup2 = new Scanner(System.in);
                String emailN = vstup2.nextLine();
                String email1 = emailN.trim();
                for (int i = 0; i < pole.length; i++) {
                    if (pole[i] == null) {
                        continue;
                    }
                    if (pole[i].email.equalsIgnoreCase(email1)) {
                        novePole[i] = pole[i];
                    }
                }
                break;

        }
        return novePole;
    }

    public Osoba[] odobratKontakt(Osoba[] pole) {
        Osoba odoberatelna = new Osoba();
        if (existuje(pole, odoberatelna)) {
            Osoba[] policko = new Osoba[pole.length];
            for (int i = 0; i < pole.length; i++) {
                if (pole[i] == null) {
                    continue;
                }
                if ((pole[i].meno.equalsIgnoreCase(odoberatelna.meno)) && (pole[i].priezvisko.equalsIgnoreCase(odoberatelna.priezvisko)) && (pole[i].cislo.equalsIgnoreCase(odoberatelna.cislo)) && (pole[i].email.equalsIgnoreCase(odoberatelna.email))) {
                    policko[i] = null;
                    continue;
                }
                policko[i] = pole[i];
            }
            System.out.println("Osoba bola úspešne vymazaná.");
            return policko;
        }
        System.out.println("Osoba sa v zozname nenachádza, preto nemôže byť vymazaná.");
        return pole;
    }

    public Osoba[] pridajKontakt(Osoba[] pole) {
        Osoba pridana = new Osoba();

        for (int i = 0; i < pole.length; i++) {
            if (pole[i] == null) {
                pole[i] = pridana;

                pole[i].meno = pridana.meno;
                pole[i].priezvisko = pridana.priezvisko;
                pole[i].cislo = pridana.cislo;
                pole[i].email = pridana.email;

                System.out.println("Osoba bola úspešne pridaná.");
                return pole;
            }

        }
        System.out.println("Osoba nebola úspešne pridaná.");
        return pole;

    }

    public Osoba[] upravitKontakt(Osoba[] pole) {
        System.out.println("Zadajte kontakt, ktorý má byť upravená: ");
        Osoba upravovana = new Osoba();
        Osoba[] novePole = new Osoba[pole.length];
        novePole = pole;
        if (!existuje(pole, upravovana)) {
            System.out.println("Osoba sa v zozname nenachádza, čiže kontakt nemôže byť upravený");
            return novePole;
        }

        int pocet1 = 0;

        do {
            System.out.println("Vyberte  paramter, ktorý chcete upraviť:\n  1 - podľa mena\n  2 - podľa priezviska\n  3 - podľa čísla\n  4 - podľa emailu\n\nZadaj volbu: ");
            Scanner vstup = new Scanner(System.in);
            try {
                pocet1 = vstup.nextInt();
            } catch (Exception e) {
                System.out.println("Nezadali ste celé číslo, skúste to ešte raz");
            };
        } while ((pocet1 > 4) || (pocet1 < 1));

        switch (pocet1) {
            case 1:
                String firstName;
                String firstN;
                int pocet2;
                do {
                    System.out.println("zadaj nové krstné meno ");
                    Scanner sc = new Scanner(System.in);
                    firstN = sc.nextLine();
                    firstName = firstN.trim();

                    pocet2 = firstName.length();

                } while (pocet2 < 1);
                for (int i = 0; i < pole.length; i++) {
                    if (pole[i] == null) {
                        continue;
                    }

                    if ((pole[i].meno.equalsIgnoreCase(upravovana.meno)) && (pole[i].priezvisko.equalsIgnoreCase(upravovana.priezvisko)) && (pole[i].cislo.equalsIgnoreCase(upravovana.cislo)) && (pole[i].email.equalsIgnoreCase(upravovana.email))) {
                        pole[i].meno = firstName;
                        System.out.println("Meno bolo úspešne zmenené.");

                        return pole;
                    }
                }
                System.out.println("Meno nebolo úspešne zmenené.");
                return pole;
            // break;
            case 2:
                System.out.println("zadaj nové priezvisko");
                Scanner vstup = new Scanner(System.in);
                String secondN = vstup.nextLine();
                String secondName = secondN.trim();

                for (int i = 0; i < novePole.length; i++) {
                    if (pole[i] == null) {
                        continue;
                    }
                    if ((pole[i].meno.equalsIgnoreCase(upravovana.meno)) && (pole[i].priezvisko.equalsIgnoreCase(upravovana.priezvisko)) && (pole[i].cislo.equalsIgnoreCase(upravovana.cislo)) && (pole[i].email.equalsIgnoreCase(upravovana.email))) {
                        pole[i].priezvisko = secondName;
                        System.out.println("Priezvisko bolo úspešne zmenené.");

                        return pole;
                    }
                }
                System.out.println("Priezvisko nebolo úspešne zmenené.");
                return pole;

            case 3:
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
                            System.out.println("Nezadali ste vhodné číslo, zadajte celé číslo! ");
                        }
                    }
                } while (kontrola != ('1') && kontrola != ('2') && kontrola != ('3') && kontrola != ('4') && kontrola != ('5') && kontrola != ('0') && kontrola != ('6') && kontrola != ('7') && kontrola != ('8') && kontrola != ('9') && kontrola != (' '));

                for (int i = 0; i < novePole.length; i++) {
                    if (pole[i] == null) {
                        continue;
                    }
                    if ((pole[i].meno.equalsIgnoreCase(upravovana.meno)) && (pole[i].priezvisko.equalsIgnoreCase(upravovana.priezvisko)) && (pole[i].cislo.equalsIgnoreCase(upravovana.cislo)) && (pole[i].email.equalsIgnoreCase(upravovana.email))) {
                        pole[i].cislo = cislo2;
                        System.out.println("Číslo bolo úspešne zmenené.");
                        return pole;
                    }
                }
                System.out.println("Číslo nebolo úspešne zmenené.");
                return pole;

            case 4:
                System.out.println("zadaj nový email");
                Scanner vstup2 = new Scanner(System.in);
                String emailN = vstup2.nextLine();
                String email1 = emailN.trim();

                for (int i = 0; i < novePole.length; i++) {
                    if (pole[i] == null) {
                        continue;
                    }
                    if ((pole[i].meno.equalsIgnoreCase(upravovana.meno)) && (pole[i].priezvisko.equalsIgnoreCase(upravovana.priezvisko)) && (pole[i].cislo.equalsIgnoreCase(upravovana.cislo)) && (pole[i].email.equalsIgnoreCase(upravovana.email))) {
                        pole[i].email = email1;
                        System.out.println("Email bol úspešne zmenený.");
                        return pole;
                    }
                }
                System.out.println("Email nebol úspešne zmenený.");
                return pole;

        }
        return pole;
    }

    public void ukoncitProgram(Osoba[] pole) {
        char t = 0;
        do {
            System.out.println("Chcete uložiť zoznam ?");
            System.out.println("Pre možnosť \"Áno\", chcem uložiť zoznam, stlačte jednotku \"1\" ");
            System.out.println("Pre možnosť \"Nie\", NE-chcem uložiť zoznam, program chcem ukončiť bez uloženia, stlačte nulu \"0\" ");

            int pocet = 9;
            do {
                Scanner vstup = new Scanner(System.in);
                try {
                    pocet = vstup.nextInt();
                } catch (Exception e) {
                    System.out.println("Nezadali ste celé číslo, skúste to ešte raz");
                }
            } while ((pocet > 1) || (pocet < 0));

            switch (pocet) {
                case 1:
                    try {
                        boolean neviemCiUlozil;
                        neviemCiUlozil = ulozitProgram(pole);
                        if (neviemCiUlozil == false) {
                            throw new Exception();
                        }
                        System.out.println("Súbor sa ulozil a program sa ukončuje.");
                        System.exit(0);

                    } catch (IOException e) {
                        System.out.println("Súbor sa z neznámych príčin neuložil, skúste to ešte raz alebo v nasledujúcom kroku stlačte nulu \"0\" pre ukončenie programu bohužial bez uloženia!");
                    } catch (Exception e) {
                        System.out.println("Súbor sa neuložil, skúste to ešte raz alebo v nasledujúcom kroku stlačte nulu \"0\" pre ukončenie programu bohužial bez uloženia!");
                        System.out.println("\n");

                    }
                    ;
                    break;
                case 0:
                    System.exit(0);
            }

        } while (t != 'j');
    }

}
