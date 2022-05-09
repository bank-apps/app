/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author samuel-portatil
 */
public class CreditCard extends Card {
        
    private double maintenance = 0.5f;
    
    public CreditCard(String cardNumber) {
        super(cardNumber);
        super.maintenance = this.maintenance;
    }    
}