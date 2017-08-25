package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Customer implements Serializable {

    /**
     * Properties
     */

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    /**
     * Relationships
     */
    
    @OneToMany(mappedBy = "owner")
    private List<DiscountType> discountTypes = new ArrayList();

    /**
     * Getters
     */

    public Long getId() {
        return id;
    }
    
    public List<DiscountType> getDiscountTypes() {
        return discountTypes;
    }
    
    public double calcDiscount(int discountType, double priceItem, int quantity) {
      return discountTypes.get(discountType).calcDiscount(priceItem, quantity);
    }

    /**
     * Setters
     */
    
    public void addDiscountType(DiscountType discountType) {
        this.discountTypes.add(discountType);
        if (discountType.getOwner() != this) {
            discountType.setOwner(this);
        }
    }
    
}