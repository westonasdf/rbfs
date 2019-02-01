import java.io.*;
import java.util.TreeSet;
import java.util.Scanner;
public class puzzle{
	public static void main(String args[]){

		node n = new node(readPuzzle("puzzle.txt"));
		node solution = startRbfs(n);
	}
	
	static String readPuzzle(String name){

			String s = "";
		try{

			Scanner inFile = new Scanner(new FileInputStream(name));
			for(int i =0; i!=9;i++){
				s += inFile.next();
			}	
		}
		catch (Exception e){}

		return s;
	}

	public static node startRbfs(node n){

		return rbfs(n,-1);
		
	}

	public static node rbfs(node n, int fLim){
	
		boolean[] visited = new boolean[4];
		System.out.println("\n................");
		n.printBoard();
	
		if(n.checkString())
			return n;
		node sucessors[] = new node[4];



		sucessors[0] = new node(n.getUp());
		sucessors[1] = new node(n.getLeft());
		sucessors[2] = new node(n.getRight());
		sucessors[3] = new node(n.getDown());

		int[] f = new int[4];
		for(int s = 0; s<4; s++){
			f[s] = sucessors[s].getManhattan();
		}
		

		while(true){

			System.out.println("up: " + f[0] + "	left: " + f[1] + "	right: " + f[2] + "	down: " + f[3]);
			int bestIndex = getBest(f);

			if(visited[bestIndex] = true){

				while(visited[bestIndex]){
					bestIndex = getNextBest(f,bestIndex);
				}
			}

			System.out.println("up: " + visited[0] + "	left: " + visited[1] + "	right: " + visited[2] + "	down: " + visited[3]);

			if(fLim != -1 && f[bestIndex] > f[fLim]){

				System.out.println("best index: " + bestIndex +	"	fLim: " + fLim);
				System.out.println("best index: " + f[bestIndex] +	"	fLim: " + f[fLim]);
				return n;
			}	

		
			int altIndex = getNextBest(f, bestIndex);

			return rbfs(sucessors[bestIndex],altIndex);

		}

		
	}
	public static int getBest(int[] f){
		int lidx = 0;
		int lowest = 99999;
		for(int i = 0; i<4;i++){
			if (f[i] < lowest) {
				lowest = f[i];
				lidx = i;
			}
		}
		return lidx;
	}
	
	public static int getNextBest(int[] f,int best){
		int lidx = best;
		int lowest = 99999;
		for(int i = 0; i<4;i++){
			if(i != best && f[i] < lowest){
				lowest = f[i];
				lidx = i;
			}
		}
		return lidx;
	}

}




