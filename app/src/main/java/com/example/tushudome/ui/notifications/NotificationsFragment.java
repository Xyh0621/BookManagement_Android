package com.example.tushudome.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.tushudome.data.LoginDataSource;
import com.example.tushudome.data.LoginRepository;
import com.example.tushudome.data.model.Reader;
import com.example.tushudome.databinding.FragmentNotificationsBinding;

import java.text.SimpleDateFormat;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView rdID = binding.rdID;
        final TextView rdName = binding.rdName;
        final TextView rdSex = binding.rdSex;
        final TextView rdType = binding.rdType;
        final TextView rdPhone = binding.rdPhone;
        final TextView rdEmail = binding.rdEmail;
        final TextView rdDateReg = binding.rdDateReg;
        final TextView rdBorrowQty = binding.rdBookNum;

        Reader user = LoginRepository.instance.getUser();

        rdID.setText(user.getRdID());
        rdName.setText(user.getRdName());
        if(user.getRdSex().equals("m")){
            rdSex.setText("男");
        }else {
            rdSex.setText("女");
        }
        rdType.setText(user.getRdTypeStr());
        rdPhone.setText(user.getRdPhone());
        rdEmail.setText(user.getRdEmail());
        rdDateReg.setText(new SimpleDateFormat("yyyy-MM-dd").format(user.getRdDateReg()));
        rdBorrowQty.setText(String.valueOf(user.getRdBorrowQty()));





        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}