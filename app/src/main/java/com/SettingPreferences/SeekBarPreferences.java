package com.SettingPreferences;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;

import com.baonhanh.R;

/**
 * Created by Le on 29-Jan-16.
 */
public class SeekBarPreferences extends Preference implements SeekBar.OnSeekBarChangeListener {

    public static final int SEEKBAR_MAX_VALUE = 30;
    public static final int SEEKBAR_VLBONUS = 30;
    private SeekBar mSeekBar;
    private int mProgress;

    public SeekBarPreferences(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayoutResource(R.layout.seekbar_preference);
    }

    public SeekBarPreferences(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SeekBarPreferences(Context context) {
        this(context, null, 0);
    }

    @Override
    protected void onBindView(View view) {
        super.onBindView(view);
        mSeekBar = (SeekBar) view.findViewById(R.id.seekbar_prefId);
        /*** add range form vlbonus to vlbonus + max value*/
        mSeekBar.setProgress(mProgress - SEEKBAR_VLBONUS);
        mSeekBar.setMax(SEEKBAR_MAX_VALUE);
        mSeekBar.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(!fromUser)
            return;
        setValue(progress + SEEKBAR_VLBONUS);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    public void setValue(int value) {
        if(shouldPersist())
            persistInt(value);

        if(value != mProgress){
            mProgress = value;
            notifyChanged();
        }
    }

    @Override
    protected Object onGetDefaultValue(TypedArray a, int index) {
        return a.getInt(index,0);
    }

    @Override
    protected void onSetInitialValue(boolean restoreValue, Object defaultValue) {
        setValue(restoreValue ? getPersistedInt(mProgress - SEEKBAR_VLBONUS) : (Integer) defaultValue);
    }
}
