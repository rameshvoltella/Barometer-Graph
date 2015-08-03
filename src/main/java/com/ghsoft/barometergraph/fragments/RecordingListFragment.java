package com.ghsoft.barometergraph.fragments;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.ghsoft.barometergraph.data.FileMan;
import com.ghsoft.barometergraph.data.RecordingData;
import com.ghsoft.barometergraph.views.IRecordingDataEvents;
import com.ghsoft.barometergraph.views.RecordingListAdapter;

import java.util.ArrayList;

/**
 * Created by brian on 8/2/15.
 */
public class RecordingListFragment extends ListFragment {

    private IRecordingDataEvents mRecordingDataEvents;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mRecordingDataEvents = (IRecordingDataEvents) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()  + " must implement NavigaitonEvents");
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((ActionBarActivity)getActivity()).getSupportActionBar().setTitle("Recorded Data");

        FileMan fm = new FileMan();
        ArrayList<RecordingData> dataList = fm.getFileList();

        setListAdapter(new RecordingListAdapter(getActivity(), dataList, mRecordingDataEvents));
    }
}
