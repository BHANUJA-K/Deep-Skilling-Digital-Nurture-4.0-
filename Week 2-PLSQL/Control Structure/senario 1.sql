DECLARE
    CURSOR cust_cursor IS
        SELECT c.CustomerID, l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE MONTHS_BETWEEN(SYSDATE, c.DOB) / 12 > 60;

BEGIN
    FOR rec IN cust_cursor LOOP
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE CustomerID = rec.CustomerID;

        DBMS_OUTPUT.PUT_LINE('1% discount applied to Customer ID: ' || rec.CustomerID);
    END LOOP;
    COMMIT;
END;
