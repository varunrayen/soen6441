/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdom.utiles;

/**
 * Implementation has to implement single method to move some amount of money from source to destination.
 * Money for user are stored in array int[c1, c5, c10, c50, c100]
 * @author andriy
 */
public final class MoneyManager {
    
    public static final int WALLET_SIZE = 5;
    /**
     * index of one coins in array
     */
    public static final int c1 = 0;
    /**
     * index of five coins in array
     */
    public static final int c5 = 1;
    /**
     * index of ten coins in array
     */
    public static final int c10 = 2;
    /**
     * index of fifty coins in array
     */
    public static final int c50 = 3;
    /**
     * index of hundred coins in array
     */
    public static final int c100 = 4;

    /**
     * Take some coins from wallet
     * @param wallet source to take coins from
     * @param  coinValue can be 1, 5, 10, 50, 100
     * @param howManyCoins number of coins to withdraw
     */
    public static void withdrawMoney(int[] wallet, int coinValue, int howManyCoins) {
        wallet[coinValue] -= howManyCoins;
    }

    /**
     * Status of money operation
     */
    public enum OperationStatus{
        SUCCESS,
        TO_LITTLE_SOURCE, // when source has less money then total to move
        NO_CHANGE, // impossible to make operation because it is not devided in coins...
        UNKNOWN
    }
    
    /**
     * Move some amount of money (in coins) from source to destination.
     * @param source get money from (in coins)
     * @param destination put money to (in coins)
     * @param howMany total moved amount
     * @return status of operation
     */
    public static OperationStatus moveMoney(int[] source, int[] destination, int howMany){
        //TODO implement
        return OperationStatus.UNKNOWN;
    }
    
    /**
     * calculate total for user wallet
     * @param wallet
     * @return total number of money in wallet
     */
    public static int getTotal(int[] wallet) {
        return wallet[c1] * 1
                + wallet[c5] * 5
                + wallet[c10] * 10
                + wallet[c50] * 50
                + wallet[c100] * 100;
    }
}
