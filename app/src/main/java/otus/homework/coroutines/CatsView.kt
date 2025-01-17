package otus.homework.coroutines

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.constraintlayout.widget.ConstraintLayout
import com.squareup.picasso.Picasso

class CatsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr), ICatsView {

    fun setOnClickListener(action: () -> Unit) {
        findViewById<Button>(R.id.button).setOnClickListener {
            action()
        }
    }

    override fun populate(factWithPicture: FactWithPicture) {
        findViewById<TextView>(R.id.fact_textView).text = factWithPicture.fact
        Picasso
            .get()
            .load(factWithPicture.pictureUrl)
            .into(findViewById<ImageView>(R.id.pictureIv))
    }

    override fun showToast(messageRes: Int) {
        showToast(context.getString(messageRes))
    }

    override fun showToast(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}

interface ICatsView {

    fun populate(factWithPicture: FactWithPicture)
    fun showToast(@StringRes messageRes: Int)
    fun showToast(message: String?)
}