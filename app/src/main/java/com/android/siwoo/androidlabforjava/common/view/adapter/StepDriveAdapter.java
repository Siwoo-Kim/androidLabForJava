package com.android.siwoo.androidlabforjava.common.view.adapter;

import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.android.siwoo.androidlabforjava.R;
import com.android.siwoo.androidlabforjava.common.vo.Drive;
import com.android.siwoo.androidlabforjava.common.vo.StepDrive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StepDriveAdapter extends ArrayAdapter<StepDrive> {
    private final int resourceId;
    private final Context context;
    private final List<StepDrive> data;

    public StepDriveAdapter(int resourceId, Context context, List data) {
        super(context, resourceId);
        this.resourceId = resourceId;
        this.context = context;
        this.data = new ArrayList(data);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Holder holder = init(view);

        StepDrive stepDrive = data.get(position);
        holder.setData(stepDrive, context);
        return view;
    }

    private Holder init(View view) {
        if(view!=null) return (Holder) view.getTag();
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view =  layoutInflater.inflate(resourceId, null);
        Holder holder = new Holder(view);
        view.setTag(holder);
        return holder;
    }

    private static class Holder {
        private final ImageView menuImg;
        private final ImageView typeImg;
        private final TextView titleText;
        private final TextView dateText;
        private Set<View> views = new HashSet<>();
        public Holder(View context) {
            this.menuImg = context.findViewById(R.id.menu_img);
            views.add(menuImg);
            this.typeImg = context.findViewById(R.id.type_img);
            views.add(typeImg);
            this.titleText = context.findViewById(R.id.title_text);
            views.add(titleText);
            this.dateText = context.findViewById(R.id.date_text);
            views.add(dateText);
        }

        private void setData(StepDrive stepDrive, Context context) {
            titleText.setText(stepDrive.getTitle());
            dateText.setText(stepDrive.getDate());
            setTypeImage(stepDrive.getType(), context);

            View.OnClickListener itemClickListener = (view) -> {
                Toast toast = Toast.makeText(context, stepDrive.getTitle() + " clicked", Toast.LENGTH_SHORT);
                toast.show();
            };
            menuImg.setOnClickListener(itemClickListener);
        }

        private void setTypeImage(String type, Context context) {
            String value = type.toLowerCase();
            switch (value) {
                case "DOC": typeImg.setImageDrawable(
                        ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_type_doc, null));
                return;
                case "FILE": typeImg.setImageDrawable(
                        ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_type_file, null));
                return;
                case "IMG": typeImg.setImageDrawable(
                        ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_type_image, null));
                return;
                default: throw new IllegalStateException("Unknown value: "+ type);
            }
        }
    }


}
