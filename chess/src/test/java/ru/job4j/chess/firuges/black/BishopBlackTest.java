package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Test;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BishopBlackTest extends TestCase {

    @Test
    public void testPosition() {
        BishopBlack bishopBlack =  new BishopBlack(Cell.findBy(1, 2));
        System.out.println(bishopBlack.position());
        assertThat(Cell.findBy(1, 2), is(bishopBlack.position()));
    }

    @Test
    public void testCopy() {
        BishopBlack bishopBlackStart = new BishopBlack(Cell.findBy(1, 2));
        BishopBlack bishopBlackEnd = new BishopBlack(Cell.findBy(4, 6));
        assertThat(
                bishopBlackEnd.position(),
                is(bishopBlackStart.copy(Cell.findBy(4, 6)).position()));
    }

    @Test
    public void testWayD5ToE4() {
        BishopBlack bishopBlackStart = new BishopBlack(Cell.findBy(3, 3));
        Cell[] way = bishopBlackStart.way(Cell.findBy(4, 4));
        assertThat(Cell.findBy(4, 4), is(way[way.length-1]));
    }

    @Test
    public void testWayD5ToC6() {
        BishopBlack bishopBlackStart = new BishopBlack(Cell.findBy(3, 3));
        Cell[] way = bishopBlackStart.way(Cell.findBy(2, 2));
        assertThat(Cell.findBy(2, 2), is(way[way.length-1]));
    }

    @Test
    public void testWayD5ToC4() {
        BishopBlack bishopBlackStart = new BishopBlack(Cell.findBy(3, 3));
        Cell[] way = bishopBlackStart.way(Cell.findBy(2, 4));
        assertThat(Cell.findBy(2, 4), is(way[way.length-1]));
    }

    @Test
    public void testWayD5ToE6() {
        BishopBlack bishopBlackStart = new BishopBlack(Cell.findBy(3, 3));
        Cell[] way = bishopBlackStart.way(Cell.findBy(4, 2));
        assertThat(Cell.findBy(4, 2), is(way[way.length-1]));
    }

    @Test
    public void testWayException() {
        BishopBlack bishopBlackStart = new BishopBlack(Cell.E2);
        try {
            Cell[] way = bishopBlackStart.way(Cell.E4);
            fail("Expected an ImpossibleMoveException to be thrown");
        } catch (ImpossibleMoveException e1) {
            assertThat(
                    e1.getMessage(),
                    is("Could not move by diagonal from E2 to E4"));
        }

    }

    @Test
    public void testIsDiagonal() {
        BishopBlack bishopBlackStart = new BishopBlack(null);

        assertEquals(true,
                bishopBlackStart.isDiagonal(
                        Cell.findBy(7, 6), Cell.findBy(5, 4)));

        assertEquals(true,
                bishopBlackStart.isDiagonal(
                        Cell.H2, Cell.G1));

        assertEquals(true,
                bishopBlackStart.isDiagonal(
                        Cell.G2, Cell.H3));
    }
}
