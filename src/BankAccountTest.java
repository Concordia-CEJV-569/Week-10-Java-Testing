import org.junit.jupiter.api.*;

import static junit.framework.TestCase.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankAccountTest {

    private BankAccount account;
    private static int count;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("This executes before any test cases. Count = " + count++);
    }

    @BeforeEach
    public void setup() {
        account = new BankAccount("Logan", "Paul", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @Test
    public void deposit() throws Exception {
        double balance = account.deposit(200.00, true);
        assertEquals(1200.00, balance, 0);
        // assertEquals(1200.00, account.getBalance(), 0); BAD PRACTICE
    }

    @Test
    public void withdraw_branch() throws Exception {
        double balance = account.withdraw(600.00, true);
        assertEquals(400.00, balance, 0);
    }

    @Test()
    public void withdraw_notBranch() throws Exception {
        assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(600.00, false),
                "Should throw an IllegalArgumentException"
        );

//        double balance = account.withdraw(600.00, false);
//        assertEquals(400.00, balance, 0);
    }

    @Test
    public void getBalance_deposit() throws Exception {
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @Test
    public void getBalance_withdraw() throws Exception {
        account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);
    }

    @Test
    public void isChecking_true() {
        assertTrue("The account is NOT a checking account", account.isChecking()); // can also be done with assertTrue
    }

    @AfterEach
    public void teardown() {
        System.out.println("Count = " + count++);
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("This executes after any test cases. Count = " + count++);
    }

}