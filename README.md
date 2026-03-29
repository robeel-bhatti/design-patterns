# Design Patterns

A collection of common design patterns implemented in Java.

Some benefits I have experienced with design patterns:
- Stronger understanding of how frameworks such as Spring Boot work under the hood
- Reduced complexity of code; easier to maintain and extend
- Improved testability and maintainability

I recommend all software engineers to read and have a basic understanding of these patterns
to achieve the same benefits I have listed above.

## Creational Patterns

| Pattern                                            | Description                              | Example                                                                       |
|----------------------------------------------------|------------------------------------------|-------------------------------------------------------------------------------|
| [Singleton](src/creational/singleton)              | Ensures a class has only one instance    | Multiple implementations: Eager, Lazy, Thread-Safe, Double-Checked, Bill Pugh |
| [Factory Method](src/creational/factory)           | Delegates object creation to subclasses  | Notification system (Email, SMS, Slack)                                       |
| [Abstract Factory](src/creational/abstractFactory) | Creates families of related objects      | Theme system (Dark/Light with colors and fonts)                               |
| [Builder](src/creational/builder)                  | Constructs complex objects step by step  | HTTP request builder                                                          |
| [Prototype](src/creational/prototype)              | Creates objects by cloning existing ones | Enemy registry for a game                                                     |

## Structural Patterns

| Pattern                               | Description                                          | Example                                                                   |
|---------------------------------------|------------------------------------------------------|---------------------------------------------------------------------------|
| [Adapter](src/structural/adapter)     | Makes incompatible interfaces work together          | Stripe SDK payment integration                                            |
| [Bridge](src/structural/bridge)       | Separates abstraction from implementation            | Notifications (Standard/Urgent/Scheduled) over channels (Email/SMS/Slack) |
| [Composite](src/structural/composite) | Treats individual objects and compositions uniformly | Employee hierarchy (Managers and Individual Contributors)                 |
| [Decorator](src/structural/decorator) | Adds behavior to objects dynamically                 | Coffee with add-ons (Milk, Sugar)                                         |
| [Flyweight](src/structural/flyweight) | Shares common state between objects to save memory   | Forest of trees with shared type data                                     |
| [Proxy](src/structural/proxy)         | Controls access to another object                    | Lazy-loading image proxy                                                  |

## Behavioral Patterns

| Pattern                                                         | Description                                            | Example                                                         |
|-----------------------------------------------------------------|--------------------------------------------------------|-----------------------------------------------------------------|
| [Chain of Responsibility](src/behavioral/chainOfResponsibility) | Passes requests along a chain of handlers              | Support ticket escalation (Basic -> Technical -> Manager)       |
| [Iterator](src/behavioral/iterator)                             | Provides sequential access to elements of a collection | Music playlist iterator                                         |
| [Observer](src/behavioral/observer)                             | Notifies dependents when state changes                 | Stock exchange with price displays, loggers, and alerts         |
| [Strategy](src/behavioral/strategy)                             | Defines interchangeable algorithms                     | Payment processing (Credit Card, PayPal, Crypto, Bank Transfer) |
