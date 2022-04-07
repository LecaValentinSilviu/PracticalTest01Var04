package ro.pub.cs.systems.eim.practicaltest01var04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
//import android.view.animation.AlphaAnimation;
import android.widget.Button;
//import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final private static long TRANSPARENCY_EFFECT_DURATION = 5000;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private static String a = "";

    private class ButtonClickListener implements Button.OnClickListener {

        @Override
        public void onClick(View view) {
            EditText userNameEditText1 = (EditText)findViewById(R.id.left_edit_text);
            EditText userNameEditText2 = (EditText)findViewById(R.id.right_edit_text);
            TextView greetingTextView = (TextView)findViewById(R.id.greeting_text_view);

            greetingTextView.setAlpha(1);
            greetingTextView.setText(greetingTextView.getText().toString().replace(a, userNameEditText1.getText() + " " + userNameEditText2.getText()));
            a = userNameEditText1.getText() + " " + userNameEditText2.getText();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitButton = (Button)findViewById(R.id.display_information_button);
        submitButton.setOnClickListener(buttonClickListener);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        EditText usernameEditText1 = (EditText)findViewById(R.id.left_edit_text);
        EditText userNameEditText2 = (EditText)findViewById(R.id.right_edit_text);

        savedInstanceState.putString("Perfect Student", usernameEditText1.getText().toString());
        savedInstanceState.putString("Perfect Student", userNameEditText2.getText().toString());

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        EditText useNameEditText1 = (EditText)findViewById(R.id.left_edit_text);
        EditText userNameEditText2 = (EditText)findViewById(R.id.right_edit_text);
        if (savedInstanceState.containsKey(useNameEditText1.getText().toString())) {
            EditText usernameEditText = (EditText)findViewById(R.id.left_edit_text);
            usernameEditText.setText(savedInstanceState.getString("Perfect Student"));
        }
        if (savedInstanceState.containsKey(useNameEditText1.getText().toString())) {
            EditText passwordEditText = (EditText)findViewById(R.id.right_edit_text);
            passwordEditText.setText(savedInstanceState.getString("341C1"));
        }
    }


}