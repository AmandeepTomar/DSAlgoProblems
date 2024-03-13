## Facade Design Pattern

#### When to use and why

- Whe we used to hide the system complexity from the client.
- Client -> facade -> system(components)
- Facade , we should not enforce client to use facade , if client want to use the facade its ok if not then also ok.
- Client can interact with components directly.
- Facade take the responsibility of creating the component instance.
- Facade can also use another facade.

- Car
    - Accelerate Paddle speed Up
    - Break speed go down.
- Example just like we have library that is performing loggin events on the basis of some logic.
- We just need to call api.logEvent() -> logEvent() is doing the complex time.

- We have a component that have many classes and many methods.


#### Where to use
- Employee dao.
- Client has facade and facade has component.
- Suppose we have a system 
  - it have classes 
    - Payment
    - Product 
    - invoice and Notification.
  - Now suppose we have client and want to  make and order
    - toCreateAndOrder()
      - getProduct() ->makePayment() -> generateInvoice() -> sendNotification().
    - First client have knowledge to create order its complex and now he / she want to write more code. 
    - Suppose now you have updated some steps in order in this case now client is need to check. 
    - Any change in logic of components classes that also impact client.
    - Order Facade has all the classes in component. 
    - Client has Orderfacade. 
    - Now if any changes required in system , then only facade required to change , so client no need to change. 
- facade is using another facade. 
- Client -> Facade -> System (Payment , Product , invoice amd Notification)
- OrderFacade 
- PaymentFacade 
- CheckoutFacade
  - create an order -> payment 

#### Facade Vs proxy
- Client -> proxy -> actual object 
- Proxy is take care of single object , so it is take care of only one object and type of that proxy is also need to same as Actual object.
- 
#### facade Vs Adapter 
- Facade to hide the complexity 
- Adapter to provide the support as middle, or adaptability. 