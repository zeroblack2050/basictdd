package com.basetdd;

import android.icu.text.DecimalFormat;
import android.icu.text.DecimalFormatSymbols;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class StarActivity extends AppCompatActivity {

    private SeekBar maiSeekBar;
    private TextView textViewCount;
    private TextView textViewPrice;
    private StarPresenter starPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star);
        starPresenter = new StarPresenter();
        //maiSeekBar.setMax(100);
        loadOwnComponent();
        loadListenerSeekbar();
    }

    public void loadOwnComponent(){
        maiSeekBar = (SeekBar)findViewById(R.id.main_seekbar);
        textViewCount = (TextView)findViewById(R.id.mai_textView_count);
        textViewPrice = (TextView)findViewById(R.id.mai_textView_price);
    }

    private void loadListenerSeekbar() {
        maiSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int pastyPrice = 400;
                textViewCount.setText(String.valueOf(seekBar.getProgress()));
                int totalValue = starPresenter.getTotalPresenter(seekBar.getProgress(),pastyPrice);
                textViewPrice.setText(priceFormat(totalValue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public String priceFormat(int value){
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("###,###.##",symbols);
        String numberFormated = decimalFormat.format(value);
        return numberFormated;
    }



}
