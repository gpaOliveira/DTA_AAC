package dta.aac;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class OptionsAdapter extends BaseAdapter {
    ArrayList<Action> _actions;
    AacActivity _context;
    // Constructor
    public OptionsAdapter(AacActivity ctx, ArrayList<Action> actions) {
        _actions = actions;
        _context =ctx;
    }

    public int getCount() {
        return _actions.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        RelativeLayout rl =null;

        if (convertView == null) {
            rl = _actions.get(position).render(_context);
        }
        else
        {
            rl =(RelativeLayout) convertView;
        }

        return rl;
    }

}