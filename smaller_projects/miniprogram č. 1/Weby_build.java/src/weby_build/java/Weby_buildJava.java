/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weby_build.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author PC Zdenko Šnúrik 
 * tento program vypíše poslednu temu na stránke:"http://linuxos.sk/forum/prehlad/"
 */
public class Weby_buildJava {

  
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws Exception {
        try {
            URL linux = new URL("https://linuxos.sk/forum/prehlad/");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(linux.openStream()));
            
            String str2 = "Posledná";
            String sig = "\">";
            char retazec[] = new char[600];
            String inputLine;
            String tema = "";
            int x = 0;
                                

            while ((inputLine = in.readLine()) != null) {

                if (inputLine.toLowerCase().contains(str2.toLowerCase())) {
                    
                    for (int t = 0; t < 7; t++) {
                        inputLine = in.readLine();
                        if (inputLine.contains(sig)) {

                            System.out.println("posledne pridaná téma na stránke linuxos.sk je: ");
                            int a = inputLine.indexOf("/\">");
                            int b = inputLine.indexOf("</");
                            for (int u = a + 3; u < b; u++) {
                                tema += inputLine.charAt(u);

                            }
                            System.out.println(tema);

                        }
                    }
                }

            }
            in.close();
        } catch (Exception e) {
            System.out.println("Niečo sa pokazilo");
        }
    }
}
