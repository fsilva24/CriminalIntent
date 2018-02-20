package com.example.felig.criminalintent;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;

import java.util.UUID;

/**
 * Created by felig on 2/5/2018.
 */

public class CrimeFragment extends Fragment {

    private static final String ARG_CRIME_ID = "crime_id";

    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private Button mStartButton;
    private Button mEndButton;
    private CheckBox mSolvedCheckBox;

    public static CrimeFragment newInstance(UUID crimeId){
        Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME_ID, crimeId);

        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID crimeId = (UUID) getArguments().getSerializable(ARG_CRIME_ID);
        mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime, container, false);
        mTitleField = (EditText) v.findViewById(R.id.crime_title);
        mTitleField.setText(mCrime.getTitle());
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
                // This space intentionally left blank
            }
            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
                // This one too
            }
        });

        mDateButton = (Button) v.findViewById(R.id.crime_date);
        mDateButton.setText(mCrime.getDate().toString());
        mDateButton.setEnabled(false);

        mSolvedCheckBox = (CheckBox)v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setChecked(mCrime.isSolved());
        mSolvedCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setSolved(isChecked);
            }
        });

        mStartButton = (Button) v.findViewById(R.id.start_button);
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numCrimes = CrimeLab.get(getContext()).getCrimes().size();
                for (int i = 0; i < numCrimes; i++){
                    String title = ("Crime #" + i);
                    Crime currCrime = CrimeLab.get(getContext()).getCrimeByTitle(title);
                    if (currCrime.getTitle().equals("Crime #0")){
                        Toast.makeText(getContext(), currCrime.getTitle(), Toast.LENGTH_SHORT).show();
                        Intent intent = CrimePagerActivity.newINtent(getActivity(), currCrime.getId());
                        startActivity(intent);
                    }
                }
            }
        });
        mEndButton = (Button) v.findViewById(R.id.end_button);
        mEndButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v){
                int numCrimes = CrimeLab.get(getContext()).getCrimes().size();
                for (int i = 0; i < numCrimes; i++){
                    String title = ("Crime #" + i);
                    String lastCrime = ("Crime #" + (numCrimes - 1));
                    Crime currCrime = CrimeLab.get(getContext()).getCrimeByTitle(title);
                    if (currCrime.getTitle().equals(lastCrime)){
                        Toast.makeText(getContext(), currCrime.getTitle(), Toast.LENGTH_SHORT).show();
                        Intent intent = CrimePagerActivity.newINtent(getActivity(), currCrime.getId());
                        startActivity(intent);
                    }
                }

            }
        });
        return v;
    }
}
