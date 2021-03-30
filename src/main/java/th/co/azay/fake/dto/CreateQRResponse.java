package th.co.azay.fake.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateQRResponse {

    String success;
    String returnCode;
    String message;
    String trxId;
    String qrcodeContent;
    String sign;

}
