package rajendra.gojekassignment.retrofit;

import io.reactivex.Observable;
import rajendra.gojekassignment.model.GitRepo;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiInterface {

    @Headers("Accept:application/json")
    @GET("repositories")
    Observable<GitRepo> getRepositories();

}
