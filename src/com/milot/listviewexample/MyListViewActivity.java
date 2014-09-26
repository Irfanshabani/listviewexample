package com.milot.listviewexample;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.milot.listviewexample.R;

public class MyListViewActivity extends ListActivity {
	
	private class Person {
		
		private String firstName;
		private String lastName;
		private String description;
		private int flag;
		
		public Person(){}
		
		public Person(String firstName, String lastName, String description, int flag) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.description = description;
			this.flag = flag;
		}

		public int getFlag() {
			return flag;
		}

		public void setFlag(int flag) {
			this.flag = flag;
		}

		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}	
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_layout);
		
		List<Person> objects = new ArrayList<Person>();
		objects.add(new Person("Hajrush", "Pula", "KFC", 0));
		objects.add(new Person("Hanife", "Shtiklla", "McDonalds", 1));
		objects.add(new Person("Halim", "Halimi", "Te Halimi", 2));
		
		setListAdapter(new MyArrayAdapter(this, objects));
	}
	
	private class MyArrayAdapter extends ArrayAdapter<Person> {

	    List<Person> objs;
	    Context context;
	    public MyArrayAdapter(Context context, List<Person> objects) {
	      super(context, R.layout.list_row, objects);
	      objs = objects;
	      this.context = context;
	    }
	    
	    @Override
	    public long getItemId(int position) {
	        return position;
	    }

	    
	    @Override
	    public int getCount() {
	    		return objs.size();
	    }

	    @Override
      public View getView(int position, View convertView, ViewGroup parent) {
	    	ViewHolder holder;
	    	final int _position = position;
	    	if (convertView == null) {
           convertView = getLayoutInflater().inflate(R.layout.list_row,
                        parent, false);
           holder = new ViewHolder(convertView);
           convertView.setTag(holder);
	    	} else {
	    		holder = (ViewHolder) convertView.getTag();
	    	}
        holder.getTekstiKryesore().setText(objs.get(position).getFirstName() + " " + 
        									  objs.get(position).getLastName());
        holder.getTekstiPerfuni().setText(objs.get(position).getDescription());
        holder.getFoto().setImageResource(R.drawable.ic_launcher);
        holder.getFoto2().setImageResource(R.drawable.ic_launcher);
        
        convertView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (objs.get(_position).flag == 0) {
					Intent youTube = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/"));
					startActivity(youTube);
				} else if (objs.get(_position).flag == 1) {
					Intent youTube = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.yahoo.com/"));
					startActivity(youTube);
				} else if (objs.get(_position).flag == 2) {
					Intent youTube = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.slashdot.org/"));
					startActivity(youTube);
				}
				
			}
		});

        return convertView;
      }
	}
}
