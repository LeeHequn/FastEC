package com.tepth.latte.ec.main.personal.profile;

import android.content.DialogInterface;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;
import com.tepth.latte.delegates.BaseLatteDelegate;
import com.tepth.latte.ec.R;
import com.tepth.latte.ec.main.personal.list.ListBean;
import com.tepth.latte.ui.date.DateDialogUtil;
import com.tepth.latte.utils.callback.CallbackKeys;
import com.tepth.latte.utils.callback.CallbackManager;
import com.tepth.latte.utils.callback.IGlobalCallback;
import com.tepth.latte.utils.log.LatteLogger;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2018/10/26
 */
@SuppressWarnings("ALL")
public class UserProfileClickListener extends SimpleClickListener {

    private final BaseLatteDelegate DELEGATE;
    private String[] mGenders = new String[]{"男", "女", "保密"};

    public UserProfileClickListener(BaseLatteDelegate delegate) {
        this.DELEGATE = delegate;
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, final View view, int position) {
        final ListBean bean = (ListBean) baseQuickAdapter.getData().get(position);
        final int id = bean.getId();
        switch (id) {
            case 1:
                CallbackManager.getIntance().addCallback(CallbackKeys.ON_CROP, new IGlobalCallback<Uri>() {
                    @Override
                    public void executeCallback(Uri args) {
                        LatteLogger.d("ON_CROP", args);
                        final ImageView avatar = view.findViewById(R.id.img_arrow_avatar);
                        Glide.with(DELEGATE)
                                .load(args)
                                .into(avatar);
                    }
                });
                //打开照相机或选择图片
                DELEGATE.startCameraWithCode();
                break;
            case 2:
                final BaseLatteDelegate nameDelegate = bean.getDelegate();
                DELEGATE.getSupportDelegate().start(nameDelegate);
                break;
            case 3:
                getGenderDialog(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        final TextView textView = (TextView) view.findViewById(R.id.tv_arrow_value);
                        textView.setText(mGenders[which]);
                        dialog.cancel();
                    }
                });
                break;
            case 4:
                final TextView textView = (TextView) view.findViewById(R.id.tv_arrow_value);
                final String defalutDateString;
                if (("未设置生日").equals(textView.getText().toString())) {
                    defalutDateString = "1990年01月01日";
                } else {
                    defalutDateString = textView.getText().toString();
                }
                try {
                    //注意：SimpleDateFormat构造函数的样式与strDate的样式必须相符
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日", Locale.getDefault());
                    Date defalutDate = simpleDateFormat.parse(defalutDateString);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(defalutDate);
                    final DateDialogUtil dateDialogUtil = new DateDialogUtil(
                            calendar.get(Calendar.YEAR),
                            calendar.get(Calendar.MONTH),
                            calendar.get(Calendar.DAY_OF_MONTH));
                    dateDialogUtil.setIDateListener(new DateDialogUtil.IDateListener() {
                        @Override
                        public void onDateConfirm(String date) {
                            textView.setText(date);
                        }
                    });
                    dateDialogUtil.showDialog(DELEGATE.getContext());
                } catch (Exception e) {
                }
                break;
            default:
                break;
        }
    }

    private void getGenderDialog(DialogInterface.OnClickListener listener) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(DELEGATE.getContext());
        builder.setSingleChoiceItems(mGenders, 0, listener);
        builder.show();
    }

    @Override
    public void onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

    }

    @Override
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

    }

    @Override
    public void onItemChildLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

    }
}
