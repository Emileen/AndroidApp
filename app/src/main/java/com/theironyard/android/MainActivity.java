package com.theironyard.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {
    ArrayAdapter<String> contact;

    // creates a list/name/phone/addButton
    ListView list;
    EditText name;
    EditText phone;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //sets the buttons that were created to the actual buttons
        list = (ListView) findViewById(R.id.listView);
        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        addButton = (Button) findViewById(R.id.button);

        //creates a simple list
        contact = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        //creates a list of contacts
        list.setAdapter(contact);

        addButton.setOnClickListener(this);
        list.setOnItemLongClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //checks to see if there are any empty entries and if there are then no info is added
        if (!name.getText().toString().equals("") && !phone.getText().toString().equals("")) {
            String item = name.getText().toString() + " " + phone.getText().toString();
            contact.add(item);
            name.setText("");
            phone.setText("");
        }


    }

    @Override
    //when there is a long click then remove the item
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        //put the postion into the contactinfo
        String contactinfo = contact.getItem(position);
        //goes and removes the contactinfo from the contact file
        contact.remove(contactinfo);
        return true;
    }
}
