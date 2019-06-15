package ru.vyaacheslav.suhov.imeit.view.ftagments.maps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.base.BaseFragment
import ru.vyaacheslav.suhov.imeit.viewmodel.LocationViewModel

/** Фрагмент с картой */
class MapsMapFragment : BaseFragment(), OnMapReadyCallback {

    private lateinit var model: LocationViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val v = inflater.inflate(R.layout.fr_maps, container, false)
        (childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment).getMapAsync(this)
        model = ViewModelProviders.of(this)[LocationViewModel::class.java]
        return v
    }

    override fun onMapReady(googleMap: GoogleMap) {

        // В цикле перебераем коодинаты и приводм к типу LatLng
        // Затем создаем point на карте и присваиваем имя из БД

        model.observeListBuilding(this, Observer { list ->

            var i = 0
            while (i < list.size) {
                val point = list[i].coordinate
                val latLong = point.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                val latitude = java.lang.Double.parseDouble(latLong[0])
                val longitude = java.lang.Double.parseDouble(latLong[1])
                val location = LatLng(latitude, longitude)

                googleMap.addMarker(MarkerOptions()
                        .position(location)
                        .title(list[i].name)
                        // .icon(BitmapDescriptorFactory.defaultMarker(colorPoint))
                )
                i++
            }
        })

        val center = LatLng(52.625338, 38.495109) // Сентрируем карту чтобы были на карте точки всех корпусов
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(center))
        googleMap.setMinZoomPreference(13.0f) //  параметры зума
        googleMap.setMaxZoomPreference(17.0f)
    }
}