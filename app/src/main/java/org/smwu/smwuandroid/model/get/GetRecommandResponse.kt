package org.smwu.smwuandroid.model.get

data class GetRecommandResponse (
        var recommandFund : GetRecommandFund,
        var recommandBoycott : GetRecommandBoycott,
        var recommandParty : GetReconmmandParty,
        var recommandSign : GetRecommandSign,
        var recommandDonate : GetRecommandDonate
        )