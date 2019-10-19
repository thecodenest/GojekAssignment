package rajendra.gojekassignment.cache;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class CacheInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            try {
                return chain.proceed(chain.request());
            } catch (Exception e) {


                CacheControl cacheControl = new CacheControl.Builder()
                        .onlyIfCached()
                        .maxStale(2, TimeUnit.HOURS)
                        .build();

                Request offlineRequest = chain.request().newBuilder()
                        .cacheControl(cacheControl)
                        .build();
                return chain.proceed(offlineRequest);
            }
        }


}
