package com.example.isseiomizu.weight;

/**
 * Created by isseiomizu on 2016/09/12.
 */

import java.util.ArrayList;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * カスタム PagerAdapter クラス.
 */
public class CustomPagerAdapter extends PagerAdapter {

    /** コンテキスト. */
    private Context mContext;

    /** リスト. */
    private ArrayList<Integer> mList;

    /**
     * コンストラクタ.
     */
    public CustomPagerAdapter(Context context) {
        mContext = context;
        mList = new ArrayList<Integer>();
    }

    /**
     * リストにアイテムを追加する.
     * @param item アイテム
     */
    public void add(Integer item) {
        mList.add(item);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        // リストから取得
        Integer item = mList.get(position);

        // View を生成
        TextView textView = new TextView(mContext);
        textView.setText("Page:" + position);
        textView.setTextSize(30);
        textView.setTextColor(item);
        textView.setGravity(Gravity.CENTER);

        // コンテナに追加
        container.addView(textView);

        return textView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // コンテナから View を削除
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        // リストのアイテム数を返す
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        // Object 内に View が存在するか判定する
        return view == (TextView) object;
    }

}