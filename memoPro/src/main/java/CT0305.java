import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CT0305 {
	public static void main(String[] args) {
		
		String my_str = "abc1Addfggg4556b";
		
		List<String> list = new ArrayList();
		
		for (int i=0; i<my_str.length(); i+=6) {
			list.add(my_str.substring(i,i+6));
		}
		
		String[] answer =list.toArray(new String[list.size()]);
		
		System.out.println(Arrays.toString(answer));
	}
}
