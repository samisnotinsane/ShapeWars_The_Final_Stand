package shapewars;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import javax.swing.*;

public class PlayState extends BasicGameState {
	String mouse = "Mouse pointer coordinates: null";
	// initial position of A1
	int A1X=0;
	int A1Y=0;
	// initial position of B2
	int C2X=1000;
	int C2Y=0;
	
	ArrayList <Image> imgList = new ArrayList<Image>();
	
	// class constructor
	public PlayState(int state) {
		System.out.println("Entered state: 7");
	}
	
	// class initialisation
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		imgList.add(new Image("res/background/play1_1.png"));
		imgList.add(new Image("res/characters/R_P1/Grp_A/A1_R.png"));
		imgList.add(new Image("res/characters/L_P2/Grp_C/C1_L.png"));
	}
	
	// draws graphics on screen
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// draw & place the background in the given position
		g.drawImage(imgList.get(0), 0, 0);
		g.drawImage(imgList.get(1), A1X, A1Y);
		g.drawImage(imgList.get(2), C2X, C2Y);
		
		// debug print: mouse position coordinates
		g.drawString(mouse, 50, 450);
	}
	
	// updates graphics on screen
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput(); // input object for keyboard/mouse IO
		// get X/Y position of mouse
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		// print mouse position coordinates
		mouse = "Mouse pointer coordinates (x,y): (" + xpos + "," + ypos+")";
		
		// move A1 up if 'A' is pressed
		if(input.isKeyDown(Input.KEY_A)) { A1Y -= 1;}
		// move A1 down if 'D' is pressed		
		if(input.isKeyDown(Input.KEY_D)) { A1Y += 1;}
		// TODO: Implement 'fire' for key 'S'
		
		
		// move C2 up if 'J' is pressed
		if(input.isKeyDown(Input.KEY_J)) { C2Y -= 1;}
		// move C2 down if 'L' is pressed
		if(input.isKeyDown(Input.KEY_L)) { C2Y += 1;}
		// TODO: Implement 'fire' for key 'K'		

		
		

		
		// exit game if 'esc' key is pressed
		if(input.isKeyDown(Input.KEY_ESCAPE)) { exitConfirmationDialog(); return;}
	}
	
	// returns ID for this state
	public int getID() {
		return 7;
	}
	
	public void exitConfirmationDialog() {
		String message="Do you really wish to exit?";
		String title="ShapeWars";
		int retVal=0;
		retVal = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
		if(retVal==JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		else {
			return;
		}
	}

}