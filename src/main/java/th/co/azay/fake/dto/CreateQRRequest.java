package th.co.azay.fake.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateQRRequest {

    String bizMchId;
    String billerId;
    String channel;
    String reference1;
    String reference2;
    String terminalId;
    String amount;
    String remark;
    String sign;

}
