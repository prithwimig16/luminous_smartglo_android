package tfl.smartglow.views.SliderPage;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tfl.smartglow.R;
import tfl.smartglow.model.DataObject;

public class CustomPageAdapter  extends PagerAdapter {
    private Context context;
    private List<DataObject> dataObjectList;
    private LayoutInflater layoutInflater;
    public CustomPageAdapter(Context context, List<DataObject> dataObjectList){
        this.context = context;
        this.layoutInflater = (LayoutInflater)this.context.getSystemService(this.context.LAYOUT_INFLATER_SERVICE);
        this.dataObjectList = dataObjectList;
    }
    @Override
    public int getCount() {
        return dataObjectList.size();
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View)object);
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = this.layoutInflater.inflate(R.layout.pager_list_items, container, false);
        ImageView displayImage = (ImageView)view.findViewById(R.id.iv_image);
        TextView tvHeader = (TextView)view.findViewById(R.id.tv_header);
        TextView tv_desc = (TextView)view.findViewById(R.id.tv_desc);
        Shader textShader=new LinearGradient(0, 0, 0, 20,
                new int[]{ 0xFF6b90ff, 0xFF202b5f},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        tvHeader.getPaint().setShader(textShader);
        displayImage.setImageResource(this.dataObjectList.get(position).getImageId());
        tvHeader.setText(this.dataObjectList.get(position).getImageHeader());
        tv_desc.setText(this.dataObjectList.get(position).getDescription());
        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}