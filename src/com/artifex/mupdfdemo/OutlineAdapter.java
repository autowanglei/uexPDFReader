package com.artifex.mupdfdemo;

import org.zywx.wbpalmstar.engine.universalex.EUExUtil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class OutlineAdapter extends BaseAdapter {
	private final OutlineItem mItems[];
	private final LayoutInflater mInflater;

	public OutlineAdapter(LayoutInflater inflater, OutlineItem items[]) {
		mInflater = inflater;
		mItems = items;
	}

	public int getCount() {
		return mItems.length;
	}

	public Object getItem(int arg0) {
		return null;
	}

	public long getItemId(int arg0) {
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View v;
		if (convertView == null) {
			v = mInflater.inflate(EUExUtil.getResLayoutID("plugin_uexpdfreader_outline_entry"), null);
		} else {
			v = convertView;
		}
		int level = mItems[position].level;
		if (level > 8)
			level = 8;
		String space = "";
		for (int i = 0; i < level; i++)
			space += "   ";
		((TextView) v.findViewById(EUExUtil.getResIdID("title"))).setText(space + mItems[position].title);
		((TextView) v.findViewById(EUExUtil.getResIdID("page"))).setText(String.valueOf(mItems[position].page + 1));
		return v;
	}

}
