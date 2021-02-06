package ru.job4j.tracker.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает модель банковской системы.
 * В системе можно производить следующие действия:
 * 1. Регистрировать пользователя.
 * 2. Добавлять пользователю банковские счета. У пользователя может быть несколько счетов.
 * 3. Переводить деньги с одного счета на другой.
 *
 * @author Sergey Korolenko
 */
public class BankService {
    /**
     * Это поле содержит всех пользователей системы с привязанными к ним счетами.
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему.
     * Проверяет, если такого пользователя нет, то добавляет его в систему.
     *
     * @param user пользователь, который может быть добавлен в систему.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет новый счет пользователю.
     *
     * @param passport паспортные данные пользователя.
     * @param account  новый счет пользователя
     */
    public void addAccount(String passport, Account account) {
        User person = findByPassport(passport);
        if (person != null) {
            List<Account> accountList = users.get(person);
            if (!accountList.contains(account)) {
                accountList.add(account);
            }
        }
    }

    /**
     * Метод принимает на вход паспортные данные пользователя и проверяет
     * есть ли такой пользователь в системе.
     *
     * @param passport паспортные данные пользователя.
     * @return возвращает пользователя или null, если пользователя нет в системе.
     */
    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод ищет пользователя по реквизитам.
     *
     * @param passport  паспортные данные пользователя
     * @param requisite реквизиты счета
     * @return возвращает пользователя или null, если пользователя нет в системе.
     */
    public Account findByRequisite(String passport, String requisite) {
        User person = findByPassport(passport);
        if (person != null) {
            return users.get(person)
                    .stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод для перечисления денег с одного счета на другой.
     *
     * @param srcPassport   паспортные данные пользователя_1, который будет перечислять деньги.
     * @param srcRequisite  реквизиты счета пользователя_1, с которого будут перечисляться деньги.
     * @param destPassport  паспортные данные пользователя_2, кому будут перечислены деньги.
     * @param destRequisite реквизиты счета пользователя_2, на который будут перечислены деньги.
     * @param amount        сумма для перечисления.
     * @return возвращает false, если счёт не найден или не хватает денег на счёте srcAccount
     * (с которого переводят).
     */
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