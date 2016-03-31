package com.pccw.lizhihui.cmcc.view.adapter;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.pccw.lizhihui.cmcc.R;
import com.pccw.lizhihui.cmcc.model.HomeModel;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lizhihui on 3/30/16.
 *
 */
public class HomeGridViewAdapter extends BaseAdapter {

    private List<HomeModel>homeCollection;

    private Context context;

    @Inject
    public HomeGridViewAdapter(Context context){
        super();
        this.context = context;
    }

    @Override
    public int getCount() {
        return (this.homeCollection != null) ? this.homeCollection.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return this.homeCollection.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setHomeCollection(Collection<HomeModel> homeModels){
        this.validateHomeCollection(homeModels);
        this.homeCollection = (List<HomeModel>)homeModels;
        this.notifyDataSetChanged();
    }

    private void validateHomeCollection(Collection<HomeModel> homeModels) {
        if (homeModels == null){
            throw new IllegalArgumentException("The list cannot be null");
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HomeGridViewItem homeGridViewItem = new HomeGridViewItem(this.context);

        HomeModel homeModel = (HomeModel) this.getItem(position);

        homeGridViewItem.setImage(homeModel.getResid());
        homeGridViewItem.setTitle(homeModel.getTitle());

        return homeGridViewItem;
    }

    public class HomeGridViewItem extends FrameLayout {

        @Bind(R.id.iv_image)  ImageView imageView;

        @Bind(R.id.tv_title)  TextView titleView;

        public void setImage(@DrawableRes int resid){
            this.imageView.setBackgroundResource(resid);
        }

        public void setTitle(String title){
            this.titleView.setText(title);
        }

        public HomeGridViewItem(Context context) {
            super(context);
            inflate(getContext(), R.layout.grid_view_home, this);
            ButterKnife.bind(this);
        }

    }
}
