package sandeep.city.Views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import sandeep.city.R;

/**
 * Created by sandeep on 7/8/15.
 */
public class CustomIconTitle extends RelativeLayout {

    Context c;
    String titleText;
    int titleSize, image_id;

    public CustomIconTitle(Context context) {
        super(context);
        this.c = context;
    }

    public CustomIconTitle(Context context, AttributeSet attrs) {
        super(context, attrs);

        c = context;

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomIconTitle, 0, 0);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.image_icon, this, true);

        TextView title = (TextView) findViewById(R.id.image_title);
        ImageView icon = (ImageView) findViewById(R.id.image_icon);


        try {
            titleText = a.getString(R.styleable.CustomIconTitle_title_name);
            image_id = a.getResourceId(R.styleable.CustomIconTitle_image_icon, 0);
            titleSize = a.getDimensionPixelSize(R.styleable.CustomIconTitle_titleSize, 0);

            title.setText(titleText);
            icon.setImageResource(image_id);
            title.setTextSize(titleSize);

        } catch (Exception e){
            Log.e("Error in ImageIcon",e.toString());
        }
        finally {
            a.recycle();
        }

    }
}