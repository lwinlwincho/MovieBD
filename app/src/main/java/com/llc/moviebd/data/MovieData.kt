package com.llc.moviebd.data

import com.llc.moviebd.R

class MovieData {

    fun loadMovieData():List<MovieModel>{
        return listOf<MovieModel>(
            MovieModel(R.drawable.image1,R.string.date1,R.string.date1),
            MovieModel(R.drawable.image2,R.string.movie2,R.string.date2),
            MovieModel(R.drawable.image3,R.string.movie3,R.string.date3),
            MovieModel(R.drawable.image4,R.string.movie4,R.string.date4),
            MovieModel(R.drawable.image5,R.string.movie5,R.string.date5),
            MovieModel(R.drawable.image6,R.string.movie6,R.string.date6),
            MovieModel(R.drawable.image7,R.string.movie7,R.string.date7),
            MovieModel(R.drawable.image8,R.string.movie8,R.string.date8),
            MovieModel(R.drawable.image9,R.string.movie9,R.string.date9),
            MovieModel(R.drawable.image10,R.string.movie10,R.string.date10)
        )
    }
}