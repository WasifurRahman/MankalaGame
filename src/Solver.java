
public class Solver implements mankalaPlayerId{
	
	/*
	 * The starting point of the game.
	 * Instantiates two agents (human/ minimax/ alpha beta pruning/ or other) and pass them to a game object.
	 * Here a TickTackToe game is implemented as an example. You need to extend the abstract class Game to create your own game.
	 * */
	
	public static void main(String[] args) 
	{
		

		MankalaAgent wasif = new HumanMankalaAgent("wasif",playerOne);
		//Agent human = new MinimaxTTTAgent("007");
		//Agent machine = new MinimaxTTTAgent("Smith");
		//MankalaAgent neamul = new HumanMankalaAgent("Neamul",playerTwo);
		//the AlphabetaAgent must get hold of the other agents role
		MankalaAgent neamul = new AlphaBetaMankalaAgent("neamul",playerTwo,wasif);

		//System.out.println(human.name+" vs. "+machine.name);
		
		//Game game = new TickTackToe(human,machine);
		Game game = new Mankala(wasif,neamul);
		game.play();
		
	}

}
