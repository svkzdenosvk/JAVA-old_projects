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
public class PredavacVstupeniek extends Zamestnanci {

    @Override
    public void pracuje() {
        System.out.println("Predavač predáva lístky do ZOO, podáva informácie návštevníkom, rieši rôzne problémy návštevníkov.");
        
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
