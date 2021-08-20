package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.white.BishopWhite;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.Is.isA;
import static org.junit.Assert.assertEquals;

public class LogicTest {

    @Test
    public void move() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test(expected = OccupiedCellException.class)
        public void free() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
                try {
                    Logic logic = new Logic();
                    logic.add(new BishopWhite(Cell.C3));
                    logic.add(new BishopBlack(Cell.D2));
                    logic.move(Cell.C3, Cell.D2);
                } catch (ImpossibleMoveException i) {
                    i.getMessage();
                }
    }

    @Test(expected = FigureNotFoundException.class)
    public void findBy() throws FigureNotFoundException, OccupiedCellException,
            ImpossibleMoveException {
        Logic logic = new Logic();
        logic.move(Cell.C1, Cell.H6);
    }

}