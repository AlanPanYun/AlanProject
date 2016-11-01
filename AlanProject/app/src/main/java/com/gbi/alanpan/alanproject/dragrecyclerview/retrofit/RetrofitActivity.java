package com.gbi.alanpan.alanproject.dragrecyclerview.retrofit;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;

import com.gbi.alanpan.alanproject.R;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by alan.pan on 2016/10/31.
 */
public class RetrofitActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        mWebView = (WebView) findViewById(R.id.web_view);

        initRetrofit();
    }

    private void initRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestService requestService = retrofit.create(RequestService.class);

        Call<String> call = requestService.getSearchBooks("小王子", "", 0, 3);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("alan", response.body().toString());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

    }

    public static final String MULTIPART_FORM_DATA = "multipart/form-data";

    @NonNull
    private RequestBody createPartFromString(String descriptionString) {
        return RequestBody.create(
                MediaType.parse(MULTIPART_FORM_DATA), descriptionString);
    }

//    @NonNull
//    private MultipartBody.Part prepareFilePart(String partName, Uri fileUri) {
//        File file = FileUtils.getFile(this, fileUri);
//
//        // 为file建立RequestBody实例
//        RequestBody requestFile =
//                RequestBody.create(MediaType.parse(MULTIPART_FORM_DATA), file);
//
//        // MultipartBody.Part借助文件名完成最终的上传
//        return MultipartBody.Part.createFormData(partName, file.getName(), requestFile);
//    }

//    private void uploadFile(){
//        Uri file1Uri = null ;// 从文件选择器或者摄像头中获取
//        Uri file2Uri = null;
//
//// 创建上传的service实例
//        FileUploadService service =
//                ServiceGenerator.createService(FileUploadService.class);
//
//// 创建文件的part (photo, video, ...)
//        MultipartBody.Part body1 = prepareFilePart("video", file1Uri);
//        MultipartBody.Part body2 = prepareFilePart("thumbnail", file2Uri);
//
//// 添加其他的part
//        RequestBody description = createPartFromString("hello, this is description speaking");
//
//// 最后执行异步请求操作
//        Call<ResponseBody> call = service.uploadMultipleFiles(description, body1, body2);
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call,
//                                   Response<ResponseBody> response) {
//                Log.v("Upload", "success");
//            }
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Log.e("Upload error:", t.getMessage());
//            }
//        });
//    }

}
