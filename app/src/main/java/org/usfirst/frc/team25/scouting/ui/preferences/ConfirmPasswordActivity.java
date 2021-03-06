package org.usfirst.frc.team25.scouting.ui.preferences;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.usfirst.frc.team25.scouting.R;
import org.usfirst.frc.team25.scouting.data.Settings;

/**
 * Activity that prompts users to enter the old password before setting a new one
 */
public class ConfirmPasswordActivity extends EnterPasswordActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Change Password");
        //noinspection ConstantConditions
        findViewById(R.id.delete_warning).setVisibility(View.INVISIBLE);
        TextView title = (TextView) findViewById(R.id.enter_password_label);


        title.setText(R.string.confirm_old_pass);
        delete.setText(R.string.confirm_button);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = passwordField.getText().toString();

                if(Settings.newInstance(getBaseContext()).matchesPassword(password)){
                    finish();
                    Intent i = new Intent(getBaseContext(), SetPasswordActivity.class);
                    startActivity(i);
                }

                else passwordField.setError("Incorrect password");

            }
        });
    }
}
