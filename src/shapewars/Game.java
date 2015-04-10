package shapewars;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame { // inheritance required for multiple screen based game

	// gameTitle will be fed to constructor to set the title for the game window
	public static final String gameTitle = "ShapeWars: The Final Stand";
	
	// int references for each state/screen. Each state is a separate class
	public static final int mainMenu = 0;
	// character selection states for Player1(P1)
	public static final int groupSelectionP1 = 1;
	public static final int groupACharSelectionP1 = 2;
	public static final int groupBCharSelectionP1 = 3;
	//public static final int groupCCharSelectionP1 = 4;
	// character selection states for Player2(P2)
	public static final int groupSelectionP2 = 4;
	public static final int groupACharSelectionP2 = 5;
	public static final int groupBCharSelectionP2 = 6;
	//public static final int groupCCharSelectionP2 = 8;
	public static final int playState = 7;
	public static final int gameOver = 8;
	
	// class constructor
	public Game(String title) {
		super(title); // pass title to StateBasedGame to set game title to the window
		//Polymorphism, creating an object of subclass with type of superclass.
        BasicGameState menu = new MainMenu(mainMenu); 
        BasicGameState p1Selection = new GroupSelectionP1(groupSelectionP1);
        BasicGameState p1SelectionA = new GroupACharSelectionP1(groupACharSelectionP1);
        BasicGameState p1SelectionB = new GroupBCharSelectionP1(groupBCharSelectionP1);
        BasicGameState p2Selection = new GroupSelectionP2(groupSelectionP2);
        BasicGameState p2SelectionA = new GroupACharSelectionP2(groupACharSelectionP2);
        BasicGameState p2SelectionB = new GroupBCharSelectionP2(groupBCharSelectionP2);
        BasicGameState play	= new PlayState(playState);   
		
		this.addState(menu);
		this.addState(p1Selection);
		this.addState(p1SelectionA);
		this.addState(p1SelectionB);
		this.addState(p2Selection);
		this.addState(p2SelectionA);
		this.addState(p2SelectionB);
		this.addState(play);
	}
	
	// implementation of abstract method required by superclass StateBasedGame
	public void initStatesList(GameContainer gc) throws SlickException {
		// initialise list of states required in this game
		this.getState(mainMenu).init(gc, this);
		this.getState(groupSelectionP1).init(gc, this);
		this.getState(groupACharSelectionP1).init(gc, this);
		this.getState(groupBCharSelectionP1).init(gc, this);
		this.getState(groupSelectionP2).init(gc, this);
		this.getState(groupACharSelectionP2).init(gc, this);
		this.getState(groupBCharSelectionP2).init(gc, this);
		this.getState(playState).init(gc, this);
		// mainMenu will be entered first
		this.enterState(mainMenu);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// create window for game
		AppGameContainer appgc;
		try {
			appgc = new AppGameContainer(new Game(gameTitle));
			appgc.setDisplayMode(1050, 600, false); // set size for container & false=not full screen mode
			appgc.start();
		} catch(SlickException ex) {
			ex.printStackTrace();
		}
		
		} // END main
	} // END Game
