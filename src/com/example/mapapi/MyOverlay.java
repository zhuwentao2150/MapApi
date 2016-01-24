package com.example.mapapi;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Paint.Style;

import com.amap.mapapi.core.GeoPoint;
import com.amap.mapapi.map.MapView;
import com.amap.mapapi.map.Overlay;

public class MyOverlay extends Overlay{

	private Context context;
	private GeoPoint point;
	
	/**
	 * 构造方法
	 * @param context 上下文对象
	 * @param point	坐标
	 */
	public MyOverlay(Context context, GeoPoint point) {
		this.context = context;
		this.point = point;
	}
	
	
	@Override
	public void draw(Canvas canvas, MapView mapView, boolean shadow) {
		
		super.draw(canvas, mapView, shadow);
		
		Point screenPts = new Point();
		mapView.getProjection().toPixels(point, screenPts);
		// add the marker
		Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), R.drawable.mapzb);
		
		canvas.drawBitmap(bmp, screenPts.x, screenPts.y-50, null);
		
//		Paint paintText = new Paint();
//		paintText.setTextScaleX(8);
//		paintText.setColor(Color.BLACK);
//		canvas.drawText("MyMap", screenPts.x, screenPts.y, paintText);	// 绘制文本
		
//		Paint mCirclePaint = new Paint();
//		mCirclePaint.setAntiAlias(true);
//		mCirclePaint.setColor(Color.BLUE);
//		mCirclePaint.setAlpha(50);
//		mCirclePaint.setStyle(Style.FILL);
//		canvas.drawCircle(screenPts.x+150, screenPts.y, 50, mCirclePaint);
		
//		Paint paintLine = new Paint();
//		paintLine.setColor(Color.RED);
//		paintLine.setStrokeWidth(3.0f);
//		paintLine.setStyle(Paint.Style.STROKE);
//		canvas.drawLine(screenPts.x-100, screenPts.y, screenPts.x, screenPts.y-200, paintLine);
		
	}
	
	@Override
	public boolean onTap(GeoPoint arg0, MapView arg1) {
		// TODO Auto-generated method stub
		return super.onTap(arg0, arg1);
	}
	
}
