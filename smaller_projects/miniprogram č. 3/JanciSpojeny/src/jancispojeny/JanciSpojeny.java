/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jancispojeny;

import java.util.Scanner;

/**
 *
 * @author PC Zdeno Šnúrik
 * 
 * tento program počíta rôzne pomocné výpočty využiteľné pre architekta
 * robil som to pre kamaráta
 * toto je hlavná trieda
 */
public class JanciSpojeny {

    
    public static void main(String[] args) {
             char q=0;

        do{
           int pocet=0;
           System.out.println("Zdravím, pán architekt, program je pripravený pracovať.");
            do{
               System.out.println("\n\nVyber, ktorý výpočet chceš zrealizovať:\n\n  1 - Sucinitiel prechodu tepla otvorovej konstrukcie\n  2 - Vykurovanie priestoru na teréne\n  3 - Skončenie programu\n\nZadaj volbu: ");
 
               Scanner vstup = new Scanner(System.in);
               try{
                   pocet = vstup.nextInt();
                  }catch(Exception e){
               System.out.println("Nezadal si kamarát celé číslo, skús to ešte raz, nie si prepracovaný ?");
                                     };
  
               }while((pocet>3)||(pocet<1));

            VypoctyAVzorce VaV = new VypoctyAVzorce();
            switch (pocet) {
                case 1:
                    VaV.sucinitielPrechoduTeplaOtvorovejKonstrukcie();
                    break;
                case 2:
                    VaV.vykurovaniePriestoruNaTerene();
                    break;
                case 3:
                    VaV.ukoncitProgram();
                    break;
                default:
                    System.out.println("Kamarát môj, zadal si možnosť, ktorá zatiaľ žiadny  výpočet neposkytuje.. nespi a dávaj pozor pri výbere možnosti!  ");
                    break;

                            }

        } while (q != 5);

    }
}
