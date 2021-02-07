package ru.job4j.tracker.bank;

import java.util.*;

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
        Optional<User> person = findByPassport(passport);
        if (person.isPresent()) {
            List<Account> accountList = users.get(person.get());
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
     * @return возвращает Optional пользователя, если пользователя нет в системе,
     * возвращает пустой Optional.
     */
    public Optional<User> findByPassport(String passport) {
        Optional<User> rsl = Optional.empty();
        Optional<User> temp = users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
        if (temp.isPresent()) {
            rsl = temp;
        }
        return rsl;
    }

    /**
     * Метод ищет пользователя по реквизитам.
     *
     * @param passport  паспортные данные пользователя
     * @param requisite реквизиты счета
     * @return возвращает Optional счета, если пользователя нет в системе,
     * возвращает пустой Optional.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> person = findByPassport(passport);
        Optional<Account> rsl = Optional.empty();
        if (person.isPresent()) {
            rsl = users.get(person.get())
                    .stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst();
        }
        return rsl;
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
        Optional<Account> srcAcc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc.isPresent() && destAcc.isPresent() && srcAcc.get().getBalance() >= amount) {
            srcAcc.get().setBalance(srcAcc.get().getBalance() - amount);
            destAcc.get().setBalance(destAcc.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}