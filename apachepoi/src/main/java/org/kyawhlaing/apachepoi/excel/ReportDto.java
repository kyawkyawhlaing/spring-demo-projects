package org.kyawhlaing.apachepoi.excel;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @ToString @EqualsAndHashCode
public class ReportDto extends  BaseEntity {
    private Long reportId;
    private String recordNo;
    private String idType1;
    private String idNumber1;
    private String dateOfBirth;
    private String name1English;
    private String name3English;
    private String fatherName1English;
    private String gender;
    private String maritalStatus;
    private String nationalityCode;
    private String raceEnglish;
    private String applicantType1;
    private String addressType1;
    private String streetNumberAndNameEnglish1;
    private String city1;
    private String country1;
    private String unformattedAddress1English;
    private String emailAddress;
    private String contactNumberType1;
    private String contactNumberUnformatted1;
    private String creditorId;
    private String accountType;
    private String smeFlag;
    private String accountNumber;
    private String dateIssued;
    private String productType;
    private String currency;
    private String productLimit;
    private String productExpiryDate;
//    private String productStatus;
    private String closeDate;
    private String restructuredLoan;
    private double intalmentAmount;
    private String paymentFrequency;
    private int tenure;
    private int loanInterestRate;
    private String tier1CapitalRatio;
    private String collateralShortfall;
    private String lastPaymentDate;
    private double lastAmountPaid;
    private double outstandingBalance;
    private double overdueAmount;
    private String nextPaymentDate;
    private String daysOverdue;
    private String asOdDate;
    private String lossStatus;
    private String lossStatusDate;
    private String lossOriginalAmountAsAtLoadDate;
    private double lossOutstandinBalance;
    private String collateralType1;
    private String collateralReference1English;
    private String collateralMarketValue1;
    private String collateralForceSaleValue1;
    private String collateralDescription1English;
    private String collateralAddress1English;
    private String collateralType2;
    private String collateralReference2English;
    private String collateralMarketValue2;
    private String collateralForcedSaleValue2;
    private String collateralDescription2English;
    private String collateralAddress2English;

}
