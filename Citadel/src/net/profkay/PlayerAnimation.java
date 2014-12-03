package net.profkay;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;

public class PlayerAnimation extends Resources
{
	
	private Animation swing;
	private Animation run; 
	private Animation idle;
	private Animation die; 
	
	private boolean facingLeft;
	private boolean facingRight;
	
	private Animation currentAnimation;

	//CONSTRUCTOR
	public PlayerAnimation()
	{
		super();
	}
	
	//GETTERS
	//animation getters
	public Animation getAnimation()
	{
		return currentAnimation;
	}
	
	//direction getter
	public boolean getDirection(String direction)
	{
		switch (direction)
		{
			case "left": 
				return facingLeft;
			
			default:
				return facingRight;
		}
		
		
		
	}
	
	public Animation getFlippedAnim()
	{
		currentAnimation.getCurrentFrame().getFlippedCopy(true, false);
		//System.out.println("SPRITE FLIPPED");
		return currentAnimation;
	}
	
	public Animation resetRotation()
	{
		currentAnimation.getCurrentFrame().setRotation(0);
		return currentAnimation;
	}
	
	
	

	//SETTERS
	//specific animation speed setter
	public void setAnimSpeed(String spec, float spd)
	{
		Animation specAnim = specificAnim(spec);
		specAnim.setSpeed(spd);
	}
	
	public void setAnimation(String spec)
	{
		currentAnimation = specificAnim(spec);
	}
	
	//direction setters
	public void setDirection(String direction, boolean dir)
	{
		if (direction == "left" && dir == true)
			facingLeft = true;
		
		else if (direction == "left" && dir == false)
			facingLeft = false;
		
		else if (direction == "right" && dir == true)
			facingRight = true;
		
		else if (direction == "right" && dir == false)
			facingRight = false;
		
		else
			System.out.println("Invalid dir");
			
		
	}

	
	
	//OTHER METHODS

	
	
	//animation loader
	public void loadAnims() throws SlickException
	{
		super.loadPlayerSheets();
		
		
		idle = new Animation(super.getPlayerSheet("idle"), 200) ;
		run = new Animation(super.getPlayerSheet("run"), 45);
		//walk = new Animation (sueper.getPlayerSheet("walk", 70, 70);
		//swing = new Animation(super.getPlayerSheet("swing"), 100);
		//die = new Animation(super.getPlayerSheet("die"), 100);
		
		System.out.println("Player animations loaded");

	}
	
	
	//selection switch
	public Animation specificAnim(String spec)
	{
		switch (spec)
		{
			case "run":
				return run;
			
			case "swing":
				return swing;
				
			case "die":
				return die;
				
			default:
				return idle;
		}
	}
	
	public void clearDirection()
	{
		facingLeft = false;
		facingRight = false;
	}
	
	public void switchAnimTo(String spec)
	{
		currentAnimation = specificAnim(spec);
	}
	
	
}