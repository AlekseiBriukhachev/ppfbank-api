package com.aleksei.ppfbankapi.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Details about the transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "trxid", nullable = false)
    @Schema(description = "The unique ID of the transaction")
    private Long trxId;

    @Column(nullable = false)
    @Schema(description = "The amount of the transaction")
    private BigDecimal amount;

    @Column(nullable = false, length = 3)
    @Schema(description = "The currency of the transaction")
    private String currency;

    @Column(nullable = false, length = 20)
    @Schema(description = "The ID of the transaction")
    private String id;

    @Column(nullable = false, length = 20)
    @Schema(description = "The bank reference of the transaction")
    private String bankref;

    @Column(name = "transactionid", nullable = false, length = 20)
    @Schema(description = "The transaction ID")
    private String transactionId;

    @Column(name = "bookingdate", nullable = false)
    @Schema(description = "The booking date of the transaction")
    private LocalDate bookingDate;

    @Column(name = "postingdate", nullable = false)
    @Schema(description = "The posting date of the transaction")
    private LocalDate postingDate;

    @Column(name = "creditdebitindicator", length = 4)
    @Schema(description = "The credit or debit indicator of the transaction")
    private String creditDebitIndicator;

    @Column(name = "ownaccountnumber", length = 20)
    @Schema(description = "The own account number of the transaction")
    private String ownAccountNumber;

    @Column(length = 50)
    @Schema(description = "Detail 1 of the transaction")
    private String detail1;

    @Column(length = 50)
    @Schema(description = "Detail 2 of the transaction")
    private String detail2;

    @Column(length = 50)
    @Schema(description = "Detail 3 of the transaction")
    private String detail3;

    @Column(length = 50)
    @Schema(description = "Detail 4 of the transaction")
    private String detail4;

    @Column(name = "productbankref", length = 50)
    @Schema(description = "The product bank reference")
    private String productBankRef;

    @Column(name = "constantsymbol", length = 10)
    @Schema(description = "The constant symbol")
    private String constantSymbol;

    @Column(name = "specificsymbol", length = 10)
    @Schema(description = "The specific symbol")
    private String specificSymbol;

    @Column(name = "variablesymbol", length = 10)
    @Schema(description = "The variable symbol")
    private String variableSymbol;

    @ManyToOne
    @JoinColumn(name = "counterpartyaccount", nullable = false)
    @Schema(description = "The counter party account")
    private Account counterPartyAccount;

    @ManyToOne
    @JoinColumn(name = "transactiontype", nullable = false)
    @Schema(description = "The transaction type")
    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn(name = "statement", nullable = false)
    @Schema(description = "The statement of the transaction")
    private Statement statement;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Transaction that = (Transaction) o;
        return getTrxId() != null && Objects.equals(getTrxId(), that.getTrxId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}