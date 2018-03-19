## Blackjack Project

#### Description

Users will be able to play Blackjack against the dealer. The game is set so that if the player or the dealer has 21 at the start of the game it is an automatic win. Users and dealer will bust if they are over 21. The user can choose to continue playing or quit at the end of each round.


#### How To Play

* Start the game.
* If the user gets 21 at the start of the game they win, if the dealer has 21, the dealer wins.
* Users can choose to hit or stay on cards less than 21.
* The user will bust if card value is over 21.
* The dealer will automatically hit when their hand is under 17.
* Users can then win if their card value is more than the dealers and under 21.
* Once a winner is decided, the user can then choose to continue playing or quit the game.

#### Lessons Learned

* Placement of methods and statements are very important.
* Figuring out how each class interacts with each other is a good start.
* Creating a new method to continue or quit playing to be placed at the end of each win/lose method makes it easier than calling the initial runGame method.
* Writing down the next step and including comments in the code are helpful for when you come back to it later.