package com.tepth.latte.ui.date;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.LinearLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2018/10/26
 */
public class DateDialogUtil {

    private int year;
    private int monthOfYear;
    private int dayOfMonth;

    public DateDialogUtil(int year, int monthOfYear, int dayOfMonth) {
        this.year = year;
        this.monthOfYear = monthOfYear;
        this.dayOfMonth = dayOfMonth;
    }

    public interface IDateListener {
        /**
         * 点击确定事件
         *
         * @param date 选中的日期
         */
        void onDateConfirm(String date);
    }

    private IDateListener mIDateListener = null;

    public void setIDateListener(IDateListener listener) {
        this.mIDateListener = listener;
    }

    public void showDialog(Context context) {
        final LinearLayout linearLayout = new LinearLayout(context);
        final DatePicker picker = new DatePicker(context);
        final LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
        picker.setLayoutParams(layoutParams);
        picker.init(year, monthOfYear, dayOfMonth, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int y, int month, int day) {
                year = y;
                monthOfYear = month;
                dayOfMonth = day;
            }
        });

        linearLayout.addView(picker);

        new AlertDialog.Builder(context)
                .setTitle("选择日期")
                .setView(linearLayout)
                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        final Calendar calendar = Calendar.getInstance();
                        calendar.set(year, monthOfYear, dayOfMonth);
                        final SimpleDateFormat format =
                                new SimpleDateFormat("yyyy年MM月dd日", Locale.getDefault());
                        final String data = format.format(calendar.getTime());
                        if (mIDateListener != null) {
                            mIDateListener.onDateConfirm(data);
                        }
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }
}
