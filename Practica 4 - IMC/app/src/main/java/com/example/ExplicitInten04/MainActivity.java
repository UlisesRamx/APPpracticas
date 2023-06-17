package com.example.ExplicitInten04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.ExplicitInten04.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(v -> {
            calculateAndOpenResultActivity();
        });
    }

    private void calculateAndOpenResultActivity() {
        try {
            double weight = Double.parseDouble(binding.userWeight.getText().toString());
            double height = Double.parseDouble(binding.userHeight.getText().toString());
            double imc = calculateIMC(weight, height);

            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra(ResultActivity.WEIGHT_KEY, weight);
            intent.putExtra(ResultActivity.HEIGHT_KEY, height);
            intent.putExtra(ResultActivity.IMC_KEY, imc);
            startActivity(intent);
        } catch (NumberFormatException ex) {
            Log.e("MainActivity", ex.toString());
            Toast.makeText(this, getString(R.string.error_message), Toast.LENGTH_SHORT).show();
        }
    }

    private double calculateIMC(double weight, double height) {
        double heightInMeters = height / 100;
        return weight / (heightInMeters * heightInMeters);
    }
}
