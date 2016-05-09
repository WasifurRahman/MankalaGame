
/**
 * Extend this abstract class for human/ AI agent
 * @author Azad
 *
 */
public abstract class MankalaAgent 
{
	String name; // Name of the agent
	int role; // This is important, Each agent will be assigned a role beforehand. 
				//For example, for tick tack toe X will be assigned to one agent, and 0 will be assigned to another agent
				// The roles are stored as integer. 
	
	public int fromIndex,toIndex;
	private int mankalaIndex;
	
	public void setIndex(int from,int to,int mankala){
		fromIndex = from;
		toIndex = to;
		setMankalaIndex(mankala);
	}
	
	public MankalaAgent(String name) 
	{
		// TODO Auto-generated constructor stub
		this.name = name;
		
	}
	
	/**
	 * Sets the role of this agent. Typlically will be called by your extended Game class (The  class which extends the Game Class).
	 * @param role
	 */
	public void setRole(int role) {
		this.role = role;
	}
	
	/**
	 * 
	 * @param holeNum
	 * @return
	 */
	public boolean isOwnHole(int holeNum){
		return holeNum>=fromIndex && holeNum < toIndex;
	}
	
	public boolean isSolved(int marbleCount[]){
		    
			
			for(int i = fromIndex;i<toIndex;i++){
				if(marbleCount[i]>0){
			        return false;
				}
			}
			
			return true;
	}

	/**
	 * Implement this method to select a move, and change the game state according to the chosen move.
	 * @param game
	 */
	public abstract boolean makeMove(Game game);

	public int getMankalaIndex() {
		return mankalaIndex;
	}

	public void setMankalaIndex(int mankalaIndex) {
		this.mankalaIndex = mankalaIndex;
	}
	
	/**
	 * Cleans up all the remaining marbles and put them into agents own mankala
	 * @param marbleCount
	 */

	public void cleanUp(int[] marbleCount) {
		// TODO Auto-generated method stub
		int remMarbleCount = 0;
		for(int i=fromIndex;i<toIndex;i++){
			remMarbleCount+=marbleCount[i];
			marbleCount[i] = 0;
		}
		marbleCount[mankalaIndex]+=remMarbleCount;
		
	}
	
	public int getMarbleCount(int[] marbleCount){
		return marbleCount[mankalaIndex];
	}
	
	public int getTotalMarbleCount(int[] marbleCount){
		int tot = 0;
		for(int i=fromIndex;i<toIndex;i++){
			tot+= marbleCount[i];
		}
		
		tot+=marbleCount[mankalaIndex];
		return tot;
		
	}
	
	

}
