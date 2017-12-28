package com.bj.kotlinproject.upload;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bj.kotlinproject.R;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    private Button bt_one;
    private Button bt_two;
    private Button bt_three;
    private ImageView image;
    private String path;
    private String path1;
    private BufferedOutputStream bos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        path = Environment.getExternalStorageDirectory().getPath() + "/binbin.png";
        path1 = Environment.getExternalStorageDirectory().getPath() + "/";
        initView();
    }
    public void crop(Uri uri){
        Intent intent=new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri,"image/*");
        intent.putExtra("crop",true);
        intent.putExtra("aspaceX",1);
        intent.putExtra("aspaceY",1);
        //设置裁剪框的大小
        intent.putExtra("outputX",250);
        intent.putExtra("outputY",250);
        //设置人脸识别
        intent.putExtra("onFaceDetection",false);
        intent.putExtra("return-data",true);

        startActivityForResult(intent,3000);
    }


    void uploadPic(File file){
        Toast.makeText(this, "上传中", Toast.LENGTH_SHORT).show();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api2.upload).addConverterFactory(GsonConverterFactory.create()).build();
        ApiService2 apiService = retrofit.create(ApiService2.class);
        //得到类型 把File封装到请求体中
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/otcet-stream"),file);
        //创建表单数据
        MultipartBody.Part body=MultipartBody.Part.createFormData("file",file.getName(),requestBody);

        String descriptionString="536";
        RequestBody description=RequestBody.create(MediaType.parse("multipart/form-data"),descriptionString);

        Call<ResponseBody> bodyCall = apiService.uploadPic(description, body);
        bodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("SSSS","ds");
                Toast.makeText(MainActivity2.this, "上传图片成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                Log.e("SSSS","请求错误的方法");

            }
        });


    }

    private void initView() {
        bt_one = (Button) findViewById(R.id.bt_one);
        bt_two = (Button) findViewById(R.id.bt_two);
        bt_three = (Button) findViewById(R.id.bt_three);

        bt_one.setOnClickListener(this);
        bt_two.setOnClickListener(this);
        bt_three.setOnClickListener(this);
        image = (ImageView) findViewById(R.id.image);
        image.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_one:
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,4000);
                break;


            case R.id.bt_two:

                Intent intent1=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent1.putExtra(MediaStore.EXTRA_OUTPUT,Uri.fromFile(new File(path)));
                startActivityForResult(intent1,2000);
                break;
            case R.id.bt_three:

                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2000){
            File file=new File(path);
            //将要保存图片的路径
            crop(Uri.fromFile(file));
        }
        if(requestCode==3000){
            if(data!=null){
                Bitmap bitmap=data.getParcelableExtra("data");
                //将要保存图片的路径
                File file=new File(path);
                BufferedOutputStream bos=null;
                try {
                    bos = new BufferedOutputStream(new FileOutputStream(file));
                    //图片压缩质量压缩
                    bitmap.compress(Bitmap.CompressFormat.JPEG,100,bos);
                    bos.flush();
                    bos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                uploadPic(file);
            }
        }
        if(requestCode==4000){
            Uri uri=data.getData();
            crop(uri);
        }
    }
}
