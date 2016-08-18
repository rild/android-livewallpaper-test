package rimp.rild.com.android.android_livewallpaper_test.assu;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Movie;
import android.graphics.Paint;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import java.io.IOException;

import rimp.rild.com.android.android_livewallpaper_test.R;

/**
 * Created by rild on 16/08/18.
 */
public class AssuLiveWallpaper extends WallpaperService {
    int mCount = 0;

    private final Handler mHandler = new Handler();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public Engine onCreateEngine() {
        //TODO

        return new AssuEngine();
    }

    public class AssuEngine extends WallpaperService.Engine {

        @Override
        public void onSurfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            super.onSurfaceChanged(holder, format, width, height);
        }

        @Override
        public void onSurfaceCreated(SurfaceHolder holder) {
            super.onSurfaceCreated(holder);
            doDraw(0, 0);
        }

        @Override
        public void onSurfaceDestroyed(SurfaceHolder holder) {
            super.onSurfaceDestroyed(holder);
        }

        @Override
        public void onCreate(SurfaceHolder surfaceHolder) {
            super.onCreate(surfaceHolder);

            // デフォルトではtouchEventで画面のTouchを受け取れない。
            //
            setTouchEventsEnabled(true);
        }

        @Override
        public void onTouchEvent(MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_MOVE || event.getAction() == MotionEvent.ACTION_DOWN) {
                doDraw((int) event.getX(), (int) event.getY());
            }
            super.onTouchEvent(event);
        }

        public void doDraw(int posX, int posY) {

            Canvas canvas = getSurfaceHolder().lockCanvas();

            Paint paint = new Paint();

            canvas.drawColor(Color.BLACK);
            Bitmap background = BitmapFactory.decodeResource(getResources(), R.drawable.mens_hinata_2);
            canvas.drawBitmap(background, 0, 0, paint);


            paint.setTextSize(36);
            paint.setFakeBoldText(true);
            paint.setColor(getResources().getColor(R.color.brown));

            //テキストの描画
            canvas.drawText("ひなただよ！", posX - 32, posY - 65, paint);

            //画像の描画
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.hinata_stamp);

            mCount++;
            canvas.drawBitmap(bmp, posX - 32, posY - 65, paint);


            getSurfaceHolder().unlockCanvasAndPost(canvas);
        }

    }
}
