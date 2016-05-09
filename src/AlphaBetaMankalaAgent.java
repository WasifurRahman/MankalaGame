
public class AlphaBetaMankalaAgent extends MankalaAgent implements mankalaPlayerId{
	
	int agentId;
	//The tow agents playing here.
	//remember that self plays in upper row and opponent in the lower row
	MankalaAgent self, opponent;
	
	public AlphaBetaMankalaAgent(String name, int Id,MankalaAgent opp) {
		// TODO Auto-generated constructor stub
		super(name);
		
		//getting hold of two agents
	    self = this;
	    opponent = opp;
		
		
		
		agentId =  Id;
		
		if(agentId ==playerTwo){
			super.setIndex(playerTwoFrom,playerTwoTo,playerTwoMankalaIndex);
		}
		else{
			//code should never reach here
			assert false;
		}
	}
	
	

	@Override
	
	public boolean makeMove(Game game) {
		// TODO Auto-generated method stub
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Mankala mankalaGame = (Mankala) game;
		
		int depth = 15;
		HoleValue best = max(mankalaGame,-100000,100000,depth);
		
		//yes, a best hole to choose from has been found
		if(best.holeNum!=-1)
		{
			return mankalaGame.executeMove(best.holeNum, this);
		}
		else{
			//should not reach upto here
			assert false;
			return false;
		}
		//every hole is the same,//may return false;
		
	}
	
	
	private HoleValue max(Mankala game,int alpha,int beta, int depth)
	{	
		HoleValue maxCVT = new HoleValue();
		maxCVT.utility = -1000000;
		
		//int winner = game.checkForWin();
		if(game.isFinished()){
			MankalaAgent winner = game.getWinner();
			
			//terminal check
	     	if(winner == self)//the Alphabeta agent wins
			{
				maxCVT.utility=1000;
				return maxCVT;
			}
			else if(winner ==  opponent) 
			{
				maxCVT.utility = -1000; //opponent wins
				return maxCVT;  
			}
			else if (winner == null)
			{
				maxCVT.utility = 0; //draw
				return maxCVT;  
			}
		}
		else if(depth==0){
			
			int utilVal = utility(game);
			
			maxCVT.utility =  utilVal;
			
			return maxCVT;
		}
		
     	//as the alphabeta agent is the max agent, we will try all his move
		for (int i = self.fromIndex; i < self.toIndex; i++) 
		{
			    //imvalid move, so continue
			    if(!game.isValidCell(i, self))continue;
				//save the gamestate
			    int[] savedState = new int[game.getArraySize()];
			    
				System.arraycopy(game.getGameArray(), 0, savedState, 0, savedState.length);
				
				//now make a temporary move
				boolean playAgain = game.executeMove(i, self);
				int v;
				if(playAgain){
					v = max(game,alpha,beta,depth-1).utility;
				}
				else{
					v = min(game,alpha,beta,depth-1).utility;
				}
				 
		
				if(v>maxCVT.utility)
				{
					maxCVT.utility=v;
					maxCVT.holeNum = i;
				}
				game.setGameArray(savedState);// reverting back to original state
				
				if(maxCVT.utility>=beta){
					return maxCVT;
							
				}
				
				alpha = Math.max(alpha, maxCVT.utility);
				
		}
		
		return maxCVT;
			
	}
	
	private int utility(Mankala game) {
		// TODO Auto-generated method stub
		//empthsize penalty
		int diffInMarbeCount = self.getTotalMarbleCount(game.getGameArray())- 5*opponent.getTotalMarbleCount(game.getGameArray());
		
		//now the opponent can take in all my marbles if they land in an empty pos.
		
		int maxRobbed = -10000000;
		int[] marbleCount = game.getGameArray();
		for(int i= opponent.fromIndex;i<opponent.toIndex;i++){
			//there is an empty state
			if(marbleCount[i] == 0){
				//check from left
				for(int j=0;j<i;j++){
					//the marbles will end at that empty pos
					if(marbleCount[j]==(i-j)){
						int robbedFromMe = marbleCount[game.oppositeHole(i)];
						if(robbedFromMe>=0){
							//the points he will get emphasized with multiplication
							int penalty = 5*(robbedFromMe+1);
							maxRobbed = Math.max(maxRobbed,penalty);
						}
					}
				}
			}
		}
		
       //i can take all his marbles if i land in an empty pos

		int maxRobOpp= -10000000;
		//int[] marbleCount = game.getGameArray();
		for(int i= self.fromIndex;i<self.toIndex;i++){
			//there is an empty state
			if(marbleCount[i] == 0){
				//check from left
				for(int j=0;j<i;j++){
					//the marbles will end at that empty pos
					if(marbleCount[j]==(i-j)){
						int robbedFromHim = marbleCount[game.oppositeHole(i)];
						if(robbedFromHim>=0){
							//the points he will get emphasized with multiplication
							int prize = 5*(robbedFromHim+1);
							maxRobOpp = Math.max(maxRobOpp,prize);
						}
					}
				}
			}
		}
		
		//now the config of my marbles matter. If there are states from which the last move will be to my mankala, they should be preferred
		int configReward= 0;
		int dest = self.getMankalaIndex();
		for(int i=self.fromIndex;i<self.toIndex;i++){
			int diff = (dest -i);
			//dorectly to the mankala,so rewarded
			if(marbleCount[i] == diff){
				configReward+= 5*marbleCount[i];
			}
			//passes ball to the opponent, so punished
			else if(marbleCount[i] > diff){
				configReward-= 5*(marbleCount[i] - diff);
			}
		}
		int finalScore = diffInMarbeCount - maxRobbed + maxRobOpp + configReward;
		return finalScore;
	}



	private HoleValue min(Mankala game,int alpha,int beta,int depth)
	{	
		HoleValue minCVT = new HoleValue();
		minCVT.utility = 1000000;
		
		//int winner = game.checkForWin();
		MankalaAgent winner = game.getWinner();
		
		//terminal check
		if(game.isFinished()){
	     	if(winner == self)//max wins
			{
				minCVT.utility=100;
				return minCVT;
			}
			else if(winner ==  opponent)//min wins 
			{
				minCVT.utility = -100; //opponent wins
				return minCVT;  
			}
			else if (winner == null)
			{
				minCVT.utility = 0; //draw
				return minCVT;  
			}
		}
        else if(depth==0){
			
			minCVT.utility =  utility(game);
			return minCVT;
		}
		
     	//as the alphabeta agent is the min agent, we will try all his move
		for (int i = opponent.fromIndex; i < opponent.toIndex; i++) 
		{
			    //invalid move, so continue
			    if(!game.isValidCell(i, opponent))continue;
				//save the gamestate
			    int[] savedState = new int[game.getArraySize()];
			    
				System.arraycopy(game.getGameArray(), 0, savedState, 0, savedState.length);
				
				//now make a temporary move
				boolean playAgain = game.executeMove(i, opponent);
				 
				int v;
				if(playAgain){
					v = min(game,alpha,beta,depth-1).utility;
				}
				else{
					v = max(game,alpha,beta,depth-1).utility;
				}
				
				if(v<minCVT.utility)
				{
					minCVT.utility=v;
					minCVT.holeNum = i;
				}
				game.setGameArray(savedState);// reverting back to original state
				
				if(minCVT.utility <= alpha){
					return minCVT;
					
				}
				
				beta = Math.min(beta, minCVT.utility);
				
		}
		
		return minCVT;
			
	}
	
	private int minRole()
	{
		if(role==0)return 1;
		else return 0;
	}

	class HoleValue
	{
		public int holeNum,utility;
		public HoleValue() {
			// TODO Auto-generated constructor stub
			holeNum = -1;
			
		}
	}

}
