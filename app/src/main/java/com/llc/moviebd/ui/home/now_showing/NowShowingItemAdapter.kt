package com.llc.moviebd.ui.home.now_showing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.llc.moviebd.R
import com.llc.moviebd.data.model.MovieModel
import com.llc.moviebd.databinding.ItemNowShowingBinding
import com.llc.moviebd.extension.loadFromUrl
import com.llc.moviebd.network.IMAGE_URL
import com.llc.moviebd.ui.home.popular.PopularItemAdapter
import com.llc.moviebd.ui.home.popular.onItemClickListener

class NowShowingItemAdapter(private val listener: onItemClickListener):
    ListAdapter<MovieModel, NowShowingItemAdapter.NowShowingViewHolder>(diffCallBack) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowShowingViewHolder {
        return NowShowingViewHolder(
            ItemNowShowingBinding.inflate(LayoutInflater.from(parent.context)),
            listener
        )
    }

    override fun onBindViewHolder(holder: NowShowingViewHolder, position: Int) {
        val movieItem: MovieModel = getItem(position)
        holder.bind(movieItem)
    }

    class NowShowingViewHolder(
        private var binding: ItemNowShowingBinding,
        private val listener:onItemClickListener
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movieModel: MovieModel) {

            with(binding) {
                ivPoster.loadFromUrl(IMAGE_URL + movieModel.posterPath)
                tvMovieName.text = movieModel.title
                tvStarRate.text = binding.root.context.getString(
                    R.string.vote_average_format,
                    movieModel.vote_average.toString()
                )

                ivPoster.setOnClickListener {
                    listener.onPosterClicked(movieModel)
                }

                imvFav.setOnClickListener {
                    listener.onFavoriteClicked(movieModel)
                }
            }
        }
    }

    companion object diffCallBack : DiffUtil.ItemCallback<MovieModel>() {

        override fun areItemsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
            return oldItem == newItem
        }
    }
}