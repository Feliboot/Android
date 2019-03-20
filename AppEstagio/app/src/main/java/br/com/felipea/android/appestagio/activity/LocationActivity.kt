package br.com.felipea.android.appestagio.activity



import br.com.felipea.android.appestagio.R

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


private const val PERMISSION_REQUEST = 10

class LocationActivity : AppCompatActivity() {


    lateinit var locationManager: LocationManager
    private var hasGps = false
    private var hasNetwork = false
    private var locationGps: Location? = null
    private var locationNetwork: Location? = null
    lateinit var btn_get_location : Button
    lateinit var tv_result1 : TextView
    lateinit var tv_result2 : TextView
    lateinit var tv_result3 : TextView
    private var permissions = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)
        btn_get_location = findViewById(R.id.btn_get_location)
        tv_result1 = findViewById(R.id.tv_result)
        tv_result2 = findViewById(R.id.tv_result2)
        tv_result3 = findViewById(R.id.tv_result3)
        disableView()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkPermission(permissions)) {
                enableView()
            } else {
                requestPermissions(permissions, PERMISSION_REQUEST)
            }
        } else {
            enableView()
        }

    }

    private fun disableView() {
        btn_get_location.isEnabled = false
        btn_get_location.alpha = 0.5F
    }

    private fun enableView() {
        btn_get_location.isEnabled = true
        btn_get_location.alpha = 1F
        btn_get_location.setOnClickListener { getLocation()}
    }

    @SuppressLint("MissingPermission")
    private fun getLocation() {
        //HABILITE OS LOGS PARA VERIFICAR OS VALORES MOSTRADOS NO APP  (E TAMBEM CASO QUEIRA VERIFICAR OS DADOS)
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        hasGps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        hasNetwork = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
        if (hasGps || hasNetwork) {

            if (hasGps) {
//                Log.d("CodeAndroidLocation", "hasGps")
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0F, object : LocationListener {
                    override fun onLocationChanged(location: Location?) {
                        if (location != null) {
                            locationGps = location

                            tv_result1.text = "GPS "
                            tv_result2.text = "Latitude : " + locationGps!!.latitude
                            tv_result3.text = "Longitude : " + locationGps!!.longitude
//                            Log.d("CodeAndroidLocation", " GPS Latitude : " + locationGps!!.latitude)
//                            Log.d("CodeAndroidLocation", " GPS Longitude : " + locationGps!!.longitude)
                        }
                    }

                    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {

                    }

                    override fun onProviderEnabled(provider: String?) {

                    }

                    override fun onProviderDisabled(provider: String?) {

                    }

                })

                val localGpsLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                if (localGpsLocation != null)
                    locationGps = localGpsLocation
            }
            if (hasNetwork) {
//                Log.d("CodeAndroidLocation", "hasGps")
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 0F, object : LocationListener {
                    override fun onLocationChanged(location: Location?) {
                        if (location != null) {
                            locationNetwork = location
                            tv_result1.text="Network "
                            tv_result2.text= "Latitude : " + locationNetwork!!.latitude
                            tv_result3.text="Longitude : " + locationNetwork!!.longitude
//                            Log.d("CodeAndroidLocation", " Network Latitude : " + locationNetwork!!.latitude)
//                            Log.d("CodeAndroidLocation", " Network Longitude : " + locationNetwork!!.longitude)
                        }
                    }

                    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {

                    }

                    override fun onProviderEnabled(provider: String?) {

                    }

                    override fun onProviderDisabled(provider: String?) {

                    }

                })

                val localNetworkLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
                if (localNetworkLocation != null)
                    locationNetwork = localNetworkLocation
            }

            if(locationGps!= null && locationNetwork!= null){
                if(locationGps!!.accuracy > locationNetwork!!.accuracy){
                    tv_result1.text="Network "
                    tv_result2.text="Latitude : " + locationNetwork!!.latitude
                    tv_result3.text = "Longitude : " + locationNetwork!!.longitude
//                    Log.d("CodeAndroidLocation", " Network Latitude : " + locationNetwork!!.latitude)
//                    Log.d("CodeAndroidLocation", " Network Longitude : " + locationNetwork!!.longitude)
                }else{
                    tv_result1.text = "GPS "
                    tv_result2.text = "Latitude : " + locationGps!!.latitude
                    tv_result3.text = "Longitude : " + locationGps!!.longitude
//                    Log.d("CodeAndroidLocation", " GPS Latitude : " + locationGps!!.latitude)
//                    Log.d("CodeAndroidLocation", " GPS Longitude : " + locationGps!!.longitude)
                }
            }

        } else {
            startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
        }
    }

    private fun checkPermission(permissionArray: Array<String>): Boolean {
        var allSuccess = true
        for (i in permissionArray.indices) {
            if (checkCallingOrSelfPermission(permissionArray[i]) == PackageManager.PERMISSION_DENIED)
                allSuccess = false
        }
        return allSuccess
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST) {
            var allSuccess = true
            for (i in permissions.indices) {
                if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                    allSuccess = false
                    val requestAgain = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && shouldShowRequestPermissionRationale(permissions[i])
                    if (requestAgain) {
                        Toast.makeText(this, "Permissao negada", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Vá para as configurações e habilite a permissão", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            if (allSuccess)
                enableView()

        }
    }
}
