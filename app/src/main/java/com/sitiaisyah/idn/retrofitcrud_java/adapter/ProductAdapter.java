package com.sitiaisyah.idn.retrofitcrud_java.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.sitiaisyah.idn.retrofitcrud_java.R;
import com.sitiaisyah.idn.retrofitcrud_java.activity.ProductActivity;
import com.sitiaisyah.idn.retrofitcrud_java.model.PersonItem;


public class ProductAdapter extends ArrayAdapter<PersonItem>{
    private Context context;
    private List<PersonItem> personItem;

    public ProductAdapter(@NonNull Context context,
                          int resource,
                          @NonNull List<PersonItem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.personItem = objects;
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context
                .LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.list_item, parent, false);

        TextView txtIdProduct = v.findViewById(R.id.txt_product_id);
        TextView txtNameProduct = v.findViewById(R.id.txt_product_name);
        TextView txtPriceProduct = v.findViewById(R.id.txt_product_price);
        TextView txtDescProduct = v.findViewById(R.id.txt_product_desc);

        txtIdProduct.setText(String.valueOf( personItem.get(position).getId()));
        txtNameProduct.setText(String.valueOf(personItem.get(position).getName()));
        txtPriceProduct.setText(String.valueOf(personItem.get(position).getPrice()));
        txtDescProduct.setText(String.valueOf(personItem.get(position).getDesc()));

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProductActivity.class);
                intent.putExtra("id", String.valueOf(personItem.get(position).getId()));
                intent.putExtra("name", personItem.get(position).getName());
                intent.putExtra("price", personItem.get(position).getPrice());
                intent.putExtra("desc", personItem.get(position).getDesc());
                context.startActivity(intent);
            }
        });

        return v;
    }

}