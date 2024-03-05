import java.util.Arrays;

public class CT0305 {
	public static void main(String[] args) {
		
		String polynomial = "3x + 7 + x";
		
		String[] strArr = polynomial.split(" ");
		
		int xn = 0;
		int n = 0;
		for (int i=0; i<strArr.length; i++) {
			strArr[i].trim();
			if (strArr[i].contains("x")) {
				if (strArr[i].equals("x")) {
					xn += 1;
				} else {
					xn += Integer.parseInt(strArr[i].substring(0, strArr[i].length()-1));
				}
			} else if(!strArr[i].contains("+")){
				n += Integer.parseInt(strArr[i]);
			}
		}
		
		String answer =	 xn+"x + "+n;
		
		System.out.println(answer);
	}
}
