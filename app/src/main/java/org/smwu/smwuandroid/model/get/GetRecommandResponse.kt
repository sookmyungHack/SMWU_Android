package org.smwu.smwuandroid.model.get

data class GetRecommandResponse (
        var fund : GetRecommandFund,
        var boycott : GetRecommandBoycott,
        var party : GetReconmmandParty,
        var sign : GetRecommandSign,
        var donate : GetRecommandDonate
        )