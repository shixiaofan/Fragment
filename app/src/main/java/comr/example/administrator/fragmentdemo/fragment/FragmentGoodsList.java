package comr.example.administrator.fragmentdemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;

import comr.example.administrator.fragmentdemo.bean.Goods;
import comr.example.administrator.fragmentdemo.GoodsDetail;
import comr.example.administrator.fragmentdemo.R;
import comr.example.administrator.fragmentdemo.db.MyDao;

public class FragmentGoodsList extends Fragment {
    private Spinner spinner;
    private EditText goods_name;
    private Button goods_serch;
    private MyDao myDao;
    private ArrayList<Goods> al;
    private MyAdapter adapter;
    private ListView goods_list;
    private ViewHolder vh;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_goods_list_item,container,false);
        spinner = (Spinner)view.findViewById(R.id.spinner);
        goods_name = (EditText)view.findViewById(R.id.frag01_edit);
        goods_serch = (Button)view.findViewById(R.id.frag01_serch);
        goods_list = (ListView)view.findViewById(R.id.goods_list);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myDao = new MyDao(getActivity());
        al=myDao.queryList(null,3);//默认情况下商品全部展示
        adapter=new MyAdapter();
        goods_list.setAdapter(adapter);
        goods_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Bundle bundle=new Bundle();

               String names= al.get(position).getName();
                bundle.putString("name",names);
                Intent intent=new Intent(getActivity(),GoodsDetail.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        goods_serch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i=spinner.getSelectedItemPosition();
                String select=goods_name.getText().toString().trim();
                al=myDao.queryList(select,i);
                adapter.notifyDataSetChanged();


            }
        });
    }
    class MyAdapter extends BaseAdapter{



        @Override
        public int getCount() {
            return al.size();
        }

        @Override
        public Object getItem(int i) {
            return al.get(i);//i相当于position
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view==null){
                view=View.inflate(getActivity(),R.layout.goods_item,null);
                vh = new ViewHolder();
                vh.iv=(ImageView)view.findViewById(R.id.image_head);
                vh.tv_name=(TextView)view.findViewById(R.id.goods_name);
                vh.tv_price=(TextView)view.findViewById(R.id.goods_price);
                view.setTag(vh);
            }else {
                vh = (ViewHolder) view.getTag();
            }
            vh.iv.setImageResource(al.get(i).getImageId());
            vh.tv_name.setText(al.get(i).getName());
            vh.tv_price.setText(al.get(i).getPrice()+" Ԫ");
            return view;
        }
    }
    class ViewHolder{
        ImageView iv;
        TextView tv_name;
        TextView tv_price;
    }
}
