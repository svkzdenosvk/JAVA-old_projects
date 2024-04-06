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
public class Upratovacka extends Zamestnanci{

    @Override
    public void pracuje() {
        System.out.println("Upratovačka upratuje priestory kancelárií, ambulancií, atď.");
       
    }

    @Override
    public boolean potrebneVzdelanie() {
        return false;
    }

    @Override
    public boolean potrebnaPrax() {
       return true;
    }
    
}
