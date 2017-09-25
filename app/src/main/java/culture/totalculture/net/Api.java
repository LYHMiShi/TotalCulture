package culture.totalculture.net;


import culture.totalculture.model.entity.Bean;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {

    @GET("/interface")
    Observable<Bean> getBeanDate();
}
