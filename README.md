# jpa_ex3
Mapping Inheritance

Report for the last part of the exercise:

I have used a OneToMany, respectively ManyToOne bidirectional relationship between the Customer and the DiscountType, which generated the DISCOUNTTYPE table with an OWNER_ID (because of the mapping I used).

I extended both DiscountQuantity and DiscountFixed from DiscountType, and used the JOINED InheritanceType, which made the DISCOUNTTYPE table differentiate between DiscountFixed and DiscountQuantity by the DTYPE column. Both entityes that inherit DiscountType can be gotten through joins, or just by calling on the DiscountQuantity or DiscountFixed objects as you would a DiscountType.

To demonstrate, I created a normal DiscountType and a DiscountFixed and added both to the List of the Customer's discount types. My method calcDiscount can call on any of the types in the array to get the discount wanted. The first one with the index 0 uses the normal method in the DiscountType class, and the other one calls the overwrite in the DiscountFixed, if the index used is 1. 
