public class ConvertBinaryToOctal {

	public int convertBinaryToOctal(int n){
		
		int triad, flag = 0, octal = 0, count = 1;
		
		while (n > 0){
			triad = n % 1000;
			n /= 1000;
			
			switch (triad){
			case 0: flag = 0;
				break;
			case 1: flag = 1;
				break;
			case 10: flag = 2;
				break;
			case 11: flag = 3;
				break;
			case 100: flag = 4;
				break;
			case 101: flag = 5;
				break;
			case 110: flag = 6;
				break;
			case 111: flag = 7;
				break;
			default: System.out.println("Please provide a binary number.");
				System.exit(0);
				break;
			}
			
			octal += flag * count;
			count *= 10;
		}
		return octal;
}
}