/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ResourceBundle;

/**
 * class that represents proposal of credit
 * @author Alex
 */
public class CreditChoise {

    /*
     * variable of property strings
     */
    private static final ResourceBundle bundle = ResourceBundle.getBundle("core.coreProps");
    /*
     * default bank name
     */
    private static final String DEFAULT_BANK_NAME = bundle.getString("default.bank.name");
    /*
     * default first payment
     */
    private static final double DEFAULT_FIRST_PAYMENT = 0;
    /*
     * default credit rate
     */
    private static final double DEFAULT_CREDIT_RATE = 12;

    /*
     * bank name
     * @pdOid ca287cc8-3880-4211-ae67-fc6347ba48e7
     */
    private String bankName = DEFAULT_BANK_NAME;
    /*
     * type of credit, as for consumer, car credit or mortgage
     */
    private final Type type = new Type();
    /*
     * time length of credit, can be short, medium or long termed
     */
    private final TimeLength timeLength = new TimeLength();
    /*
     * if the credit can be returned early or not
     * @pdOid 1ebdc1e4-fc10-4f91-8aea-b3413137b995
     */
    private boolean earlyReturn = false;
    /*
     * release type of the credit.
     * credit can be common or credit line
     */
    private final ReleaseType releaseType = new ReleaseType();
    /*
     * if line credit has expandable limit (works only if credit release type is credit line)
     * @pdOid de35fa17-d13c-4bf3-811e-b29556aade0d
     */
    private boolean lineExpandable = false;
    /*
     * if credit is given in cash or by account
     * @pdOid 6da15191-0fe9-4fbd-a252-12738437140f
     */
    private boolean isCash = false;
    /*
     * summ of first payment
     * @pdOid 851e02c8-59a6-4cce-a269-e83de4af20a7
     */
    private double firstPayment = DEFAULT_FIRST_PAYMENT;
    /*
     * credit rate
     * @pdOid 5d176e63-9ab8-4153-a24e-2df2050fc925
     */
    private double rate = DEFAULT_CREDIT_RATE;
    /*
     * if the credit has differential payback system
     * @pdOid 7202e675-22c0-44d9-ac14-6b3c79e4460a
     */
    private boolean isDifferential = false;

    /**
     * constructor of proposal
     *
     * @param bankName bank name
     * @param type type of credit (as for consumer credit, car credit or
     * mortgage)
     * @param timeLength time length of credit (as for short term, between 1 and
     * 2 years or long term)
     * @param earlyReturn defines if credit can be returned early
     * @param releaseType type of release (common or credit line)
     * @param lineExpandable only for credit line
     * @param isCash cash or non-cash
     * @param firstPayment summ of first payment
     * @param rate credit rate
     * @param isDifferential defines if credit is differential
     */
    public CreditChoise(
            String bankName,
            int type,
            int timeLength,
            boolean earlyReturn,
            boolean releaseType,
            boolean lineExpandable,
            boolean isCash,
            double firstPayment,
            double rate,
            boolean isDifferential
    ) {
        setBankName(bankName);
        setType(type);
        setTimeLength(timeLength);
        setEarlyReturn(earlyReturn);
        setReleaseType(releaseType);
        setLineExpandable(lineExpandable);
        setIsCash(isCash);
        setFirstPayment(firstPayment);
        setRate(rate);
        setIsDifferential(isDifferential);
    }

    /**
     * get the bank name
     * @return bank name
     * @pdOid 149ad492-61bd-4201-9f66-0bfad8a17866
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * set the bank name
     * @param newBankName bank name
     * @pdOid f18b9c82-c1aa-444a-9a78-534a39a2d7e3
     */
    public void setBankName(String newBankName) {
        bankName = newBankName;
        if (newBankName == "") {
            bankName = DEFAULT_BANK_NAME;
        }
    }

    /**
     * get if the credit can be returned early
     * @return if the credit can be returned early
     * @pdOid 11a9d119-4515-4769-81b8-4cbe4d2c019a
     */
    public boolean getEarlyReturn() {
        return earlyReturn;
    }

    /**
     * set if the credit can be returned early
     * @param newEarlyReturn if the credit can be returned early
     * @pdOid 9f83e39c-913b-486e-8cf5-b65c92ab5fc4
     */
    public void setEarlyReturn(boolean newEarlyReturn) {
        earlyReturn = newEarlyReturn;
    }

    /**
     * get if the credit line is expandable
     * @return if the credit line is expandable
     * @pdOid 38463ef0-d603-4848-abbd-1ef1e0eaa288
     */
    public boolean getLineExpandable() {

        return lineExpandable;
    }

    /**
     * set if the credit line is expandable
     * @param newLineExpandable if the credit line is expandable
     * @pdOid 584aabcb-d09e-47a0-9ade-545c069cd037
     */
    public void setLineExpandable(boolean newLineExpandable) {
        if (getReleaseType()) {
            lineExpandable = newLineExpandable;
        } else {
            lineExpandable = getReleaseType();
        }

    }

    /**
     * get if the credit is released by cash
     * @return if the credit is released by cash
     * @pdOid 0440e542-cbb9-4e9a-9d01-9bb89533add4
     */
    public boolean getIsCash() {
        return isCash;
    }

    /**
     * set if the credit is released by cash
     * @param newIsCash if the credit is released by cash
     * @pdOid a2263a44-75f6-4649-972c-0fb666590ffe
     */
    public void setIsCash(boolean newIsCash) {
        isCash = newIsCash;
    }

    /**
     * get the sum of the first payment
     * @return sum of the first payment
     * @pdOid 98edcb2b-0502-4278-8865-bca240d37aff
     */
    public double getFirstPayment() {
        return firstPayment;
    }

    /**
     * set the summ of the first payment
     * @param newFirstPayment first payment
     * @pdOid 089ac732-adcb-4de4-bfc5-a4c0df97dcd1
     */
    public void setFirstPayment(double newFirstPayment) {
        if (newFirstPayment >= 0) {
            firstPayment = newFirstPayment;
        } else {
            System.out.println(bundle.getString("error.set.first.payment"));
            firstPayment = DEFAULT_FIRST_PAYMENT;
        }

    }

    /**
     * get credit rate
     * @return credit rate
     * @pdOid 7efbe6f9-6a9d-4117-9f19-1ccc9342cd95
     */
    public double getRate() {
        return rate;
    }

    /**
     * set credit rate
     * @param newRate credit rate
     * @pdOid df360cb5-19e9-448d-bb51-79f468fa431f
     */
    public void setRate(double newRate) {
        if (newRate >= 0) {
            rate = newRate;
        } else {
            System.out.println(bundle.getString("error.set.rate"));
            rate = DEFAULT_CREDIT_RATE;
        }

    }

    /**
     * get if the credit has differential payback system
     * @return if the credit has differential payback system
     * @pdOid 6dd09e64-0654-4a5e-bef7-71a0488e9b7d
     */
    public boolean getIsDifferential() {
        return isDifferential;
    }

    /**
     * set if the credit has differential payback system
     * @param newIsDifferential if the credit has differential payback system
     * @pdOid d190ceb0-e822-484e-ad91-e56cc606c04b
     */
    public void setIsDifferential(boolean newIsDifferential) {
        isDifferential = newIsDifferential;
    }

    /**
     * overwritten toString method
     * @return credit information
     * @pdOid c0c75eba-3a39-4931-a8fa-948d25bbe21f
     */
    @Override
    public String toString() {
        String str;
        str = bankName + bundle.getString("comma.space") + Type.typeList[getType()] 
                + bundle.getString("comma.space")
                + (TimeLength.timeLengthList[getTimeLength()]) 
                + bundle.getString("comma.space")
                + (earlyReturn ? (bundle.getString("is.early.return") 
                + bundle.getString("comma.space")) : "")
                + (getReleaseType() ? (ReleaseType.releaseTypeName[1]
                + (lineExpandable ? (bundle.getString("comma.space") 
                + bundle.getString("is.expandable")) : ""))
                : ReleaseType.releaseTypeName[0])
                + (isCash ? (bundle.getString("comma.space") 
                + bundle.getString("is.cash") + bundle.getString("comma.space")) 
                : (bundle.getString("comma.space") + 
                bundle.getString("is.non.cash") 
                + bundle.getString("comma.space")))
                + "" + firstPayment + bundle.getString("currency") + bundle.getString("comma.space")
                + bundle.getString("credit.rate.is") + rate + "%"
                + (isDifferential ? (bundle.getString("comma.space") + bundle.getString("is.differential")) : "");

        return str;
    }

    /**
     * get the integer value of credit type
     * @return the type
     */
    public int getType() {
        return type.getType();
    }

    /**
     * set the integer value of credit type
     * @param type the type to set
     */
    public void setType(int type) {
        this.type.setType(type);
    }

    /**
     * get the integer value of credit time length
     * @return the timeLength
     */
    public int getTimeLength() {
        return timeLength.getTimeLength();
    }

    /**
     * set the integer value of credit time length
     * @param timeLength the timeLength to set
     */
    public void setTimeLength(int timeLength) {
        this.timeLength.setTimeLength(timeLength);
    }

    /**
     * get if the credit release type is credit line
     * @return the releaseType
     */
    public boolean getReleaseType() {
        return releaseType.getReleaseType();
    }

    /**
     * set if the credit release type is credit line
     * @param releaseType the releaseType to set
     */
    public void setReleaseType(boolean releaseType) {
        this.releaseType.setReleaseType(earlyReturn);
    }

}
