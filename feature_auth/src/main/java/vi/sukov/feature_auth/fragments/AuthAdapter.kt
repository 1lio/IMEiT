package vi.sukov.feature_auth.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vi.sukov.feature_auth.R

class AuthAdapter : RecyclerView.Adapter<AuthAdapter.PagerVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH =
            PagerVH(LayoutInflater.from(parent.context).inflate(R.layout.fr_container, parent, false))

    override fun getItemCount(): Int = 2

    override fun onBindViewHolder(holder: PagerVH, position: Int) = holder.itemView.run {}

    inner class PagerVH(itemView: View) : RecyclerView.ViewHolder(itemView)
}