package com.example.myapplication.monhoc;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.slide.ScreenSlideActivity;
import com.google.android.material.navigation.NavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrangChuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrangChuFragment extends Fragment {

    GridView gvSubject;
    ImageView tvTA, tvDL, tvGDCD, tvLS, tvT, tvTN;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TrangChuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TrangChuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TrangChuFragment newInstance(String param1, String param2) {
        TrangChuFragment fragment = new TrangChuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Trang Ch???");

        return inflater.inflate(R.layout.fragment_trang_chu, container, false);
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        gvSubject = (GridView) getActivity().findViewById(R.id.gvSubject);
        tvTA = (ImageView) getActivity().findViewById(R.id.imageTA);
        tvTA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TAFragment taFragment = new TAFragment();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.content_main, taFragment, taFragment.getTag()).commit();
                //dialogTB();
            }
        });

        tvGDCD = (ImageView) getActivity().findViewById(R.id.imageGDCD);
        tvGDCD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GDCDFragment gdcdFragment = new GDCDFragment();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.content_main, gdcdFragment, gdcdFragment.getTag()).commit();
                //dialogTB();
            }
        });

        tvLS = (ImageView) getActivity().findViewById(R.id.imageLS);
        tvLS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LichSuFragment lichSuFragment = new LichSuFragment();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.content_main, lichSuFragment, lichSuFragment.getTag()).commit();
                //dialogTB();
            }
        });

        tvDL = (ImageView) getActivity().findViewById(R.id.imageDL);
        tvDL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DiaLyFragment diaLyFragment = new DiaLyFragment();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.content_main, diaLyFragment, diaLyFragment.getTag()).commit();
                //dialogTB();
            }
        });

        tvT = (ImageView) getActivity().findViewById(R.id.imageT);
        tvT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToanHocFragment toanHocFragment = new ToanHocFragment();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.content_main, toanHocFragment, toanHocFragment.getTag()).commit();
                //dialogTB();
            }
        });

        tvTN = (ImageView) getActivity().findViewById(R.id.imageTN);
        tvTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SinhFragment sinhFragment = new SinhFragment();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.content_main, sinhFragment, sinhFragment.getTag()).commit();
                //dialogTB();
            }
        });


    }
    public void dialogTB(){
        final AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Th??ng b??o");
        builder.setMessage("\n??ang ph??t tri???n t??nh n??ng n??y");
        builder.show();
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        // initialise your views


    }


}