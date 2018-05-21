package tfl.smartglow.utils;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class ProgressDrawable extends Drawable {
    private static final int NUM_RECTS = 50;
    Paint mPaint = new Paint();

    @Override
    protected boolean onLevelChange(int level) {
        invalidateSelf();
        return true;
    }

    @Override
    public void draw(Canvas canvas) {
        int level = getLevel();
        Rect b = getBounds();
        float width = b.width();
        for (int i = 0; i < NUM_RECTS; i++) {
            float left = width * i / NUM_RECTS;
            float right = left + 0.9f * width / NUM_RECTS;
          // mPaint.setColor((i + 1) * 10000 / NUM_RECTS <= level? 0xff888888 : 0xffbbbbbb);
            mPaint.setColor((i + 1) * 10000 / NUM_RECTS <= level? 0xff31F6CA : 0xffE1E3D6);
            canvas.drawRect(left, b.top, right, b.bottom, mPaint);
        }
    }

    @Override
    public void setAlpha(int alpha) {
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
