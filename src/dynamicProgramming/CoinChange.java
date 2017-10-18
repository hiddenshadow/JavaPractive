/**
 * 
 */
package dynamicProgramming;

/**
toString, hashCode equals
 */

/**
 * @author niharika
 *
 */
public class CoinChange {
	
	public static void test() {
		int[] coins = {1, 2, 5};
		
/*		System.out.println("Ways - "+getNumberOfWaysToTenderChange(coins, 5, 2));		
		System.out.println("Ways - "+getNumberOfWaysToTenderChange(coins, 3, 0));*/
		
		System.out.println("Coins - "+coinChange(coins, 5, 3));
//		System.out.println("Coins - "+coinChange(coins, 3, 0));
	}
	
	/**
	 * For each coin, update number of ways of tendering each sum from that coin value till max sum. 
	 * Each visit to a sum is like a possible method call asking to find that sum using all coins below & including the current coin.
	 *     
	 * @param s
	 * @param n
	 * @param m
	 * @return
	 */
	public static int coinChange(int[] s, int n, int m){
		int[] table = new int[n+1];
		
		table[0] = 1;
		int curCoinValue=0, prev=0;
		
		// Taking one coin at a time starting from low value coin.
		for(int i = 0; i < m; i++){

			curCoinValue = s[i];
			
			int j=curCoinValue;
			
			prev = (j - curCoinValue);
			
			// Updating no of ways to tender sum j
				while(j <= n){
					table[j] = table[j] + table[prev];
					j++;
					prev = j - curCoinValue;
				}
			}
		
		return table[n];
	}
	
	/**
	 * Recursive brute force.
	 * @param coins
	 * @param val
	 * @param maxCoin
	 * @return
	 */
	public static int getNumberOfWaysToTenderChange(int[] coins, int val, int maxCoin){
		if(val == 0 ) return 1;
		
		if(val < 0 || maxCoin < 0) return 0;
		
		int coinCountRange = (val / coins[maxCoin]);
		int totalWays = 0;
		int valRem = 0;
		
		for (int i = 0; i <= coinCountRange; i++) {
			valRem = (val - (coins[maxCoin]*i) );
			totalWays += getNumberOfWaysToTenderChange(coins, valRem, maxCoin-1);
		}
		
		return totalWays;
	}

}
