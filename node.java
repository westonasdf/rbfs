public class node{
	String s;
	int[][] board;
	//0 = parent, 1 = left, 2= right, 3 = up, 4 = down
	
	public node(String s){
		this.s = s;
		board = new int[3][3];
		if(!s.equals(null)){
			int count = 0;
			for(int i = 0; i < 3; i++){

				for(int j = 0; j<3; j++){
				
					board[i][j] = Integer.parseInt(String.valueOf(s.charAt(count)));
					count++;
				}	
			}

	
		}
	}
	public void printBoard(){
		for(int i = 0; i != 3; i++){
			for(int j = 0; j!=3; j++){
				System.out.print(board[i][j]);
			}	
			System.out.println();
		}
		
	}
	


	public int  getManhattan(){
		if(s.equals("999999999"))
			return 9999999;
		int distance = 0;
		char[] sArray = s.toCharArray();
		//go through board
		for(int i =0; i<3; i++){
			for(int j=0; j<3; j++){
				int x = 0,y = 0;
				int value = board[i][j];
			
				x = getX(value);
				y = getY(value);

				distance += Math.abs(j-x) + Math.abs(i-y);
			

			}
			
		}

		return distance;	
	}
	//helper method to calc manhattan
	public static int getX(int value){
		
	
		if(value%3==1)
			return 1;
		else if(value%3==2)
			return 2;

		return 0;
	}
	//helper method to cal manhattan
	public static int getY(int value){	
		if(value<3)
			return  0;
		else if(value >=3 && value<6)
			return 1;
		else
			return 2;
	}
	public boolean checkString(){
		if(s.compareTo("012345678")==0)
			return true;
		return false;
	}
	public static String arrayToString(int[][] board){
		String s = "";
		for(int i = 0; i<3; i++){
			for(int j =0; j<3; j++){
				s += "" + board[i][j];		

			}
		}
		return s;
	}
	
	//returns board from moving left
	public String getLeft(){
		int tempBoard[][] = new int[3][3];
		for(int k = 0; k<3; k++){
			for(int l =0; l<3; l++){
				tempBoard[k][l] = board[k][l];
			}
		}
		
		for(int i = 0; i<3; i++){
			for(int j =0; j<3; j++){
				if(board[i][j]==0){
					if(j==0)
						return "999999999";
					else{
						tempBoard[i][j] = board[i][j-1];
						tempBoard[i][j-1]=0;				
						return arrayToString(tempBoard);
					}
							
					
				}
			}	
		}
		return "";
	}
	
		
	public String getRight(){
		int tempBoard[][] = new int[3][3];

		for(int k = 0; k<3; k++){
			for(int l =0; l<3; l++){
				tempBoard[k][l] = board[k][l];
			}
		}

		for(int i = 0; i<3; i++){
			for(int j =0; j<3; j++){
				if(board[i][j]==0){
					if(j==2)
						return "999999999";
					else{
						tempBoard[i][j] = board[i][j+1];
						tempBoard[i][j+1]=0;				
						return arrayToString(tempBoard);
					}
							
					
				}
			}	
		}
		return "";
	}
	
	public String getDown(){
		int tempBoard[][] = new int[3][3];
		for(int k = 0; k<3; k++){
			for(int l =0; l<3; l++){
				tempBoard[k][l] = board[k][l];
			}
		}

		for(int i = 0; i<3; i++){
			for(int j =0; j<3; j++){
				if(board[i][j]==0){
					if(i==2)
						return "999999999";
					else{
						tempBoard[i][j] = board[i+1][j];
						tempBoard[i+1][j]=0;				
						return arrayToString(tempBoard);
					}
							
					
				}
			}	
		}
		return "";	
	}
	public String getUp(){
		int tempBoard[][] = new int[3][3];
		for(int k = 0; k<3; k++){
			for(int l =0; l<3; l++){
				tempBoard[k][l] = board[k][l];
			}
		}

		for(int i = 0; i<3; i++){
			for(int j =0; j<3; j++){
				if(board[i][j]==0){
					if(i==0)
						return "999999999";
					else{
						tempBoard[i][j] = board[i-1][j];
						tempBoard[i-1][j]=0;				
						return arrayToString(tempBoard);
					}
							
					
				}
			}	
		}
		return "";	
	}
	
	
}
