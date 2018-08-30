package com.android.siwoo.androidlabforjava.common.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.siwoo.androidlabforjava.R;
import com.android.siwoo.androidlabforjava.common.vo.Drive;

import java.util.ArrayList;
import java.util.List;

public class DriveAdapter extends ArrayAdapter<Drive> {
    private Context context;
    private int resourceId;
    private List<Drive> data;

    public DriveAdapter(Context context, int resource, List<Drive> data) {
        super(context, resource);
        this.context = context;
        this.resourceId = resource;
        this.data = new ArrayList<>(data);
    }

    public static class DriveHolder {
        private ImageView typeImage;
        private TextView titleText;
        private TextView dateText;
        private ImageView menuImage;

        public DriveHolder(View root) {
            this.typeImage = root.findViewById(R.id.drive_type_img);
            this.titleText = root.findViewById(R.id.drive_title_text);
            this.dateText = root.findViewById(R.id.drive_date_text);
            this.menuImage = root.findViewById(R.id.drive_menu_img);
        }
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(resourceId, null);
            DriveHolder driveHolder = new DriveHolder(convertView);
            convertView.setTag(driveHolder);
        }

        DriveHolder driveHolder = (DriveHolder) convertView.getTag();
        ImageView typeImage = driveHolder.typeImage;
        ImageView menuImage = driveHolder.menuImage;
        TextView titleText = driveHolder.titleText;
        TextView dateText = driveHolder.dateText;

        final Drive drive = data.get(position);

        titleText.setText(drive.getTitle());
        dateText.setText(drive.getDate());

        switch (drive.getType().toUpperCase()) {
            case "DOC": typeImage.setImageDrawable(
                    ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_type_doc, null));
                    break;
            case "FILE": typeImage.setImageDrawable(
                    ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_type_file, null));
                    break;
            case "IMG": typeImage.setImageDrawable(
                    ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_type_image, null));
                    break;
            default: throw new IllegalStateException("Unknown value " + drive.getType());
        }

        menuImage.setOnClickListener((view) -> {
            Toast toast = Toast.makeText(context, drive.getTitle() + " menu click", Toast.LENGTH_SHORT);
            toast.show();
        });

        return convertView;
    }
}
