CREATE OR REPLACE PROCEDURE TransferFunds (
    from_account IN NUMBER,
    to_account IN NUMBER,
    amount IN NUMBER
) AS
    from_balance NUMBER;
BEGIN
    -- Check if from_account has enough balance
    SELECT Balance INTO from_balance
    FROM Accounts
    WHERE AccountID = from_account
    FOR UPDATE;

    IF from_balance < amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account.');
    END IF;

    -- Deduct from source
    UPDATE Accounts
    SET Balance = Balance - amount
    WHERE AccountID = from_account;

    -- Add to destination
    UPDATE Accounts
    SET Balance = Balance + amount
    WHERE AccountID = to_account;

    DBMS_OUTPUT.PUT_LINE('Transfer of ' || amount || ' completed from account ' ||
                         from_account || ' to account ' || to_account);
    COMMIT;
END;
BEGIN
    TransferFunds(1, 2, 100);
END;
