package com.desertmoon.ui.login;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.desertmoon.R;
import com.desertmoon.databinding.FragOtpverificationBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class OTPVerification extends Fragment {

    private OtpverificationViewModel mViewModel;
private FragOtpverificationBinding binding;
    public static OTPVerification newInstance() {
        return new OTPVerification();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater,R.layout.frag_otpverification, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(OtpverificationViewModel.class);
        // TODO: Use the ViewModel
        String strText="One time password is send to "+getArguments().getString("strMobileNumber")+", please enter OTP to verify your mobile number";
        setListeners();


    }

    private void setListeners() {

        binding.buttonVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.editTextOtp.getEditText().getText().toString().trim().isEmpty()==false){

                 String strReferenceCode=   getArguments().getString("strReferenceCode");

                    PhoneAuthCredential credential= PhoneAuthProvider.getCredential(strReferenceCode,binding.editTextOtp.getEditText().getText().toString());
                    FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()){

                                Toast.makeText(getActivity(),"Login successful",Toast.LENGTH_LONG).show();

                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            e.printStackTrace();
                            Toast.makeText(getActivity(),"Login fail "+e.getMessage(),Toast.LENGTH_LONG).show();

                        }
                    });

                }else{
                    binding.editTextOtp.setError("Please enter a OTP");
                }
            }
        });

    }

}
