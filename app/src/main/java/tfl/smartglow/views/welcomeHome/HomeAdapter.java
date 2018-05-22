package tfl.smartglow.views.welcomeHome;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import com.jingxun.meshlibtelink.TelinkLightService;
import com.telink.bluetooth.light.Opcode;

import java.util.List;

import tfl.smartglow.R;
import tfl.smartglow.model.Device;
import tfl.smartglow.utils.ProgressDrawable;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeItemViewHolder> {

    private final Activity mActivity;
    private final LayoutInflater inflater;
    public List<Device> devices;
    ItemListener itemListener;
    int changedColor=0;
    public  int RED,BLUE,GREEN;
    public HomeAdapter(WelcomeHomeActivity homeActivity,ItemListener itemListener) {
        this.mActivity = homeActivity;
        inflater = LayoutInflater.from(homeActivity);
        this.itemListener = itemListener;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
        notifyDataSetChanged();
    }


    public void colorSeekBar(final HomeItemViewHolder holder, Device device){
        holder.ll.setOrientation(LinearLayout.VERTICAL);
        final ProgressBar pb = new ProgressBar(mActivity, null, android.R.attr.progressBarStyleHorizontal);
        Drawable d = new ProgressDrawable();
        pb.setProgressDrawable(d);
        pb.setProgress(125);

        pb.setPadding(20, 0, 20, 0);
        holder.ll.removeAllViews();
        holder.ll.addView(pb);
        SeekBar seekBar = holder.seekBar;

        SeekBar.OnSeekBarChangeListener l = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int newProgress = pb.getMax() * progress / seekBar.getMax();
                Log.d("TAG", "onProgressChanged " + newProgress);
                pb.setProgress(newProgress);
               // holder.bulbChangedColor.setColorFilter(Color.rgb( 255, 255, newProgress));
                // if(progress<5){
                holder.bulbChangedColor.setColorFilter(changedColor-newProgress);
                String hexColor = String.format("#%06X", (0xFFFFFF & changedColor-newProgress));
                String s1 = hexColor.substring(1, 3);
                String s2 = hexColor.substring(3, 5);
                String s3 = hexColor.substring(5, 7);
                TelinkLightService.Instance().getAdapter().sendCommand(Opcode.BLE_GATT_OP_CTRL_E2.getValue(), 0x01, new byte[]{0x04, (byte) hexStringToByte(s1), (byte) hexStringToByte(s2), (byte) hexStringToByte(s3)});
                // }
            }
        };

        int[] maxs = {100};
        for (int i = 0; i < maxs.length; i++) {
//            SeekBar sb = new SeekBar(mActivity);
            seekBar.setMax(maxs[i]);
            //sb.setAlpha(0.8f);
            seekBar.setAlpha(0.0f);
            seekBar.setOnSeekBarChangeListener(l);
            seekBar.setPadding(20, 0, 20, 0);
           // holder.ll.addView(seekBar);
            seekBar.getThumb().mutate().setAlpha(0);
        }

//        setContentView(holder.ll);

    }
    private static byte hexStringToByte(String data) {
        return (byte) ((Character.digit(data.charAt(0), 16) << 4)
                | Character.digit(data.charAt(1), 16));
    }

    @NonNull
    @Override
    public HomeItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = inflater.inflate(R.layout.item_device, viewGroup, false);
        return new HomeItemViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull HomeItemViewHolder holder, final int position) {
        final Device deviceInfo = devices.get(position);
        holder.tvBulbName.setText(deviceInfo.deviceName.substring(0,6)+""+position);
//        holder.bulbChangedColor.setColorFilter(Color.rgb( RED, GREEN, BLUE));
        holder.bulbChangedColor.setColorFilter(deviceInfo.color);
        holder.bulbBg.setColorFilter(deviceInfo.color);
        this.changedColor=deviceInfo.color;

        holder.relClickColorSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemListener.onItemClick(deviceInfo, position);
            }
        });

        holder.relClickColorSelect.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                itemListener.onItemLongClick(deviceInfo);
                return true;
            }
        });


        holder.setItem(deviceInfo);
        colorSeekBar(holder,  deviceInfo);

    }

    @Override
    public int getItemCount() {
        return devices == null ? 0 : devices.size();
    }

    class HomeItemViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {

        TextView tvBulbName;
        ImageView bulbChangedColor,bulbBg;
        RelativeLayout relClickColorSelect;
        private Device item;
        LinearLayout ll;
        SeekBar seekBar;

        //RelativeLayout relMain;

        public HomeItemViewHolder(View itemView) {
            super(itemView);
            tvBulbName = itemView.findViewById(R.id.tv_bulb_name_home);
            bulbChangedColor=itemView.findViewById(R.id.img_bulb_top);
            relClickColorSelect = itemView.findViewById(R.id.rel_color_select);
            bulbBg=itemView.findViewById(R.id.img_bulb_bg);
            ll=itemView.findViewById(R.id.ll);
            seekBar = itemView.findViewById(R.id.sb_bulb);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (itemListener != null)
                itemListener.onItemClick(item);
        }

        @Override
        public boolean onLongClick(View v) {
            return false;
        }

        public void setItem(Device item) {
            this.item = item;
        }
    }
}
