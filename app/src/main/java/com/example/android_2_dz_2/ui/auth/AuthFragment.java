package com.example.android_2_dz_2.ui.auth;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android_2_dz_2.R;
import com.example.android_2_dz_2.databinding.FragmentAuthBinding;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.lang.ref.PhantomReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class AuthFragment extends Fragment {
    private FragmentAuthBinding binding;
    private NavController navController;
    private String vertId;
    private String code ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAuthBinding.inflate(inflater, container, false);
        FirebaseAuth.getInstance().getFirebaseAuthSettings().forceRecaptchaFlowForTesting(true);
        onClickListener();
        navController = NavHostFragment.findNavController(this);
        return binding.getRoot();
    }

    private void onClickListener() {

        binding.btnSing.setOnClickListener(v -> {
            binding.codCon.setVisibility(View.VISIBLE);
            binding.phoneCons.setVisibility(View.GONE);
            sendVertCode();
        });
    }

    private void check(String phoneAuthProvider, String s) {

        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(phoneAuthProvider, s );
        signInWithPhoneAuthCredential(credential);
    }

    //    mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//
//        @Override
//        public void onVerificationCompleted(PhoneAuthCredential credential) {
//            // This callback will be invoked in two situations:
//            // 1 - Instant verification. In some cases the phone number can be instantly
//            //     verified without needing to send or enter a verification code.
//            // 2 - Auto-retrieval. On some devices Google Play services can automatically
//            //     detect the incoming verification SMS and perform verification without
//            //     user action.
//            Log.d(TAG, "onVerificationCompleted:" + credential);
//
//            signInWithPhoneAuthCredential(credential);
//        }
//
//        @Override
//        public void onVerificationFailed(FirebaseException e) {
//            // This callback is invoked in an invalid request for verification is made,
//            // for instance if the the phone number format is not valid.
//            Log.w(TAG, "onVerificationFailed", e);
//
//            if (e instanceof FirebaseAuthInvalidCredentialsException) {
//                // Invalid request
//            } else if (e instanceof FirebaseTooManyRequestsException) {
//                // The SMS quota for the project has been exceeded
//            }
//
//            // Show a message and update the UI
//        }
//
//        @Override
//        public void onCodeSent(@NonNull String verificationId,
//                @NonNull PhoneAuthProvider.ForceResendingToken token) {
//            // The SMS verification code has been sent to the provided phone number, we
//            // now need to ask the user to enter the code and then construct a credential
//            // by combining the code with a verification ID.
//            Log.d(TAG, "onCodeSent:" + verificationId);
//
//            // Save verification ID and resending token so we can use them later
//            mVerificationId = verificationId;
//            mResendToken = token;
//        }
//    };
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback =
            new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                @Override
                public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                    Toast.makeText(requireContext(), "Авторизация успешна", Toast.LENGTH_SHORT)
                            .show();
                    signInWithPhoneAuthCredential(phoneAuthCredential);
                }

                @Override
                public void onVerificationFailed(@NonNull FirebaseException e) {

                }

                @Override
                public void onCodeSent(@NonNull String s, @NonNull
                        PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                    super.onCodeSent(s, forceResendingToken);
                    vertId = s;
                    binding.btnSms.setOnClickListener(v -> {
                        code = binding.etCod.getText().toString().trim();
                        check(s , binding.etCod.getText().toString());
                    });
                }
            };

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        FirebaseAuth.getInstance().signInWithCredential(credential)
                .addOnCompleteListener(requireActivity(), task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("TAG", "signInWithCredential:success");
                        Toast.makeText(requireContext(), "success register", Toast.LENGTH_SHORT).show();
                        FirebaseUser user = task.getResult().getUser();
                        navController.navigate(R.id.action_authFragment_to_navigation_home);

                        // Update UI
                    } else {
                        // Sign in failed, display a message and update the UI
                        Log.w("TAG", "signInWithCredential:failure", task.getException());
                        if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                            // The verification code entered was invalid
                        }
                    }
                });
    }


    private void sendVertCode() {
        String phone = binding.etPhone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            binding.etPhone.setError("введите номер");
            return;
        }

        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(FirebaseAuth.getInstance())
                        .setPhoneNumber(phone)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(requireActivity())                 // Activity (for callback binding)
                        .setCallbacks(mCallback)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

}