package net.profkay;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
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
	
	private Image flippedAnimation[]; //for storing an identical but flipped-horizontally animation
	
	
	private Animation idle_left;
	private Animation run_left;
	
	//private Animation swing_left;
	//private Animation die_left;
	
	

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
	
	
	public void setFlippedAnimation(Animation anim) //setter for horizontally flipping animations
	{
		
		Image flippedFrame;
		flippedAnimation = new Image[anim.getFrameCount()];
		//FIGURE OUT HOW TO CREATE A NEW FLIPPED-ANMATION BY GETTING THE FRAMES FROM THE CURRENT-ANIMATION
		
		for (int i = 0; i < anim.getFrameCount(); i ++)
		{
			flippedFrame = anim.getImage(i).getFlippedCopy(true, false);
			flippedAnimation[i] = flippedFrame;
		}
	}
	
	public Image[] getFlippedAnimation() //getter for horizontally flipping animations
	{
		return flippedAnimation;
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
	
	//frame image flipper
	
	
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
		
		
		setFlippedAnimation(idle);
		idle_left = new Animation(getFlippedAnimation(), 200);
		 
	    setFlippedAnimation(run);
		run_left = new Animation(getFlippedAnimation(), 45);
		 
		/*
		setFlippedAnimation(walk);
		walk_left = new Animation(getFlippedAnimation(), duration);
		 
		setFlippedAnimation(swing);
		swing_left = new Animation(getFlippedAnimation(), duration);
		 
		setFlippedAnimation(die);
		die_left = getFlippedAnimation();
		 */
		
		System.out.println("Player animations loaded");
	}
	
	
	//selection switch
	public Animation specificAnim(String spec)
	{
		switch (spec)
		{
			case "run":
				return run;
			case "run_left":
				return run_left;
			
			case "swing":
				return swing;
			//case "swing_left":
				//return swing_left;
				
			case "die":
				return die;
				
			case "idle_left":
				return idle_left;
			default:
				return idle;
		}
	}
	
	public void clearDirection()
	{
		facingLeft = false;
		facingRight = false;
	}
	
	public Animation getAltAnim(String spec)//used to get alternate variations of the standard animations
	{
		Animation specAnim = specificAnim(spec);
		
		return specAnim;
	}
	
	
}