package com.example.mapapi;

import android.os.Bundle;

import com.amap.mapapi.core.GeoPoint;
import com.amap.mapapi.map.MapActivity;
import com.amap.mapapi.map.MapController;
import com.amap.mapapi.map.MapView;
public class MainActivity extends MapActivity {

	private MapView mMapView;
	private MapController mMapController;
	private GeoPoint point;

	/**
	 * 显示栅格地图，启用内置缩放控件，并用MapController控制地图的中心点及Zoom级别
	 * */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapview);	// 布局文件夹
		
		// 取得map视图控件
		mMapView = (MapView) findViewById(R.id.mapView);
		
		
//		// 设置地图为矢量模式
//		mMapView.setVectorMap(true);
		// 设置启用内置的缩放控件
		mMapView.setBuiltInZoomControls(true);	
		// 得到mMapView的控制权,可以用它控制和驱动平移和缩放
		mMapController = mMapView.getController();
		// 九江市的经纬度：北纬29.71，东经115.97-->（29.71 N, 115.97 E)
		// 用给定的经纬度构造一个GeoPoint，单位是微度(度*1E6)
		point = new GeoPoint((int)(29.71 * 1E6), (int)(115.97 * 1E6)); 
		// 地图的中心点设置
		mMapController.setCenter(point);
		// zoom级别就是地图初始显示的大小
		mMapController.setZoom(13);
		
		
		
		
		// 覆盖图层
		mMapView.getOverlays().add(new MyOverlay(getApplicationContext(), point));
		
	}
	
	
	
	
	

}
