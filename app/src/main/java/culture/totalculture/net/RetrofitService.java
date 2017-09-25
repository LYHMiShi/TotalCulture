package culture.totalculture.net;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static Retrofit retrofit;

    private RetrofitService(){

    }

    public static Api create(){
        if(retrofit == null) {
            synchronized (RetrofitService.class){
                if(retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl("")
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();
                }
            }
        }
        return retrofit.create(Api.class);
    }
}
