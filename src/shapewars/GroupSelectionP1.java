package shapewars;

import javax.swing.JOptionPane;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class GroupSelectionP1 extends BasicGameState {
	String mouse = "Mouse pointer coordinates: null";
	Image background;
	
	// class constructor
	public GroupSelectionP1(int state) {
		System.out.println("Entered state: 1");
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		background = new Image("res/background/groupSelectionP1.png");
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		//g.drawString("This is the GroupSelectionP1 state", 100, 100);
		g.drawImage(background, 0, 0);
		g.drawString(mouse, 50, 450);
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput(); // input object for keyboard/mouse IO
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		mouse = "Mouse pointer coordinates (x,y): (" + xpos + "," + ypos+")";
		
		// player chooses Class A
		if((xpos>165 && xpos<345)&&(ypos>160&&ypos<300)) {
			if(input.isMouseButtonDown(0)) {
				System.out.println("Transitioning to State: 2");
				sbg.enterState(2);
			}
		}
		
		// player chooses Class B
		if((xpos>684 && xpos<908)&&(ypos>163&&ypos<290)) {
			if(input.isMouseButtonDown(0)) {
				System.out.println("Transitioning to State: 3");
				sbg.enterState(3);
			}
		}
		
		
		// exit game if 'esc' key is pressed
		if(input.isKeyDown(Input.KEY_ESCAPE)) { System.exit(0);}
		
		if(input.isKeyDown(Input.KEY_LEFT)) { sbg.enterState(0);}
				
	}
	
	// returns ID for this state
	public int getID() {
		return 1;
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
