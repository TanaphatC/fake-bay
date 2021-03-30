package th.co.azay.fake.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import th.co.azay.fake.configuration.ReturnCode;
import th.co.azay.fake.dto.CreateQRRequest;
import th.co.azay.fake.dto.CreateQRResponse;

import javax.servlet.http.HttpServletRequest;
import java.security.SecureRandom;

@RestController
@RequestMapping("/trans")
public class QrGenerateController {

    private static final Logger logger = LogManager.getLogger(QrGenerateController.class);

    static final String  NUMBERIC_ALPHABET = "0123456789";
    static final int TRXID_LENGTH = 18;
    static SecureRandom srand = new SecureRandom();

    static final String SIGN = "d2wUpmY2otLbGziMDRcDCilUSIjRgYo7/4MY9eGWTDYCUu+69YcGoe0s5LLI0nqL5EYqR5zgX+klGQi+g424cfItUcubid1taL/cMbzOsQ7zcq4yP7nDO7+IqKAaQThOB2hWMu4iDlDvTtI2d7XfkOq3l4gontO5DzLFzuWz488=";
    static final String QR_CONTENT = "00020101021230560016A00000067701011201151234567890223990213738382728271853037645406100.005802TH6222071818342464011737907263048EE0";

    @PostMapping(value = "/precreate")
    public CreateQRResponse precreate(@RequestBody CreateQRRequest createQRRequest, HttpServletRequest req) {
        CreateQRResponse response = new CreateQRResponse();
        response.setSign(SIGN);
        ReturnCode returnCode = ReturnCode.getReturnCode(createQRRequest.getAmount());
        if(ReturnCode.CODE10000.equals(returnCode)){
            response.setSuccess("true");
            response.setReturnCode(ReturnCode.CODE10000.getCode());
            response.setMessage(ReturnCode.CODE10000.getMessage());
            response.setTrxId(generateTrxId());
            response.setQrcodeContent(QR_CONTENT);
        }else {
            response.setSuccess("false");
            response.setReturnCode(returnCode.getCode());
            response.setMessage(returnCode.getMessage());
            response.setTrxId("");
            response.setQrcodeContent("");
        }
        return response;
    }

    private String generateTrxId(){
        StringBuilder sb = new StringBuilder(TRXID_LENGTH);
        for(int i = 0; i < TRXID_LENGTH; i++){
            sb.append(NUMBERIC_ALPHABET.charAt(srand.nextInt(NUMBERIC_ALPHABET.length())));
        }
        return sb.toString();
    }

}
