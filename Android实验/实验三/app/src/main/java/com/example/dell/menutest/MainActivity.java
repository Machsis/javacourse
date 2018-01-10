package com.example.dell.menutest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.ViewConfiguration;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {
    final int Font_10 = 1;
    final int Font_16 = 2;
    final int Font_20 = 3;
    final int Plain_Item = 4;
    final int Font_red = 5;
    final int Font_black =6;
    private EditText edit;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = (EditText)findViewById(R.id.et);
    }


    public boolean onCreateOptionsMenu(Menu menu){
        SubMenu fontMenu = menu.addSubMenu("字体大小");
        fontMenu.setHeaderTitle("选择字体大小");
        fontMenu.add(0,Font_10,0,"10号字体");
        fontMenu.add(0,Font_16,0,"16号字体");
        fontMenu.add(0,Font_20,0,"20号字体");
        menu.add(0,Plain_Item,0,"普通菜单选项");
        SubMenu colorMenu = menu.addSubMenu("字体颜色");
        colorMenu.setHeaderTitle("选择字体颜色");
        colorMenu.add(0,Font_red,0,"红色");
        colorMenu.add(0,Font_black,0,"黑色");
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem mi){
        switch (mi.getItemId()){
            case Font_10:
                edit.setTextSize(10*2);
                break;
            case Font_16:
                edit.setTextSize(16*2);
                break;
            case Font_20:
                edit.setTextSize(20*2);
                break;
            case Plain_Item:
                Toast toast=Toast.makeText(MainActivity.this,"点击普通菜单选项",Toast.LENGTH_SHORT);
                toast.show();
                break;
            case Font_red:
                edit.setTextColor(Color.RED);
                break;
            case Font_black:
                edit.setTextColor(Color.BLACK);
                break;
        }
        return
                true;
    }

}
