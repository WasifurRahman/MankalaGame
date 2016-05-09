import java.util.Scanner;

public class HumanMankalaAgent extends MankalaAgent implements mankalaPlayerId{
	
	static Scanner in = new Scanner(System.in);

	int agentId;


	public HumanMankalaAgent(String name,int Id) {
		super(name);
		agentId =  Id;
		if(agentId ==playerOne){
			
			super.setIndex(playerOneFrom,playerOneTo,playerOneMankalaIndex);
		}
		else{
			//code should never reach here
			assert false;
		}
		
		// TODO Auto-generated constructor stub
	}
	
	public int getAgentId(){
		return agentId;
	}

	@Override
	public boolean makeMove(Game game) {
		// TODO Auto-generated method stub
		
		int holeNum;
		//TickTackToe tttGame = (TickTackToe) game;
		Mankala mankalaGame = (Mankala) game;
		
		boolean first = true;
		do
		{
			if(first) 	System.out.println("select the hole");
			else System.out.println("Invalid input! select hole again");
			//holeNum = in.nextInt();
			holeNum = game.gui.getButtonNo();
			//1 based index for making it more intuitive
			//holeNum--;
			first=false;
		}while(!mankalaGame.isValidCell(holeNum,this));
		
		//tttGame.board[row][col] = role;
		
		return mankalaGame.executeMove(holeNum,this);
		

	}
	
	


}
