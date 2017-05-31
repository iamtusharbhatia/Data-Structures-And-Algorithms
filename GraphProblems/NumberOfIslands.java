package GraphProblems;

/**
 * This class provides the method which tells how many islands are there in a Graph.
 * Any set of 1's which are surrounded by zeroes is termed as an island.
 */

public class NumberOfIslands {

    //This method tells if this index lies within the matrix and has the value 1 and is also never visited before.
	boolean isSafe(int arr[][], boolean[][] visited, int i, int j){
		if(i < arr.length && j<arr[0].length && i>=0 && j>= 0 && (arr[i][j] ==1 && !visited[i][j])){
			return true;
		} else {
			return false;
		}
	}
	
	void DFS(int arr[][], boolean[][] visited, int i, int j) {
		visited[i][j] = true;

		int rowNbr[] = {1,1,1,0,0,-1,-1,-1};
		int colNbr[] = {-1,0,1,-1,1,-1,0,1};

		for(int k=0; k<8; k++){
			if(isSafe(arr, visited,i+rowNbr[k],j+colNbr[k])){
				DFS(arr, visited,i+rowNbr[k],j+colNbr[k]);
			}
		}
	}

	//This method returns the number of islands in the matrix.
	int findIslands(int arr[][], int N, int M){
		int count =0;
		boolean[][] visited = new boolean[N][M];

		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				if(arr[i][j] ==1 && !visited[i][j]){
					count ++;
					DFS(arr, visited,i,j);

				}
			}
		}
		return count;
	}

	public static void main(String[] args) {

		int arr[][]=  new int[][]  {{1, 1, 0, 0, 0},
									{0, 1, 0, 0, 1},
									{1, 0, 0, 1, 1},
									{0, 0, 0, 0, 1},
									{1, 0, 1, 0, 1}};
		
		NumberOfIslands I = new NumberOfIslands();
		System.out.println("Number of islands: " +I.findIslands(arr,arr.length,arr[0].length));
	}
}
