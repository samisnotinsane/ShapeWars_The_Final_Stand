package shapewars;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class GroupSelectionP2 extends BasicGameState{
	String mouse = "Mouse pointer coordinates: null";
	Image background;
	
	// class constructor
		public GroupSelectionP2(int state) {
			System.out.println("Entered state: 4");
		}
		
		public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
			background = new Image("res/background/groupSelectionP2.png");
			
		}
		
		public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
			//g.drawString("This is the GroupSelectionP2 state", 100, 100);
			g.drawImage(background, 0, 0);
			g.drawString(mouse, 50, 450);
		}
		
		public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
			Input input = gc.getInput(); // input object for keyboard/mouse IO
			int xpos = Mouse.getX();
			int ypos = Mouse.getY();
			mouse = "Mouse pointer coordinates (x,y): (" + xpos + "," + ypos+")";
			
			// player 2 chooses Class A
			if((xpos>165 && xpos<345)&&(ypos>260&&ypos<415)) {
				if(input.isMouseButtonDown(0)) {
					System.out.println("Transitioning to State: 5");
					sbg.enterState(5);
					// TODO: Remember player 1 character selection
					
				}
			}
			
			// player chooses Class B
			if((xpos>684 && xpos<908)&&(ypos>163&&ypos<290)) {
				if(input.isMouseButtonDown(0)) {
					System.out.println("Transitioning to State: 6");
					sbg.enterState(6);
				}
			}
			
			
			// exit game if 'esc' key is pressed
			if(input.isKeyDown(Input.KEY_ESCAPE)) { System.exit(0);}
			
			if(input.isKeyDown(Input.KEY_LEFT)) { sbg.enterState(1);}
					
		}
		
		// returns ID for this state
		public int getID() {
			return 4;
		}

}