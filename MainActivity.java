package com.example.colorchange;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.colorchange.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private String[] textViewColors = new String[4];
    private String[] textViewTexts = new String[4];
    private final ColorModel colorModel = new ColorModel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        if (savedInstanceState != null) {
            textViewColors = savedInstanceState.getStringArray("textViewColors");
            textViewTexts = savedInstanceState.getStringArray("textViewTexts");
            restoreState();
        } else {
            setColorAndTextForAllTextview();
        }
        setUpTextviewClickListeners();
    }

    private void setUpTextviewClickListeners(){
        setRandomColorOnClick(mBinding.textview1);
        setRandomColorOnClick(mBinding.textview2);
        setRandomColorOnClick(mBinding.textview3);
        setRandomColorOnClick(mBinding.textview4);
    }
    private void setRandomColorOnClick(@NonNull TextView textView) {
        textView.setOnClickListener(v -> setColorAndTextForAllTextview());
    }
    private void restoreState() {
        restoreTextView(mBinding.textview1, 0);
        restoreTextView(mBinding.textview2, 1);
        restoreTextView(mBinding.textview3, 2);
        restoreTextView(mBinding.textview4, 3);
    }

    private void restoreTextView(@NonNull TextView textView, int index) {
        int color = Color.parseColor(textViewColors[index]);
        textView.setBackgroundColor(color);
        textView.setText(textViewTexts[index]);
    }

    private void setColorAndTextForAllTextview() {
        ColorModel.ColorData colorData1, colorData2, colorData3, colorData4;
        colorData1 = colorModel.generateRandomColor();
        mBinding.textview1.setBackgroundColor(colorData1.getColorInt());
        mBinding.textview1.setText(colorData1.getColorName());
        textViewColors[0] = colorData1.getHexColor();
        textViewTexts[0] = colorData1.getColorName();

        do {
            colorData2 = colorModel.generateRandomColor();
        } while (colorData1.getColorInt() == colorData2.getColorInt());
        mBinding.textview2.setBackgroundColor(colorData2.getColorInt());
        mBinding.textview2.setText(colorData2.getColorName());
        textViewColors[1] = colorData2.getHexColor();
        textViewTexts[1] = colorData2.getColorName();

        do {
            colorData3 = colorModel.generateRandomColor();
        } while (colorData1.getColorInt() == colorData3.getColorInt() ||
                colorData3.getColorInt() == colorData2.getColorInt());
        mBinding.textview3.setBackgroundColor(colorData3.getColorInt());
        mBinding.textview3.setText(colorData3.getColorName());
        textViewColors[2] = colorData3.getHexColor();
        textViewTexts[2] = colorData3.getColorName();

        do {
            colorData4 = colorModel.generateRandomColor();
        } while (colorData4.getColorInt() == colorData3.getColorInt() ||
                colorData4.getColorInt() == colorData2.getColorInt() ||
                colorData4.getColorInt() == colorData1.getColorInt());
        mBinding.textview4.setBackgroundColor(colorData4.getColorInt());
        mBinding.textview4.setText(colorData4.getColorName());
        textViewColors[3] = colorData4.getHexColor();
        textViewTexts[3] = colorData4.getColorName();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArray("textViewColors", textViewColors);
        outState.putStringArray("textViewTexts", textViewTexts);
    }
}