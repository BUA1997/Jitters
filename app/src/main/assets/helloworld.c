//
// Created by SCORPIO on 2/13/2020.
//
<#include <stdio.h>
  int main() {
     // printf() displays the string inside quotation
     printf("Hello, World!");
     return 0;
  }

package com.example.jitters;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recycler extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    AdapterRecyclerLinear adapterRecyclerLinear;

    ArrayList<PojoLinear> list;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        linearList();
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapterRecyclerLinear = new AdapterRecyclerLinear(this,list);
        recyclerView.setAdapter(adapterRecyclerLinear);

    }

    private void linearList() {
        list = new ArrayList<PojoLinear>();
        list.add(new PojoLinear("BUA","9.0"));
        list.add(new PojoLinear("STUART","8.0"));
        list.add(new PojoLinear("JAMES","7.0"));
        list.add(new PojoLinear("ERINAH","6.0"));
        list.add(new PojoLinear("HASSAN","5.0"));
        list.add(new PojoLinear("THOMAS","4.4"));
        list.add(new PojoLinear("JASPER","4.1"));
        list.add(new PojoLinear("CECILIA","4.0"));
        list.add(new PojoLinear("SUZIE","3.0 , 3.1 and 3.2"));
        list.add(new PojoLinear("DERECK","2.3 , 2.4"));
        list.add(new PojoLinear("PATRICIA","2.2"));
        list.add(new PojoLinear("ESTER","2.0 , 2.1"));
        list.add(new PojoLinear("DONAH","1.6"));
        list.add(new PojoLinear("BALUKU","1.5"));
        list.add(new PojoLinear("MICHAEL","1.0 , 1.1"));


    }

}
