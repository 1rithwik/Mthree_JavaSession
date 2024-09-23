package sep_23;

// class BankAccount {
//     private volatile int balance;

//     BankAccount() {
//         balance = 0;
//     }

//     public synchronized void deposit(int amount) {
//         balance += amount;
//         System.out.println("Deposited: " + amount + " New Balance: " + balance);
//         notifyAll();
//     }

//     public synchronized void withdraw(int amount) {
//         while (balance < amount) {
//             try {
//                 wait();
//             } catch (Exception e) {
//                 Thread.currentThread().interrupt();
//             }
//         }
//         balance -= amount;
//         System.out.println("Withdrawn: " + amount + " New Balance: " + balance);
//     }

//     public int getBalance() {
//         return balance;
//     }
// }

// public class BankDemo {
//     public static void main(String[] args) throws InterruptedException {
//         System.out.println("Bank Demo");
//         BankAccount account = new BankAccount();
//         Thread depositThread = new Thread(() -> {
//             for (int i = 0; i < 5; i++) {
//                 account.deposit(100);
//                 try {
//                     Thread.sleep(100);
//                 } catch (InterruptedException e) {
//                     e.printStackTrace();
//                 }
//             }
//         }, "Deposit Thread");
//         Thread withdrawThread = new Thread(() -> {
//             for (int i = 0; i < 5; i++) {
//                 account.withdraw(80);
//                 try {
//                     Thread.sleep(100);
//                 } catch (InterruptedException e) {
//                     e.printStackTrace();
//                 }
//             }
//         }, "Withdraw Thread");
//         depositThread.start();
//         withdrawThread.start();

//         // try {
//         // depositThread.join();
//         withdrawThread.join();
//         // } catch (InterruptedException e) {
//         // e.printStackTrace();
//         // }
//         System.out.println("Final Balance: " + account.getBalance());
//     }
// }

class BankAccount {
    private volatile int balance;

    BankAccount() {
        balance = 0;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " New Balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public int getBalance() {
        return balance;
    }
}

public class BankDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Bank Demo");
        BankAccount account = new BankAccount();
        Thread depositThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.deposit(100);

            }
        }, "Deposit Thread");
        Thread withdrawThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.withdraw(80);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Withdraw Thread");
        depositThread.start();
        Thread.sleep(10);
        withdrawThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final Balance: " + account.getBalance());
    }
}
