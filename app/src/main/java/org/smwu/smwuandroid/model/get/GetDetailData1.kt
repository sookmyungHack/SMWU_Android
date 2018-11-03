package org.smwu.smwuandroid.model.get

data class GetDetailData1 (
        var party_idx : Int,
        var party_url: String,
        var party_img: String,
        var party_title: String,
        var party_content: String,
        var party_like: Int,
        var party_limit: String,
        var party_date: String,
        var party_person: Int,
        var party_count: Int,
        var user_idx: Int,
        var user_img: String,
        var user_nickname: String
)