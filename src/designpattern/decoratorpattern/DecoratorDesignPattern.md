## Decorator Design Pattern

- to avoid Class explosion , its like we have Pizza and topics as decorator so we are creating endless classes if we
  use simple inheritance. As the feature increased we also create new classes.
- We have a base object that is `abstract` and have `cost()`