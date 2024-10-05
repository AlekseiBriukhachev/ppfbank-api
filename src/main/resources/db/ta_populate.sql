USE [ppfbank-db]
GO
-- Insert into transactionType
SET IDENTITY_INSERT transactionType ON;

INSERT INTO transactionType (trxTypeId, type, code)
VALUES
    (1000, 'DPO', 1012209),
    (1001, 'DPO', 0);

SET IDENTITY_INSERT transactionType OFF;

-- Insert into account (counterPartyAccount)
SET IDENTITY_INSERT account ON;

INSERT INTO account (accountId, name, number, code)
VALUES
    (1000, 'PPF BANKA A.S.', '0000009504010019', '6000'),
    (1001, 'PPF BANKA A.S.', '0000009505020008', '6000'),
    (1002, 'PPF BANKA A.S.', '0000009503010009', '6000');

SET IDENTITY_INSERT account OFF;

-- Insert into statement
SET IDENTITY_INSERT statement ON;

INSERT INTO statement (statementId, number, period)
VALUES
    (1000, '196', '2022'),
    (1001, '195', '2022');

SET IDENTITY_INSERT statement OFF;

-- Insert into transaction
SET IDENTITY_INSERT [transaction] ON;

SET IDENTITY_INSERT [transaction] ON;
INSERT INTO [transaction] (
    trxId, amount, currency, id, bankref, transactionId, bookingDate, postingDate, creditDebitIndicator,
    ownAccountNumber, counterPartyAccount, detail1, productBankRef, transactionType, statement,
    specificSymbol, variableSymbol
)VALUES
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
SET IDENTITY_INSERT [transaction] OFF;
SET IDENTITY_INSERT [transaction] OFF;
