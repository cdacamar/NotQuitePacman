--- Not Quite Pacman README ---
Authors:
Cameron DaCamara
Dominic

Description:
Not Quite Pacman is a simple Pacman based game for Android it emulates the player (Pacman) and 
one ghost (Blinky) who stalks him. The object of the game it to collect all of the crumps on 
the board (yellow balls) before the ghost can kill you.

Known Bugs:
Since the pathfinding algorithm is really simple it causes the ghost to sometimes wonder off
and disregard the player. I fixed the issue of the ghost endlessly looping left, right or up,
down when the player is directly above or to the side of the ghost.

Cameron DaCamara contributions:
Board.java, Entity.java, GameCanvas.java, GameState.java, NotQuitePacmanActivity.java,
Player.java, Tile.java and any assets for the game like the manifest and @string or @color

Dominic contributions:
Blinky.java + ideas for the game