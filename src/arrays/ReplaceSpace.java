package arrays;

public class ReplaceSpace {

	
	public static void test() {
		char[] s1 = new char[100];
		s1[0] = 'a';
		s1[1] = 'c';
		s1[2] = 'b';
		s1[3] = 'd';
		
		replaceFunMoreSpaceInArr(s1, 4);
		
		
		
		System.out.println("Res = "+(new String(s1)));
	}
	
	public static void replaceFunMoreSpaceInArr(char[] str, int length) {
		int spaceCount=0, newLength=0;

		for (int i = 0; i < length; i++) {
			if(str[i] == ' ') spaceCount++;
		}

		newLength = length + spaceCount*2;
		
		for (int i = length-1; i > 0; i--) {
			if( str[i] == ' ') {
				str[newLength-1] = '0';
				str[newLength-2] = '2';
				str[newLength-3] = '%';
				
				newLength = newLength - 3;
			} else {
				str[newLength-1] = str[i];
				
				newLength = newLength - 1;
			}
		}		
	}
	
	
	/*char[] res = new char[str.length + spaceCount];
	
	for (int i = 0; i < str.length; i++) {
		if(str[i] == ' ') spaceCount++;
	}*/
	
}
