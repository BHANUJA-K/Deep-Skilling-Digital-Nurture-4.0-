DECLARE
    CURSOR vip_cursor IS
        SELECT CustomerID, Balance
        FROM Customers
        WHERE Balance > 10000;

BEGIN
    FOR rec IN vip_cursor LOOP
        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE CustomerID = rec.CustomerID;

        DBMS_OUTPUT.PUT_LINE('VIP status granted to Customer ID: ' || rec.CustomerID);
    END LOOP;

    COMMIT;
END;
