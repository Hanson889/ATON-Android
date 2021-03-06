package com.juzix.wallet.component.ui.view;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.juzix.wallet.R;
import com.juzix.wallet.app.Constants;
import com.juzix.wallet.component.ui.base.BaseFragment;

public class ExportIndividualPrivateKeyFragment extends BaseFragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_export_individual_private_key, container, false);
        view.findViewById(R.id.btn_copy).setOnClickListener(this);
        ((TextView)view.findViewById(R.id.tv_private_key)).setText(getActivity().getIntent().getStringExtra(Constants.Extra.EXTRA_PASSWORD));
//        int          shapeRadius  = AndroidUtil.dip2px(getContext(), 1);
//        int          shadowRadius = AndroidUtil.dip2px(getContext(), 4);
//        ShadowDrawable.setShadowDrawable(mTvPrivateKey,
//                ContextCompat.getColor(getContext(), R.color.color_1f2841),
//                shapeRadius,
//                ContextCompat.getColor(getContext(), R.color.color_020527),
//                shadowRadius, 0, 0);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_copy:
                Activity activity = getActivity();
                ClipboardManager cm = (ClipboardManager) activity.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("text", activity.getIntent().getStringExtra(Constants.Extra.EXTRA_PASSWORD));
                cm.setPrimaryClip(clipData);
                showLongToast(string(R.string.textCopiedTips));
                break;
        }
    }
}
