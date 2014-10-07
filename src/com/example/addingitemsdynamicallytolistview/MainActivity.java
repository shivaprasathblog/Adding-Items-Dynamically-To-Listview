package com.example.addingitemsdynamicallytolistview;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity 
{

	EditText et;
	Button b;
	ListView lv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et=(EditText)findViewById(R.id.editText1);
		b=(Button)findViewById(R.id.button1);
		lv=(ListView)findViewById(R.id.listView1);
		
		/** Items entered by the user is stored in this ArrayList variable */
		final ArrayList<String> al= new ArrayList<String>();
		/** Defining the ArrayAdapter to set items to ListView */
		final ArrayAdapter<String>aa=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,al);
		/** Setting the adapter to the ListView */
		lv.setAdapter(aa);
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,	long arg3) 
				{
				// TODO Auto-generated method stub
				String item=al.get(arg2);
				}
		});
		
		b.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View arg0)
			{
				// TODO Auto-generated method stub
				// take text from et and add to arraylist
				String item=et.getText().toString();
				al.add(item);
				// notify to adapter
				aa.notifyDataSetChanged();
				// clr edit text
				et.setText("");
			}
		});
	}

	

}
