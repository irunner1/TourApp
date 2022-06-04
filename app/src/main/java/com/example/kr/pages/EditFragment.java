package com.example.kr.pages;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.kr.R;
import com.example.kr.databinding.ActivityMainBinding;
import com.example.kr.helpers.Fles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class EditFragment extends Fragment {
    private Toolbar toolbar;
    private ActivityMainBinding binding;
    private Uri imageUri = null;
    ImageView iv;
    Button btnSave;
    EditText etName, etEmail, etCity;
    String Name = "", City = "", Email = "";

    private void toolBarSet() {
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        if (((AppCompatActivity)getActivity()).getSupportActionBar() != null) {
            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("");
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit, container, false);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolBarSet();
        iv = view.findViewById(R.id.imageView4);
        btnSave = view.findViewById(R.id.btnSave);
        etName = view.findViewById(R.id.etName);
        etCity = view.findViewById(R.id.etCity);
        etEmail = view.findViewById(R.id.etEmail);
        iv.setOnClickListener(this::pickImage);
        btnSave.setOnClickListener(this::onSaveClick);

        String str = Fles.readfromFile(getContext());
        int c1 = str.indexOf('/'); //находим элемент после названия страны
        int c2 = str.indexOf('|'); //находим элемент после дат
        for (int i = 0; i < str.length(); i++) { //парсим данные в переменные
            if (i < c1) {Name += str.charAt(i);}
            if (i > c1 && i < c2) {Email += str.charAt(i);}
            if (i > c2) City += str.charAt(i);
        }
        etName.setText(Name);
        etCity.setText(City);
        etEmail.setText(Email);
        Fles.loadImageFromStorage(getContext(), iv);
        return view;
    }

    private void pickImage(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        galleryActivityResultLauncher.launch(intent);
    }

    private ActivityResultLauncher<Intent> galleryActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Toast.makeText(getContext(), "Image Picked from gallery", Toast.LENGTH_SHORT).show();
                        Intent data = result.getData();
                        imageUri = data.getData();
                        iv.setImageURI(imageUri);
                    }
                    else {
                        Toast.makeText(getContext(),"Cancelled..", Toast.LENGTH_SHORT).show();
                    }
                }
            }
    );

    public void onSaveClick(View view) {
        Fles.writetoFile(etName.getText().toString(), etEmail.getText().toString(), etCity.getText().toString(), getContext());
        Bitmap bitmap = ((BitmapDrawable)iv.getDrawable()).getBitmap();
        Fles.saveToInternalStorage(bitmap, getContext());
    }
}