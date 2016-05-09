
public class Mankala extends Game implements mankalaPlayerId{

	private int[] marbleCount = new int[14];
	private int arraySize = 14;
	
	
	
	
	public Mankala(MankalaAgent a, MankalaAgent b) {
		super(a, b);
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean isFinished() {
		// TODO Auto-generated method stub
		//the game finishes on two instance,
		//if the holes of the first players are all empty
		
		for(int i=0;i<agent.length;i++){
			MankalaAgent curAgent = agent[i];
			
			if(curAgent.isSolved(marbleCount)){
				
				MankalaAgent otherAgent = this.otherAgent(curAgent);
				//just before cleanup, show it again
				//showGameState();
				otherAgent.cleanUp(marbleCount);
				return true;
			}
		}
		return false;
	
	}
	
	@Override
	
	public MankalaAgent getWinner(){
		MankalaAgent one = this.agent[0];
		MankalaAgent two = this.agent[1];
		int oneCount = one.getMarbleCount(marbleCount);
		int twoCount = two.getMarbleCount(marbleCount);
		
		if(oneCount>twoCount){
			return one;
		}
		else if(oneCount < twoCount){
			return two;
		}
		else{
			//draw
			return null;
		}
	}
	
	
	@Override
	void initialize(boolean fromFile) {
		// TODO Auto-generated method stub
		//every hole has 4 marbles each at the beginning
		
		for(int i=0;i< marbleCount.length;i++){
			marbleCount[i] = 4;
		}
		marbleCount[playerOneMankalaIndex] = 0;
		marbleCount[playerTwoMankalaIndex] = 0;
		
		
	
		
		
	}

	@Override
	void showGameState() {
		
		gui.updateCount(marbleCount);
		// TODO Auto-generated method stub
		//print the holes of the second player in reverse order
		int cnt=0;

		for(int i=playerTwoTo-1;i>=playerTwoFrom;i--){
			System.out.print(" " + String.format("%2d",marbleCount[i]));
			cnt++;
		}
		System.out.println();
		
		System.out.print(String.format("%2d",marbleCount[playerTwoMankalaIndex]));
		for(int i=0;i<2.7* cnt;i++)System.out.print(" ");
		System.out.print(String.format("%2d",marbleCount[playerOneMankalaIndex]));
		System.out.println();
		
		for(int i=playerOneFrom;i<playerOneTo;i++){
			System.out.print(" " + String.format("%2d",marbleCount[i]));
		}
		System.out.println();
		System.out.println();
		System.out.println();
	}

	@Override
	void updateMessage(String msg) {
		// TODO Auto-generated method stub
		System.out.println(msg);
		gui.updateTurn(msg);
		
	}
	
	public int getArraySize(){
		return arraySize;
	}
	
	public int[] getGameArray(){
		return marbleCount;
	}
	
	public void setGameArray(int[] a){
		marbleCount = a;
	}
	
	
	
	public boolean isValidCell(int holeNum, MankalaAgent agent) {
		// TODO Auto-generated method stub
		return agent.isOwnHole(holeNum) && marbleCount[holeNum]>0;
		
	}

	
	
	public int oppositeHole(int hole){
		return Math.abs(12 - hole);
	}
	
	private MankalaAgent otherAgent(MankalaAgent curAgent){
		if(curAgent.equals(this.agent[0])){
			return this.agent[1];
		}
		return this.agent[0];
	}
	
	//return true if the user will get another round of move, false otherwise
	public boolean executeMove(int holeNum,MankalaAgent curAgent) {
		// TODO Auto-generated method stub
		//how many marbles are there
		int ownMankala = curAgent.getMankalaIndex();
		int opponentMankala = otherAgent(curAgent).getMankalaIndex();
		
		int numMarble = marbleCount[holeNum];
		marbleCount[holeNum] = 0;
		int curIndex = holeNum;
		//go on until all the marbles are distributed
		
		while(numMarble >0){
			//index is incremented first since the distribution begins from the right of the selected hole
			curIndex=(curIndex+1)%arraySize;
			//now if this is the index of the opponent user's mankala, we have to skip it
			if(curIndex == opponentMankala){
				continue;
			}
			
			//else increment the marble count of that index
			marbleCount[curIndex]++;
			//and decrease marble count by one
			numMarble--;
			
			
		}
		
		//if the curIndex ends in a position which was mine and previously empty, we can bring in all the other marbles of the
		//opposite position
		boolean isOwnHole  = curAgent.isOwnHole(curIndex);
		
		//there is only one marble which we inserted
		if(isOwnHole && marbleCount[curIndex]==1){
			int oppositeHoleIndex = oppositeHole(curIndex);
			int numMarbleInOppositeHole = marbleCount[oppositeHoleIndex];
			if(numMarbleInOppositeHole>0){
				int newGain = marbleCount[curIndex] + marbleCount[oppositeHoleIndex];
				marbleCount[ownMankala]+=newGain;
				marbleCount[curIndex] = 0;
				marbleCount[oppositeHoleIndex] = 0;
			}
		}
		
		//if curIndex ends in own mankala, then we return true;
		if(curIndex == ownMankala){
			return true;
		}
		
		return false;
		
	}

}
