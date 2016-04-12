package matrix;

public class MatrixZero {

	public static void print (int[][] arr) {

                for(int i = 0 ; i< arr.length; i++) {
                        for (int j = 0; j<arr[i].length; j++) {
                                System.out.print(arr[i][j] + " ");
                        }
                        System.out.println();
                }
	}
		
	public static void main(String[] args) {
		int[][] arr =  {
			{1,2,0,1},
			{0,1,3,5},
			{5,3,1,1},
			{1,2,3,4}
		};
		print (arr);

		int[] xz = {1,1,1,1};
		int[] yz = {1,1,1,1};
		
		for(int i=0;i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				xz[i] &= (arr[i][j]>0 ?1:0);
				yz[j] &= (arr[i][j]>0 ? 1:0);
			}
		}
		for(int i=0;i < xz.length; i++ ) {
			System.out.println( "Row " + i + ":" + xz[i]);
		}
		for (int j=0; j<yz.length; j++) {
			System.out.println( "Col " + j + ":" + yz[j]);
		}
                for(int i=0;i<arr.length; i++) {
			for(int j = 0; j< arr[i].length; j++) {
				if( (xz[i] & yz[j]) > 0) continue;
				arr[i][j] = 0;
			}
		}		
		print(arr);
		

	}


}
