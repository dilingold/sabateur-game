Team Name: G2
Team Members:
	s3394461 -- Devorah Newman
	s3018841 -- John Lakkis
	s3435996 -- Sash Petrovski
	s3547443 -- Tristan Boyd
	
Run Instructions:
To run the program run from controller.GameEngine

Requirements:
Java 1.8

SOLID Principals:

Single Responsibility Principle - SRP
We have demonstrated through classes such as 'deal' and 'validator' to conform to the SRP. We have achieved this by
removing the methods specializing in a single task and placed them into there own classes.

Open - Closed Principle - OCP
We have demonstrated effective use of the open-closed principle by ensuring that our classes are open for extension
and closed for modification. We have achieved this by allowing the path and action cards to inherit from the card class,
this way if at anytime we were to add another card type it would be easy to extend without any modification.

Liskov Substitution Principle
When designing our program with LSP, we have ensured that a child class cannot break a parent class' type
definitions. We have allowed our subclasses to override the parent class' methods such that it does not break the
functionality.

We have achieved this by ensuring that inheritance is used correctly, and any relevant method within the child class
can override the parent method. We have shown an example of this within the 'path' and 'action cards' class'.

Interface Segregation Principle
Interface segregation can be demonstrated by the 3 abstract card classes (ActionCard, BoardCard and Personal Card 
separating the methods and variables these classes use.

Dependency Inversion Principle
N/A

GRASP Principals:

Creator
We have achieved this by allowing the following:

    - PlayerController creates player
    - Board and Deck are singletons, ensuring there is only one instance of both:
        -- Deck creates all playable cards
        -- Board Creates all board-cards (treasure and blank cards)

Controller
We have adhered to this design principle by using a controller to delegate to its team, we have achieved this in the
following:

    - GameEngine, with assistance from some listeners, handles interactions
      between the view and the actions the player makes.

High Cohesion
To ensure our code promotes understandability, maintainability and reuse, we ensured our classes maintained a small
number of methods, small number of parameters and small number of lines of code. This is evident in the following
classes for example:

    - Deal
    - ToxicCard
    - ExitListener

Information Expert
We have achieved IEP by allowing the following:

    - PlayerController is IE for players
    - Board is IE for all objects on the board
    - Hand is IE for all objects on the board

Low Coupling
Highly coupled classes are sensitive to change. Wherever possible we were committed to achieving low coupling by
reducing the dependencies between classes. Only when it was relevant did we move methods into their own classes.

Polymorphism
We have adhered to the rules of polymorphism by having the abstract card classes these are:

    - path cards extends cards
    - action cards extends cards
    - personal cards extends cards

Pure Fabrication
We tried to ensure that all of our classes had a real world analogy, where we were not able to do this we used pure
fabrication to support high cohesion, low coupling, and reuse. We applied pure fabrication to the following classes:

    - Validator class is effectively the "Rule Enforcer"
    - PlayerController keeps a list of all players and player order

Protected Variations
All classes use getters and setters to change local variables, which are kept private.

Indirection
N/A

Design by Contract principles:

Employed primarily in the Validator class, a particularly important class which checks and enforces the rules of
the game.
As the validator takes both a card and a coordinate, it was important that the information it receives is within a
specific range (and so preconditions were specified clearly)
It is also important that it functions correctly, only asking the board to update if a move is legal, and only returning
True (letting the player know they should discard the card they successfully used) when the card was played.


