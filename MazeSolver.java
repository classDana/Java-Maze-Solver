import io.In;
import io.Out;

public class MazeSolver{
	
	public static void main (String[] args) throws Exception{
		final String [] files = {"MazeWithExit.txt", "MazeWithExit2.txt", "MazeWithoutExit.txt", "MazeWithoutExit2.txt"};
		for(String fileName: files){
			Maze game = new Maze(fileName);
			game.play(fileName);
		}
	}
}

