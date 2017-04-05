package com.team.speedcoders.licttestrecyclerview;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Items> items=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int []imageList={R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,R.drawable.image6};
        for(int i=0;i<20;i++){
            items.add(new Items("Deperement "+i,imageList[i%6],"Name"+i));
        }
        final CustomRecyclerViewAdapter customRecyclerViewAdapter=new CustomRecyclerViewAdapter(this,items);
        recyclerView= (RecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(customRecyclerViewAdapter);

        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                int movement= ItemTouchHelper.UP | ItemTouchHelper.DOWN;
                int remove=ItemTouchHelper.END;
                return makeMovementFlags(movement,remove);
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                Items item=items.get(viewHolder.getAdapterPosition());
                items.add(target.getAdapterPosition(),item);
                customRecyclerViewAdapter.notifyItemMoved(viewHolder.getAdapterPosition(),target.getAdapterPosition());
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                items.remove(viewHolder.getAdapterPosition());
                customRecyclerViewAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    public void odIt( ImageView imageView, int pos) {
        Intent intent =new Intent(this,DetailActivity.class);
        intent.putExtra("name",items.get(pos).getName());
        intent.putExtra("image",items.get(pos).getImageRes());
        intent.putExtra("dept",items.get(pos).getDepertment());
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            ActivityOptions activityOption=ActivityOptions.makeSceneTransitionAnimation(this,imageView,"my_transition");
            startActivity(intent,activityOption.toBundle());
        }
        else startActivity(intent);
    }
}
