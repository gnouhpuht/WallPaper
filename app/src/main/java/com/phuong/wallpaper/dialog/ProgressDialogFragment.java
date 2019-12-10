package com.phuong.wallpaper.dialog;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.phuong.wallpaper.R;

public class ProgressDialogFragment extends DialogFragment {
    private static final String ARG_MESSAGE = "message";
    private static final String ARG_INDETERMINATE = "indeterminate";
    public static final String FRAGMENT_TAG = "LoadingFragment";

    public static boolean DIALOG_INDETERMINATE = true;
    public static boolean DIALOG_NOT_INDETERMINATE;
    public static boolean DIALOG_CANCELABLE = true;

    public static ProgressDialogFragment newInstance() {
        return newInstance(R.string.progress_dialog_waiting_message);
    }

    public static ProgressDialogFragment newInstance(int message) {
        return newInstance(message, DIALOG_INDETERMINATE, DIALOG_CANCELABLE);
    }

    public static ProgressDialogFragment newInstance(int message, boolean indeterminate, boolean cancelable) {
        Bundle args = new Bundle();
        args.putInt(ARG_MESSAGE, message);
        args.putBoolean(ARG_INDETERMINATE, indeterminate);

        ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment();
        progressDialogFragment.setArguments(args);
        progressDialogFragment.setCancelable(cancelable);
        return progressDialogFragment;
    }

    public static ProgressDialogFragment newInstance(String message, boolean indeterminate, boolean cancelable) {
        Bundle args = new Bundle();
        args.putString(ARG_MESSAGE, message);
        args.putBoolean(ARG_INDETERMINATE, indeterminate);

        ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment();
        progressDialogFragment.setArguments(args);
        progressDialogFragment.setCancelable(cancelable);
        return progressDialogFragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        String message = getString(R.string.progress_dialog_waiting_message);
        boolean indeterminate = arguments.getBoolean(ARG_INDETERMINATE, DIALOG_NOT_INDETERMINATE);

        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage(message);
        progressDialog.setIndeterminate(indeterminate);
        return progressDialog;
    }
}
