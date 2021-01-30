package intro;

public class multiarray {

	
	public static void main(String[] args) {
		int[][] multi = new int[10][10];
		
		for(int x=0;x<10;x++)
		{
			for(int y=0;y<10;y++)
			{
				multi[x][y] = x*y;
			}
		}

		int num1 = 6;
		int num2 = 8;
		
		int answer = multi[num1][num2];
		System.out.println(answer);
		
	}

}
