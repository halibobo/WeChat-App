package dahei.me.xiaobai.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import dahei.me.xiaobai.R;

/**
 * created by yubosu
 * 2018年11月12日2:12 PM
 */
public class ItemBarLayout extends RelativeLayout {

    private ImageView imageView;
    private TextView textView;

    public ItemBarLayout(Context context) {
        super(context);
        initView(context);
    }

    public ItemBarLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        initAttrs(attrs);
    }

    public ItemBarLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        initAttrs(attrs);
    }

    private void initAttrs( AttributeSet attrs) {
        TypedArray t = getContext().obtainStyledAttributes(attrs, R.styleable.ItemBarLayout);
        String contValue = t.getString(R.styleable.ItemBarLayout_ibl_tabText);
        BitmapDrawable iconNormal = (BitmapDrawable) t.getDrawable(R.styleable.ItemBarLayout_ibl_image);
        Boolean showLIne = t.getBoolean(R.styleable.ItemBarLayout_ibl_line, false);
        findViewById(R.id.lineBottom).setVisibility(showLIne ? VISIBLE : GONE);
        if (iconNormal != null) {
            imageView.setImageDrawable(iconNormal);
        }
        textView.setText(contValue);
        t.recycle();
    }

    private void initView(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_item_bar, this);
        textView = findViewById(R.id.textTitle);
        imageView = findViewById(R.id.imageLogo);
    }
}
