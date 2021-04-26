package com.example.myapplication.slide;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.question.EntityClass.Question;

import java.util.ArrayList;
import java.util.List;

public class ScreenSlidePageFragment extends Fragment {

    List<Question> arr_Ques;


    public static final String ARG_PAGE = "page";
    public static final String ARG_CHECKANSWER = "checkAnswer";
    public int mPageNumber; // vị trí trang hiện tại
    public int checkAns; //biến kiểm tra

    TextView tvNum, tvQuestion;
    RadioGroup radioGroup;
    RadioButton radA, radB, radC, radD;
    ImageView imageView;

    public int choiceID = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);

        tvNum = (TextView)rootView.findViewById(R.id.tvNum);
        tvQuestion = (TextView)rootView.findViewById(R.id.tvQuestion);
        radA = (RadioButton) rootView.findViewById(R.id.radA);
        radB = (RadioButton) rootView.findViewById(R.id.radB);
        radC = (RadioButton) rootView.findViewById(R.id.radC);
        radD = (RadioButton) rootView.findViewById(R.id.radD);
        imageView = (ImageView) rootView.findViewById(R.id.ivIcon);
        radioGroup = (RadioGroup) rootView.findViewById(R.id.radGroup);

        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        arr_Ques = new ArrayList<Question>();
        ScreenSlideActivity screenSlideActivity = (ScreenSlideActivity) getActivity();
        arr_Ques = (ArrayList)screenSlideActivity.getData();
        mPageNumber = getArguments().getInt(ARG_PAGE);
        checkAns = getArguments().getInt(ARG_CHECKANSWER);
    }

    public static ScreenSlidePageFragment create(int pageNumber, int checkAnswer){
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        args.putInt(ARG_CHECKANSWER, checkAnswer);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvNum.setText("Câu " + (mPageNumber + 1) + "/" + (arr_Ques.size()) );
        tvQuestion.setText(arr_Ques.get(mPageNumber).getQuestion());

        radA.setText(arr_Ques.get(mPageNumber).getAns_a());
        radB.setText(arr_Ques.get(mPageNumber).getAns_b());
        radC.setText(arr_Ques.get(mPageNumber).getAns_c());
        radD.setText(arr_Ques.get(mPageNumber).getAns_d());

        imageView.setImageResource(getResources().getIdentifier(arr_Ques.get(mPageNumber).getImage(), "drawable", "com.example.myapplication"));

        if(checkAns!=0){
            radA.setClickable(false);
            radB.setClickable(false);
            radC.setClickable(false);
            radD.setClickable(false);
            getCheckAns(arr_Ques.get(mPageNumber).getResult().toString());
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                choiceID = checkedId;
                arr_Ques.get(mPageNumber).setTraloi(getChoiceFromID(choiceID));
                //Toast.makeText(getActivity(),"Đây là đáp án "+ choiceID, Toast.LENGTH_SHORT).show();
            }
        });
    }


    //Lấy giá trị (vị trí) radiogroup chuyển thành đáp án A/B/C/D
    private String getChoiceFromID(int ID) {
        if (ID == R.id.radA) {
            return "A";
        } else if (ID == R.id.radB) {
            return "B";
        } else if (ID == R.id.radC) {
            return "C";
        } else if (ID == R.id.radD) {
            return "D";
        } else return "";
    }

    //Hàm kiểm tra câu đúng, nếu câu đúng thì đổi màu background radiobutton tương ứng
    private void getCheckAns(String ans){
        if(ans.equals("A")==true){
            radA.setBackgroundColor(Color.GREEN);
        }
        else if(ans.equals("B")==true){
            radB.setBackgroundColor(Color.GREEN);
        }else if(ans.equals("C")==true){
            radC.setBackgroundColor(Color.GREEN);
        }else if(ans.equals("D")==true){
            radD.setBackgroundColor(Color.GREEN);
        }else ;
    }
}



