package dahei.me.xiaobai;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dahei.me.xiaobai.mainpage.MainPageActivity;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btnStart)
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnStart)
    public void onViewClicked() {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, MainPageActivity.class);
        startActivity(intent);

    }
}
