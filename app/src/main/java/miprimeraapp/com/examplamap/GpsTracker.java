package miprimeraapp.com.examplamap;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import static android.content.Context.LOCATION_SERVICE;

public class GpsTracker implements LocationListener {

    Context context;
    public  boolean isGPSEnabled;

    public  GpsTracker(Context context)
    {super();
    this.context=context;
    isGPSEnabled=false;


    }
public Location getLocation()
{  if (ContextCompat.checkSelfPermission( context, android.Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED) {
    Log.e("fist","error");
    return null;
}
    try {
        LocationManager lm = (LocationManager) context.getSystemService(LOCATION_SERVICE);
        isGPSEnabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (isGPSEnabled){
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 6000,10,this);
            Location loc = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            return loc;
        }else{
            Log.e("sec","errpr");
        }
    }catch (Exception e){
        e.printStackTrace();
    }
    return null;

}


    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {



    }

}
