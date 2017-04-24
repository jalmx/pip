package leyva.josef.xizuth.pip.about;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import leyva.josef.xizuth.pip.R;

/**
 * Created by josef on 4/24/17.
 */

public class AuthorAdapter extends ArrayAdapter<Author> {

    public AuthorAdapter(@NonNull Context context, @NonNull List<Author> authors) {
        super(context, 0, authors);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_author, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.name_author);
        TextView mail = (TextView) convertView.findViewById(R.id.email_author);
        TextView description = (TextView) convertView.findViewById(R.id.description_author);

        name.setText(getItem(position).getName());
        mail.setText(getItem(position).getEmail());
        description.setText(getItem(position).getDescription());
        return convertView;
    }
}
