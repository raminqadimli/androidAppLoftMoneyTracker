/**
 * Copyright (c) 2015 Bookmate.
 * All Rights Reserved.
 * <p/>
 * Author: Dmitry Gordeev <netimen@dreamindustries.co>
 * Date:   27.04.15
 */
package com.my.moneytracker;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class TransactionsFragment extends Fragment {
    private RecyclerView recyclerView;
    private TransactionAdapter transactionAdapter;
    List<Transaction> data = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View inflate = inflater.inflate(R.layout.fragment_transactions, container, false);
        List<Transaction> adapterData = getDataList();
        transactionAdapter = new TransactionAdapter(adapterData);

        recyclerView = (RecyclerView) inflate.findViewById(R.id.transactions_list);
        FloatingActionButton fab = (FloatingActionButton) inflate.findViewById(R.id.fab);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(transactionAdapter);
        fab.attachToRecyclerView(recyclerView);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), AddTransactionActivity.class);
                //myIntent.putExtra("key", data.get(0).toString()); //Optional parameters
                getActivity().startActivity(myIntent);
            }
        });
        return inflate;
    }

    private List<Transaction> getDataList() {

        data.add(new Transaction("Telephone", "2000"));
        data.add(new Transaction("T-Shirts", "3000"));
        data.add(new Transaction("Jeans", "1000"));
        data.add(new Transaction("Telephone", "2000"));
        data.add(new Transaction("T-Shirts", "3000"));
        data.add(new Transaction("Jeans", "1000"));
        data.add(new Transaction("Telephone", "2000"));
        data.add(new Transaction("T-Shirts", "3000"));
        data.add(new Transaction("Jeans", "1000"));
        data.add(new Transaction("Telephone", "2000"));
        data.add(new Transaction("T-Shirts", "3000"));
        data.add(new Transaction("Jeans", "1000"));

        return data;
    }
}
