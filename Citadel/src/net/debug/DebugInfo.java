package net.debug;

import org.newdawn.slick.Input;

public class DebugInfo
{
	
	
	Input i = new Input(0);
	
	//CONSTRUCTORS
	public DebugInfo() 
	{
	}
	
	//SETTERS
	
	//GETTERS
	
	//OTHER METHODS
	public String mouseCoords()
	{
		String info = "MOUSE COORDINATES";
		
		return info + ": " + i.getMouseX() + " " + i.getMouseY();
	}
	
	
	
}
