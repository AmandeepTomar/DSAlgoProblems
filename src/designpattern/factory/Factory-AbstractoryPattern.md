## Factory Pattern and Abstract Factory pattern 
- Its a creation design pattern. 
- We have to create the object on the basis of some condition.
- `interface Shape` that has a `fun draw()` that will be implemented by shapes.
- `Rect` , `Oval` , `Circle` they all implemented the `Shape` they all have `is-A` relation ship with `Shape`
- Now we have a class `Shapefactory` this one is responsible to create the object of shapes on the basis of some condition. or this one is the source of truth to generate the object os shape classes. 
- We have `HAS-A` relation between `Shapefactory` and `Shape interface`.

## Abstract Factory Design Pattern
- Its a factory of factory
- When we have more than one factory and each factory group objects logically. 
- Like we have two factory Ordinary and Luxury and both have more than one type of products that will be return on the basis of logic or conditions.