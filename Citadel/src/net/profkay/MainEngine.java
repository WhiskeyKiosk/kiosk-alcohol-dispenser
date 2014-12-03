package net.profkay;

import net.states.*;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class MainEngine extends StateBasedGame
{

	private static final String GAME_NAME = "CITADEL";
	
	//CONSTRUCTORS
	public MainEngine() 
	{
		super(GAME_NAME);
	}

	//MAIN
	public static void main (String args[]) throws SlickException
	{
		AppGameContainer game = new AppGameContainer( new MainEngine() );
		
		game.setDisplayMode(Window.WIDTH, Window.HEIGHT, false);
		game.start();
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException 
	{
		gc.setTargetFrameRate(60);
		gc.setMaximumLogicUpdateInterval(60);
		gc.setAlwaysRender(false);
		gc.setVSync(true);
		gc.setShowFPS(true);	
		
		
		this.addState(new GameState());
		this.addState(new MenuState());
	}
}
