package shapewars;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class GroupBCharSelectionP1 extends BasicGameState{
	String mouse = "Mouse pointer coordinates: null";
	Image background;
	
	// class constructor
		public GroupBCharSelectionP1(int state) {
			System.out.println("Entered state: 3");
		}
		
		public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
			background = new Image("res/background/groupBCharSelectionP1.png");
			
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
			
			// Player 1 chooses B1
			if((xpos>159 && xpos<370)&&(ypos>152&&ypos<419)) {
				if(input.isMouseButtonDown(1)) {
					sbg.enterState(4);
					System.out.println("Transitioning to State: 4");
					// TODO: Remember player 1 character selection
					
				}
			}
			// Player 1 chooses B2
			if((xpos>681 && xpos<897)&&(ypos>150&&ypos<415)) {
				if(input.isMouseButtonDown(1)) {
					sbg.enterState(4);
					System.out.println("Transitioning to State: 4");
					// TODO: Remember player 1 character selection
					
				}
			}
			
			// exit game if 'esc' key is pressed
			if(input.isKeyDown(Input.KEY_ESCAPE)) { System.exit(0);}
			
			if(input.isKeyDown(Input.KEY_LEFT)) { sbg.enterState(1);}
					
		}
		
		// returns ID for this state
		public int getID() {
			return 3;
		}

}
