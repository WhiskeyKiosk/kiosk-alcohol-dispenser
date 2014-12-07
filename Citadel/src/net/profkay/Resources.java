package net.profkay;


import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;

public class Resources 
{
	private SpriteSheet spriteSheet_idle;
	private SpriteSheet spriteSheet_swing;
	private SpriteSheet spriteSheet_run;
	private SpriteSheet spriteSheet_die;
	private SpriteSheet spriteSheet_walk;
	
	private SpriteSheet tileSpriteSheet;
	
	//CONSTRUCTOR
	public Resources()
	{
	}
	
	//GETTERS
	
	//getter for spritesheet
	public SpriteSheet getPlayerSheet(String spec)
	{
		return specificSheet(spec);
	}
	
	//getter for tilesheet
	public SpriteSheet getTileSheet()
	{
		return tileSpriteSheet;
	}
	
	//getter for sound files
	
	
	//OTHER METHODS
	
	
	//image loader
	public Image imageLoader(String path) throws SlickException
	{
		return new Image(path);
	}
	
	//player spritesheet loader
	public void loadPlayerSheets() throws SlickException
	{
		spriteSheet_idle = new SpriteSheet( "res/sprites/SpriteSheets/playersheet_idle.png", 70, 70);
		spriteSheet_run = new SpriteSheet( "res/sprites/SpriteSheets/playersheet_run.png", 70, 70);
		//spriteSheet_walk = new SpriteSheet( "res/sprites/SpriteSheets/playersheet_walk.png", 70, 70);
		//spriteSheet_swing = new SpriteSheet( "res/sprites/SpriteSheets/playersheet_swing.png", 70, 70);
		//spriteSheet_die = new SpriteSheet( "res/sprites/SpriteSheets/playersheet_die.png", 70, 70);
		
		System.out.println("Player spritesheets loaded");
	}
	
	//tile spritesheet loader
	public void loadTileSheet() throws SlickException
	{
		tileSpriteSheet = new SpriteSheet( "res/sprites/SpriteSheets/tilesheet.png", 70, 70);
	}
	
	//sound loader
	public void loadSounds() throws SlickException
	{
		
	}
	
	
	//selection switch
	public SpriteSheet specificSheet(String spec)
	{
		switch (spec)
		{
			case "run":
				return spriteSheet_run;
			
			case "swing":
				return spriteSheet_swing;
				
			case "die":
				return spriteSheet_die;
				
			case "walk":
				return spriteSheet_walk;
				
			default:
				return spriteSheet_idle;
		}
			
	}
	
	
	

}
	
	
	
	
	
	
