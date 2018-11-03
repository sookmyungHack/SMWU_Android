package org.smwu.smwuandroid.model.get

data class GetDetailData3 (
        var boycott_idx : Int,
        var boycott_count: Int,
        var boycott_title: String,
        var boycott_content: String,
        var boycott_img: String,
        var boycott_date: String,
        var boycott_limit: String,
        var boycott_like: Int,
        var boycott_person: Int,
        var user_idx: Int,
        var user_img: String,
        var user_nickname: String
)