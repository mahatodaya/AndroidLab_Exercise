package lab08

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab01.R
import de.hdodenhof.circleimageview.CircleImageView

class StudentAdapter (
    private val lstStudent : ArrayList<StudentModel>,
    val context : Context
        ) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder> (){
    class StudentViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imageProfile : CircleImageView = view.findViewById(R.id.imgProfile)
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvAddress: TextView = view.findViewById(R.id.tvAddress)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_layout_design, parent,false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = lstStudent[position]
        holder.tvName.text = student.name
        holder.tvAddress.text = student.address

        Glide.with(context)
            .load(student.image)
            .into(holder.imageProfile)
    }

    override fun getItemCount(): Int {
        return lstStudent.size
    }
}


