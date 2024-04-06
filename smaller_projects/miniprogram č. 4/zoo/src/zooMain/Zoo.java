/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zooMain;
import AktivityZoo.Reklama;
import AktivityZoo.Vzdelavanie;
import Zamestnanci.Osetrovatel;
import Zviera.Cicavce.Medved;
import Zviera.Vtaky.Orol;



/**
 *
 * @author Einstein
 * 
 * tento program bude imitácia prevádzky ZOO .. zatial nie je doroboný
 */
public class Zoo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Orol Jakub = new Orol();
        Jakub.pohybujeSa();
        Osetrovatel Ondrej = new Osetrovatel();
        Ondrej.pracuje();
        Vzdelavanie a = new Vzdelavanie();
        a.cinnosti();
       
    }
    
}
