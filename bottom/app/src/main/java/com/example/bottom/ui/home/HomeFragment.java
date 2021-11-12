package com.example.bottom.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.bottom.ChiTietActivity;
import com.example.bottom.FragmentAdapter;
import com.example.bottom.Photo;
import com.example.bottom.PhotoAdapter;
import com.example.bottom.R;
import com.example.bottom.TimKiemActivity;
import com.example.bottom.databinding.FragmentTrangChuBinding;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentTrangChuBinding binding;
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private PhotoAdapter photoAdapter;
    private ViewPager2 viewPager2;
    private FragmentAdapter fragmentAdapter;
    private View view1, view2;
    private ImageView imgViewLauThai;
    private ImageButton imgBtSearch;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentTrangChuBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //start slide
        viewPager = root.findViewById(R.id.viewpager);
        circleIndicator = root.findViewById(R.id.circle_indicator);

        photoAdapter = new PhotoAdapter(root.getContext(), getListPhoto());
        viewPager.setAdapter(photoAdapter);

        circleIndicator.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
        //end slide

        //start viewpager2
        viewPager2 = root.findViewById(R.id.viewpagerlist);

        FragmentManager fm = getActivity().getSupportFragmentManager();
        fragmentAdapter = new FragmentAdapter(fm, getLifecycle());
        viewPager2.setAdapter(fragmentAdapter);

        view1 = root.findViewById(R.id.scrollIn1);
        view2 = root.findViewById(R.id.scrollIn2);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                if(position==1){
                    view1.setVisibility(View.INVISIBLE);
                    view2.setVisibility(View.VISIBLE);
                }
                else{
                    view1.setVisibility(View.VISIBLE);
                    view2.setVisibility(View.INVISIBLE);
                }

            }
        });
        //end viewpager2


        imgViewLauThai = root.findViewById(R.id.lauthai);
        imgViewLauThai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getActivity();
                Context view = root.getContext();
                Intent intent = new Intent(root.getContext(), ChiTietActivity.class);
                intent.putExtra("lauthai","Lẩu thái");
                startActivity(intent);
            }
        });

        //start button search
        imgBtSearch = root.findViewById(R.id.imgBtSearch);
        imgBtSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(root.getContext(), TimKiemActivity.class);
                startActivity(intent);
            }
        });
        //end button search



//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    private List<Photo> getListPhoto(){
        List<Photo> list = new ArrayList<>();
        list.add(new Photo(R.drawable.slide1));
        list.add(new Photo(R.drawable.slide2));
        list.add(new Photo(R.drawable.silde3));
        return list;
    }
}