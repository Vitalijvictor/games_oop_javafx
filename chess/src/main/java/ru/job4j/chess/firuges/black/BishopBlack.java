package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }

        int size = Math.abs(position.getX() - dest.getX());
        Cell[] steps = new Cell[size];
        int deltaX = position.getX() == dest.getX()
                ? 0
                : (position.getX() > dest.getX() ? -1 : 1);
        int deltaY = position.getY() == dest.getY()
                ? 0
                : (position.getY() > dest.getY() ? -1 : 1);

        int x = position.getX(), y = position.getY();
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(x += deltaX, y += deltaY);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int diffX = source.getX() - dest.getX();
        int diffY = source.getY() - dest.getY();
        return Math.abs(diffX) == Math.abs(diffY);
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
