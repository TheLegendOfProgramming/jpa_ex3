/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

/**
 *
 * @author mircea
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class DiscountType implements Serializable {

    /**
     * Properties
     */

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    public double calcDiscount(double priceItem, int quantity) {
      return priceItem * quantity;
    }
    
    /**
     * Relationships
     */
    
    @ManyToOne
    private Customer owner;

    /**
     * Getters
     */
    
    public Long getId() {
        return id;
    }
    
    public Customer getOwner() {
        return owner;
    }
    
    /**
     * Setters
     */
    
    public void setOwner(Customer owner) {
        this.owner = owner;
    }
    
}
