package com.example.shoppdemo.fragment;

import android.graphics.Color;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.mvplibrary.base.BaseFragment;
import com.example.shoppdemo.R;
import com.example.shoppdemo.adapter.GridAdapter;
import com.example.shoppdemo.adapter.GriddAdapter;
import com.example.shoppdemo.adapter.LanGeAdapter;
import com.example.shoppdemo.adapter.LanGetowAdapter;
import com.example.shoppdemo.adapter.LayLinAdapter;
import com.example.shoppdemo.adapter.MyAdapter;
import com.example.shoppdemo.adapter.MyTowAdapter;
import com.example.shoppdemo.bean.HomeBannerBean;
import com.example.shoppdemo.contart.HomeBannerContart;
import com.example.shoppdemo.presenter.HomeBannerPreseneter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class HomeFragment extends BaseFragment<HomeBannerPreseneter> implements HomeBannerContart.IHomeView {

    @BindView(R.id.home_Recycler)
    RecyclerView homeRecycler;
    private ArrayList<HomeBannerBean.DataDTO.BannerDTO> banner;
    private ArrayList<HomeBannerBean.DataDTO.ChannelDTO> channelDTOS;
    private MyAdapter myAdapter;
    private LanGetowAdapter lanGetowAdapter;
    private MyTowAdapter myTowAdapter;
    private MyTowAdapter myTowAdaptere;
    private MyTowAdapter myTowAdapterer;
    private MyTowAdapter myTowAdapterere;
    private DelegateAdapter adapter;
    private LanGeAdapter lanGeAdapter;
    private VirtualLayoutManager layoutManager;
    private ArrayList<HomeBannerBean.DataDTO.BrandListDTO> brandlist;
    private GridAdapter gridAdapter;
    private ArrayList<HomeBannerBean.DataDTO.NewGoodsListDTO> newGoodsListDTOS;
    private GriddAdapter griddAdapter;
    private ArrayList<HomeBannerBean.DataDTO.HotGoodsListDTO> hotGoodsListDTOS;
    private LayLinAdapter layLinAdapter;

    @Override
    protected void initData() {
        presenter.getHome();
    }

    @Override
    protected void initView() {
        banner = new ArrayList<>();
        channelDTOS = new ArrayList<>();
        brandlist = new ArrayList<>();
        newGoodsListDTOS = new ArrayList<>();
        hotGoodsListDTOS = new ArrayList<>();

        layoutManager = new VirtualLayoutManager(getContext());
        //设置回收复用线程池大小
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        homeRecycler.setRecycledViewPool(recycledViewPool);
        recycledViewPool.setMaxRecycledViews(0,15);
        //通栏
        myAdapter = initTongLan();
        lanGeAdapter = initLanGe();
        lanGetowAdapter = initChannel();
        myTowAdapter = initGoodList("品牌制造供应商");
        gridAdapter = initBrandlist();
        myTowAdaptere = initGoodList("周一周四，新品发送");
        griddAdapter = initBrandlistt();
        myTowAdapterer = initGoodList("人气推荐");
        layLinAdapter = initLL();
        myTowAdapterere = initGoodList("专题精选");
    }

    private LayLinAdapter initLL() {
        // TODO 设置线性布局
        layoutManager.setOrientation(VirtualLayoutManager.VERTICAL);
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();

        // 所有布局的公共属性（属性会在下面详细说明）
        linearLayoutHelper.setItemCount(hotGoodsListDTOS.size());// 设置布局里Item个数
        linearLayoutHelper.setPadding(10,10,10,10);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        linearLayoutHelper.setMargin(0,0,0,10);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        linearLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        linearLayoutHelper.setAspectRatio(3);// 设置设置布局内每行布局的宽与高的比
        // linearLayoutHelper特有属性
        linearLayoutHelper.setDividerHeight(2); // 设置每行Item的距离
        LayLinAdapter layLinAdapter = new LayLinAdapter(linearLayoutHelper, hotGoodsListDTOS);
        return layLinAdapter;
    }

    private GriddAdapter initBrandlistt() {
        //TODO 设置grid布局
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(3);

        //公共属性
        gridLayoutHelper.setItemCount(brandlist.size());// 设置布局里Item个数
        gridLayoutHelper.setPadding(5, 5, 5, 0);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
//        gridLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        gridLayoutHelper.setAspectRatio(2);// 设置设置布局内每行布局的宽与高的比

        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(2);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(2);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(2);// 设置每行多少个网格
        GriddAdapter griddAdapter = new GriddAdapter(gridLayoutHelper, newGoodsListDTOS);
        return griddAdapter;
    }

    private GridAdapter initBrandlist() {
        // TODO  设置Grid布局
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(3);

        //公共行数
        gridLayoutHelper.setItemCount(brandlist.size());
        gridLayoutHelper.setPadding(5,5,5,0); //设置layouthelper的子元素对layouthelper边缘的距离
        gridLayoutHelper.setBgColor(Color.WHITE);//设置背景颜色
        gridLayoutHelper.setAspectRatio(3); //设置布局内每行布局的宽高比

        //gridlayouthelper特有属性
        gridLayoutHelper.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(2);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(2);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(2);// 设置每行多少个网格
        GridAdapter gridAdapter = new GridAdapter(gridLayoutHelper, brandlist);
        return gridAdapter;
    }

    private LanGeAdapter initLanGe() {
        /**
         TODO 设置栏格布局
         */
        ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
        // 创建对象

        // 公共属性
        columnLayoutHelper.setItemCount(1);// 设置布局里Item个数
//        columnLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
//        columnLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        columnLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        columnLayoutHelper.setAspectRatio(2);// 设置设置布局内每行布局的宽与高的比

        // columnLayoutHelper特有属性
//        columnLayoutHelper.setWeights(new float[]{100});// 设置该行每个Item占该行总宽度的比例
        // 同上面Weigths属性讲解
        LanGeAdapter geAdapter = new LanGeAdapter(columnLayoutHelper, banner);
        return geAdapter;
    }
    private MyTowAdapter initGoodList(String string) {
        /**
         TODO 设置通栏布局
         */
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper.setPadding(0, 50, 0, 0);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
//        singleLayoutHelper.setMargin(20, 80, 20, 0);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        singleLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比
        MyTowAdapter myTowAdapter = new MyTowAdapter(singleLayoutHelper,string);
        return myTowAdapter;
    }

    private LanGetowAdapter initChannel() {
/**
 TODO 设置栏格布局
 */
        ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
        // 创建对象

        // 公共属性
        columnLayoutHelper.setItemCount(channelDTOS.size());// 设置布局里Item个数
        columnLayoutHelper.setPadding(20, 50, 20, 0);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
//        columnLayoutHelper.setMargin(0, 0, 0, 0);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        columnLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        columnLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比

        // columnLayoutHelper特有属性
//        columnLayoutHelper.setWeights(new float[]{100});// 设置该行每个Item占该行总宽度的比例
        // 同上面Weigths属性讲解
        LanGetowAdapter getowAdapter = new LanGetowAdapter(columnLayoutHelper, channelDTOS);
        return getowAdapter;
    }

    private MyAdapter initTongLan() {
        /**
         TODO 设置通栏布局
         */
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(3);// 设置布局里Item个数
        //singleLayoutHelper.setPadding(0, 0, 0, 0);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
//        singleLayoutHelper.setMargin(50, 50, 50, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        singleLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比
        MyAdapter myAdapter = new MyAdapter(singleLayoutHelper);
        return myAdapter;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    public HomeBannerPreseneter getPresenter() {
        return new HomeBannerPreseneter();
    }

    private void initAddAdapter(){

        homeRecycler.setLayoutManager(layoutManager);
        homeRecycler.setAdapter(adapter);
    }

    @Override
    public <T> void getHomeV(T t) {
        HomeBannerBean homeBannerBean = (HomeBannerBean) t;
        if (homeBannerBean!=null){
            List<HomeBannerBean.DataDTO.BannerDTO> banner = homeBannerBean.getData().getBanner();
            this.banner.clear();
            this.banner.addAll(banner);
            lanGeAdapter.notifyDataSetChanged();
            List<HomeBannerBean.DataDTO.ChannelDTO> channel = homeBannerBean.getData().getChannel();
            channelDTOS.clear();
            channelDTOS.addAll(channel);
            lanGetowAdapter.notifyDataSetChanged();
            List<HomeBannerBean.DataDTO.BrandListDTO> brandList = homeBannerBean.getData().getBrandList();
            brandlist.clear();
            brandlist.addAll(brandList);
            gridAdapter.notifyDataSetChanged();
            List<HomeBannerBean.DataDTO.NewGoodsListDTO> newGoodsList = homeBannerBean.getData().getNewGoodsList();
            newGoodsListDTOS.clear();
            newGoodsListDTOS.addAll(newGoodsList);
            griddAdapter.notifyDataSetChanged();
            List<HomeBannerBean.DataDTO.HotGoodsListDTO> hotGoodsList = homeBannerBean.getData().getHotGoodsList();
            hotGoodsListDTOS.clear();
            hotGoodsListDTOS.addAll(hotGoodsList);
            layLinAdapter.notifyDataSetChanged();


            adapter = new DelegateAdapter(layoutManager, true);
            adapter.addAdapter(myAdapter);
            adapter.addAdapter(lanGeAdapter);
            adapter.addAdapter(lanGetowAdapter);
            adapter.addAdapter(myTowAdapter);
            adapter.addAdapter(gridAdapter);
            adapter.addAdapter(myTowAdaptere);
            adapter.addAdapter(griddAdapter);
            adapter.addAdapter(myTowAdapterer);
            adapter.addAdapter(layLinAdapter);
            adapter.addAdapter(myTowAdapterere);
        }
        initAddAdapter();
    }

    @Override
    public void tips(String string) {
        Log.e("TAG",string);
    }
}