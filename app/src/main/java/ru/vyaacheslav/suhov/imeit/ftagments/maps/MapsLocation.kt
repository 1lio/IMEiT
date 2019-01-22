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

/** Фрагмент с картой */
class MapsLocation : Fragment(), OnMapReadyCallback {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val v = inflater.inflate(R.layout.fragment_maps, container, false)
        val mapFragment: SupportMapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        return v
    }

    override fun onMapReady(googleMap: GoogleMap) {
        val dbLocate = DB(this.context!!).dbMaps()  // Подключаемся к базе к таблице с картой
        // В цикле перебераем коодинаты и приводм к типу LatLng
        // Затем создаем point на карте и присваиваем имя из БД

        /*   val colorPoint = 136f // Цвет маркера на карте*/
        var i = 0

        while (i < dbLocate.size) {
            val hh = dbLocate[i]["locate"].toString()
            val latLong = hh.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val latitude = java.lang.Double.parseDouble(latLong[0])
            val longitude = java.lang.Double.parseDouble(latLong[1])
            val location = LatLng(latitude, longitude)

            googleMap.addMarker(MarkerOptions().position(location)
                    .title("${dbLocate[i]["name"]}")
                    /* .icon(BitmapDescriptorFactory.defaultMarker(colorPoint))*/)
            i++
        }

        val center = LatLng(52.625338, 38.495109)
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(center))// Сентрируем карту чтобы были на карте точки всех корпусов
        googleMap.setMinZoomPreference(13.0f) // Устанавливаем пораметры зума
        googleMap.setMaxZoomPreference(17.0f)
    }
}