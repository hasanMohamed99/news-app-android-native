package com.example.newsapp.repository

import com.example.newsapp.api.RetrofitInstance
import com.example.newsapp.dp.ArticleDatabase
import com.example.newsapp.models.Article


class NewsRepository(
    private val dp: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)

    suspend fun searchNews(searchQuery:String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

    suspend fun upsert(article: Article) = dp.getArticleDao().upsert(article)

    fun getSavedNews() = dp.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = dp.getArticleDao().deleteArticle(article)
}