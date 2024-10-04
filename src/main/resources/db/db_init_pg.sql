CREATE TABLE transaction (
                             trxId SERIAL PRIMARY KEY,
                             amount NUMERIC(19, 2) NOT NULL,
                             currency VARCHAR(3) NOT NULL,
                             id VARCHAR(20) NOT NULL,
                             bankref VARCHAR(20) NOT NULL,
                             transactionId VARCHAR(20) NOT NULL,
                             bookingDate DATE,
                             postingDate DATE NOT NULL,
                             creditDebitIndicator VARCHAR(4),
                             ownAccountNumber VARCHAR(20),
                             counterPartyAccount BIGINT NOT NULL,
                             detail1 VARCHAR(50),
                             detail2 VARCHAR(50),
                             detail3 VARCHAR(50),
                             detail4 VARCHAR(50),
                             productBankRef VARCHAR(50),
                             transactionType BIGINT NOT NULL,
                             statement BIGINT NOT NULL,
                             constantSymbol VARCHAR(10),
                             specificSymbol VARCHAR(10),
                             variableSymbol VARCHAR(10)
);

CREATE TABLE transactionType (
                                 trxTypeId SERIAL PRIMARY KEY,
                                 type VARCHAR(20) NOT NULL,
                                 code INT NOT NULL
);

CREATE TABLE statement (
                           statementId SERIAL PRIMARY KEY,
                           number VARCHAR(20) NOT NULL,
                           period VARCHAR(20) NOT NULL,
                           description VARCHAR(1000)
);

CREATE TABLE account (
                         accountId SERIAL PRIMARY KEY,
                         name VARCHAR(50) NOT NULL,
                         number VARCHAR(20) NOT NULL,
                         code VARCHAR(4) NOT NULL
);

ALTER TABLE transaction
    ADD CONSTRAINT FK_transaction_counterPartyAccount FOREIGN KEY (counterPartyAccount) REFERENCES account(accountId);

ALTER TABLE transaction
    ADD CONSTRAINT FK_transaction_transactionType FOREIGN KEY (transactionType) REFERENCES transactionType(trxTypeId);

ALTER TABLE transaction
    ADD CONSTRAINT FK_transaction_statement FOREIGN KEY (statement) REFERENCES statement(statementId);