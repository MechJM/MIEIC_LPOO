## Smells found:
- Useless methods in Product.java (the set methods)
- Use of primitives for small tasks in Order.java
- If statement that could be simplified in Order.java (isEligible...)
- OrderLine has two public fields
- There is reused code to calculate an Order's value in isEligible... and printOrder


## Refactorings done:
- Removed useless methods in Product.java (the set methods)
- Replaced the double primitives with the Double object
- Simplified the return/if statements in isEligible... in Order.java
- Made the fields private and added get methods
- Replaced duplicate code with separate method getTotal()
