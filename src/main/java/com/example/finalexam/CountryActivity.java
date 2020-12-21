package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CountryActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, SeekBar.OnSeekBarChangeListener, View.OnClickListener, AdapterView.OnItemClickListener {
    Spinner spinner;
    TextView cname,quant,total;
    ImageView cImage;
    ListView listView;
    Button Total_price;
    SeekBar seek;
    String countryFlag[]={"Canada","USA","England"};
    ArrayList<POI>visitingPlaces=new ArrayList<>();
    public static double price=1.0;
    public static String placeName="";

    public static ArrayList<POI>tempList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        filldata();

        spinner = findViewById(R.id.sp1);
        cname = findViewById(R.id.countryname);
        cImage = findViewById(R.id.countryimage);
        listView = findViewById(R.id.listv1);
        seek=findViewById(R.id.seekBar1);
        quant=findViewById(R.id.totalno);
        total=findViewById(R.id.totalprice);
        Total_price=findViewById(R.id.totalbtn);

        ArrayAdapter rs = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,countryFlag);
        spinner.setAdapter(rs);
        spinner.setOnItemSelectedListener(this);
        seek.setOnSeekBarChangeListener(this);
        Total_price.setOnClickListener(this);
        listView.setOnItemClickListener(this);

    }
    public void filldata() {

        visitingPlaces.add(new POI("Niagara Falls", "niagra", 100.0, "Ottawa", "canada", countryFlag[0]));
        visitingPlaces.add(new POI("CN Tower", "cntower", 30.0, "Ottawa", "canada", countryFlag[0]));
        visitingPlaces.add(new POI("The ButChart Garden", "butchart", 30.0, "Ottawa", "canada", countryFlag[0]));
        visitingPlaces.add(new POI("Notre-Dame Basilica", "notredame", 50.0, "Ottawa", "canada", countryFlag[0]));
        visitingPlaces.add(new POI("The Statue of Liberty", "statue", 90.0, "Washington", "usa", countryFlag[1]));
        visitingPlaces.add(new POI("The White House", "whitehouse", 60.0, "Washington", "usa", countryFlag[1]));
        visitingPlaces.add(new POI("Time Square  ", "timesquare", 75.0, "Washington", "usa", countryFlag[1]));
        visitingPlaces.add(new POI("Big Ben", "bigben", 30.0, "London", "england", countryFlag[2]));
        visitingPlaces.add(new POI("Westminster Abbey ", "westminster", 25.0, "London", "england", countryFlag[2]));
        visitingPlaces.add(new POI("Hyde Park", "hydepark", 15.0, "London", "england", countryFlag[2]));
    }
    public void fillTempList(String cat){
        for(int i=0;i<visitingPlaces.size();i++)
            if((visitingPlaces.get(i).countryName).equals(cat))
                tempList.add(visitingPlaces.get(i));
    }
    public String getcaps(String rs)
    {
        for(int j=0;j<visitingPlaces.size();j++)
        {
            if(visitingPlaces.get(j).getCountryName().equals(rs))
            {
                return visitingPlaces.get(j).getC_name();
            }
        }
        return null;
    }
    public String getsimage(String rsd)
    {
        for(int i=0;i<visitingPlaces.size();i++)
        {
            if(visitingPlaces.get(i).getCountryName().equals(rsd))
            {
                return visitingPlaces.get(i).getC_image();
            }
        }
        return null;
    }

    @Override




    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        cname.setText(getcaps(countryFlag[position]));
        int imag1 = getResources().getIdentifier(getsimage(countryFlag[position]),"drawable",getPackageName());
        cImage.setImageResource(imag1);
        tempList.clear();
        fillTempList(countryFlag[position]);

        listView.setAdapter(new CountryAdapter(this,tempList));

       // listView.setAdapter(new CountryAdapter(this,visitingPlaces));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        if(progress>=1)
            quant.setText(String.valueOf(progress));
        else
            quant.setText("1");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onClick(View v) {
       if (v.getId()==(R.id.totalbtn))
       {
           double qty = Double.parseDouble(quant.getText().toString());
           double tempPrice = qty * price;
           double percent = 0.05*tempPrice;
           double lastprice=tempPrice-percent;

           if(qty<15)
           {
               total.setText(String.format("%.2f", tempPrice));
           }
           else
           {
               total.setText(String.format("%.2f", lastprice)); }
           }
       }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        price = tempList.get(position).getP_price();
        placeName = tempList.get(position).getP_name();
        Toast.makeText(this, ""+tempList.get(position).getP_name()+" Selected", Toast.LENGTH_SHORT).show();

    }
}
