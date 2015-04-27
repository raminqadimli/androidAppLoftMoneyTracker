/**
 * Copyright (c) 2015 Bookmate.
 * All Rights Reserved.
 * <p/>
 * Author: Dmitry Gordeev <netimen@dreamindustries.co>
 * Date:   27.04.15
 */
package com.my.moneytracker;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TransactionsFragment extends Fragment {
    private ListView listView;
    private TransactionAdapter transactionAdapter;
    List<Transactions> data = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View inflate = inflater.inflate(R.layout.fragment_transactions, container);
        List<Transactions> adapterData = getDataList();
        transactionAdapter = new TransactionAdapter(getActivity(), adapterData);

        listView = (ListView) inflate.findViewById(R.id.listview);
        listView.setAdapter(transactionAdapter);
        return inflate;
    }

    private List<Transactions> getDataList() {

        data.add(new Transactions("Telephone", "2000"));
        data.add(new Transactions("T-Shirts", "3000"));
        data.add(new Transactions("Jeans", "1000"));

        return data;
    }
}
