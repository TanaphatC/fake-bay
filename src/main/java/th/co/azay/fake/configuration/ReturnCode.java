package th.co.azay.fake.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ReturnCode {

    CODE10000("10000.00","10000", "Success"),
    CODE21000("21000.00","21000", "Invalid signature"),
    CODE21001("21001.00","21001", "Invalid bizMchId"),
    CODE21002("21002.00","21002", "Invalid biller id"),
    CODE21004("21004.00","21004", "Number per page value exceed limit. Max value is 30"),
    CODE31002("31002.00","31002", "QR code has expired"),
    CODE31001("31001.00","31001", "QR code has scanned"),
    CODE31101("32201.00","32201", "Transaction not found"),
    CODE32301("32301.00","32301", "QR code format error"),
    CODE32322("32322.00","32322", "Trade has closed. Corresponding trade is closed, is not allowed for current operation. Merchant may generate a new payment."),
    CODE32341("32341.00","32341", "Get transaction detail fail"),
    CODE32351("32351.00", "32351",  "Get transaction list fail");

    @Getter
    String amount;

    @Getter
    String code;

    @Getter
    String message;

    public static ReturnCode getReturnCode(String amount){
        for(ReturnCode returnCode : ReturnCode.values())
            if(returnCode.getAmount().equals(amount))
                return returnCode;
        return ReturnCode.CODE10000;
    }

}