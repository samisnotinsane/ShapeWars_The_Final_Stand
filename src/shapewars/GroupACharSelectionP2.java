package shapewars;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class GroupACharSelectionP2 extends BasicGameState{
	String mouse = "Mouse pointer coordinates: null";
	Image background;
	
	// class constructor
		public GroupACharSelectionP2(int state) {
			System.out.println("Entered state: 5");
		}
		
		public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
			background = new Image("res/background/groupACharSelectionP2.png");
			
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
			
			// Player 1 chooses character
			if((xpos>216 && xpos<350)&&(ypos>260&&ypos<415)) {
				if(input.isMouseButtonDown(1)) {
					sbg.enterState(7);
					System.out.println("Transitioning to State: 7");
					// TODO: Remember player 1 character selection
					
				}
			}
			
			// Player 1 chooses character
			if((xpos>681 && xpos<897)&&(ypos>150&&ypos<415)) {
				if(input.isMouseButtonDown(1)) {
					sbg.enterState(7);
					System.out.println("Transitioning to State: 7");
					// TODO: Remember player 1 character selection
					
				}
			}
			
			
			
			// exit game if 'esc' key is pressed
			if(input.isKeyDown(Input.KEY_ESCAPE)) { System.exit(0);}
			
			if(input.isKeyDown(Input.KEY_LEFT)) { sbg.enterState(1);}
					
		}
		
		// returns ID for this state
		public int getID() {
			return 5;
		}

}
