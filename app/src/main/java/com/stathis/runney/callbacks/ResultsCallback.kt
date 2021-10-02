package com.stathis.runney.callbacks

import com.stathis.runney.models.Article
import com.stathis.runney.models.News
import com.stathis.runney.models.RunningRace

interface ResultsCallback {
    fun onNewsTap(news : News)
    fun onRaceTap(race : RunningRace)
    fun onArticleTap(article : Article)
}