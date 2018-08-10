package ru.vyaacheslav.suhov.imeit.ftagments.maps

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.data.DB

class MapsLocation : Fragment(), OnMapReadyCallback {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val v = inflater.inflate(R.layout.fragment_maps, container, false)
        val mapFragment: SupportMapFragment = childFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        DB(this.context!!).dbMaps()
        return v
    }

    override fun onMapReady(googleMap: GoogleMap) {

        val gk = LatLng(52.626593, 38.488465)
        val uk1 = LatLng(52.626129, 38.497927)
        val uk2 = LatLng(52.625338, 38.495109)
        val uk3 = LatLng(52.628794, 38.491596)
        val uk4 = LatLng(52.624833, 38.498389)
        val uk11 = LatLng(52.625600, 38.488658)
        val uk12 = LatLng(52.609469, 38.514106)
        val uk14 = LatLng(52.616596, 38.514557)
        val uk15 = LatLng(52.625678, 38.487747)
        val nb = LatLng(52.626791, 38.489200)
        val obc = LatLng(52.626282, 38.498928)

        val mir: ArrayList<LatLng> = arrayListOf(gk, uk1, uk2, uk3, uk4, uk11, uk12, uk14, uk15, nb, obc)

        val s = DB(this.context!!).dbMaps()

        var i = 0
        while (i < mir.size) {
            googleMap.addMarker(MarkerOptions().position(mir[i])
                    .title("${s[i]["name"]}"))
            i++
        }

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(uk2))
        googleMap.setMinZoomPreference(13.0f)
        googleMap.setMaxZoomPreference(17.0f)
    }
}