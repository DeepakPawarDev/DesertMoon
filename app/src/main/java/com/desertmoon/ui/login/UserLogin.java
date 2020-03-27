package com.desertmoon.ui.login;

import androidx.arch.core.executor.TaskExecutor;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.desertmoon.R;
import com.desertmoon.databinding.FragUserLoginBinding;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;


public class UserLogin extends Fragment {

    private UserLoginViewModel mViewModel;
    private FragUserLoginBinding binding;
    private static final String TAG = "UserLogin";
String strReferenceCode;
    public static UserLogin newInstance() {
        return new UserLogin();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.frag_user_login, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(UserLoginViewModel.class);
        setListeners();
        // TODO: Use the ViewModel
    }

    private void setListeners() {



        binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validation()) {

                    String strName = binding.editTextName.getEditText().getText().toString();
                     String strMobile = binding.editTextMobile.getEditText().getText().toString();

                     System.out.println("***************  "+strMobile);

                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
                            "+91" + strMobile,        // Phone number to verify
                            60,                 // Timeout duration
                            TimeUnit.SECONDS,   // Unit of timeout
                            TaskExecutors.MAIN_THREAD,               // Activity (for callback binding)
                            mCallbacks);        // OnVerificationStateChangedCallbacks


                }
            }
        });


    }


    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

            Log.i(TAG, "onVerificationCompleted");


            Bundle bundle = new Bundle();
            bundle.putString("strMobileNumber", binding.editTextMobile.getEditText().getText().toString());
            bundle.putString("strReferenceCode", strReferenceCode);

            Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.action_userLogin_to_OTPVerification,bundle);


        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            Log.i(TAG, "Code failed " + e.getMessage());
            e.printStackTrace();
        }

        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            strReferenceCode=s;
            Log.i(TAG, "Code Sent");
        }
    };


    private boolean validation() {

        if (binding.editTextName.getEditText().getText().toString().isEmpty()) {

            binding.editTextName.setError("please enter a name");
            return false;

        } else if (binding.editTextMobile.getEditText().getText().toString().isEmpty()) {

            binding.editTextMobile.setError("please enter a mobile number");
            return false;
        }

        return true;

    }

}
