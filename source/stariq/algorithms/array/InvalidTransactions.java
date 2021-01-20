package stariq.algorithms.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/invalid-transactions/
public class InvalidTransactions {

    public static void main(String[] args) {
        String[] array = new String[] {"alice,20,800,mtv", "alice,50,100,beijing"};
        InvalidTransactions it = new InvalidTransactions();
        System.out.println(it.invalidTransactions(array));
    }

    class Transaction {
        String name;
        int time;
        int amount;
        String city;

        Transaction(String transaction) {
            String[] split = transaction.split(",");
            this.name = split[0];
            this.time = Integer.parseInt(split[1]);
            this.amount = Integer.parseInt(split[2]);
            this.city = split[3];
        }

        public boolean invalidTransaction(String city, int time) {
            if(invalidAmount() || differentCity(city, time)) {
                return true;
            }
            return false;
        }

        private boolean differentCity(String city, int time) {
            if(!this.city.equals(city) && Math.abs(this.time - time) <= 60) {
                return true;
            }
            return false;
        }

        private boolean invalidAmount() {
            if(amount > 1000) {
                return true;
            }
            return false;
        }
    }


    public List<String> invalidTransactions(String[] transactions) {

        List<String> invalidList = new ArrayList<>();
        Map<String, List<Transaction>> map = new HashMap<>();

        for(String t : transactions) {
            Transaction transaction = new Transaction(t);

            List<Transaction> list = map.get(transaction.name);
            if(list != null) {
                list.add(transaction);
            } else {
                list = new ArrayList<>();
                list.add(transaction);
                map.put(transaction.name, list);
            }
        }

        for(String t : transactions) {
            Transaction transaction = new Transaction(t);
            if(!isValid(map.get(transaction.name), transaction)) {
                invalidList.add(t);
            }
        }

        return invalidList;
    }

    private boolean isValid(List<Transaction> transactionList, Transaction transaction) {
        if(transactionList.size() <= 1 && transaction.amount < 1000) {
            return true;
        }

        for(Transaction t : transactionList) {
            if(transaction.invalidTransaction(t.city, t.time)) {
                return false;
            }
        }
        return true;
    }
}
