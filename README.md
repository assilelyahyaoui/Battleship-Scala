# Battleship-Scala

During the Functional Programming course provided by Polytech during the 5th year of computer science and management, I had to implement a battleship game. The rules are the ones used usually : 
Two players have two grids each : the first, the primary grid, enables to see the player’s placed boats and the hits made by the adversary; the second helps the player keep track of the shots he/she made. The players start by adding boats to their primary grid before battling each other. One by one, they target one of the cells of the opponent's grid. There are three outcome to this : either an empty cell (not containing any boats) is hit, or a cell that is already hit is hit again or finally a cell containing a boat is hit.  
Either way, the targeted cell is changed on the opponent’s primary grid and on the attacker’s tracking grid. A player wins a round whenever he hits all the cells containing boats of his opponents
In this version, 3 AIs are also implemented that are meant to act as players . We will talk about them later on in the report.
