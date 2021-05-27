package com.cayhualla.ecommerce_cineplanet.response;

import com.cayhualla.ecommerce_cineplanet.model.payu.TransactionResponse;

import org.simpleframework.xml.Root;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "paymentResponse")
public class PaymentResponse {

    TransactionResponse transactionResponse;
    private String code;
    private String error;

    public TransactionResponse getTransactionResponse() {
        return transactionResponse;
    }

    @Root(name = "transactionResponse")
    public void setTransactionResponse(TransactionResponse transactionResponse) {
        this.transactionResponse = transactionResponse;
    }

    public String getCode() {
        return code;
    }

    @Root(name = "code")
    public void setCode(String code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    @Root(name = "error")
    public void setError(String error) {
        this.error = error;
    }

}
