package tfl.smartglow.views.SliderPage;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import tfl.smartglow.R;

/**
 * Created by Prithwi on 11/07/17.
 */

public class AndroidImageAdapter extends PagerAdapter {

    Context mContext;
    public AndroidImageAdapter(Context context) {
        this.mContext = context;
    }
    @Override
    public int getCount() {
        return sliderImagesId.length;
    }

    private int[] sliderImagesId = new int[]{
            R.drawable.slide1, R.drawable.slide2, R.drawable.slide3,R.drawable.slide4,

    };

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((ImageView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int i) {
        ImageView mImageView = new ImageView(mContext);
        mImageView.setScaleType(ImageView.ScaleType.FIT_START);
        mImageView.setImageResource(sliderImagesId[i]);
        ((ViewPager) container).addView(mImageView, 0);
        return mImageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int i, Object obj) {
        ((ViewPager) container).removeView((ImageView) obj);
    }
}
