# PyraminxRandomizer
A randomizer of a Master Pyraminx written in Java
README:

Pyraminx Structure and Randomizer
Written By: Alexander Bix
Programming Language: Java (JDK version 14.0.2)

    Running the program:
      Running the Program through a terminal:
        -Download and install JDK 14.0.2 from here: https://www.oracle.com/java/technologies/javase-downloads.html
        -In a terminal, go to the directory of the 'Pyraminx' folder.
        -Then in the terminal, go to the directory of the 'src' folder.
        -Run the following command to compile the program: 'javac Main.java'
          -If this command doesn't work, make sure that environment variables are configured properly:
            -Instructions on how to do this: https://www.java.com/en/download/help/path.xml
        -Run the following command to start the program: 'java Main'
          -The program should be running now, prompting the user to:
            -Enter the number of random movements they want to happen
            -Enter 'r' to reset the Pyraminx
            -Enter 'q' to quit the program

	Running the Program with Intellij:
		-Download and install JDK 14.0.2 from here: https://www.oracle.com/java/technologies/javase-downloads.html
		-Download and install from Intellij (Community Edition) from here: https://www.jetbrains.com/idea/download/#section=windows
		-Open Intellij.
		-Click on 'File' on the top bar of Intellij
		-Click on 'Open' on the drop-down menu that should appear
		-Set the directory to the location of the 'Pyraminx' source code folder
		-Click on 'Run' on the top bar of Intellij 
		-Click on 'Run...' on the drop-down menu that should appear
		-Click 'Main' on the menu that should appear in the center of the screen
		-The program should be running now, prompting the user to:
			-Enter the number of random movements they want to happen
			-Enter 'r' to reset the Pyraminx
			-Enter 'q' to quit the program

    Data Structure:
      -There are four faces of the pyraminx:
        -They are named: 
          -Red
          -Yellow
          -Blue
          -Green

	-Every triangle node on a side is stored in an array of arrays:
		-The array values to access every node of a side:
					                 side[0][0]
				              side[1][0] side[1][1] side[1][2]
				   side[2][0] side[2][1] side[2][2] side[2][3] side[2][4]
			side[3][0] side[3][1] side[3][2] side[3][3] side[3][4] side[3][5] side[3][6]
		-Each triangle node will hold one of the following character values:
			-'r': Red
			-'y': Yellow
			-'b': Blue
			-'g': Green

	-When a face is selected to be modified, it is considered to be in the center. 
		-The faces that are left, right, and below the center face are tracked to ensure that all faces are modified properly upon movements.
			-When the 'Red' face is the center:
				-The 'Yellow' face is to the left
				-The 'Blue' face is to the right
				-The 'Green' face is below
			-When the 'Green' face is the center:
				-The 'Red' face is to the left
				-The 'Blue' face is to the right
				-The 'Yellow' face is below
			-When the 'Blue' face is the center:
				-The 'Red' face is to the left
				-The 'Yellow' face is to the right
				-The 'Green' face is below
			-When the 'Yellow' face is the center:
				-The 'Blue' face is to the left
				-The 'Red' face is to the right
				-The 'Green' face is below
				
	-The GUI output will display the four faces of the Pyraminx:
		-The left face displayed is the 'Yellow' face
		-The center face displayed is the 'Red' face
		-The right face displayed is the 'Blue' face
		-The bottom face displayed is the 'Green' face

    Randomizer:
      -For each movement that is randomized:
        -A random integer between 0-3 is picked to determine the center face:
          -If 0 is picked:
            -The 'Red' face is the center.
          -If 1 is picked:
            -The 'Green' face is the center.
          -If 2 is picked:
            -The 'Blue' face is the center.
          -If 3 is picked:
				-The 'Yellow' face is the center.
			
		-A random integer between 0-11 is picked to determine which triangle nodes will be affected relative to the center picked:
			-If 0 is picked:
				-The top row of the center is moved.
			-If 1 is picked:
				-The second row of the center is moved.
			-If 2 is picked:
				-The third row of the center is moved.
			-If 3 is picked:
				-The bottom row of the center is moved.
			-If 4 is picked:
				-The Bottom Left corner diagonal of the center is moved.
			-If 5 is picked:
				-The second left diagonal of the center is moved.
			-If 6 is picked:
				-The third left diagonal of the center is moved.
			-If 7 is picked:
				-The fourth left diagonal of the center is moved.
			-If 8 is picked:
				-The Bottom Right corner diagonal of the center is moved.
			-If 9 is picked:
				-The second right diagonal of the center is moved.
			-If 10 is picked:
				-The third right diagonal of the center is moved.
			-If 11 is picked:
				-The fourth right diagonal of the center is moved.
		-Surrounding Left, Right, and Bottom faces are modified as necessary for each movement.
		
		-A random integer between 0-1 is picked to determine which direction the triangle nodes selected will move:
			-If 0 is picked:
				-Selected triangle nodes will move to the left.
			-If 1 is picked:
				-Selected triangle nodes will move to the right.

	-After a random move is made, the following is displayed:
		-Face: A description of which face was modified on the GUI.
		-Direction: A description of which direction the selected triangle nodes moved.
		-Affected: A description of which triangle nodes were affected.
		-A GUI representation of the four faces of the Pyraminx. 



