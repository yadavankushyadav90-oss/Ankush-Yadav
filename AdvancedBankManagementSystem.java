import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AdvancedBankManagementSystem extends JFrame {

    // =====================================================
    // ACCOUNT CLASS
    // =====================================================

    static class Account {

        String accountNo;
        String customerId;
        String name;
        String fatherName;
        String dob;
        String gender;
        String phone;
        String email;
        String address;
        String accountType;
        String pin;

        double balance;

        ArrayList<Transaction> transactions =
                new ArrayList<>();

        Account(
                String accountNo,
                String customerId,
                String name,
                String fatherName,
                String dob,
                String gender,
                String phone,
                String email,
                String address,
                String accountType,
                String pin,
                double balance
        ) {

            this.accountNo = accountNo;
            this.customerId = customerId;
            this.name = name;
            this.fatherName = fatherName;
            this.dob = dob;
            this.gender = gender;
            this.phone = phone;
            this.email = email;
            this.address = address;
            this.accountType = accountType;
            this.pin = pin;
            this.balance = balance;
        }
    }


    // =====================================================
    // TRANSACTION CLASS
    // =====================================================

    static class Transaction {

        String transactionId;
        String type;
        double amount;
        String date;
        String description;

        Transaction(
                String transactionId,
                String type,
                double amount,
                String description
        ) {

            this.transactionId = transactionId;
            this.type = type;
            this.amount = amount;
            this.description = description;

            date =
                    new SimpleDateFormat(
                            "dd-MM-yyyy HH:mm:ss"
                    ).format(new Date());
        }
    }


    // =====================================================
    // DATABASE SIMULATION
    // =====================================================

    static HashMap<String, Account> accounts =
            new HashMap<>();


    static Account currentUser = null;


    // =====================================================
    // MAIN FRAME
    // =====================================================

    public AdvancedBankManagementSystem() {

        setTitle(
                "Advanced Bank Management System"
        );

        setSize(1100, 700);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        showLogin();
    }


    // =====================================================
    // LOGIN PAGE
    // =====================================================

    void showLogin() {

        getContentPane().removeAll();

        JPanel main =
                new JPanel(
                        new GridBagLayout()
                );

        main.setBackground(
                new Color(235, 242, 250)
        );


        JPanel box =
                new JPanel();

        box.setLayout(
                new BoxLayout(
                        box,
                        BoxLayout.Y_AXIS
                )
        );

        box.setBorder(
                BorderFactory.createEmptyBorder(
                        35,
                        50,
                        35,
                        50
                )
        );


        JLabel title =
                new JLabel(
                        "🏦 ADVANCED BANK"
                );

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        30
                )
        );

        title.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        JLabel subtitle =
                new JLabel(
                        "Management System"
                );

        subtitle.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        18
                )
        );

        subtitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        JTextField account =
                new JTextField(18);

        JPasswordField pin =
                new JPasswordField(18);


        box.add(title);

        box.add(
                Box.createVerticalStrut(5)
        );

        box.add(subtitle);

        box.add(
                Box.createVerticalStrut(25)
        );


        box.add(
                new JLabel(
                        "Account Number"
                )
        );

        box.add(account);


        box.add(
                Box.createVerticalStrut(10)
        );


        box.add(
                new JLabel("PIN")
        );

        box.add(pin);


        box.add(
                Box.createVerticalStrut(20)
        );


        JButton login =
                new JButton("LOGIN");

        JButton register =
                new JButton(
                        "CREATE NEW ACCOUNT"
                );


        login.addActionListener(
                e -> {

                    String acc =
                            account.getText();

                    String p =
                            new String(
                                    pin.getPassword()
                            );


                    if (!accounts.containsKey(
                            acc
                    )) {

                        JOptionPane.showMessageDialog(
                                this,
                                "Account not found!"
                        );

                        return;
                    }


                    Account a =
                            accounts.get(acc);


                    if (!a.pin.equals(p)) {

                        JOptionPane.showMessageDialog(
                                this,
                                "Wrong PIN!"
                        );

                        return;
                    }


                    currentUser = a;

                    showDashboard();
                }
        );


        register.addActionListener(
                e -> showRegistration()
        );


        box.add(login);

        box.add(
                Box.createVerticalStrut(10)
        );

        box.add(register);


        main.add(box);

        add(main);

        revalidate();

        repaint();
    }


    // =====================================================
    // REGISTRATION
    // =====================================================

    void showRegistration() {

        getContentPane().removeAll();


        JPanel panel =
                new JPanel(
                        new GridLayout(
                                12,
                                2,
                                10,
                                10
                        )
                );


        panel.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        100,
                        20,
                        100
                )
        );


        JLabel title =
                new JLabel(
                        "CUSTOMER REGISTRATION"
                );

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );


        JTextField name =
                new JTextField();

        JTextField father =
                new JTextField();

        JTextField dob =
                new JTextField();

        JComboBox<String> gender =
                new JComboBox<>(
                        new String[]{
                                "Male",
                                "Female",
                                "Other"
                        }
                );

        JTextField phone =
                new JTextField();

        JTextField email =
                new JTextField();

        JTextField address =
                new JTextField();

        JComboBox<String> type =
                new JComboBox<>(
                        new String[]{
                                "Savings",
                                "Current",
                                "Student"
                        }
                );

        JPasswordField pin =
                new JPasswordField();

        JTextField deposit =
                new JTextField();


        panel.add(title);
        panel.add(new JLabel());


        panel.add(
                new JLabel("Full Name:")
        );

        panel.add(name);


        panel.add(
                new JLabel("Father Name:")
        );

        panel.add(father);


        panel.add(
                new JLabel("Date of Birth:")
        );

        panel.add(dob);


        panel.add(
                new JLabel("Gender:")
        );

        panel.add(gender);


        panel.add(
                new JLabel("Mobile:")
        );

        panel.add(phone);


        panel.add(
                new JLabel("Email:")
        );

        panel.add(email);


        panel.add(
                new JLabel("Address:")
        );

        panel.add(address);


        panel.add(
                new JLabel("Account Type:")
        );

        panel.add(type);


        panel.add(
                new JLabel("Create PIN:")
        );

        panel.add(pin);


        panel.add(
                new JLabel("Initial Deposit:")
        );

        panel.add(deposit);


        JButton create =
                new JButton(
                        "CREATE ACCOUNT"
                );


        JButton back =
                new JButton("BACK");


        create.addActionListener(
                e -> {

                    if (
                            name.getText().isEmpty()
                            ||
                            phone.getText().isEmpty()
                            ||
                            address.getText().isEmpty()
                            ||
                            deposit.getText().isEmpty()
                    ) {

                        JOptionPane.showMessageDialog(
                                this,
                                "Please fill all required fields."
                        );

                        return;
                    }


                    double amount;

                    try {

                        amount =
                                Double.parseDouble(
                                        deposit.getText()
                                );

                    } catch (Exception ex) {

                        JOptionPane.showMessageDialog(
                                this,
                                "Invalid amount."
                        );

                        return;
                    }


                    if (amount < 500) {

                        JOptionPane.showMessageDialog(
                                this,
                                "Minimum deposit ₹500."
                        );

                        return;
                    }


                    String accountNo =
                            generateAccountNumber();


                    String customerId =
                            "CUS" +
                            (10000 +
                            new Random().nextInt(
                                    89999
                            ));


                    Account a =
                            new Account(

                                    accountNo,

                                    customerId,

                                    name.getText(),

                                    father.getText(),

                                    dob.getText(),

                                    gender.getSelectedItem()
                                            .toString(),

                                    phone.getText(),

                                    email.getText(),

                                    address.getText(),

                                    type.getSelectedItem()
                                            .toString(),

                                    new String(
                                            pin.getPassword()
                                    ),

                                    amount
                            );


                    a.transactions.add(
                            new Transaction(
                                    generateTransactionId(),
                                    "ACCOUNT OPEN",
                                    amount,
                                    "New account opened"
                            )
                    );


                    accounts.put(
                            accountNo,
                            a
                    );


                    JOptionPane.showMessageDialog(
                            this,

                            "ACCOUNT CREATED!\n\n" +

                            "Customer ID: " +
                            customerId +

                            "\nAccount No: " +
                            accountNo +

                            "\nName: " +
                            name.getText() +

                            "\nBalance: ₹" +
                            amount
                    );


                    showLogin();
                }
        );


        back.addActionListener(
                e -> showLogin()
        );


        panel.add(create);

        panel.add(back);


        add(panel);

        revalidate();

        repaint();
    }


    // =====================================================
    // DASHBOARD
    // =====================================================

    void showDashboard() {

        getContentPane().removeAll();


        JPanel main =
                new JPanel(
                        new BorderLayout()
                );


        JPanel header =
                new JPanel(
                        new BorderLayout()
                );


        header.setBorder(
                BorderFactory.createEmptyBorder(
                        15,
                        20,
                        15,
                        20
                )
        );


        JLabel welcome =
                new JLabel(
                        "Welcome, " +
                        currentUser.name
                );


        welcome.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );


        JLabel balance =
                new JLabel(
                        "Balance: ₹" +
                        String.format(
                                "%.2f",
                                currentUser.balance
                        )
                );


        balance.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        20
                )
        );


        header.add(
                welcome,
                BorderLayout.WEST
        );


        header.add(
                balance,
                BorderLayout.EAST
        );


        main.add(
                header,
                BorderLayout.NORTH
        );


        JPanel menu =
                new JPanel(
                        new GridLayout(
                                3,
                                3,
                                15,
                                15
                        )
                );


        menu.setBorder(
                BorderFactory.createEmptyBorder(
                        40,
                        60,
                        40,
                        60
                )
        );


        JButton deposit =
                new JButton(
                        "💰 DEPOSIT"
                );

        JButton withdraw =
                new JButton(
                        "💸 WITHDRAW"
                );

        JButton transfer =
                new JButton(
                        "🔄 TRANSFER"
                );

        JButton balanceBtn =
                new JButton(
                        "💳 BALANCE"
                );

        JButton details =
                new JButton(
                        "👤 ACCOUNT DETAILS"
                );

        JButton history =
                new JButton(
                        "📜 HISTORY"
                );

        JButton changePin =
                new JButton(
                        "🔐 CHANGE PIN"
                );

        JButton logout =
                new JButton(
                        "🚪 LOGOUT"
                );

        JButton exit =
                new JButton(
                        "❌ EXIT"
                );


        deposit.addActionListener(
                e -> deposit()
        );

        withdraw.addActionListener(
                e -> withdraw()
        );

        transfer.addActionListener(
                e -> transfer()
        );

        balanceBtn.addActionListener(
                e -> showBalance()
        );

        details.addActionListener(
                e -> accountDetails()
        );

        history.addActionListener(
                e -> transactionHistory()
        );

        changePin.addActionListener(
                e -> changePin()
        );

        logout.addActionListener(
                e -> {

                    currentUser = null;

                    showLogin();
                }
        );

        exit.addActionListener(
                e -> System.exit(0)
        );


        menu.add(deposit);
        menu.add(withdraw);
        menu.add(transfer);
        menu.add(balanceBtn);
        menu.add(details);
        menu.add(history);
        menu.add(changePin);
        menu.add(logout);
        menu.add(exit);


        main.add(
                menu,
                BorderLayout.CENTER
        );


        add(main);

        revalidate();

        repaint();
    }


    // =====================================================
    // DEPOSIT
    // =====================================================

    void deposit() {

        String input =
                JOptionPane.showInputDialog(
                        this,
                        "Enter deposit amount:"
                );


        if (input == null) return;


        try {

            double amount =
                    Double.parseDouble(
                            input
                    );


            if (amount <= 0) {

                throw new Exception();
            }


            currentUser.balance +=
                    amount;


            currentUser.transactions.add(
                    new Transaction(
                            generateTransactionId(),
                            "DEPOSIT",
                            amount,
                            "Cash deposited"
                    )
            );


            JOptionPane.showMessageDialog(
                    this,
                    "Deposit successful!\n" +
                    "₹" + amount
            );


            showDashboard();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid amount!"
            );
        }
    }


    // =====================================================
    // WITHDRAW
    // =====================================================

    void withdraw() {

        String input =
                JOptionPane.showInputDialog(
                        this,
                        "Enter withdrawal amount:"
                );


        if (input == null) return;


        try {

            double amount =
                    Double.parseDouble(
                            input
                    );


            if (
                    amount <= 0 ||
                    amount >
                    currentUser.balance
            ) {

                JOptionPane.showMessageDialog(
                        this,
                        "Insufficient balance!"
                );

                return;
            }


            currentUser.balance -=
                    amount;


            currentUser.transactions.add(
                    new Transaction(
                            generateTransactionId(),
                            "WITHDRAW",
                            amount,
                            "Cash withdrawn"
                    )
            );


            JOptionPane.showMessageDialog(
                    this,
                    "Withdrawal successful!"
            );


            showDashboard();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid amount!"
            );
        }
    }


    // =====================================================
    // TRANSFER
    // =====================================================

    void transfer() {

        JPanel panel =
                new JPanel(
                        new GridLayout(
                                2,
                                2,
                                10,
                                10
                        )
                );


        JTextField receiver =
                new JTextField();

        JTextField amount =
                new JTextField();


        panel.add(
                new JLabel(
                        "Receiver Account:"
                )
        );

        panel.add(receiver);


        panel.add(
                new JLabel(
                        "Amount:"
                )
        );

        panel.add(amount);


        int result =
                JOptionPane.showConfirmDialog(
                        this,
                        panel,
                        "Money Transfer",
                        JOptionPane.OK_CANCEL_OPTION
                );


        if (
                result !=
                JOptionPane.OK_OPTION
        ) {

            return;
        }


        String receiverNo =
                receiver.getText();


        if (!accounts.containsKey(
                receiverNo
        )) {

            JOptionPane.showMessageDialog(
                    this,
                    "Receiver account not found!"
            );

            return;
        }


        if (
                receiverNo.equals(
                        currentUser.accountNo
                )
        ) {

            JOptionPane.showMessageDialog(
                    this,
                    "Cannot transfer to yourself."
            );

            return;
        }


        try {

            double money =
                    Double.parseDouble(
                            amount.getText()
                    );


            if (
                    money <= 0 ||
                    money >
                    currentUser.balance
            ) {

                JOptionPane.showMessageDialog(
                        this,
                        "Insufficient balance."
                );

                return;
            }


            Account receiverAccount =
                    accounts.get(
                            receiverNo
                    );


            currentUser.balance -=
                    money;


            receiverAccount.balance +=
                    money;


            currentUser.transactions.add(
                    new Transaction(
                            generateTransactionId(),
                            "TRANSFER SENT",
                            money,
                            "To " + receiverNo
                    )
            );


            receiverAccount.transactions.add(
                    new Transaction(
                            generateTransactionId(),
                            "TRANSFER RECEIVED",
                            money,
                            "From " +
                            currentUser.accountNo
                    )
            );


            JOptionPane.showMessageDialog(
                    this,
                    "Transfer Successful!\n" +
                    "Amount: ₹" +
                    money
            );


            showDashboard();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid amount."
            );
        }
    }


    // =====================================================
    // BALANCE
    // =====================================================

    void showBalance() {

        JOptionPane.showMessageDialog(

                this,

                "Account Number:\n" +
                currentUser.accountNo +

                "\n\nAvailable Balance:\n₹" +

                String.format(
                        "%.2f",
                        currentUser.balance
                ),

                "Balance",

                JOptionPane.INFORMATION_MESSAGE
        );
    }


    // =====================================================
    // ACCOUNT DETAILS
    // =====================================================

    void accountDetails() {

        String information =

                "========== ACCOUNT DETAILS ==========\n\n" +

                "Customer ID : " +
                currentUser.customerId +

                "\nAccount No : " +
                currentUser.accountNo +

                "\nName : " +
                currentUser.name +

                "\nFather Name : " +
                currentUser.fatherName +

                "\nDOB : " +
                currentUser.dob +

                "\nGender : " +
                currentUser.gender +

                "\nMobile : " +
                currentUser.phone +

                "\nEmail : " +
                currentUser.email +

                "\nAddress : " +
                currentUser.address +

                "\nAccount Type : " +
                currentUser.accountType +

                "\nBalance : ₹" +
                currentUser.balance;


        JTextArea area =
                new JTextArea(
                        information
                );


        area.setEditable(false);

        area.setFont(
                new Font(
                        "Monospaced",
                        Font.PLAIN,
                        14
                )
        );


        JOptionPane.showMessageDialog(
                this,
                area,
                "Account Information",
                JOptionPane.INFORMATION_MESSAGE
        );
    }


    // =====================================================
    // TRANSACTION HISTORY
    // =====================================================

    void transactionHistory() {

        String[] columns = {

                "Transaction ID",
                "Type",
                "Amount",
                "Date",
                "Description"
        };


        DefaultTableModel model =
                new DefaultTableModel(
                        columns,
                        0
                );


        for (
                Transaction t :
                currentUser.transactions
        ) {

            model.addRow(
                    new Object[]{

                            t.transactionId,

                            t.type,

                            "₹" +
                            String.format(
                                    "%.2f",
                                    t.amount
                            ),

                            t.date,

                            t.description
                    }
            );
        }


        JTable table =
                new JTable(model);


        table.setAutoCreateRowSorter(
                true
        );


        JScrollPane scroll =
                new JScrollPane(table);


        scroll.setPreferredSize(
                new Dimension(
                        850,
                        400
                )
        );


        JOptionPane.showMessageDialog(
                this,
                scroll,
                "Transaction History",
                JOptionPane.INFORMATION_MESSAGE
        );
    }


    // =====================================================
    // CHANGE PIN
    // =====================================================

    void changePin() {

        String oldPin =
                JOptionPane.showInputDialog(
                        this,
                        "Enter old PIN:"
                );


        if (oldPin == null) return;


        if (
                !currentUser.pin.equals(
                        oldPin
                )
        ) {

            JOptionPane.showMessageDialog(
                    this,
                    "Wrong old PIN!"
            );

            return;
        }


        String newPin =
                JOptionPane.showInputDialog(
                        this,
                        "Enter new 4 digit PIN:"
                );


        if (
                newPin == null ||
                !newPin.matches(
                        "\\d{4}"
                )
        ) {

            JOptionPane.showMessageDialog(
                    this,
                    "PIN must contain 4 digits."
            );

            return;
        }


        currentUser.pin =
                newPin;


        JOptionPane.showMessageDialog(
                this,
                "PIN changed successfully!"
        );
    }


    // =====================================================
    // ACCOUNT NUMBER
    // =====================================================

    String generateAccountNumber() {

        Random random =
                new Random();

        String number;

        do {

            number =
                    "60" +
                    (10000000 +
                    random.nextInt(
                            89999999
                    ));

        } while (
                accounts.containsKey(
                        number
                )
        );


        return number;
    }


    // =====================================================
    // TRANSACTION ID
    // =====================================================

    String generateTransactionId() {

        return "TXN" +
                System.currentTimeMillis();
    }


    // =====================================================
    // MAIN
    // =====================================================

    public static void main(
            String[] args
    ) {

        SwingUtilities.invokeLater(
                () -> {

                    AdvancedBankManagementSystem bank =
                            new AdvancedBankManagementSystem();

                    bank.setVisible(true);
                }
        );
    }
}