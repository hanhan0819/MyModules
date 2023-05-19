package sg.edu.rp.c346.id21007466.mymodules;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=findViewById(R.id.textView);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an explicit intent to launch ModuleDetailActivity
                Intent intent = new Intent(MainActivity.this, ModuleDetailActivity.class);

                // Pass the module information as extras
                intent.putExtra("Module", new ModuleDetailActivity.Module("C346", "Android Programming", "2020", "1", 4, "W66M"));

                startActivity(intent);
            }
        });
    }
}