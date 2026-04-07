import java.util.Arrays;

public class PracticeProblem {

	public static void main(String args[]) {

		            String[][] maze = {
                    { "", "", "F", "", "" },
                    { "", "", "", "", "" },
                    { "", "", "", "", "" },
                    { "S", "", "", "", "" },
            };

			noOfPaths(maze);

	}

	public static int searchMazeMoves(String[][] arr){
		int firstRow = arr.length-1;
		int firstColumn = 0;
		int moves = 0;

		return sMMHelper(arr, firstRow, firstColumn, moves);
	}

	public static int sMMHelper(String[][] arr,int firstRow, int firstColumn ,int moves){
		//CHECK IF OUT OF BOUBNDS, RETURN -1
		if(firstColumn >= arr[0].length || firstRow < 0){
			return -1;
		}

		//IF THE INDEX IS AT FINISH, RETURN THE AMOUNT OF MOVES 
		if(arr[firstRow][firstColumn].equals("F")){
			return moves;
		}

		//RECURSIVELY CALL FOR MOVING RIGHT AND UP
		int rightMoves = sMMHelper(arr, firstRow, firstColumn + 1, moves + 1);
		int upMoves =  sMMHelper(arr, firstRow - 1, firstColumn, moves + 1);

		//if one move always ends out of bounds, return the one that isn't
		//if both are out of bounds, return -1
		//if both are valid, return the one with the lowest moves
		if(rightMoves == -1 || upMoves == -1){
			return Math.max(rightMoves, upMoves);
		} else {
			return Math.min(rightMoves, upMoves);
		}
	}

	public static int noOfPaths(String[][] arr){
		int firstRow = arr.length-1;
		int firstColumn = 0;
		int paths = 0;

		return nOPathsHelper(arr, firstRow, firstColumn, paths);
	}

	public static int nOPathsHelper(String[][] arr,int firstRow, int firstColumn ,int paths){
		//IF OUT OF BOUNDS, IT IS NOT A VALID PATH, DON"T INCREASE TOTAL PATHS
		if(firstColumn >= arr[0].length || firstRow < 0){
			return 0;
		}
		//IF THE ELEMENT AT INDEX IS "F", RETURN 1, THAT IS A PATH, WE INCREASIN BOI
		if(arr[firstRow][firstColumn].equals("F")){
			return 1;
		}

		//FIND IF ANY OF RIGHT OR UP MOVES ENDS WITH A NULL OR F
		int rightMoves = nOPathsHelper(arr, firstRow, firstColumn + 1, paths);
		int upMoves =  nOPathsHelper(arr, firstRow - 1, firstColumn, paths);

		//ACCUMULATE
		return rightMoves + upMoves;
	}
	
	

}
