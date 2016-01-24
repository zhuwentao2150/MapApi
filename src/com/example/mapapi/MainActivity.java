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
	 * ��ʾդ���ͼ�������������ſؼ�������MapController���Ƶ�ͼ�����ĵ㼰Zoom����
	 * */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapview);	// �����ļ���
		
		// ȡ��map��ͼ�ؼ�
		mMapView = (MapView) findViewById(R.id.mapView);
		
		
//		// ���õ�ͼΪʸ��ģʽ
//		mMapView.setVectorMap(true);
		// �����������õ����ſؼ�
		mMapView.setBuiltInZoomControls(true);	
		// �õ�mMapView�Ŀ���Ȩ,�����������ƺ�����ƽ�ƺ�����
		mMapController = mMapView.getController();
		// �Ž��еľ�γ�ȣ���γ29.71������115.97-->��29.71 N, 115.97 E)
		// �ø����ľ�γ�ȹ���һ��GeoPoint����λ��΢��(��*1E6)
		point = new GeoPoint((int)(29.71 * 1E6), (int)(115.97 * 1E6)); 
		// ��ͼ�����ĵ�����
		mMapController.setCenter(point);
		// zoom������ǵ�ͼ��ʼ��ʾ�Ĵ�С
		mMapController.setZoom(13);
		
		
		
		
		// ����ͼ��
		mMapView.getOverlays().add(new MyOverlay(getApplicationContext(), point));
		
	}
	
	
	
	
	

}
