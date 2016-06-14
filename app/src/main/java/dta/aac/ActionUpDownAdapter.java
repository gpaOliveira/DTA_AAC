package dta.aac;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class ActionUpDownAdapter extends BaseAdapter {
    ArrayList<Action> _actions;
    AacActivity _context;
    ScrollingWay _scroll;

    public enum ScrollingWay{
        HORIZONTAL,
        VERTICAL
    }

    // Constructor
    public ActionUpDownAdapter(AacActivity ctx, ArrayList<Action> actions, ActionUpDownAdapter.ScrollingWay scroll) {
        _actions = actions;
        _context =ctx;
        _scroll = scroll;
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
            if (_scroll.equals(ScrollingWay.HORIZONTAL)) {
                rl = _actions.get(position).renderHorizontal(_context);
            }
            if (_scroll.equals(ScrollingWay.VERTICAL)) {
                rl = _actions.get(position).renderVertical(_context);
            }
        }
        else
        {
            rl =(RelativeLayout) convertView;
        }

        return rl;
    }

}