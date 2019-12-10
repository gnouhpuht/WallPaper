package com.phuong.wallpaper.untils;

import android.app.ProgressDialog;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.phuong.wallpaper.R;
import com.phuong.wallpaper.activity.MainActivity;
import com.phuong.wallpaper.dialog.ProgressDialogFragment;

public class BaseDialogFragment extends DialogFragment {
    protected ProgressDialog progressDialog;


    protected MainActivity getMainActivity() {
        return (MainActivity) getActivity();
    }
    public void showLoadingDialog() {
        if (getActivity() != null) {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            if (fragmentManager != null) {
                ProgressDialogFragment fragment = (ProgressDialogFragment) fragmentManager
                        .findFragmentByTag(ProgressDialogFragment.FRAGMENT_TAG);
                if (fragment == null) {
                    fragment = ProgressDialogFragment.newInstance();
                    fragment.setCancelable(true);
                    fragmentManager.beginTransaction()
                            .add(fragment, ProgressDialogFragment.FRAGMENT_TAG)
                            .commitAllowingStateLoss();
                }
            }
        }

    }

    public void hideLoadingDialog() {
        if (getActivity() != null) {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

            if (fragmentManager != null) {
                ProgressDialogFragment fragment = (ProgressDialogFragment) fragmentManager
                        .findFragmentByTag(ProgressDialogFragment.FRAGMENT_TAG);
                if (fragment != null) {
                    fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
                }
            }
        }
    }
    protected void showProgressDialog(boolean isShown, String message) {
        if (this.progressDialog == null) {
            if (this.getActivity() == null) {
                return;
            }
            progressDialog = new ProgressDialog(this.getActivity());
            progressDialog.setMessage(getString(R.string.progress_dialog_waiting_message));
        }

//        if (StringUtils.isNotBlank(message)) {
//            progressDialog.setMessage(message);
//        }

        if (this.progressDialog != null) {
            if (isShown) {
                progressDialog.show();
            } else {
                progressDialog.dismiss();
            }
        }
    }

    public void showFullScreenDialogFragment(final BaseDialogFragment dialogFragment) {
        dialogFragment.setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_DeviceDefault);
        if (getMainActivity() != null) {
            getMainActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    FragmentTransaction transaction = getMainActivity().getSupportFragmentManager().beginTransaction();
                    transaction.add(dialogFragment, dialogFragment.getClass().toString());
                    transaction.commitAllowingStateLoss();
                }
            });
        }
    }

    public void showFullScreenFragment(final BaseDialogFragment dialogFragment) {
        dialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.AppTheme);
        if (getMainActivity() != null) {
            getMainActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    FragmentTransaction transaction = getMainActivity().getSupportFragmentManager().beginTransaction();
                    transaction.add(dialogFragment, dialogFragment.getClass().toString());
                    transaction.commitAllowingStateLoss();
                }
            });
        }
    }
}
