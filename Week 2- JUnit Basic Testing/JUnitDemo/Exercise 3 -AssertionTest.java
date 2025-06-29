public class AssertionTest {

    public static void main(String[] args) {
        AssertionTest test = new AssertionTest();

        test.testAssertEquals();
        test.testAssertTrue();
        test.testAssertFalse();
        test.testAssertNull();
        test.testAssertNotNull();
    }

    public void testAssertEquals() {
        System.out.println("Running testAssertEquals...");
        int expected = 5;
        int actual = 2 + 3;
        if (expected == actual) {
            System.out.println("testAssertEquals passed.");
        } else {
            System.out.println("testAssertEquals failed: expected " + expected + ", got " + actual);
        }
    }

    public void testAssertTrue() {
        System.out.println("Running testAssertTrue...");
        if (5 > 3) {
            System.out.println("testAssertTrue passed.");
        } else {
            System.out.println("testAssertTrue failed: expected true.");
        }
    }

    public void testAssertFalse() {
        System.out.println("Running testAssertFalse...");
        if (!(5 < 3)) {
            System.out.println("testAssertFalse passed.");
        } else {
            System.out.println("testAssertFalse failed: expected false.");
        }
    }

    public void testAssertNull() {
        System.out.println("Running testAssertNull...");
        Object obj = null;
        if (obj == null) {
            System.out.println("testAssertNull passed.");
        } else {
            System.out.println("testAssertNull failed: expected null.");
        }
    }

    public void testAssertNotNull() {
        System.out.println("Running testAssertNotNull...");
        Object obj = new Object();
        if (obj != null) {
            System.out.println("testAssertNotNull passed.");
        } else {
            System.out.println("testAssertNotNull failed: expected not null.");
        }
    }
}
