package comr.example.administrator.fragmentdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GoodsDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goods_detail);
        TextView goods_name=(TextView)findViewById(R.id.item_name);
        Bundle bundle=getIntent().getExtras();
        String name=bundle.getString("name");
        goods_name.setText(name);
    }
}
