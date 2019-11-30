package com.liliana.roomdb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.liliana.roomdb.Activities.UpdateWord;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.WordViewHodel> {
    private WordViewModel model;
    private List<Word> words;
    private LayoutInflater mlayoutInflater;
    private Context context;

    public Adapter(Context context) {
        mlayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WordViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mlayoutInflater.inflate(R.layout.itemword, parent, false);
        return new WordViewHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHodel holder, int position) {
        Word word = words.get(position);
        if (words == null) {
            holder.txt.setText("no word");
        } else {
            // holder.txtiD.setText(word.getiD()+"");
            holder.txt.setText(word.getWord());

        }
     holder.btnUpdateAWord.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             String getdta=word.getWord();
             Intent intent=new Intent(v.getContext(),UpdateWord.class);
             intent.putExtra("key",getdta);
             v.getContext().startActivity(intent);
         }
     });
    }

    void setWords(List<Word> words) {
        this.words = words;
        notifyDataSetChanged();
    }

    public Word getWordAtPosition(int position) {
        return words.get(position);
    }

    @Override
    public int getItemCount() {
        return words == null ? 0 : words.size();
    }

    static class WordViewHodel extends RecyclerView.ViewHolder {
        private Onclick itemClickListener;
        private TextView txt;
        private TextView txtiD;
        private Button btnUpdateAWord;

        public WordViewHodel(@NonNull View itemView) {
            super(itemView);
            txtiD = itemView.findViewById(R.id.txtiD);
            txt = itemView.findViewById(R.id.txt);
            btnUpdateAWord = itemView.findViewById(R.id.btn_update);
        }

    }
}
