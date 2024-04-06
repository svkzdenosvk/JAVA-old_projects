/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zamestnanci;

/**
 *
 * @author Einstein
 */
public class Chovatel extends Zamestnanci {

    @Override
    public void pracuje() {
        System.out.println("Chovateľ kŕmi zvieratá, čistí ich, stará sa celkovo o nich");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean potrebneVzdelanie() {
        return true;
    }

    @Override
    public boolean potrebnaPrax() {
        return true;
    }
    
}
