package listener;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

@WebListener
public class CustomAsyncListener implements AsyncListener {
    @Override
    public void onComplete(AsyncEvent asyncEvent) throws IOException {
        System.out.println("ASYNC_LISTENER: onComplete");
    }

    @Override
    public void onTimeout(AsyncEvent asyncEvent) throws IOException {
        System.out.println("ASYNC_LISTENER: onTimeout");
    }

    @Override
    public void onError(AsyncEvent asyncEvent) throws IOException {
        System.out.println("ASYNC_LISTENER: onError");
    }

    @Override
    public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
        System.out.println("ASYNC_LISTENER: onStartAsync");
    }
}
