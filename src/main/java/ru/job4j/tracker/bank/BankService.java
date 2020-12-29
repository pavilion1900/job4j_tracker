package ru.job4j.tracker.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<>());
        }
    }

    public void addAccount(String passport, Account account) {
        User person = findByPassport(passport);
        List<Account> accountList = users.get(person);
        if (person != null && !accountList.contains(account)) {
            accountList.add(account);
        }
    }

    public User findByPassport(String passport) {
        User person = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                person = user;
                break;
            }
        }
        return person;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account account = null;
        User person = findByPassport(passport);
        List<Account> accountList = users.get(person);
        if (person != null) {
            for (Account acc : accountList) {
                if (acc.getRequisite().equals(requisite)) {
                    account = acc;
                    break;
                }
            }
        }
        return account;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc != null && destAcc != null && srcAcc.getBalance() >= amount) {
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            destAcc.setBalance(destAcc.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
