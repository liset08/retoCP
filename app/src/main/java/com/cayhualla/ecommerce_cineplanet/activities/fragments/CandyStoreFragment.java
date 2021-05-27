package com.cayhualla.ecommerce_cineplanet.activities.fragments;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.cayhualla.ecommerce_cineplanet.R;
import com.cayhualla.ecommerce_cineplanet.adapters.ListCandyStoreAdapter;
import com.cayhualla.ecommerce_cineplanet.adapters.ListDetailProductAdapter;
import com.cayhualla.ecommerce_cineplanet.model.CandyStore;
import com.cayhualla.ecommerce_cineplanet.model.payu.Items;
import com.cayhualla.ecommerce_cineplanet.response.PaymentResponse;
import com.cayhualla.ecommerce_cineplanet.response.ResponseMessage;
import com.cayhualla.ecommerce_cineplanet.service.ApiService;
import com.cayhualla.ecommerce_cineplanet.service.ApiServiceGenerator;
import com.cayhualla.ecommerce_cineplanet.service.ApiServiceGeneratorPayU;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CandyStoreFragment extends Fragment implements ListCandyStoreAdapter.ListDetailItemsInterface {

    private static String TAG = CandyStoreFragment.class.getSimpleName();
    private ApiService service = ApiServiceGenerator.createService(ApiService.class);
    private ApiService servicePayU = ApiServiceGeneratorPayU.createService(ApiService.class);
    private RecyclerView rv_list_candy_store;
    private ListCandyStoreAdapter adapter;
    private ListDetailProductAdapter adapter_products;
    private Context context;
    private ImageButton btn_fin_buy;
    private Dialog ald_detail_buy, ald_pay, ald_success_transaction;
    private JSONArray objArrayListDetail;
    private List<Items> items;
    private double total_amount;
    private String card_number;
    private ProgressDialog pd_transaction;

    public CandyStoreFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public static CandyStoreFragment newInstance() {
        CandyStoreFragment fragment = new CandyStoreFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_candy_store, container, false);

        rv_list_candy_store = view.findViewById(R.id.rv_list_candy_store);
        btn_fin_buy = view.findViewById(R.id.btn_fin_buy);

        rv_list_candy_store.setLayoutManager(new GridLayoutManager(context, 2));
        rv_list_candy_store.setAdapter(new ListCandyStoreAdapter(context, this));
        adapter = (ListCandyStoreAdapter) rv_list_candy_store.getAdapter();

        get_list_candy_store();

        btn_fin_buy.setOnClickListener(v -> {
            items = new ArrayList<>();
            total_amount = 0.0;
            if (objArrayListDetail != null) {
                try {
                    for (int i = 0; i < objArrayListDetail.length(); i++) {
                        JSONObject obj = objArrayListDetail.getJSONObject(i);
                        if (!obj.isNull("description")) {
                            String description = obj.getString("description");
                            String name = obj.getString("name");
                            Double price = obj.getDouble("price");
                            Integer unit = obj.getInt("unit");
                            items.add(new Items(price.toString(), description, name, unit.toString()));
                            total_amount = total_amount + price;
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                //Mostrar el dialog del detalle de los productos
                ald_detail_buy = new Dialog(context);
                ald_detail_buy.setContentView(R.layout.dialog_detail_buy);

                Button btn_cer_lis_det_pro = ald_detail_buy.findViewById(R.id.btn_cer_lis_det_pro);
                RecyclerView rv_lis_det_pro = ald_detail_buy.findViewById(R.id.rv_lis_det_pro);
                TextView txt_tot_lis_det_pro = ald_detail_buy.findViewById(R.id.txt_tot_lis_det_pro);

                txt_tot_lis_det_pro.setText("S/. " + String.format("%.2f", total_amount));
                rv_lis_det_pro.setLayoutManager(new LinearLayoutManager(getActivity()));
                rv_lis_det_pro.setAdapter(new ListDetailProductAdapter(context));
                adapter_products = (ListDetailProductAdapter) rv_lis_det_pro.getAdapter();
                adapter_products.setListDetailProductAdapter(items);
                adapter_products.notifyDataSetChanged();
                btn_cer_lis_det_pro.setOnClickListener(vd -> {
                    ald_detail_buy.dismiss();

                    //Mostrar el dialogo de pago
                    ald_pay = new Dialog(context);
                    ald_pay.setContentView(R.layout.dialog_pay);

                    Button btn_cer_pay = ald_pay.findViewById(R.id.btn_cer_pay);
                    EditText etxt_num_car_1 = ald_pay.findViewById(R.id.etxt_num_car_1);
                    EditText etxt_fec_exp = ald_pay.findViewById(R.id.etxt_fec_exp);
                    EditText etxt_cvv = ald_pay.findViewById(R.id.etxt_cvv);
                    EditText etxt_nom_tit = ald_pay.findViewById(R.id.etxt_nom_tit);
                    EditText etxt_cor_ele = ald_pay.findViewById(R.id.etxt_cor_ele);
                    EditText etxt_dni = ald_pay.findViewById(R.id.etxt_dni);
                    btn_cer_pay.setText("Pagar  S/. " + total_amount);
                    btn_cer_pay.setOnClickListener(vp -> {

                        if (etxt_num_car_1.length() < 16) {
                            etxt_num_car_1.setError("Debe contener 16 dígitos");
                        } else if (etxt_cvv.length() < 3) {
                            etxt_cvv.setError("Debe contener 3 dígitos");
                        } else if (etxt_nom_tit.length() < 2) {
                            etxt_nom_tit.setError("Debe ingresar sus datos");
                        } else if (etxt_cor_ele.length() < 3) {
                            etxt_cor_ele.setError("Debe ingresar sus datos");
                        } else if (etxt_dni.length() < 8) {
                            etxt_dni.setError("Debe contener 8 dígitos");
                        } else {
                            ald_pay.dismiss();
                            //Mostrar progress dialog
                            pd_transaction = new ProgressDialog(context);
                            pd_transaction.setMessage(getString(R.string.dl_transaction));
                            pd_transaction.show();
                            pd_transaction.setCancelable(false);

                            card_number = etxt_num_car_1.getText().toString();
                            data_pay(etxt_nom_tit.getText().toString(), card_number, etxt_dni.getText().toString(), etxt_cor_ele.getText().toString(), etxt_cvv.getText().toString(), etxt_fec_exp.getText().toString());

                        }
                    });
                    ald_pay.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    ald_pay.show();
                });

                ald_detail_buy.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                ald_detail_buy.show();
            } else {
                Toast.makeText(context, "No hay productos agregados", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    public void get_list_candy_store() {

        Call<CandyStore> call = service.list_candy_store();
        call.enqueue(new Callback<CandyStore>() {
            @Override
            public void onResponse(Call<CandyStore> call, Response<CandyStore> response) {
                try {
                    if (response.isSuccessful()) {
                        CandyStore candyStore = response.body();
                        adapter.setListaSolicitudes(candyStore.getItem());
                        adapter.notifyDataSetChanged();
                        Log.e(TAG, "Data candy store: " + candyStore.getItem().get(0).getName());

                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    Log.e(TAG, "onThrowable: " + t.toString(), t);
                }
            }

            @Override
            public void onFailure(Call<CandyStore> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
            }
        });
    }

    public void data_pay(String person, String card_number, String dni, String email, String cvv, String date) {


        String xml = "<request>\n" +
                "   <language>" + getResources().getString(R.string.language) + "</language>\n" +
                "   <command>" + getResources().getString(R.string.command) + "</command>\n" +
                "   <merchant>\n" +
                "      <apiKey>" + getResources().getString(R.string.apiKey) + "</apiKey>\n" +
                "      <apiLogin>" + getResources().getString(R.string.apiLogin) + "</apiLogin>\n" +
                "   </merchant>\n" +
                "   <transaction>\n" +
                "      <order>\n" +
                "         <accountId>512323</accountId>\n" +
                "         <referenceCode>payment_test_00000001</referenceCode>\n" +
                "         <description>payment test</description>\n" +
                "         <language>es</language>\n" +
                "         <signature>" + getResources().getString(R.string.signature) + "</signature>\n" +
                "         <notifyUrl>" + getResources().getString(R.string.notifyUrl) + "</notifyUrl>\n" +
                "         <additionalValues>\n" +
                "            <entry>\n" +
                "               <string>TX_VALUE</string>\n" +
                "               <additionalValue>\n" +
                "                  <value>" + total_amount + "</value>\n" +
                "                  <currency>PEN</currency>\n" +
                "               </additionalValue>\n" +
                "            </entry>\n" +
                "         </additionalValues>\n" +
                "         <buyer>\n" +
                "            <merchantBuyerId>1</merchantBuyerId>\n" +
                "            <fullName>" + person + "</fullName>\n" +
                "            <emailAddress>" + email + "</emailAddress>\n" +
                "            <contactPhone>7563126</contactPhone>\n" +
                "            <dniNumber>" + dni + "</dniNumber>\n" +
                "            <shippingAddress>\n" +
                "               <street1>Avenida de la poesia</street1>\n" +
                "               <street2>106</street2>\n" +
                "               <city>Cuzco</city>\n" +
                "               <state>CU</state>\n" +
                "               <country>PE</country>\n" +
                "               <postalCode>000000</postalCode>\n" +
                "               <phone>7563126</phone>\n" +
                "            </shippingAddress>\n" +
                "         </buyer>\n" +
                "         <shippingAddress>\n" +
                "            <street1>Prueba</street1>\n" +
                "            <street2>106</street2>\n" +
                "            <city>Cuzco</city>\n" +
                "            <state>CU</state>\n" +
                "            <country>PE</country>\n" +
                "            <postalCode>0000000</postalCode>\n" +
                "            <phone>7563126</phone>\n" +
                "         </shippingAddress>\n" +
                "      </order>\n" +
                "      <payer>\n" +
                "         <merchantPayerId>1</merchantPayerId>\n" +
                "         <fullName>First name and second payer name</fullName>\n" +
                "         <emailAddress>payer_test@test.com</emailAddress>\n" +
                "         <contactPhone>7563126</contactPhone>\n" +
                "         <dniNumber>54156688</dniNumber>\n" +
                "         <billingAddress>\n" +
                "            <street1>av abancay</street1>\n" +
                "            <street2>cra 4</street2>\n" +
                "            <city>Iquitos</city>\n" +
                "            <state>LO</state>\n" +
                "            <country>PE</country>\n" +
                "            <postalCode>64000</postalCode>\n" +
                "            <phone>7563126</phone>\n" +
                "         </billingAddress>\n" +
                "      </payer>\n" +
                "      <creditCard>\n" +
                "         <number>" + card_number + "</number>\n" +
                "         <securityCode>" + cvv + "</securityCode>\n" +
                "         <expirationDate>" + date + "</expirationDate>\n" +
                "         <name>" + getResources().getString(R.string.nameCreditCard) + "</name>\n" +
                "      </creditCard>\n" +
                "      <extraParameters>\n" +
                "         <entry>\n" +
                "            <string>INSTALLMENTS_NUMBER</string>\n" +
                "            <string>1</string>\n" +
                "         </entry>\n" +
                "      </extraParameters>\n" +
                "      <type>" + getResources().getString(R.string.type) + "</type>\n" +
                "      <paymentMethod>" + getResources().getString(R.string.paymentMethod) + "</paymentMethod>\n" +
                "      <paymentCountry>PE</paymentCountry>\n" +
                "      <deviceSessionId>" + getResources().getString(R.string.deviceSessionId) + "</deviceSessionId>\n" +
                "      <ipAddress>" + getResources().getString(R.string.ipAddress) + "</ipAddress>\n" +
                "      <cookie>" + getResources().getString(R.string.cookie) + "</cookie>\n" +
                "      <userAgent>" + getResources().getString(R.string.userAgent) + "</userAgent>\n" +
                "   </transaction>\n" +
                "   <isTest>false</isTest>\n" +
                "</request>";

        send_transaction_payu(xml, person, dni, email);

    }

    public void send_transaction_payu(String xml, String person, String dni, String email) {

        RequestBody requestBody = RequestBody.create(MediaType.parse("text/xml;charset=utf-8"), xml);
        Call<PaymentResponse> call = servicePayU.make_transaction(requestBody);
        call.enqueue(new Callback<PaymentResponse>() {
            @Override
            public void onResponse(Call<PaymentResponse> call, Response<PaymentResponse> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);
                    PaymentResponse paymentResponse = response.body();
                    Log.e(TAG, "onResponse: " + response.body().getTransactionResponse().getOrderId());

                    if (response.isSuccessful()) {
                        store_complete(response.body().getTransactionResponse().getOrderId(), person, dni, email);
                    } else {
                        pd_transaction.dismiss();
                        Toast.makeText(context, R.string.txt_error, Toast.LENGTH_SHORT).show();
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }
                } catch (Throwable t) {
                    try {
                        pd_transaction.dismiss();
                        Toast.makeText(context, R.string.txt_error, Toast.LENGTH_SHORT).show();
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                    } catch (Throwable x) {
                    }
                }
            }

            @Override
            public void onFailure(Call<PaymentResponse> call, Throwable t) {
                pd_transaction.dismiss();
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(context, R.string.txt_error, Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void store_complete(String operation_date, String person, String dni, String email) {

        Call<ResponseMessage> call = service.store_complete(person, email, dni, operation_date);
        call.enqueue(new Callback<ResponseMessage>() {
            @Override
            public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {
                try {
                    int statusCode = response.code();
                    ResponseMessage responseMessage = response.body();
                    if (response.isSuccessful()) {
                        if (responseMessage.getResul_code().equals("0")) {
                            pd_transaction.dismiss();
                            ald_success_transaction = new Dialog(context);
                            ald_success_transaction.setContentView(R.layout.dialog_success_transaction);

                            Button btn_dlg_sec_tra = ald_success_transaction.findViewById(R.id.btn_dlg_sec_tra);
                            btn_dlg_sec_tra.setOnClickListener(vp -> {
                                ald_success_transaction.dismiss();
                            });

                            ald_success_transaction.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                            ald_success_transaction.show();
                        }
                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }
                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                    } catch (Throwable x) {
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseMessage> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
            }
        });
    }

    @Override
    public void updateList(JSONArray objArray) {
        objArrayListDetail = new JSONArray();
        objArrayListDetail = objArray;

    }

}