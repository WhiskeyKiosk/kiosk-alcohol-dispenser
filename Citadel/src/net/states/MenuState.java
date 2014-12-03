package net.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import net.debug.*;

public class MenuState extends BasicGameState
{
	//CONSTRUCTORS
	
	//SETTERS
	
	//GETTERS
	
	//OTHER METHODS
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException 
	{
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException 
	{
		DebugInfo dbug = new DebugInfo();
		g.drawString(dbug.mouseCoords(), 50, 50);
		
		g.drawString("MENU", 100, 100);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException 
	{
		if (gc.getInput().isKeyPressed(Input.KEY_0) )
		{
			sbg.enterState(States.GAME);
		}
	}

	@Override
	public int getID() 
	{
		return States.MENU;
	}

}
