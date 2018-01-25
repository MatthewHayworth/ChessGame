
import Application.ChessPieces.*;
import Application.Chessboard.Board;
import Application.Chessboard.Ownership;
import Application.Chessboard.Position;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class PawnTest {

    @Test
    public void testForwardMovementWithNoObstacles() {
        Pawn pawn = new Pawn(Team.WHITE);
        Position position = Board.BOARD.getPosition('a', 7);
        pawn.setPosition(position);
        pawn.move('a', 6);
        assertEquals("[a,6]", pawn.getPosition().toString());
    }

    @Test
    public void testForwardMovementWithObstacle() {
        Pawn whitePawn = new Pawn(Team.WHITE);
        Position positionWhite = Board.BOARD.getPosition('d', 2);
        whitePawn.setPosition(positionWhite);
        Board.BOARD.getPosition('d', 3).setOwner(Ownership.WHITE);
        whitePawn.move('d', 3);
        Board.BOARD.getPosition('d', 3).setOwner(Ownership.NEUTRAL);
        assertEquals("[d,2]", whitePawn.getPosition().toString());
    }

    @Test
    public void testMovementWhileCaptured() {
        Pawn whitePawn = new Pawn(Team.WHITE);
        Position positionWhite = Board.BOARD.getPosition('d', 2);
        whitePawn.setPosition(positionWhite);
        whitePawn.setCaptured();
        whitePawn.move('d', 3);
        assertEquals("[d,2]", whitePawn.getPosition().toString());
    }

    @Test
    public void testCrossMovementLeftToCaptureEnemy() {
        Pawn whitePawn = new Pawn(Team.WHITE);
        Position positionWhite = Board.BOARD.getPosition('d', 2);
        whitePawn.setPosition(positionWhite);
        Board.BOARD.getPosition('c', 3).setOwner(Ownership.BLACK);
        whitePawn.move('c', 3);
        Board.BOARD.getPosition('c', 3).setOwner(Ownership.NEUTRAL);
        assertEquals("[c,3]", whitePawn.getPosition().toString());
    }

    @Test
    public void testCrossMovementRightToBeatEnemy() {
        Pawn whitePawn = new Pawn(Team.WHITE);
        Position positionWhite = Board.BOARD.getPosition('d', 2);
        whitePawn.setPosition(positionWhite);
        Board.BOARD.getPosition('e', 3).setOwner(Ownership.BLACK);
        whitePawn.move('e', 3);
        Board.BOARD.getPosition('e', 3).setOwner(Ownership.NEUTRAL);
        assertEquals("[e,3]", whitePawn.getPosition().toString());
    }

    @Test
    public void testCrossMovementLeftBlockedByAlly() {
        Pawn whitePawn1 = new Pawn(Team.WHITE);
        Position positionWhite = Board.BOARD.getPosition('d', 2);
        whitePawn1.setPosition(positionWhite);
        Board.BOARD.getPosition('c', 3).setOwner(Ownership.WHITE);
        whitePawn1.move('c', 3);
        Board.BOARD.getPosition('c', 3).setOwner(Ownership.NEUTRAL);
        assertEquals("[d,2]", whitePawn1.getPosition().toString());
    }

    @Test
    public void testCrossMovementRightBlockedByAlly() {
        Pawn whitePawn1 = new Pawn(Team.WHITE);
        Position positionWhite = Board.BOARD.getPosition('d', 2);
        whitePawn1.setPosition(positionWhite);
        Board.BOARD.getPosition('e', 3).setOwner(Ownership.WHITE);
        whitePawn1.move('e', 3);
        Board.BOARD.getPosition('e', 3).setOwner(Ownership.NEUTRAL);
        assertEquals("[d,2]", whitePawn1.getPosition().toString());
    }

}
