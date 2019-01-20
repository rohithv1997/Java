
import java.util.*;
import java.sql.*;

public class BankingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ch, ch1, ch2, ch3, exitstat = 0;
        String Name;
        long AccNo, PhoneNo, Balance;
        System.out.println(" ----------------");
        System.out.println("| Banking System|");
        System.out.println(" ----------------");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            System.out.println(e);
        }
        while (exitstat != 1) {
            System.out.println("\n1->CustomerInformation | 2->AccountDetails | 3->Transaction | 4->Exit");
            System.out.println("Enter your choice:");
            ch = scanner.nextInt();
            switch (ch) {
                case 1:
                    System.out.println(" ----------------------");
                    System.out.println("| Customer Information|");
                    System.out.println(" ----------------------");
                    System.out.println("1->Insert | 2->Update | 3->Delete | 4->View | 5->Go Home");
                    System.out.println("Enter your choice:");
                    ch1 = scanner.nextInt();
                    switch (ch1) {
                        case 1:
                            Scanner sc1 = new Scanner(System.in);
                            Scanner sc2 = new Scanner(System.in);
                            Scanner sc3 = new Scanner(System.in);
                            System.out.println("Enter Name: ");
                            Name = sc1.nextLine();
                            System.out.println("Enter Account Number: ");
                            AccNo = sc2.nextLong();
                            System.out.println("Enter Phone Number: ");
                            PhoneNo = sc3.nextLong();
                            try {
                                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "oracle");
                                Statement statement = conn.createStatement();
                                ResultSet rs = statement.executeQuery("INSERT INTO CUSTOMER VALUES(" + "'" + Name + "'," + AccNo + "," + PhoneNo + ")");
                                ResultSet rs2 = statement.executeQuery("INSERT INTO ACCOUNT VALUES(" + "'" + AccNo + "',0)");
                                System.out.println("Inserted!");
                                conn.close();
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            break;
                        case 2:
                            Scanner sc11 = new Scanner(System.in);
                            Scanner sc12 = new Scanner(System.in);
                            Scanner sc13 = new Scanner(System.in);
                            System.out.println("Enter Account Number: ");
                            AccNo = sc11.nextLong();
                            System.out.println("Enter Name: ");
                            Name = sc12.nextLine();
                            System.out.println("Enter Phone Number: ");
                            PhoneNo = sc13.nextLong();
                            try {
                                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "oracle");
                                Statement statement = conn.createStatement();
                                ResultSet rs = statement.executeQuery("UPDATE CUSTOMER SET NAME='" + Name + "',PHONENO=" + PhoneNo + " WHERE ACCNO=" + AccNo);
                                System.out.println("Updated!");
                                conn.close();
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            break;
                        case 3:
                            Scanner delscan = new Scanner(System.in);
                            System.out.println("Enter the Account Number:");
                            AccNo = delscan.nextLong();
                            try {
                                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "oracle");
                                Statement statement = conn.createStatement();
                                ResultSet rs = statement.executeQuery("DELETE FROM CUSTOMER WHERE AccNo=" + AccNo);
                                ResultSet rs2 = statement.executeQuery("DELETE FROM ACCOUNT WHERE AccNo=" + AccNo);
                                System.out.println("Deleted!");
                                conn.close();
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            break;
                        case 4:
                            try {
                                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "oracle");
                                Statement statement = conn.createStatement();
                                ResultSet rs = statement.executeQuery("SELECT * FROM Customer");
                                System.out.println("Name\t\tAccountNumber\tPhoneNumber");
                                while (rs.next()) {
                                    System.out.println(rs.getString(1) + "\t" + rs.getLong(2) + "\t" + rs.getLong(3));
                                }
                                conn.close();
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            break;
                        case 5:
                            break;
                    }
                    break;
                case 2:
                    System.out.println(" ----------------- ");
                    System.out.println("| Account Details|");
                    System.out.println(" ----------------- ");
                    System.out.println("1->View | 2->Go Home");
                    System.out.println("Enter your choice:");
                    ch2 = scanner.nextInt();
                    switch (ch2) {
                        case 1:
                            try {
                                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "oracle");
                                Statement statement = conn.createStatement();
                                ResultSet rs = statement.executeQuery("SELECT * FROM ACCOUNT");
                                System.out.println("Account\t\tBalance");
                                while (rs.next()) {
                                    System.out.println(rs.getLong(1) + "\t" + rs.getLong(2));
                                }
                                conn.close();
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            break;
                        case 2:
                            break;
                    }
                    break;
                case 3:
                    long dp,
                     wd;
                    System.out.println(" -------------");
                    System.out.println("| Transaction |");
                    System.out.println(" -------------");
                    System.out.println("1->Deposit | 2->Withdraw | 3->Go Home");
                    System.out.println("Enter your choice:");
                    ch3 = scanner.nextInt();
                    switch (ch3) {
                        case 1:
                            Scanner dpscan = new Scanner(System.in);
                            Scanner ac1scan = new Scanner(System.in);
                            System.out.println("Enter the Account Number: ");
                            AccNo = ac1scan.nextLong();
                            System.out.println("Enter the amount to be deposited");
                            dp = dpscan.nextLong();
                            try {
                                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "oracle");
                                Statement statement = conn.createStatement();
                                ResultSet rs = statement.executeQuery("UPDATE ACCOUNT SET BALANCE=BALANCE+" + dp + "WHERE ACCNO=" + AccNo);
                                System.out.println(dp + " Deposited!");
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            break;
                        case 2:
                            Scanner wdscan = new Scanner(System.in);
                            Scanner ac2scan = new Scanner(System.in);
                            System.out.println("Enter the Account Number: ");
                            AccNo = ac2scan.nextLong();
                            System.out.println("Enter the amount to be withdrawn");
                            wd = wdscan.nextLong();
                            try {
                                long temp = 0;
                                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "oracle");
                                Statement statement = conn.createStatement();
                                ResultSet rs2 = statement.executeQuery("SELECT * FROM ACCOUNT WHERE ACCNO=" + AccNo);
                                while (rs2.next()) {
                                    temp = rs2.getInt(2);
                                }
                                if (temp > wd) {
                                    ResultSet rs = statement.executeQuery("UPDATE ACCOUNT SET BALANCE=BALANCE-" + wd + "WHERE ACCNO=" + AccNo);
                                    System.out.println(wd + " Withdrawn!");
                                } else {
                                    System.out.println("Insufficient Balance");
                                }
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            break;
                        case 3:
                            break;
                    }
                    break;
                case 4:
                    exitstat = 1;
                    break;
            }
        }
        System.out.println("Bye!");
    }
}
