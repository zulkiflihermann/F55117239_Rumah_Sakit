package palu.developer.net.f55117239_rumahsakit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsFragment extends Fragment {

    private GoogleMap mapkips;

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {

            mapkips = googleMap;
            LatLng posisi1bosku = new LatLng(-0.8961548294293535, 119.8474284133975);
            LatLng posisi2bosku = new LatLng(-0.8983076578628951, 119.8474616916557);
            LatLng posisi3bosku = new LatLng(-0.8980930186426039, 119.8498414509799);
            LatLng posisi4bosku = new LatLng(-0.9007530458706801, 119.85003423032941);
            LatLng posisi5bosku = new LatLng(-0.9007225262461681, 119.84885345689848);



            LatLng kiostato = new LatLng(-0.8962468455601039, 119.8473212119775);

            googleMap.addMarker(new MarkerOptions().position(kiostato).title("Lokasi Rumahku").icon(BitmapDescriptorFactory.fromResource(R.drawable.rumahkips)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(kiostato,16));
            LatLng rs = new LatLng(-0.8999808418636444, 119.84920224132952);
            googleMap.addMarker(new MarkerOptions().position(rs).title("Rumah Sakit ANUTAPURA").icon(BitmapDescriptorFactory.fromResource(R.drawable.rumahsakit)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(rs));

            PolylineOptions jalurgalon = new PolylineOptions()
                    .add(posisi1bosku).add(posisi2bosku).add(posisi3bosku)
                    .add(posisi4bosku).add(posisi5bosku);
            Polyline garisjalur = googleMap.addPolyline(jalurgalon);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}