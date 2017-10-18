package list;

import list.JustListNode.Node;

public class SumOfNumbersInListForm {
	
	
	public static ListNodeInt getSum(ListNodeInt one, ListNodeInt two){
		
		int carry=0, sum=0, curDigitOfSum=0;
		ListNodeInt resultCurDigitNode =null, resultHead=null;
		
		while(one !=null || two != null || carry >0){
			sum = carry;
			
			if(one != null){
				sum += one.val; 
				one = one.next;
			}
			
			if(two != null){
				sum += two.val;
				two = two.next;
			}
			
			curDigitOfSum = sum % 10;
			carry = sum / 10;
			
			if(resultHead == null){
				resultHead = new ListNodeInt(curDigitOfSum);
				resultCurDigitNode = resultHead;
			} else {
				resultCurDigitNode.next = new ListNodeInt(curDigitOfSum);
				resultCurDigitNode = resultCurDigitNode.next; 
			}
		}
		
		return resultHead;
	}

	
	public static void test(){
		
		ListNodeInt one = ListNodeInt.getRandomListNode(3);
		ListNodeInt two = ListNodeInt.getRandomListNode(2);
		
		System.out.println("One ="+ListNodeInt.printString(one));
		System.out.println("Two ="+ListNodeInt.printString(two));
		
		ListNodeInt res = getSum(one, two);
		
		System.out.println("res - "+ListNodeInt.printString(res));
	}
	
}
