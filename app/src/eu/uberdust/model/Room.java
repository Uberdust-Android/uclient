package eu.uberdust.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Room implements Serializable  {

	private ArrayList<Capability> capabilities = new ArrayList<Capability>();
	private ArrayList<Capability> commands = new ArrayList<Capability>();
	
	public ArrayList<Capability> getCapabilities() {
		return capabilities;
	}
	
	public ArrayList<Capability> getCommands() {
		return commands;
	}

	public void appendCapability(Capability c)
	{
		capabilities.add(c);
	}
	
	public void appendCommand(Capability c)
	{
		commands.add(c);
	}
	
	public int getCapabilitiesNum()
	{
		return capabilities.size();
	}
	
	public int getCommandsNum()
	{
		return commands.size();
	}
	
	public Capability getCapability(int i)
	{
		return capabilities.get(i);
	}
	
	public Capability getCommand(int i)
	{
		return commands.get(i);
	}

}
