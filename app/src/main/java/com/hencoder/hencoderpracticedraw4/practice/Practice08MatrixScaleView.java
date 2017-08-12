package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice08MatrixScaleView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);
    Matrix matrix = new Matrix();

    public Practice08MatrixScaleView(Context context) {
        super(context);
    }

    public Practice08MatrixScaleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice08MatrixScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        canvas.save();
        canvas.translate(200,200);
        matrix.reset();
        matrix.postScale(1.3f, 1.3f, 1.3f, 1.3f);
//        canvas.setMatrix(matrix);
//        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.drawBitmap(bitmap, matrix, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(400,200);
        matrix.reset();
        matrix.postScale(2f, 3f, 2f, 3f);
        canvas.drawBitmap(bitmap, matrix, paint);
        canvas.restore();
    }
}
