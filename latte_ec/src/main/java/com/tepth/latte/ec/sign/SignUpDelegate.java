package com.tepth.latte.ec.sign;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Patterns;
import android.view.View;

import com.tepth.latte.delegates.BaseLatteDelegate;
import com.tepth.latte.ec.R;
import com.tepth.latte.ec.R2;
import com.tepth.latte.net.RestClient;
import com.tepth.latte.net.callback.ISuccess;
import com.tepth.latte.utils.input.InputHandlerUtil;
import com.tepth.latte.utils.log.LatteLogger;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description:注册Delegate
 *
 * @author Hequn.Lee
 * @date 2018/10/19
 */
@SuppressWarnings("ALL")
public class SignUpDelegate extends BaseLatteDelegate {
    @BindView(R2.id.edit_sign_up_name)
    TextInputEditText mName = null;
    @BindView(R2.id.edit_sign_up_email)
    TextInputEditText mEmail = null;
    @BindView(R2.id.edit_sign_up_phone)
    TextInputEditText mPhone = null;
    @BindView(R2.id.edit_sign_up_password)
    TextInputEditText mPassword = null;
    @BindView(R2.id.edit_sign_up_re_password)
    TextInputEditText mRePassword = null;

    private ISignListener mISignListener = null;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ISignListener) {
            mISignListener = (ISignListener) context;
        }
    }

    @OnClick(R2.id.btn_sign_up)
    void onClickSignUp() {
        if (checkForm()) {
            RestClient.builder()
                    .url("user_profile.php")
                    .params("name", mName.getText().toString())
                    .params("email", mEmail.getText().toString())
                    .params("phone", mPhone.getText().toString())
                    .params("password", mPassword.getText().toString())
                    .loader(getProxyActivity())
                    .success(new ISuccess() {
                        @Override
                        public void onSuccess(String response) {
                            LatteLogger.json("USER_PROFILE", response);
                            SignHandler.onSignUp(response, mISignListener);
                        }
                    })
                    .builder()
                    .post();
        }
    }

    @OnClick(R2.id.tv_link_sign_in)
    void onClickLink() {
        getSupportDelegate().start(new SignInDelegate());
    }

    private boolean checkForm() {
        final String name = mName.getText().toString();
        final String email = mEmail.getText().toString();
        final String phone = mPhone.getText().toString();
        final String password = mPassword.getText().toString();
        final String rePassword = mRePassword.getText().toString();

        boolean isPass = true;
        if (name.isEmpty()) {
            mName.setError("请输入姓名");
            isPass = false;
        } else {
            mName.setError(null);
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmail.setError("错误的邮箱格式");
            isPass = false;
        } else {
            mEmail.setError(null);
        }

        if (phone.isEmpty() || phone.length() != InputHandlerUtil.PHONE_MAX_LENGTH) {
            mPhone.setError("请输入正确的手机号");
            isPass = false;
        } else {
            mPhone.setError(null);
        }

        if (password.isEmpty() || password.length() < InputHandlerUtil.PASSWORD_LENGTH) {
            mPassword.setError("请填写至少6位密码");
            isPass = false;
        } else {
            mPassword.setError(null);
        }

        if (rePassword.isEmpty() || rePassword.length() < InputHandlerUtil.PASSWORD_LENGTH || !password.equals(rePassword)) {
            mRePassword.setError("两次密码不一致");
            isPass = false;
        } else {
            mRePassword.setError(null);
        }
        return isPass;
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_up;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
    }
}
