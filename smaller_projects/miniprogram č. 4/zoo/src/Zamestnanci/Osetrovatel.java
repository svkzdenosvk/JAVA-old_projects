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
public class Osetrovatel extends Zamestnanci{

    @Override
    public void pracuje() {
        System.out.println("Ošetrovateľ lieči choré zvieratá, očkuje ich, ..");
        
    }

    @Override
    public boolean potrebneVzdelanie() {
        return true;
    }

    @Override
    public boolean potrebnaPrax() {
       return false;
    }
    
    
}
