/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlcssimage_build;

import java.io.File;
import java.io.PrintWriter;

/**
 *
 * @author PC Zdenko Šnúrik 
 * program načíta obrázky zo suboru, a vloží ich na
 * stránku, po kliknutí na obrázok sa urobi náhľad obrázku
 *
 * program nemusí byť ošetrený na všetky výnimky
 * 
 * Ciel: staticka galéria
 * *
 * Obrazky: 640x480 px Nahlady: 64x48
 *
 *  vytvori v /html_subor vyslednu stranku Image.html.
 *
 *  ... Hlavna stranka s nahladmi obrazkov 
 *  ... v htmlDokumenty/ - stranka s obrazkom v plnom
 * rozliseny 640x480 ... otvori po nahlade z hlavnej stranky ....  ma aj
 * odkaz naspat na hlavnu
 *
 * Obrazok je v strede stranky... Pod nim je nadpis: Obrázok c. 1.
 */
public class HtmlCssImage_build {

    public static void main(String[] args) {
        try {
           // Htmlcko htm = new Htmlcko();
            String stringExportPath = "html_subor\\Image.html";
            File html = new File(stringExportPath);

            PrintWriter writer = new PrintWriter(stringExportPath, "UTF-8");

            String path = "obrazky";

            File folder = new File(path);
            String uvodzovky = "\\";
            File[] listOfFiles = folder.listFiles();

            if (listOfFiles == null) {
                System.out.println("Subor s obrázkami neexistuje, alebo cesta k nemu nie je správna, uprav kód alebo vytvor súbor, program sa ukončuje!");
                System.exit(0);
            }
            int p = 1;

            if (listOfFiles.length == 0) {
                System.out.println("V súbore sa nenachádza žiadny obrázok, program sa ukončuje!");
                System.exit(0);
            }

            new File("htmlDokumenty").mkdir();

            for (int h = 0; h < listOfFiles.length; h++) {
                String cesta = "htmlDokumenty\\html" + h + ".html";

                File foldern = new File(cesta);
                PrintWriter pisatel = new PrintWriter(cesta, "UTF-8");
                pisatel.println("<img src=\"..\\" + path + uvodzovky + listOfFiles[h].getName() + "\" style=\"width:640px;height:480px;margin:50px auto;padding-left:350px;\">");
                pisatel.println("<br />");

                if ((h + 1) <= listOfFiles.length) {
                    pisatel.println("<a style=\"margin:250px;padding-left:375px\">Obrázok č. " + (h + 1) + "</a> ");
                }
                pisatel.println("<a href=\"..\\html_subor\\Image.html\">klikni sem na návrat späť</a> ");

                pisatel.close();

            }

            for (int i = 0; i < listOfFiles.length; i += 3) {

                writer.println("<a href=\"..\\htmlDokumenty\\html" + i + ".html\"><img src=\"..\\" + path + uvodzovky + listOfFiles[i].getName() + "\" style=\"width:64px;height:48px;margin:5px auto;padding:185px;\"</a> ");

                if ((i + 1) < listOfFiles.length) {
                    writer.println("<a href=\"..\\htmlDokumenty\\html" + (i + 1) + ".html\"><img src=\"..\\" + path + uvodzovky + listOfFiles[i + 1].getName() + "\" style=\"width:64px;height:48px;margin:5px auto;padding:185px;\"</a> ");
                }
                if ((i + 2) < listOfFiles.length) {
                    writer.println("<a href=\"..\\htmlDokumenty\\html" + (i + 2) + ".html\"><img src=\"..\\" + path + uvodzovky + listOfFiles[i + 2].getName() + "\" style=\"width:64px;height:48px;margin:5px auto;padding:185px;\"</a> ");
                }

                writer.println("<br />");

                if ((i + 1) <= listOfFiles.length) {
                    writer.println("<a style=\"padding:175px;\">Obrázok č. " + (i + 1) + "</a> ");
                }
                if ((i + 2) <= listOfFiles.length) {
                    writer.println("<a style=\"padding:175px;\">Obrázok č. " + (i + 2) + "</a> ");
                }
                if ((i + 3) <= listOfFiles.length) {
                    writer.println("<a style=\"padding:175px;\">Obrázok č. " + (i + 3) + "</a> ");
                }

            }

            writer.close();

        } catch (Exception e) {
            System.out.println("Niekde v metode main sa stala chyba");
            e.printStackTrace();

        }
    }
}
