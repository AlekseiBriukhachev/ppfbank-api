-- Insert into transactionType
INSERT INTO transactionType (trxTypeId, type, code) VALUES (1000, 'DPO', 1012209);
INSERT INTO transactionType (trxTypeId, type, code) VALUES (1001, 'DPO', 0);

-- Insert into account (counterPartyAccount)
INSERT INTO account (accountId, name, number, code) VALUES (1000, 'PPF BANKA A.S.', '0000009504010019', '6000');
INSERT INTO account (accountId, name, number, code) VALUES (1001, 'PPF BANKA A.S.', '0000009505020008', '6000');
INSERT INTO account (accountId, name, number, code) VALUES (1002, 'PPF BANKA A.S.', '0000009503010009', '6000');

-- Insert into statement
INSERT INTO statement (statementId, number, period) VALUES (1000, '196', '2022');
INSERT INTO statement (statementId, number, period) VALUES (1001, '195', '2022');

-- Insert into transaction
INSERT INTO [transaction] (
    trxId, amount, currency, id, bankref, transactionId, bookingDate, postingDate, creditDebitIndicator,
    ownAccountNumber, counterPartyAccount, detail1, productBankRef, transactionType, statement,
    specificSymbol, variableSymbol
) VALUES
    (1000, 1500, 'CZK', '20221019:0000000219', 'PS221019SO314822', '4831716', '2022-10-19', '2022-10-19', 'CRDT',
    '2002222222', 1000, 'Posílám peníze', 'PS221019SO314822', 1000, 1000, '12', '12'),

    (1001, 1999, 'CZK', '20221019:0000000220', 'PS221019SO314822', '4831701', '2022-10-19', '2022-10-19', 'CRDT',
    '2002222222', 1001, 'Trvalý příkaz 8', 'PS221019SO314822', 1001, 1000, '12', '12'),

    (1002, 2000, 'CZK', '20221019:0000000221', 'PS221019SO314823', '4831700', '2022-10-19', '2022-10-19', 'CRDT',
    '2002222222', 1002, 'Na dárky', 'PS221019SO314823', 1000, 1000, '61', '61'),

    (1003, 100, 'CZK', '20221018:0000003607', 'PS221018SO314645', '4831425', '2022-10-18', '2022-10-18', 'CRDT',
    '2002222222', 1000, 'Příspěvek', 'PS221018SO314645', 1000, 1001, '12', '12'),

    (1004, 1594, 'CZK', '20221018:0000003608', 'PS221018SO314645', '4831381', '2022-10-18', '2022-10-18', 'DBIT',
    '2002222222', 1001, 'Platba elektřiny', 'PS221018SO314645', 1001, 1001, '12', '12');
