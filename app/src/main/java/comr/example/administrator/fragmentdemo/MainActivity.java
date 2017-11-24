package comr.example.administrator.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import comr.example.administrator.fragmentdemo.fragment.FragmentGoodsList;
import comr.example.administrator.fragmentdemo.fragment.FragmentShopCar;

public class MainActivity extends AppCompatActivity {

    private ViewPager main_vp;
    private Button goods_list;
    private Button shop_car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_vp = (ViewPager)findViewById(R.id.main_vp);
        goods_list = (Button)findViewById(R.id.goods_list);
        shop_car = (Button)findViewById(R.id.shop_car);
        goods_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_vp.setCurrentItem(0);
            }
        });
        shop_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_vp.setCurrentItem(1);
            }
        });
        main_vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            Fragment fragment=null;
            @Override
            public Fragment getItem(int position) {
                if (position==0){
                    fragment=new FragmentGoodsList();
                }else if (position==1){
                    fragment=new FragmentShopCar();
                }

                return fragment;
            }

            @Override
            public int getCount() {
                return 2;
            }
        });
    }
}
