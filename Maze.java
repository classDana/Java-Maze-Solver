import io.In;
import io.Out;

public class Maze{
	final int height;
	final int width;
	final char field [][];
	boolean goal = false;
		
	public Maze(String fileName) {
		In.open(fileName);
	
		height = In.readInt();
		width = In.readInt();
		field = new char[height][width];
		
		//insert characters in array
		for(int row = 0; row < height; row++) {
            for(int col = 0; col < width; col++) {
				field[row][col] = In.read();
            }
            In.readLine();
        }
        In.close();
	}
	
	public void printField(){
		for(int row = 0; row < field.length; row++){
			Out.print(field[row]);
			Out.println();
		}
	}
	
	//searching for the startpoint
	private void start(){
		for(int row = 0; row < height; row++){
			for(int column = 0; column < width; column++){
				if(field[row][column]== '*'){
					exploreMaze(row, column);
					break;
				}
			}	
		}
	}
	//searching the goal
	public boolean exploreMaze(int x, int y){
		if(field[y][x] != '*'){
			field[y][x] = '.';
		}
		//Out.println("x: "+x +"\n"+"y: "+y);
		if(x == width-1 || y==height-1 || x == 0 || y == 0){
			goal = true;
			return true;
		//left	
		}else if(field[y][x-1] != '#' && field[y][x-1] != '.' && exploreMaze(x-1,y)){
			x--;
		//right	
		}else if(field[y][x+1] != '#' && field[y][x+1] != '.' && exploreMaze(x+1,y)){
			x++;
		//up	
		}else if(field[y-1][x] != '#' && field[y-1][x] != '.' && exploreMaze(x,y-1)){
			y--;
		//down	
		}else if(field[y+1][x] != '#' && field[y+1][x] != '.' && exploreMaze(x,y+1)){
			y++;
			
		}
		return false;
		
	}
	//GameLoop
	public void play(String fileName){
		Out.println("Die Lösung von folgender Textdatei: " + fileName);
		start();
		printField();
		
		
		if(goal){
			Out.println("Ziel erreicht!");
		}else{
			Out.println("Sackgasse! :|");
		}
		Out.print("\n\n");
	}
	
}
