package game.builder;

import games.Tictactoe;

public class TictactoeBuilder {
    private int dimension = 3;

    public TictactoeBuilder setDimension (int dimension) {

        this.dimension = dimension;
        return this;
    }

    public games.Tictactoe buildGameBoard () {

        return new games.Tictactoe(dimension);
    }
}