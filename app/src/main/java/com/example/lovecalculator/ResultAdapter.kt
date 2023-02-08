package com.example.lovecalculator
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculator.databinding.ItemResultBinding
import com.example.lovecalculator.remote.LoveModel


class ResultAdapter : RecyclerView.Adapter<ResultAdapter.ResultViewHolder> (){
    private val post = arrayListOf<LoveModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        return ResultViewHolder(ItemResultBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
       holder.bind(post[position])
    }


    fun setItem(list : List<LoveModel>){
        post.clear()
        post.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return post.size
    }
    inner class ResultViewHolder(private val binding: ItemResultBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(loveModel: LoveModel) {
            binding.textFirstname.text = loveModel.firstName
            binding.textSecondname.text = loveModel.secondName
            binding.textPercentage.text = loveModel.percentage
            binding.textResult.text = loveModel.result
        }
    }
}