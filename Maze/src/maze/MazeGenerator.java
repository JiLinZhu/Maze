package maze;

//Imports
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

//Maze Generator Class
public class MazeGenerator{
    
    //Fields
    MazeWindow gui;
    Random r = new Random();
    
    int mazeX; 
    int mazeY;
    int sleepTime;
    int numberOfMoves;
    String [][] maze;
    boolean[][] visited;
    boolean[][] solution;
         
    
    //INITIALIZING METHODS
    
    //Maze Constructor
    public MazeGenerator( MazeWindow in, int mazeX, int mazeY, int sleepTime ) {
        gui = in; //Cross Referencing MazeWindow
        this.mazeX = mazeX;
        this.mazeY = mazeY;
        this.sleepTime = sleepTime;
        maze = new String[mazeY][mazeX];
        visited = new boolean[mazeY][mazeX];
        solution = new boolean[mazeY][mazeX];
    } //End of MazeGenerator Constructor
    
    //Resets Maze to Specified State
    public void resetMaze( String state ) {
        for ( int y=0; y<mazeY; y++ ) {
            for ( int x=0; x<mazeX; x++ ) 
                maze[y][x] = state; //State: start, exit, path, wall
        }
    } //End of resetMaze Method
    
    //Sets Exterior Wall of the Maze
    public void setExteriorWall() {
        for ( int x=0; x<mazeX; x++ ){ //Creates Top and Bottom Border
            maze[0][x] = "wall";
            maze[mazeY-1][x] = "wall";
        }
        
        for ( int y=0; y<mazeY; y++ ){ //Creates Left and Right Border
            maze[y][0] = "wall";
            maze[y][mazeX-1] = "wall";
        }        
    } //End of setExteriorWall Method
    
    
    //CALCULATE/GET METHODS
    
    //Finds the Start of the Maze and Returns as Point
    public Point getMazeStart() {
        for ( int y=0; y<mazeY; y++ ) {
            for ( int x=0; x<mazeX; x++ ) {
                if ( maze[y][x].equals("start") )
                    return new Point(x, y);
            }
        }
        return new Point(-1, -1); //Error Case, Should Not Occur
    } //End of getMazeStart Method
    
    //Finds the End of the Maze and Returns as Point
    public Point getMazeEnd() {
        for ( int y=0; y<mazeY; y++ ) {
            for ( int x=0; x<mazeX; x++ ) {
                if ( maze[y][x].equals("exit") )
                    return new Point(x, y);
            }
        }
        return new Point(-1, -1); //Error Case, Should Not Occur
    } //End of getMazeEnd Method
    
    //Finds the Next Move Based on Left Hand Rule
    public String calculateMoveLeftHand( int currX, int currY, String prevMove ) {
        switch ( prevMove ) { //Orientation will change based on previous move
            case "U": //Up
                if ( !maze[currY][currX-1].equals("wall") ) //Checks if move is possible (not a wall)
                    return "L";
                else if ( !maze[currY-1][currX].equals("wall") )
                    return "U";
                else if ( !maze[currY][currX+1].equals("wall") )
                    return "R";
                else
                    return "D";
            case "D": //Down
                if ( !maze[currY][currX+1].equals("wall") )
                    return "R";
                else if ( !maze[currY+1][currX].equals("wall") )
                    return "D";
                else if ( !maze[currY][currX-1].equals("wall") )
                    return "L";
                else
                    return "U";
            case "L": //Left
                if ( !maze[currY+1][currX].equals("wall") )
                    return "D";
                else if ( !maze[currY][currX-1].equals("wall") )
                    return "L";
                else if ( !maze[currY-1][currX].equals("wall") )
                    return "U";
                else
                    return "R";
            case "R": //Right
                if ( !maze[currY-1][currX].equals("wall") )
                    return "U";
                else if ( !maze[currY][currX+1].equals("wall") )
                    return "R";
                else if ( !maze[currY+1][currX].equals("wall") )
                    return "D";
                else
                    return "L";
        }
        return prevMove; //In case no cases are met (should not occur)
    } //End of calculateMoveLeftHand Method
    
    //Finds the Next Move Based on Right Hand Rule
    public String calculateMoveRightHand( int currX, int currY, String prevMove ) {
        switch ( prevMove ) { //Orientation will change based on previous move
            case "U": //Up
                if ( !maze[currY][currX+1].equals("wall") ) //Checks if move is possible (not a wall)
                    return "R";
                else if ( !maze[currY-1][currX].equals("wall") )
                    return "U";
                else if ( !maze[currY][currX-1].equals("wall") )
                    return "L";
                else
                    return "D";
            case "D": //Down
                if ( !maze[currY][currX-1].equals("wall") )
                    return "L";
                else if ( !maze[currY+1][currX].equals("wall") )
                    return "D";
                else if ( !maze[currY][currX+1].equals("wall") )
                    return "R";
                else
                    return "U";
            case "L": //Left
                if ( !maze[currY-1][currX].equals("wall") )
                    return "U";
                else if ( !maze[currY][currX-1].equals("wall") )
                    return "L";
                else if ( !maze[currY+1][currX].equals("wall") )
                    return "D";
                else
                    return "R";
            case "R": //Right
                if ( !maze[currY+1][currX].equals("wall") )
                    return "D";
                else if ( !maze[currY][currX+1].equals("wall") )
                    return "R";
                else if ( !maze[currY-1][currX].equals("wall") )
                    return "U";
                else
                    return "L";
        }
        return prevMove; //In case no cases are met (should not occur)
    } //End of calculateMoveRightHand Method
    
    //Find the Next Move Randomly
    public String getRandomMove( int currX, int currY ) {
        ArrayList<String> moves = new ArrayList<>();
        
        if ( !maze[currY-1][currX].equals("wall") ) //Adds possible moves to ArrayList
            moves.add("U");
        if ( !maze[currY+1][currX].equals("wall") )
            moves.add("D");
        if ( !maze[currY][currX-1].equals("wall") )
            moves.add("L");
        if ( !maze[currY][currX+1].equals("wall") )
            moves.add("R");
        
        return moves.get(r.nextInt(moves.size())); //Randomly Selects a direction and returns
    } //End of getRandomMove Method
    
    
    //MAZE GENERATION METHODS
    
    //Generates Maze Using Randomized Prim's Algorithm
    public void createPrimMaze( int xStart, int yStart ) {
        maze[yStart][xStart] = "start"; //Sets start point of maze
        
        Points startPoint = new Points( xStart, yStart, null );
        ArrayList<Points> frontier = new ArrayList<>(); //ArrayList of possible points
        
        for ( int x = -1; x <= 1; x++ ) {
            for ( int y = -1; y <= 1; y++ ) {
                if ( x != 0 && y == 0 || x == 0 && y != 0 ) {
                    try {
                        //If an adjacent cell is a wall, add to frontier of possible points
                        if ( maze[yStart+y][xStart+x].equals("wall") )
                            frontier.add( new Points( xStart+x, yStart+y, startPoint ) );
                    } catch ( Exception e ) {}
                }
            }
        }
        
        Points exit = new Points( xStart, yStart, null ); //Initializing maze exit
        
        while( !frontier.isEmpty() ) { //while there are still possible points
            //Randomly choose a point and remove from frontiers
            Points currentPoint = frontier.remove( r.nextInt(frontier.size()) );
            Points otherPoint = currentPoint.other(); //Calculates opposite point
            
            try {
                //If both currentPoint and otherPoint are walls, make them a path
                if ( maze[currentPoint.y][currentPoint.x].equals("wall") 
                        && maze[otherPoint.y][otherPoint.x].equals("wall") ) {
                    maze[currentPoint.y][currentPoint.x] = "path";
                    maze[otherPoint.y][otherPoint.x] = "path";
                    
                    exit = otherPoint; //Set maze exit as most recent point
                    
                    //Find more possible points adjacent to otherPoint
                    for ( int x = -1; x <= 1; x++ ) {
                        for ( int y = -1; y <= 1; y++ ) {
                            if ( otherPoint.x+x > 1 && otherPoint.y+y > 1 
                                    && otherPoint.x+x < mazeX-2 && otherPoint.y+y < mazeY-2
                                    && ( x != 0 && y == 0 || x == 0 && y != 0 ) ) {    
                                try {
                                    if ( maze[otherPoint.y+y][otherPoint.x+x].equals("wall") )
                                        frontier.add( new Points( otherPoint.x+x, otherPoint.y+y, otherPoint ) );
                                } catch ( Exception e ) {}
                            }
                        }
                    }
                }
            } catch (Exception e) {}
            gui.paintMaze(maze); //paints maze
            gui.sleep(sleepTime); //sleep
        }
        if ( frontier.isEmpty() ) //No more possible points
            maze[exit.y][exit.x] = "exit"; //Set exit as last point
    } //End of createPrimMaze Method
    
    //Generates Maze Using Depth First Search
    public void createDepthFirstSearchMaze( int xStart, int yStart ) {
        ArrayList<Integer> randomDirection = new ArrayList<>();
        randomDirection.add(1);
        randomDirection.add(2);
        randomDirection.add(3);
        randomDirection.add(4);
        Collections.shuffle(randomDirection); //Randomly orders the 4 directions
        
        //Iterates through the list of directions by order of index
        for ( int i = 0; i < randomDirection.size(); i++ ) {
            switch( randomDirection.get(i) ){
                case 1: //Up
                    if ( yStart-2 <= 0 ) //If the move puts it past the top border
                        continue;
                    //Makes a path of length 2 in the specified direction as long as both cells are not already paths
                    if ( !maze[yStart-2][xStart].equals("path") ) {  
                        maze[yStart-2][xStart] = "path";
                        maze[yStart-1][xStart] = "path";
                        createDepthFirstSearchMaze( xStart, yStart-2 ); //Recursive call
                    } 
                    gui.paintMaze(maze); //Paints maze
                    gui.sleep(sleepTime); //Sleep
                    break;
                    
                case 2: //Right
                    if ( xStart+2 >= mazeX-1 ) //If the move puts it past the right border
                        continue;
                    if ( !maze[yStart][xStart+2].equals("path") ) {
                        maze[yStart][xStart+2] = "path";
                        maze[yStart][xStart+1] = "path";
                        createDepthFirstSearchMaze( xStart+2, yStart );
                    }
                    gui.paintMaze(maze);
                    gui.sleep(sleepTime);
                    break;
                    
                case 3: //Down
                    if ( yStart+2 >= mazeY-1 ) //If the move puts it past the bottom border
                        continue;
                    if ( !maze[yStart+2][xStart].equals("path") ) {
                        maze[yStart+2][xStart] = "path";
                        maze[yStart+1][xStart] = "path";
                        createDepthFirstSearchMaze( xStart, yStart+2 );
                    }
                    gui.paintMaze(maze);
                    gui.sleep(sleepTime);
                    break;
                    
                case 4: //Left
                    if ( xStart-2 <= 0 ) //If the move puts it past the left border
                        continue;
                    if ( !maze[yStart][xStart-2].equals("path") ) {
                        maze[yStart][xStart-2] = "path";
                        maze[yStart][xStart-1] = "path";
                        createDepthFirstSearchMaze( xStart-2, yStart );
                    }
                    gui.paintMaze(maze);
                    gui.sleep(sleepTime);
                    break;
            }
        }
    } //End of createDepthFirstSearchMaze Method
    
    
    //MAZE SOLVING METHODS
    
    //Solves Maze Using a Randomized Algorithm
    public void solveMazeRandomly( int xStart, int yStart ) {
        int prevX, prevY;
        int currX = xStart; //Sets current point as start point
        int currY = yStart;
        
        while ( !maze[currY][currX].equals("exit") ) { //while the exit has not been reached
            prevX = currX; //Sets previos point as current point
            prevY = currY;
            
            switch ( getRandomMove(currX, currY) ){ //Goes in a random direction
                case "U":
                    currY--;
                    break;
                case "D":
                    currY++;
                    break;
                case "L":
                    currX--;
                    break;
                case "R":
                    currX++;
                    break;
            }
            
            numberOfMoves++; //Increments number of comparisons
            gui.drawLabel(numberOfMoves); //Updates display
            gui.paintSolution(prevX, prevY, currX, currY, mazeX, mazeY); //Paints move as a line from previous to current point
            gui.sleep(sleepTime);
        }
    } //End of solveMazeRandomly Method
    
    //Solves Maze Using Left or Right Hand Rule
    public void solveMazeWallFollower( int xStart, int yStart, String method ) {
        String currMove;
        String prevMove = "D";
        int prevX, prevY;
        int currX = xStart; //Sets current point as start point
        int currY = yStart;

        while ( !maze[currY][currX].equals("exit") ) { //while exit has not been found
            prevX = currX; //Sets previous point as current point
            prevY = currY;
            
            if ( method.equals("left") ) //Calls calculateMove based on method (left/right)
                currMove = calculateMoveLeftHand( currX, currY, prevMove );
            else
                currMove = calculateMoveRightHand( currX, currY, prevMove );
            
            switch ( currMove ){ //Moves based on Left/Right Hand Rules
                case "U":
                    currY--;
                    break;
                case "D":
                    currY++;
                    break;
                case "L":
                    currX--;
                    break;
                case "R":
                    currX++;
                    break;
            }
            
            prevMove = currMove;
            numberOfMoves++; //Increments move counter
            gui.drawLabel(numberOfMoves);
            gui.paintSolution(prevX, prevY, currX, currY, mazeX, mazeY); //Paints line from previous to current point
            gui.sleep(sleepTime);
        }
    } //End of solveMazeWallFollower Method

    //Solves Maze Using Recursive Algorithm
    public boolean solveMazeRecursively( int xPrev, int yPrev, int xStart, int yStart, int xEnd, int yEnd ) {
        numberOfMoves++; //Increments Comparisons
        gui.drawLabel(numberOfMoves);
        
        if ( xStart == xEnd && yStart == yEnd ) //If exit has been reached
            return true;
        
        if ( maze[yStart][xStart].equals("wall") || visited[yStart][xStart] ) //If cell has been visited or is a wall
            return false;
        
        visited[yStart][xStart] = true; //Sets current cell as visited
        
        //The stuff below is called recursively until the exit is reached or all
        //possible paths are found to be dead ends
        if ( xStart > 0 ) { //Not at left edge of maze
            //Moves Left
            if ( solveMazeRecursively( xStart, yStart, xStart-1, yStart, xEnd, yEnd ) ) {
                gui.paintSolution(xPrev, yPrev, xStart, yStart, mazeX, mazeY); //Paints path only if it is correct
                gui.sleep(sleepTime);
                solution[yStart][xStart] = true; //Sets the cell as part of the solution path
                return true;
            }
        }
        if ( xStart < mazeX-1 ) { //Not at right edge of maze
            //Move Right
            if ( solveMazeRecursively( xStart, yStart, xStart+1, yStart, xEnd, yEnd ) ) {
                gui.paintSolution(xPrev, yPrev, xStart, yStart, mazeX, mazeY);
                gui.sleep(sleepTime);
                solution[yStart][xStart] = true;
                return true;
            }
        }
        if ( yStart > 0 ) { //Not at top of maze
            //Move Up
            if ( solveMazeRecursively( xStart, yStart, xStart, yStart-1, xEnd, yEnd ) ) {
                gui.paintSolution(xPrev, yPrev, xStart, yStart, mazeX, mazeY);
                gui.sleep(sleepTime);
                solution[yStart][xStart] = true;
                return true;
            }
        }
        if ( yStart < mazeY-1 ) { //Not at bottom of maze
            //Move Down
            if ( solveMazeRecursively( xStart, yStart, xStart, yStart+1, xEnd, yEnd ) ) {
                gui.paintSolution(xPrev, yPrev, xStart, yStart, mazeX, mazeY);
                gui.sleep(sleepTime);
                solution[yStart][xStart] = true;
                return true;
            }
        }
        return false; //No Solution, return false
    } //End of solveMazeRecursively Method

} //End of MazeGenerator Class
