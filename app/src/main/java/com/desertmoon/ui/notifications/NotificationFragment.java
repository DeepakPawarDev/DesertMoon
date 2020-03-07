package com.desertmoon.ui.notifications;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.app.Notification;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.desertmoon.R;
import com.desertmoon.common.Notifications;
import com.desertmoon.databinding.NotificationFragmentBinding;

import java.util.ArrayList;

public class NotificationFragment extends Fragment {

    private NotificationViewModel mViewModel;
    NotificationFragmentBinding binding;

    public static NotificationFragment newInstance() {
        return new NotificationFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding= DataBindingUtil.inflate(inflater,R.layout.notification_fragment, container, false);
        initialize();
        return binding.getRoot();
    }

    private void initialize() {

        Notifications  notifications=new Notifications();

        ArrayList<Notifications> notifications1=new ArrayList<>();
        notifications1.add(notifications);
        notifications1.add(notifications);
        notifications1.add(notifications);
        notifications1.add(notifications);
        notifications1.add(notifications);
        notifications1.add(notifications);
        notifications1.add(notifications);
        notifications1.add(notifications);

        AdapterNotification adapterNotification=new AdapterNotification(getActivity(),notifications1);
        binding.setAdapter(adapterNotification);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(NotificationViewModel.class);




        // TODO: Use the ViewModel
    }

}
