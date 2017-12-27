package maze;

//Imports
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;

//MazeWindow Class
public class MazeWindow extends javax.swing.JFrame {
    
    //Initializing Variables
    
    //Numbers that fit well: 25, 35, 75 (Smaller Number Will Be Faster to Generate)
    //Solutions may be hard to follow as the maze gets larger
    //Especially the Random Solution( may run endlessly )
    //(this, mazeX, mazeY, sleepTime)
    MazeGenerator mg = new MazeGenerator(this, 35, 35, 15);
    
    Color color;
    Image img;
    
    
    public MazeWindow() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        drawingPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        solveLabel = new javax.swing.JLabel();
        generateLabel = new javax.swing.JLabel();
        leftHand = new javax.swing.JButton();
        primAlgorithm = new javax.swing.JButton();
        depthFirstSearch = new javax.swing.JButton();
        rightHand = new javax.swing.JButton();
        labelPanel = new javax.swing.JPanel();
        recursiveMethod = new javax.swing.JButton();
        randomMethod = new javax.swing.JButton();
        comparisonCounterLabel = new javax.swing.JLabel();
        resetSolution = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        drawingPanel.setBackground(new java.awt.Color(0, 0, 0));
        drawingPanel.setPreferredSize(new java.awt.Dimension(600, 600));

        javax.swing.GroupLayout drawingPanelLayout = new javax.swing.GroupLayout(drawingPanel);
        drawingPanel.setLayout(drawingPanelLayout);
        drawingPanelLayout.setHorizontalGroup(
            drawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        drawingPanelLayout.setVerticalGroup(
            drawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        titleLabel.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Maze Generator & Solver");
        titleLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        solveLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        solveLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        solveLabel.setText("Solve Maze");

        generateLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        generateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        generateLabel.setText("Generate Maze");

        leftHand.setBackground(new java.awt.Color(51, 204, 255));
        leftHand.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        leftHand.setText("Left Hand");
        leftHand.setActionCommand("LeftHand");
        leftHand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftHandSolve(evt);
            }
        });

        primAlgorithm.setBackground(new java.awt.Color(255, 153, 0));
        primAlgorithm.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        primAlgorithm.setText("PrimAlgorithm");
        primAlgorithm.setBorderPainted(false);
        primAlgorithm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                primAlgorithmMazeGenerate(evt);
            }
        });

        depthFirstSearch.setBackground(new java.awt.Color(255, 153, 0));
        depthFirstSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        depthFirstSearch.setText("DepthFirstSearch");
        depthFirstSearch.setBorderPainted(false);
        depthFirstSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depthFirstSearchMazeGenerate(evt);
            }
        });

        rightHand.setBackground(new java.awt.Color(51, 204, 255));
        rightHand.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rightHand.setText("Right Hand");
        rightHand.setActionCommand("RightHand");
        rightHand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightHandSolve(evt);
            }
        });

        labelPanel.setBackground(new java.awt.Color(0, 0, 0));
        labelPanel.setPreferredSize(new java.awt.Dimension(600, 600));

        javax.swing.GroupLayout labelPanelLayout = new javax.swing.GroupLayout(labelPanel);
        labelPanel.setLayout(labelPanelLayout);
        labelPanelLayout.setHorizontalGroup(
            labelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 152, Short.MAX_VALUE)
        );
        labelPanelLayout.setVerticalGroup(
            labelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        recursiveMethod.setBackground(new java.awt.Color(51, 204, 255));
        recursiveMethod.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        recursiveMethod.setText("Recursive");
        recursiveMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recursiveSolve(evt);
            }
        });

        randomMethod.setBackground(new java.awt.Color(51, 204, 255));
        randomMethod.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        randomMethod.setText("Random");
        randomMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomSolve(evt);
            }
        });

        comparisonCounterLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        comparisonCounterLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comparisonCounterLabel.setText("Comparison Counter");

        resetSolution.setBackground(new java.awt.Color(255, 51, 51));
        resetSolution.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        resetSolution.setText("ResetSolution");
        resetSolution.setActionCommand("ResetSolution");
        resetSolution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetSolution(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(depthFirstSearch)
                .addGap(42, 42, 42)
                .addComponent(primAlgorithm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(recursiveMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(randomMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(leftHand, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(rightHand, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(172, 172, 172))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(comparisonCounterLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(generateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(solveLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(drawingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(211, 211, 211))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(resetSolution)
                .addGap(446, 446, 446))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(comparisonCounterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(drawingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(solveLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(leftHand, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(primAlgorithm, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(depthFirstSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rightHand, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recursiveMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(randomMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resetSolution, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Generates Maze Using Randomized Prim's Algorithm and Paints to Screen
    private void primAlgorithmMazeGenerate(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_primAlgorithmMazeGenerate
        mg.resetMaze( "wall" ); //Sets maze as all walls
        mg.createPrimMaze( 1, 1 );
        paintMaze( mg.maze ); //Paints completed maze
    }//GEN-LAST:event_primAlgorithmMazeGenerate

    //Generates Maze Using Depth First Search and Paints to Screen
    private void depthFirstSearchMazeGenerate(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depthFirstSearchMazeGenerate
        mg.resetMaze( "wall" ); //Sets maze as all walls
        mg.createDepthFirstSearchMaze( 1, 1 );
        mg.maze[1][1] = "start"; //Sets start point of maze
        
        if ( mg.mazeX%2 == 0 ) //Sets end point based on maze size (odd or even)
            mg.maze[mg.mazeY-3][mg.mazeX-3] = "exit";
        else
            mg.maze[mg.mazeY-2][mg.mazeX-2] = "exit";
        
        paintMaze( mg.maze ); //Paints completed maze
    }//GEN-LAST:event_depthFirstSearchMazeGenerate

    //Solves Maze Using Left Hand Rule
    private void leftHandSolve(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftHandSolve
        Point start = mg.getMazeStart(); //Finds start point of maze
        mg.numberOfMoves = 0; //Resets number of comparisons
        color = Color.blue; //Sets path colour to blue
        mg.solveMazeWallFollower(start.x, start.y, "left");
    }//GEN-LAST:event_leftHandSolve

    //Solves Maze Using Right Hand Rule
    private void rightHandSolve(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightHandSolve
        Point start = mg.getMazeStart(); //Finds start point of maze
        mg.numberOfMoves = 0; //Resets number of comparisons
        color = Color.red; //Sets path colour to red
        mg.solveMazeWallFollower(start.x, start.y, "right");
    }//GEN-LAST:event_rightHandSolve

    //Solves Maze Using Recursive Algorithm
    private void recursiveSolve(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recursiveSolve
        Point start = mg.getMazeStart(); //Finds start and end points
        Point end = mg.getMazeEnd();
        
        for ( int i=0; i<mg.mazeY; i++ ) { //Fills visited and solution arraylists
            for ( int j=0; j<mg.mazeX; j++ ) {
                mg.visited[i][j] = false;
                mg.solution[i][j] = false;
            }
        }
        
        mg.numberOfMoves = 0; //Resets number of comparions
        color = Color.green; //Sets path colour to green
        mg.solveMazeRecursively(start.x, start.y, start.x, start.y, end.x, end.y);
    }//GEN-LAST:event_recursiveSolve

    //Solves Maze Using Randomized Approach
    private void randomSolve(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomSolve
        Point start = mg.getMazeStart(); //Finds start point of maze
        mg.numberOfMoves = 0; //Resets number of comparisons
        color = Color.cyan; //Sets path colour to cyan
        mg.solveMazeRandomly(start.x, start.y);
    }//GEN-LAST:event_randomSolve

    //Clears the Solutions But Keeps the Maze
    private void resetSolution(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetSolution
        Graphics g = this.drawingPanel.getGraphics();
        g.drawImage(img, 0, 0, this); //Redraws maze image onto screen
    }//GEN-LAST:event_resetSolution
    
    //Sleep
    public void sleep(int duration) {
        try {
            Thread.sleep(duration);
        } 
        catch (Exception e) {}
    } //End of sleep Method
    
    //Paints the Maze onto the Drawing Panel
    public void paintMaze( String[][] maze ) {
        img = createImage( maze ); //Calls createImage method
        Graphics g = this.drawingPanel.getGraphics();
        g.drawImage(img, 0, 0, this); //Draws image to screen
    } //End of paintMaze Method

    //Creates the Maze as an Image
    public Image createImage( String[][] maze ) {
        int width = this.drawingPanel.getWidth(); //Gets width and height of drawing panel
        int height = this.drawingPanel.getHeight();        
        
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) bufferedImage.getGraphics();
        
        g.setColor(Color.white); //Draws a white background
        g.fillRect(0, 0, width , height);
        
        int x;
        int y = 0;
        int xInc = width/maze[0].length; //Calculates the size of each cell
        int yInc = height/maze.length;
        
        for ( int i=0; i<maze.length; i++ ) { //Row Number
            x = 0;
            for ( int j=0; j<maze[0].length; j++ ) { //Column Number
                switch (maze[i][j]) { //Changes colour based on state of current cell
                    case "wall":
                        g.setColor(Color.black);
                        break;
                    case "path":
                        g.setColor(Color.white);
                        break;
                    case "start":
                        g.setColor(Color.green);
                        break;
                    default:
                        g.setColor(Color.red);
                        break;
                }
                g.fillRect(x, y, xInc, yInc); //Draws rectangle at positon
                x += xInc; //Increments x by cellWidth
            }
            y += yInc; //Increments y by cellHeight
        }
        return bufferedImage; //Returns image
    } //End of createImage Method  
    
    //Paints the Solution to the Maze
    public void paintSolution( int x1, int y1, int x2, int y2, int mazeX, int mazeY ) {
        int width = this.drawingPanel.getWidth(); //Gets width and height of drawing panel
        int height = this.drawingPanel.getHeight();
        Graphics g = this.drawingPanel.getGraphics();
        
        int xInc = width/mazeX; //Finds size of each cell
        int yInc = height/mazeY;
        
        //Draws a line from the middle of the first cell to the middle of the second cell
        g.setColor(color);
        g.drawLine(x1*xInc + xInc/2, y1*yInc + yInc/2, x2*xInc + xInc/2, y2*yInc + yInc/2);
    } //End of paintSolution Method

    //Paints the Counter onto the Label Panel
    public void drawLabel( int counter ) {
        int width = this.labelPanel.getWidth(); //Gets width and height of panel
        int height = this.labelPanel.getHeight();        
        Graphics g = this.labelPanel.getGraphics();
        
        g.setColor(Color.black); //Draws black background for panel
        g.fillRect(0, 0, width, height);
        
        g.setColor(Color.white); //Displays the counter
        g.drawString("Number of Moves: " + counter, 7, 25);
    } //End of drawLabel Method
    
    //main
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MazeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MazeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MazeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MazeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MazeWindow().setVisible(true);
            }
        });
    } //End of main Method

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel comparisonCounterLabel;
    private javax.swing.JButton depthFirstSearch;
    private javax.swing.JPanel drawingPanel;
    private javax.swing.JLabel generateLabel;
    private javax.swing.JPanel labelPanel;
    private javax.swing.JButton leftHand;
    private javax.swing.JButton primAlgorithm;
    private javax.swing.JButton randomMethod;
    private javax.swing.JButton recursiveMethod;
    private javax.swing.JButton resetSolution;
    private javax.swing.JButton rightHand;
    private javax.swing.JLabel solveLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
