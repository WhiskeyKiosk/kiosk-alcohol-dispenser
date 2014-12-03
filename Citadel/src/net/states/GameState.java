package net.states;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import net.debug.*;
import net.profkay.PlayerAnimation;
import net.profkay.Resources;

public class GameState extends BasicGameState
{
	//CONSTRUCTORS
	private Resources res = new Resources();
	private PlayerAnimation playerAnim = new PlayerAnimation();
	
	//SETTERS
	
	
	//GETTERS
	
	//OTHER METHODS
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException 
	{
		res.loadPlayerSheets();
		playerAnim.loadAnims();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException 
	{
		DebugInfo dbug = new DebugInfo();
		g.drawString(dbug.mouseCoords(), 50, 50);
		
		g.drawString("GAME", 100, 100);
		
				
		//directional animation switching
		if (gc.getInput().isKeyDown(Input.KEY_D))
		{
			playerAnim.setAnimation("run");
			playerAnim.setDirection("right", true);
			g.drawAnimation(playerAnim.getAnimation(), 400, 400);
		}
		
		else if (gc.getInput().isKeyDown(Input.KEY_A) )
		{	
			playerAnim.setAnimation("run");
			playerAnim.setDirection("left", true);
			g.drawAnimation(playerAnim.getFlippedAnim(), 400, 400);
		}
		
		else 
			playerAnim.setAnimation("idle");
			playerAnim.clearDirection();
			g.drawAnimation(playerAnim.getAnimation(), 400, 400);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException 
	{
		if (gc.getInput().isKeyPressed(Input.KEY_1) )
		{
			sbg.enterState(States.MENU);
		}
		
		//movement animation testing
		
		
		

	}

	@Override
	public int getID() 
	{
		return States.GAME;
	}

}
