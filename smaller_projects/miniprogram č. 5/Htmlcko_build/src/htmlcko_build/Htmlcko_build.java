/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package htmlcko_build;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author PC Zdenko Šnúrik
 * program vypíše obsah priečinka (bez podpriečinkov) do html dokumentu Zoznam.html,
 * ktorý vytvorý do priečinka html_subor 
 * dalšie vylepšenie programu môže byť napr.- upraviť cestu ako vstup od uzivatela
 * môžu sa vyskytnúť neupravené výnimky
 */
public class Htmlcko_build {
 public File vypis(String stringDirPath, String stringExportath) {

        File stringDirPathFolder = new File(stringDirPath);
        File stringExportathFolder = new File(stringExportath);

        File[] listOfFiles = stringDirPathFolder.listFiles();
        if (listOfFiles == null) {
            System.out.println("Subor s dokumentmi neexistuje, alebo cesta k nemu nie je správna, uprav kod alebo vytvor subor, program sa ukončuje!");
            System.exit(0);
        }
        try {
            PrintWriter writer = new PrintWriter(stringExportath, "UTF-8");

            for (int i = 0; i < listOfFiles.length; i++) {
                writer.println(listOfFiles[i].getName());
                writer.println("<br />");

            }
            writer.close();

        } catch (IOException e) {
            System.out.println("Niekde v metode vypis sa stala chyba");
            e.printStackTrace();
        }

        return stringExportathFolder;
    }

    public static void main(String[] args) {
        try {
            Htmlcko_build htm = new Htmlcko_build();
                                                                                     
          String stringExportPath = "html_subor\\Zoznam.html";                       //cesta kde vytvára html dokument s vypisaným zoznamom
       
            String stringDirPath = "\\";                                             //cesta k suboru, z ktoreho treba vypísať obsah 
            File html = new File(stringExportPath);
            html = htm.vypis(stringDirPath, stringExportPath);

        } catch (Exception e) {
            System.out.println("Niekde v metode main sa stala chyba");
            e.printStackTrace();

        }
    }
}

