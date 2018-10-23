package com.lyna.www.mypet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox_agree;
    RadioGroup radiogroup_animal;
    RadioButton radiobutton_dog, radiobutton_cat, radiobutton_rabbit;
    Button button_complete;
    ImageView imageview_pet;
    TextView textView_petlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBox_agree = (CheckBox) findViewById(R.id.checkBox_agree);
        this.radiogroup_animal = (RadioGroup) findViewById(R.id.radiogroup_animal);
        this.radiobutton_dog = (RadioButton) findViewById(R.id.radiobutton_dog);
        this.radiobutton_cat = (RadioButton) findViewById(R.id.radiobutton_cat);
        this.radiobutton_rabbit = (RadioButton) findViewById(R.id.radiobutton_rabbit);
        this.button_complete = (Button) findViewById(R.id.button_complete);
        this.imageview_pet = (ImageView) findViewById(R.id.imageview_pet);
        this.textView_petlist = (TextView) findViewById(R.id.textView_petlist);

        checkBox_agree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox_agree.isChecked()) {
                    textView_petlist.setVisibility(View.VISIBLE);
                    radiogroup_animal.setVisibility(View.VISIBLE);
                    radiobutton_dog.setVisibility(View.VISIBLE);
                    radiobutton_cat.setVisibility(View.VISIBLE);
                    radiobutton_rabbit.setVisibility(View.VISIBLE);
                    button_complete.setVisibility(View.VISIBLE);
                    imageview_pet.setVisibility(View.INVISIBLE);

                    radiobutton_dog.setChecked(false);
                    radiobutton_cat.setChecked(false);
                    radiobutton_rabbit.setChecked(false);

                } else {
                    textView_petlist.setVisibility(View.INVISIBLE);
                    radiogroup_animal.setVisibility(View.INVISIBLE);
                    button_complete.setVisibility(View.INVISIBLE);
                    imageview_pet.setVisibility(View.INVISIBLE);

                }
            }
        });

        button_complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(radiogroup_animal.getCheckedRadioButtonId()){
                    case R.id.radiobutton_dog:
                        imageview_pet.setImageResource(R.drawable.dog);
                        imageview_pet.setVisibility(View.VISIBLE);
                        break;
                    case R.id.radiobutton_cat:
                        imageview_pet.setImageResource(R.drawable.cat);
                        imageview_pet.setVisibility(View.VISIBLE);
                        break;
                    case R.id.radiobutton_rabbit:
                        imageview_pet.setImageResource(R.drawable.rabbit);
                        imageview_pet.setVisibility(View.VISIBLE);
                        break;
                    default:
                        Toast.makeText(getApplication(), "동물을 선택하세요", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });


    }
}
