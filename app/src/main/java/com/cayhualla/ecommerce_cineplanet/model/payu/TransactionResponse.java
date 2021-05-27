package com.cayhualla.ecommerce_cineplanet.model.payu;

import org.simpleframework.xml.Root;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "transactionResponse")

public class TransactionResponse {

    private String orderId;
    private String transactionId;
    private String state;
    private String paymentNetworkResponseCode;
    private String responseCode;
    private String responseMessage;
    private ExtraParameters extraParameters;


    // Getter Methods

    public String getOrderId() {
        return orderId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getState() {
        return state;
    }

    public String getPaymentNetworkResponseCode() {
        return paymentNetworkResponseCode;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }


    // Setter Methods
    @Root(name = "orderId")

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Root(name = "transactionId")

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @Root(name = "state")

    public void setState(String state) {
        this.state = state;
    }

    @Root(name = "paymentNetworkResponseCode")

    public void setPaymentNetworkResponseCode(String paymentNetworkResponseCode) {
        this.paymentNetworkResponseCode = paymentNetworkResponseCode;
    }

    @Root(name = "responseCode")

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    @Root(name = "responseMessage")

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    @Root(name = "extraParameters")

    public void setExtraParameters(ExtraParameters extraParameters) {
        extraParameters = extraParameters;
    }

    public ExtraParameters getExtraParameters() {
        return extraParameters;
    }

}
