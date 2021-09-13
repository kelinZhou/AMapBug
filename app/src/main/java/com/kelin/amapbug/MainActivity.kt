package com.kelin.amapbug

import android.graphics.BitmapFactory
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import com.amap.api.maps.CameraUpdateFactory
import com.amap.api.maps.model.BitmapDescriptorFactory
import com.amap.api.maps.model.MyLocationStyle
import com.amap.api.navi.AMapNavi
import com.amap.api.navi.AMapNaviListener
import com.amap.api.navi.model.*
import com.umeng.commonsdk.UMConfigure
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , AMapNaviListener {

    /**
     * 导航引擎
     */
    private val navigator by lazy { AMapNavi.getInstance(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        UMConfigure.init(this, "610a52d7864a9558e6dd05b0", "", UMConfigure.DEVICE_TYPE_PHONE, "")
        setContentView(R.layout.activity_main)
        navigator.run {
            addAMapNaviListener(this@MainActivity)
        }
        mapNavigatorView.run {
            onCreate(savedInstanceState)
            map.run {
                uiSettings.isZoomControlsEnabled = false
                myLocationStyle?.apply {
                    val color = Color.parseColor("#261266FF")
                    strokeColor(color)
                    radiusFillColor(color)
                    myLocationIcon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(resources, R.drawable.ic_location_my_self)))
                }
                setMyLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE)

                setOnMapLoadedListener {
                    mapNavigatorView.also { mapView ->
                        //设置地图中心点在屏幕上的位置
                        setPointToCenter(mapView.width / 2, mapView.height / 3)
                        //设置地图缩放比例
                        moveCamera(CameraUpdateFactory.zoomTo(15f))
                    }
                }

                setOnMapTouchListener {
                    if (it.action == MotionEvent.ACTION_MOVE && isMyLocationEnabled) {
                        setMyLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE_NO_CENTER)
                    }
                }
            }
        }
    }


    override fun onResume() {
        super.onResume()
        mapNavigatorView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapNavigatorView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapNavigatorView.onDestroy()
        AMapNavi.destroy()
    }

    override fun onInitNaviFailure() {

    }

    override fun onInitNaviSuccess() {
    }

    override fun onStartNavi(p0: Int) {
    }

    override fun onTrafficStatusUpdate() {
    }

    override fun onLocationChange(p0: AMapNaviLocation?) {
    }

    override fun onGetNavigationText(p0: Int, p1: String?) {
    }

    override fun onGetNavigationText(p0: String?) {
    }

    override fun onEndEmulatorNavi() {
    }

    override fun onArriveDestination() {
    }

    override fun onCalculateRouteFailure(p0: Int) {
    }

    override fun onCalculateRouteFailure(p0: AMapCalcRouteResult?) {
    }

    override fun onReCalculateRouteForYaw() {
    }

    override fun onReCalculateRouteForTrafficJam() {
    }

    override fun onArrivedWayPoint(p0: Int) {
    }

    override fun onGpsOpenStatus(p0: Boolean) {
    }

    override fun onNaviInfoUpdate(p0: NaviInfo?) {
    }

    override fun updateCameraInfo(p0: Array<out AMapNaviCameraInfo>?) {
    }

    override fun updateIntervalCameraInfo(p0: AMapNaviCameraInfo?, p1: AMapNaviCameraInfo?, p2: Int) {
    }

    override fun onServiceAreaUpdate(p0: Array<out AMapServiceAreaInfo>?) {
    }

    override fun showCross(p0: AMapNaviCross?) {
    }

    override fun hideCross() {
    }

    override fun showModeCross(p0: AMapModelCross?) {
    }

    override fun hideModeCross() {
    }

    override fun showLaneInfo(p0: Array<out AMapLaneInfo>?, p1: ByteArray?, p2: ByteArray?) {
    }

    override fun showLaneInfo(p0: AMapLaneInfo?) {
    }

    override fun hideLaneInfo() {
    }

    override fun onCalculateRouteSuccess(p0: IntArray?) {
    }

    override fun onCalculateRouteSuccess(p0: AMapCalcRouteResult?) {
    }

    override fun notifyParallelRoad(p0: Int) {
    }

    override fun OnUpdateTrafficFacility(p0: Array<out AMapNaviTrafficFacilityInfo>?) {
    }

    override fun OnUpdateTrafficFacility(p0: AMapNaviTrafficFacilityInfo?) {
    }

    override fun updateAimlessModeStatistics(p0: AimLessModeStat?) {
    }

    override fun updateAimlessModeCongestionInfo(p0: AimLessModeCongestionInfo?) {
    }

    override fun onPlayRing(p0: Int) {
    }

    override fun onNaviRouteNotify(p0: AMapNaviRouteNotifyData?) {
    }

    override fun onGpsSignalWeak(p0: Boolean) {
    }
}