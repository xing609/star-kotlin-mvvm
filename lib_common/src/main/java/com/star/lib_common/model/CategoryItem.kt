package com.star.lib_common.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
/**
* Description:分类tab信息
* Author:star
**/
data class CategoryItem(
    val cid: Int?,
    val name: String?,
    var isSelected: Boolean?,
    val articles: MutableList<CategorySecondItem>? = mutableListOf()
)

@Parcelize
data class CategorySecondItem(
    val id: Int?,
    val link: String?,
    val title: String?,
    val chapterId: Int?
) : Parcelable