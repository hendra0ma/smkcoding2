import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.corona.savelive.CoronaIndonesiaItem
import com.corona.savelive.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.corona_item.*

class CoronaAdapter(private val context: Context, private val items:
List<CoronaIndonesiaItem>, private val listener: (CoronaIndonesiaItem)-> Unit) :
    RecyclerView.Adapter<CoronaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(context, LayoutInflater.from(context).inflate(
            R.layout.corona_item,
            parent, false))
    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position), listener)
    }
    class ViewHolder(val context: Context, override val containerView : View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer{
        fun bindItem(item: CoronaIndonesiaItem, listener: (CoronaIndonesiaItem) -> Unit) {

            txtDirawat.text = item.dirawat
            txtPositif.text = item.positif
            txtMeninggal.text = item.meninggal
            txtSembuh.text = item.sembuh

            containerView.setOnClickListener { listener(item) }
        }
    }
}