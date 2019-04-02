package top.qvisa.experimentfive;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {
    private Context mContext;
    private List<Staff> mList;

    public Myadapter(Context context, List<Staff> noteList) {
        mContext = context;
        mList = noteList;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_staff, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.mTextView_item_name.setText(mList.get(i).getName());
        viewHolder.mTextView_item_sex.setText(mList.get(i).getSex());
        viewHolder.mTextView_item_department.setText(mList.get(i).getDepartment());
        viewHolder.mTextView_item_salary.setText(mList.get(i).getSalary_String());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView_item_name;
        TextView mTextView_item_sex;
        TextView mTextView_item_department;
        TextView mTextView_item_salary;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView_item_name = itemView.findViewById(R.id.item_name);
            mTextView_item_sex = itemView.findViewById(R.id.item_sex);
            mTextView_item_department = itemView.findViewById(R.id.item_department);
            mTextView_item_salary = itemView.findViewById(R.id.item_salary);
        }
    }
}
