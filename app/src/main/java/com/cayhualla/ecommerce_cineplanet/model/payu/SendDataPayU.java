package com.cayhualla.ecommerce_cineplanet.model.payu;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendDataPayU {


    public static class AdditionalValues {

        @SerializedName("TX_VALUE")
        @Expose
        private TX_VALUE txValue;

        public TX_VALUE getTX_VALUE() {
            return txValue;
        }

        public void setTX_VALUE(TX_VALUE txValue) {
            this.txValue = txValue;
        }

        public AdditionalValues withTxValue(TX_VALUE txValue) {
            this.txValue = txValue;
            return this;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(AdditionalValues.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("TX_VALUE");
            sb.append('=');
            sb.append(((this.txValue == null) ? "<null>" : this.txValue));
            sb.append(',');
            if (sb.charAt((sb.length() - 1)) == ',') {
                sb.setCharAt((sb.length() - 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

    }

    public static class BillingAddress {

        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("phone")
        @Expose
        private String phone;
        @SerializedName("postalCode")
        @Expose
        private String postalCode;
        @SerializedName("state")
        @Expose
        private String state;
        @SerializedName("street1")
        @Expose
        private String street1;
        @SerializedName("street2")
        @Expose
        private String street2;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public BillingAddress withCity(String city) {
            this.city = city;
            return this;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public BillingAddress withCountry(String country) {
            this.country = country;
            return this;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public BillingAddress withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        public BillingAddress withPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public BillingAddress withState(String state) {
            this.state = state;
            return this;
        }

        public String getStreet1() {
            return street1;
        }

        public void setStreet1(String street1) {
            this.street1 = street1;
        }

        public BillingAddress withStreet1(String street1) {
            this.street1 = street1;
            return this;
        }

        public String getStreet2() {
            return street2;
        }

        public void setStreet2(String street2) {
            this.street2 = street2;
        }

        public BillingAddress withStreet2(String street2) {
            this.street2 = street2;
            return this;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(BillingAddress.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("city");
            sb.append('=');
            sb.append(((this.city == null) ? "<null>" : this.city));
            sb.append(',');
            sb.append("country");
            sb.append('=');
            sb.append(((this.country == null) ? "<null>" : this.country));
            sb.append(',');
            sb.append("phone");
            sb.append('=');
            sb.append(((this.phone == null) ? "<null>" : this.phone));
            sb.append(',');
            sb.append("postalCode");
            sb.append('=');
            sb.append(((this.postalCode == null) ? "<null>" : this.postalCode));
            sb.append(',');
            sb.append("state");
            sb.append('=');
            sb.append(((this.state == null) ? "<null>" : this.state));
            sb.append(',');
            sb.append("street1");
            sb.append('=');
            sb.append(((this.street1 == null) ? "<null>" : this.street1));
            sb.append(',');
            sb.append("street2");
            sb.append('=');
            sb.append(((this.street2 == null) ? "<null>" : this.street2));
            sb.append(',');
            if (sb.charAt((sb.length() - 1)) == ',') {
                sb.setCharAt((sb.length() - 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

    }

    public static class Buyer {

        @SerializedName("contactPhone")
        @Expose
        private String contactPhone;
        @SerializedName("dniNumber")
        @Expose
        private String dniNumber;
        @SerializedName("emailAddress")
        @Expose
        private String emailAddress;
        @SerializedName("fullName")
        @Expose
        private String fullName;
        @SerializedName("merchantBuyerId")
        @Expose
        private String merchantBuyerId;
        @SerializedName("shippingAddress")
        @Expose
        private ShippingAddress shippingAddress;

        public String getContactPhone() {
            return contactPhone;
        }

        public void setContactPhone(String contactPhone) {
            this.contactPhone = contactPhone;
        }

        public Buyer withContactPhone(String contactPhone) {
            this.contactPhone = contactPhone;
            return this;
        }

        public String getDniNumber() {
            return dniNumber;
        }

        public void setDniNumber(String dniNumber) {
            this.dniNumber = dniNumber;
        }

        public Buyer withDniNumber(String dniNumber) {
            this.dniNumber = dniNumber;
            return this;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        public Buyer withEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public Buyer withFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public String getMerchantBuyerId() {
            return merchantBuyerId;
        }

        public void setMerchantBuyerId(String merchantBuyerId) {
            this.merchantBuyerId = merchantBuyerId;
        }

        public Buyer withMerchantBuyerId(String merchantBuyerId) {
            this.merchantBuyerId = merchantBuyerId;
            return this;
        }

        public ShippingAddress getShippingAddress() {
            return shippingAddress;
        }

        public void setShippingAddress(ShippingAddress shippingAddress) {
            this.shippingAddress = shippingAddress;
        }

        public Buyer withShippingAddress(ShippingAddress shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Buyer.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("contactPhone");
            sb.append('=');
            sb.append(((this.contactPhone == null) ? "<null>" : this.contactPhone));
            sb.append(',');
            sb.append("dniNumber");
            sb.append('=');
            sb.append(((this.dniNumber == null) ? "<null>" : this.dniNumber));
            sb.append(',');
            sb.append("emailAddress");
            sb.append('=');
            sb.append(((this.emailAddress == null) ? "<null>" : this.emailAddress));
            sb.append(',');
            sb.append("fullName");
            sb.append('=');
            sb.append(((this.fullName == null) ? "<null>" : this.fullName));
            sb.append(',');
            sb.append("merchantBuyerId");
            sb.append('=');
            sb.append(((this.merchantBuyerId == null) ? "<null>" : this.merchantBuyerId));
            sb.append(',');
            sb.append("shippingAddress");
            sb.append('=');
            sb.append(((this.shippingAddress == null) ? "<null>" : this.shippingAddress));
            sb.append(',');
            if (sb.charAt((sb.length() - 1)) == ',') {
                sb.setCharAt((sb.length() - 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

    }

    public static class CreditCard {

        @SerializedName("expirationDate")
        @Expose
        private String expirationDate;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("number")
        @Expose
        private String number;
        @SerializedName("securityCode")
        @Expose
        private String securityCode;

        public String getExpirationDate() {
            return expirationDate;
        }

        public void setExpirationDate(String expirationDate) {
            this.expirationDate = expirationDate;
        }

        public CreditCard withExpirationDate(String expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public CreditCard withName(String name) {
            this.name = name;
            return this;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public CreditCard withNumber(String number) {
            this.number = number;
            return this;
        }

        public String getSecurityCode() {
            return securityCode;
        }

        public void setSecurityCode(String securityCode) {
            this.securityCode = securityCode;
        }

        public CreditCard withSecurityCode(String securityCode) {
            this.securityCode = securityCode;
            return this;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(CreditCard.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("expirationDate");
            sb.append('=');
            sb.append(((this.expirationDate == null) ? "<null>" : this.expirationDate));
            sb.append(',');
            sb.append("name");
            sb.append('=');
            sb.append(((this.name == null) ? "<null>" : this.name));
            sb.append(',');
            sb.append("number");
            sb.append('=');
            sb.append(((this.number == null) ? "<null>" : this.number));
            sb.append(',');
            sb.append("securityCode");
            sb.append('=');
            sb.append(((this.securityCode == null) ? "<null>" : this.securityCode));
            sb.append(',');
            if (sb.charAt((sb.length() - 1)) == ',') {
                sb.setCharAt((sb.length() - 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

    }



        @SerializedName("command")
        @Expose
        private String command;
        @SerializedName("language")
        @Expose
        private String language;
        @SerializedName("merchant")
        @Expose
        private Merchant merchant;
        @SerializedName("test")
        @Expose
        private Boolean test;
        @SerializedName("transaction")
        @Expose
        private Transaction transaction;

        public String getCommand() {
            return command;
        }

        public void setCommand(String command) {
            this.command = command;
        }

        public SendDataPayU withCommand(String command) {
            this.command = command;
            return this;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public SendDataPayU withLanguage(String language) {
            this.language = language;
            return this;
        }

        public Merchant getMerchant() {
            return merchant;
        }

        public void setMerchant(Merchant merchant) {
            this.merchant = merchant;
        }

        public SendDataPayU withMerchant(Merchant merchant) {
            this.merchant = merchant;
            return this;
        }

        public Boolean getTest() {
            return test;
        }

        public void setTest(Boolean test) {
            this.test = test;
        }

        public SendDataPayU withTest(Boolean test) {
            this.test = test;
            return this;
        }

        public Transaction getTransaction() {
            return transaction;
        }

        public void setTransaction(Transaction transaction) {
            this.transaction = transaction;
        }

        public SendDataPayU withTransaction(Transaction transaction) {
            this.transaction = transaction;
            return this;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(SendDataPayU.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("command");
            sb.append('=');
            sb.append(((this.command == null) ? "<null>" : this.command));
            sb.append(',');
            sb.append("language");
            sb.append('=');
            sb.append(((this.language == null) ? "<null>" : this.language));
            sb.append(',');
            sb.append("merchant");
            sb.append('=');
            sb.append(((this.merchant == null) ? "<null>" : this.merchant));
            sb.append(',');
            sb.append("test");
            sb.append('=');
            sb.append(((this.test == null) ? "<null>" : this.test));
            sb.append(',');
            sb.append("transaction");
            sb.append('=');
            sb.append(((this.transaction == null) ? "<null>" : this.transaction));
            sb.append(',');
            if (sb.charAt((sb.length() - 1)) == ',') {
                sb.setCharAt((sb.length() - 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }




    public static class ExtraParameters {

        @SerializedName("INSTALLMENTS_NUMBER")
        @Expose
        private Integer installmentsNumber;

        public Integer getINSTALLMENTS_NUMBER() {
            return installmentsNumber;
        }

        public void setINSTALLMENTS_NUMBER(Integer installmentsNumber) {
            this.installmentsNumber = installmentsNumber;
        }

        public ExtraParameters withInstallmentsNumber(Integer installmentsNumber) {
            this.installmentsNumber = installmentsNumber;
            return this;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(ExtraParameters.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("INSTALLMENTS_NUMBER");
            sb.append('=');
            sb.append(((this.installmentsNumber == null) ? "<null>" : this.installmentsNumber));
            sb.append(',');
            if (sb.charAt((sb.length() - 1)) == ',') {
                sb.setCharAt((sb.length() - 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

    }


    public static class Merchant {

        @SerializedName("apiKey")
        @Expose
        private String apiKey;
        @SerializedName("apiLogin")
        @Expose
        private String apiLogin;

        public String getApiKey() {
            return apiKey;
        }

        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }

        public Merchant withApiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public String getApiLogin() {
            return apiLogin;
        }

        public void setApiLogin(String apiLogin) {
            this.apiLogin = apiLogin;
        }

        public Merchant withApiLogin(String apiLogin) {
            this.apiLogin = apiLogin;
            return this;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Merchant.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("apiKey");
            sb.append('=');
            sb.append(((this.apiKey == null) ? "<null>" : this.apiKey));
            sb.append(',');
            sb.append("apiLogin");
            sb.append('=');
            sb.append(((this.apiLogin == null) ? "<null>" : this.apiLogin));
            sb.append(',');
            if (sb.charAt((sb.length() - 1)) == ',') {
                sb.setCharAt((sb.length() - 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

    }


    public static class Order {

        @SerializedName("accountId")
        @Expose
        private String accountId;
        @SerializedName("additionalValues")
        @Expose
        private AdditionalValues additionalValues;
        @SerializedName("buyer")
        @Expose
        private Buyer buyer;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("language")
        @Expose
        private String language;
        @SerializedName("notifyUrl")
        @Expose
        private String notifyUrl;
        @SerializedName("referenceCode")
        @Expose
        private String referenceCode;
        @SerializedName("shippingAddress")
        @Expose
        private ShippingAddress shippingAddress;
        @SerializedName("signature")
        @Expose
        private String signature;

        public String getAccountId() {
            return accountId;
        }

        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }

        public Order withAccountId(String accountId) {
            this.accountId = accountId;
            return this;
        }

        public AdditionalValues getAdditionalValues() {
            return additionalValues;
        }

        public void setAdditionalValues(AdditionalValues additionalValues) {
            this.additionalValues = additionalValues;
        }

        public Order withAdditionalValues(AdditionalValues additionalValues) {
            this.additionalValues = additionalValues;
            return this;
        }

        public Buyer getBuyer() {
            return buyer;
        }

        public void setBuyer(Buyer buyer) {
            this.buyer = buyer;
        }

        public Order withBuyer(Buyer buyer) {
            this.buyer = buyer;
            return this;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Order withDescription(String description) {
            this.description = description;
            return this;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public Order withLanguage(String language) {
            this.language = language;
            return this;
        }

        public String getNotifyUrl() {
            return notifyUrl;
        }

        public void setNotifyUrl(String notifyUrl) {
            this.notifyUrl = notifyUrl;
        }

        public Order withNotifyUrl(String notifyUrl) {
            this.notifyUrl = notifyUrl;
            return this;
        }

        public String getReferenceCode() {
            return referenceCode;
        }

        public void setReferenceCode(String referenceCode) {
            this.referenceCode = referenceCode;
        }

        public Order withReferenceCode(String referenceCode) {
            this.referenceCode = referenceCode;
            return this;
        }

        public ShippingAddress getShippingAddress() {
            return shippingAddress;
        }

        public void setShippingAddress(ShippingAddress shippingAddress) {
            this.shippingAddress = shippingAddress;
        }

        public Order withShippingAddress(ShippingAddress shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public Order withSignature(String signature) {
            this.signature = signature;
            return this;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Order.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("accountId");
            sb.append('=');
            sb.append(((this.accountId == null) ? "<null>" : this.accountId));
            sb.append(',');
            sb.append("additionalValues");
            sb.append('=');
            sb.append(((this.additionalValues == null) ? "<null>" : this.additionalValues));
            sb.append(',');
            sb.append("buyer");
            sb.append('=');
            sb.append(((this.buyer == null) ? "<null>" : this.buyer));
            sb.append(',');
            sb.append("description");
            sb.append('=');
            sb.append(((this.description == null) ? "<null>" : this.description));
            sb.append(',');
            sb.append("language");
            sb.append('=');
            sb.append(((this.language == null) ? "<null>" : this.language));
            sb.append(',');
            sb.append("notifyUrl");
            sb.append('=');
            sb.append(((this.notifyUrl == null) ? "<null>" : this.notifyUrl));
            sb.append(',');
            sb.append("referenceCode");
            sb.append('=');
            sb.append(((this.referenceCode == null) ? "<null>" : this.referenceCode));
            sb.append(',');
            sb.append("shippingAddress");
            sb.append('=');
            sb.append(((this.shippingAddress == null) ? "<null>" : this.shippingAddress));
            sb.append(',');
            sb.append("signature");
            sb.append('=');
            sb.append(((this.signature == null) ? "<null>" : this.signature));
            sb.append(',');
            if (sb.charAt((sb.length() - 1)) == ',') {
                sb.setCharAt((sb.length() - 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

    }


    public static class Payer {

        @SerializedName("billingAddress")
        @Expose
        private BillingAddress billingAddress;
        @SerializedName("contactPhone")
        @Expose
        private String contactPhone;
        @SerializedName("dniNumber")
        @Expose
        private String dniNumber;
        @SerializedName("emailAddress")
        @Expose
        private String emailAddress;
        @SerializedName("fullName")
        @Expose
        private String fullName;
        @SerializedName("merchantPayerId")
        @Expose
        private String merchantPayerId;

        public BillingAddress getBillingAddress() {
            return billingAddress;
        }

        public void setBillingAddress(BillingAddress billingAddress) {
            this.billingAddress = billingAddress;
        }

        public Payer withBillingAddress(BillingAddress billingAddress) {
            this.billingAddress = billingAddress;
            return this;
        }

        public String getContactPhone() {
            return contactPhone;
        }

        public void setContactPhone(String contactPhone) {
            this.contactPhone = contactPhone;
        }

        public Payer withContactPhone(String contactPhone) {
            this.contactPhone = contactPhone;
            return this;
        }

        public String getDniNumber() {
            return dniNumber;
        }

        public void setDniNumber(String dniNumber) {
            this.dniNumber = dniNumber;
        }

        public Payer withDniNumber(String dniNumber) {
            this.dniNumber = dniNumber;
            return this;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        public Payer withEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public Payer withFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public String getMerchantPayerId() {
            return merchantPayerId;
        }

        public void setMerchantPayerId(String merchantPayerId) {
            this.merchantPayerId = merchantPayerId;
        }

        public Payer withMerchantPayerId(String merchantPayerId) {
            this.merchantPayerId = merchantPayerId;
            return this;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Payer.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("billingAddress");
            sb.append('=');
            sb.append(((this.billingAddress == null) ? "<null>" : this.billingAddress));
            sb.append(',');
            sb.append("contactPhone");
            sb.append('=');
            sb.append(((this.contactPhone == null) ? "<null>" : this.contactPhone));
            sb.append(',');
            sb.append("dniNumber");
            sb.append('=');
            sb.append(((this.dniNumber == null) ? "<null>" : this.dniNumber));
            sb.append(',');
            sb.append("emailAddress");
            sb.append('=');
            sb.append(((this.emailAddress == null) ? "<null>" : this.emailAddress));
            sb.append(',');
            sb.append("fullName");
            sb.append('=');
            sb.append(((this.fullName == null) ? "<null>" : this.fullName));
            sb.append(',');
            sb.append("merchantPayerId");
            sb.append('=');
            sb.append(((this.merchantPayerId == null) ? "<null>" : this.merchantPayerId));
            sb.append(',');
            if (sb.charAt((sb.length() - 1)) == ',') {
                sb.setCharAt((sb.length() - 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

    }


    public static class ShippingAddress {

        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("phone")
        @Expose
        private String phone;
        @SerializedName("postalCode")
        @Expose
        private String postalCode;
        @SerializedName("state")
        @Expose
        private String state;
        @SerializedName("street1")
        @Expose
        private String street1;
        @SerializedName("street2")
        @Expose
        private String street2;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public ShippingAddress withCity(String city) {
            this.city = city;
            return this;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public ShippingAddress withCountry(String country) {
            this.country = country;
            return this;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public ShippingAddress withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        public ShippingAddress withPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public ShippingAddress withState(String state) {
            this.state = state;
            return this;
        }

        public String getStreet1() {
            return street1;
        }

        public void setStreet1(String street1) {
            this.street1 = street1;
        }

        public ShippingAddress withStreet1(String street1) {
            this.street1 = street1;
            return this;
        }

        public String getStreet2() {
            return street2;
        }

        public void setStreet2(String street2) {
            this.street2 = street2;
        }

        public ShippingAddress withStreet2(String street2) {
            this.street2 = street2;
            return this;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(ShippingAddress.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("city");
            sb.append('=');
            sb.append(((this.city == null) ? "<null>" : this.city));
            sb.append(',');
            sb.append("country");
            sb.append('=');
            sb.append(((this.country == null) ? "<null>" : this.country));
            sb.append(',');
            sb.append("phone");
            sb.append('=');
            sb.append(((this.phone == null) ? "<null>" : this.phone));
            sb.append(',');
            sb.append("postalCode");
            sb.append('=');
            sb.append(((this.postalCode == null) ? "<null>" : this.postalCode));
            sb.append(',');
            sb.append("state");
            sb.append('=');
            sb.append(((this.state == null) ? "<null>" : this.state));
            sb.append(',');
            sb.append("street1");
            sb.append('=');
            sb.append(((this.street1 == null) ? "<null>" : this.street1));
            sb.append(',');
            sb.append("street2");
            sb.append('=');
            sb.append(((this.street2 == null) ? "<null>" : this.street2));
            sb.append(',');
            if (sb.charAt((sb.length() - 1)) == ',') {
                sb.setCharAt((sb.length() - 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

    }


    public class ShippingAddress__1 {

        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("phone")
        @Expose
        private String phone;
        @SerializedName("postalCode")
        @Expose
        private String postalCode;
        @SerializedName("state")
        @Expose
        private String state;
        @SerializedName("street1")
        @Expose
        private String street1;
        @SerializedName("street2")
        @Expose
        private String street2;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public ShippingAddress__1 withCity(String city) {
            this.city = city;
            return this;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public ShippingAddress__1 withCountry(String country) {
            this.country = country;
            return this;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public ShippingAddress__1 withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        public ShippingAddress__1 withPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public ShippingAddress__1 withState(String state) {
            this.state = state;
            return this;
        }

        public String getStreet1() {
            return street1;
        }

        public void setStreet1(String street1) {
            this.street1 = street1;
        }

        public ShippingAddress__1 withStreet1(String street1) {
            this.street1 = street1;
            return this;
        }

        public String getStreet2() {
            return street2;
        }

        public void setStreet2(String street2) {
            this.street2 = street2;
        }

        public ShippingAddress__1 withStreet2(String street2) {
            this.street2 = street2;
            return this;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(ShippingAddress__1.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("city");
            sb.append('=');
            sb.append(((this.city == null) ? "<null>" : this.city));
            sb.append(',');
            sb.append("country");
            sb.append('=');
            sb.append(((this.country == null) ? "<null>" : this.country));
            sb.append(',');
            sb.append("phone");
            sb.append('=');
            sb.append(((this.phone == null) ? "<null>" : this.phone));
            sb.append(',');
            sb.append("postalCode");
            sb.append('=');
            sb.append(((this.postalCode == null) ? "<null>" : this.postalCode));
            sb.append(',');
            sb.append("state");
            sb.append('=');
            sb.append(((this.state == null) ? "<null>" : this.state));
            sb.append(',');
            sb.append("street1");
            sb.append('=');
            sb.append(((this.street1 == null) ? "<null>" : this.street1));
            sb.append(',');
            sb.append("street2");
            sb.append('=');
            sb.append(((this.street2 == null) ? "<null>" : this.street2));
            sb.append(',');
            if (sb.charAt((sb.length() - 1)) == ',') {
                sb.setCharAt((sb.length() - 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

    }


    public static class Transaction {

        @SerializedName("cookie")
        @Expose
        private String cookie;
        @SerializedName("creditCard")
        @Expose
        private CreditCard creditCard;
        @SerializedName("deviceSessionId")
        @Expose
        private String deviceSessionId;
        @SerializedName("extraParameters")
        @Expose
        private ExtraParameters extraParameters;
        @SerializedName("ipAddress")
        @Expose
        private String ipAddress;
        @SerializedName("order")
        @Expose
        private Order order;
        @SerializedName("payer")
        @Expose
        private Payer payer;
        @SerializedName("paymentCountry")
        @Expose
        private String paymentCountry;
        @SerializedName("paymentMethod")
        @Expose
        private String paymentMethod;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("userAgent")
        @Expose
        private String userAgent;

        public String getCookie() {
            return cookie;
        }

        public void setCookie(String cookie) {
            this.cookie = cookie;
        }

        public Transaction withCookie(String cookie) {
            this.cookie = cookie;
            return this;
        }

        public CreditCard getCreditCard() {
            return creditCard;
        }

        public void setCreditCard(CreditCard creditCard) {
            this.creditCard = creditCard;
        }

        public Transaction withCreditCard(CreditCard creditCard) {
            this.creditCard = creditCard;
            return this;
        }

        public String getDeviceSessionId() {
            return deviceSessionId;
        }

        public void setDeviceSessionId(String deviceSessionId) {
            this.deviceSessionId = deviceSessionId;
        }

        public Transaction withDeviceSessionId(String deviceSessionId) {
            this.deviceSessionId = deviceSessionId;
            return this;
        }

        public ExtraParameters getExtraParameters() {
            return extraParameters;
        }

        public void setExtraParameters(ExtraParameters extraParameters) {
            this.extraParameters = extraParameters;
        }

        public Transaction withExtraParameters(ExtraParameters extraParameters) {
            this.extraParameters = extraParameters;
            return this;
        }

        public String getIpAddress() {
            return ipAddress;
        }

        public void setIpAddress(String ipAddress) {
            this.ipAddress = ipAddress;
        }

        public Transaction withIpAddress(String ipAddress) {
            this.ipAddress = ipAddress;
            return this;
        }

        public Order getOrder() {
            return order;
        }

        public void setOrder(Order order) {
            this.order = order;
        }

        public Transaction withOrder(Order order) {
            this.order = order;
            return this;
        }

        public Payer getPayer() {
            return payer;
        }

        public void setPayer(Payer payer) {
            this.payer = payer;
        }

        public Transaction withPayer(Payer payer) {
            this.payer = payer;
            return this;
        }

        public String getPaymentCountry() {
            return paymentCountry;
        }

        public void setPaymentCountry(String paymentCountry) {
            this.paymentCountry = paymentCountry;
        }

        public Transaction withPaymentCountry(String paymentCountry) {
            this.paymentCountry = paymentCountry;
            return this;
        }

        public String getPaymentMethod() {
            return paymentMethod;
        }

        public void setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        public Transaction withPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Transaction withType(String type) {
            this.type = type;
            return this;
        }

        public String getUserAgent() {
            return userAgent;
        }

        public void setUserAgent(String userAgent) {
            this.userAgent = userAgent;
        }

        public Transaction withUserAgent(String userAgent) {
            this.userAgent = userAgent;
            return this;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Transaction.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("cookie");
            sb.append('=');
            sb.append(((this.cookie == null) ? "<null>" : this.cookie));
            sb.append(',');
            sb.append("creditCard");
            sb.append('=');
            sb.append(((this.creditCard == null) ? "<null>" : this.creditCard));
            sb.append(',');
            sb.append("deviceSessionId");
            sb.append('=');
            sb.append(((this.deviceSessionId == null) ? "<null>" : this.deviceSessionId));
            sb.append(',');
            sb.append("extraParameters");
            sb.append('=');
            sb.append(((this.extraParameters == null) ? "<null>" : this.extraParameters));
            sb.append(',');
            sb.append("ipAddress");
            sb.append('=');
            sb.append(((this.ipAddress == null) ? "<null>" : this.ipAddress));
            sb.append(',');
            sb.append("order");
            sb.append('=');
            sb.append(((this.order == null) ? "<null>" : this.order));
            sb.append(',');
            sb.append("payer");
            sb.append('=');
            sb.append(((this.payer == null) ? "<null>" : this.payer));
            sb.append(',');
            sb.append("paymentCountry");
            sb.append('=');
            sb.append(((this.paymentCountry == null) ? "<null>" : this.paymentCountry));
            sb.append(',');
            sb.append("paymentMethod");
            sb.append('=');
            sb.append(((this.paymentMethod == null) ? "<null>" : this.paymentMethod));
            sb.append(',');
            sb.append("type");
            sb.append('=');
            sb.append(((this.type == null) ? "<null>" : this.type));
            sb.append(',');
            sb.append("userAgent");
            sb.append('=');
            sb.append(((this.userAgent == null) ? "<null>" : this.userAgent));
            sb.append(',');
            if (sb.charAt((sb.length() - 1)) == ',') {
                sb.setCharAt((sb.length() - 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

    }


    public static class TX_VALUE {

        @SerializedName("currency")
        @Expose
        private String currency;
        @SerializedName("value")
        @Expose
        private Double value;

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public TX_VALUE withCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public Double getValue() {
            return value;
        }

        public void setValue(Double value) {
            this.value = value;
        }

        public TX_VALUE withValue(Double value) {
            this.value = value;
            return this;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(TX_VALUE.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("currency");
            sb.append('=');
            sb.append(((this.currency == null) ? "<null>" : this.currency));
            sb.append(',');
            sb.append("value");
            sb.append('=');
            sb.append(((this.value == null) ? "<null>" : this.value));
            sb.append(',');
            if (sb.charAt((sb.length() - 1)) == ',') {
                sb.setCharAt((sb.length() - 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

    }

}
