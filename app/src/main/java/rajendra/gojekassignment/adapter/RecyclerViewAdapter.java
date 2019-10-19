package rajendra.gojekassignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;
import rajendra.gojekassignment.R;
import rajendra.gojekassignment.model.GitRepo;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<GitRepo> mData ;

    public RecyclerViewAdapter(Context mContext, List<GitRepo> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.list_item,parent,false) ;
        final MyViewHolder viewHolder = new MyViewHolder(view) ;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        Glide.with(mContext)
                .load(mData.get(position).getAvatar())
                .into(holder.Aavatar);


        holder.Aauthor.setText(mData.get(position).getAuthor());
        holder.Aname.setText(mData.get(position).getName());


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView Aauthor,Aname ;
        CircleImageView Aavatar;
        LinearLayout view_container;

        public MyViewHolder(View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.container);
            Aavatar = itemView.findViewById(R.id.avatar);
            Aauthor = itemView.findViewById(R.id.author);
            Aname = itemView.findViewById(R.id.name);

        }
    }

}

