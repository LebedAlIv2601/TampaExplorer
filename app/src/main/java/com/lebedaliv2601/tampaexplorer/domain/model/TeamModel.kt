package com.lebedaliv2601.tampaexplorer.domain.model

data class TeamModel(
    val id: Int,
    val name: String
)

fun getTeamIconByName(name: String): String{
    return TeamModel(0, name).getTeamIcon()
}

fun TeamModel.getTeamIcon(): String {
    return when (name) {
        "Arizona Coyotes" -> "https://content.sportslogos.net/logos/1/5263/full/arizona_coyotes_logo_primary_2022_sportslogosnet-8273.png"
        "Anaheim Ducks" -> "https://content.sportslogos.net/logos/1/1736/full/1651_anaheim_ducks-primary-20141.png"
        "Boston Bruins" -> "https://content.sportslogos.net/logos/1/3/full/venf9fmhgnsawnxxvehf.png"
        "Buffalo Sabres" -> "https://content.sportslogos.net/logos/1/4/full/5493_buffalo_sabres-primary-2021.png"
        "Calgary Flames" -> "https://content.sportslogos.net/logos/1/5/full/4820_calgary_flames-primary-2021.png"
        "Carolina Hurricanes" -> "https://content.sportslogos.net/logos/1/6/full/fotih31tn5r345nufo5xxayh3.png"
        "Chicago Blackhawks" -> "https://content.sportslogos.net/logos/1/7/full/56.png"
        "Colorado Avalanche" -> "https://content.sportslogos.net/logos/1/8/full/64.png"
        "Columbus Blue Jackets" -> "https://content.sportslogos.net/logos/1/9/full/jhepegs329pc7ugyypebl28wg.png"
        "Dallas Stars" -> "https://content.sportslogos.net/logos/1/10/full/dallas_stars_logo_primary_2022_sportslogosnet-4332.png"
        "Detroit Red Wings" -> "https://content.sportslogos.net/logos/1/11/full/yo3wysbjtagzmwj37tb11u0fh.png"
        "Edmonton Oilers" -> "https://content.sportslogos.net/logos/1/12/full/2728_edmonton_oilers-primary-2018.png"
        "Florida Panthers" -> "https://content.sportslogos.net/logos/1/13/full/8078_florida_panthers-primary-2017.png"
        "Los Angeles Kings" -> "https://content.sportslogos.net/logos/1/14/full/2220_los_angeles_kings-primary-2020.png"
        "Minnesota Wild" -> "https://upload.wikimedia.org/wikipedia/en/thumb/1/1b/Minnesota_Wild.svg/1200px-Minnesota_Wild.svg.png"
        "Montréal Canadiens" -> "https://content.sportslogos.net/logos/1/16/full/montreal_canadiens_logo_primary_20001687.png"
        "Nashville Predators" -> "https://content.sportslogos.net/logos/1/17/full/lvchw3qfsun2e7oc02kh2zxb6.png"
        "New Jersey Devils" -> "https://content.sportslogos.net/logos/1/18/full/32tfs723a3bes0p0hb4hgcy1u.png"
        "New York Islanders" -> "https://content.sportslogos.net/logos/1/19/full/3911_new_york_islanders-primary-2018.png"
        "New York Rangers" -> "https://content.sportslogos.net/logos/1/20/full/new_york_rangers-primary_20006777.png"
        "Ottawa Senators" -> "https://content.sportslogos.net/logos/1/21/full/1129_ottawa_senators-primary-2021.png"
        "Philadelphia Flyers" -> "https://content.sportslogos.net/logos/1/22/full/161.png"
        "Pittsburgh Penguins" -> "https://content.sportslogos.net/logos/1/24/full/6362_pittsburgh_penguins-primary-2017.png"
        "San Jose Sharks" -> "https://content.sportslogos.net/logos/1/26/full/san_jose_sharks-primary_20099429.png"
        "Seattle Kraken" -> "https://content.sportslogos.net/logos/1/6740/full/seattle_kraken_logo_primary_20226314.png"
        "St. Louis Blues" -> "https://content.sportslogos.net/logos/1/25/full/187.png"
        "Tampa Bay Lightning" -> "https://content.sportslogos.net/logos/1/27/full/tampa_bay_lightning_logo_primary_20124022.png"
        "Toronto Maple Leafs" -> "https://content.sportslogos.net/logos/1/28/full/8761_toronto_maple_leafs-primary-2017.png"
        "Vancouver Canucks" -> "https://content.sportslogos.net/logos/1/29/full/2084_vancouver_canucks-primary-2020.png"
        "Vegas Golden Knights" -> "https://content.sportslogos.net/logos/1/6114/full/2684_vegas_golden_knights-primary-2018.png"
        "Washington Capitals" -> "https://content.sportslogos.net/logos/1/30/full/llrs2zxi127vkqgcsvfb.png"
        "Winnipeg Jets" -> "https://content.sportslogos.net/logos/1/3050/full/z9qyy9xqoxfjn0njxgzoy2rwk.png"
        else -> "https://content.sportslogos.net/leagues/thumbs/1.gif"
    }
}

fun TeamModel.getTeamLastName(): String {
    return when (name) {
        "Arizona Coyotes" -> "Coyotes"
        "Anaheim Ducks" -> "Ducks"
        "Boston Bruins" -> "Bruins"
        "Buffalo Sabres" -> "Sabres"
        "Calgary Flames" -> "Flames"
        "Carolina Hurricanes" -> "Hurricanes"
        "Chicago Blackhawks" -> "Blackhawks"
        "Colorado Avalanche" -> "Avalanche"
        "Columbus Blue Jackets" -> "Blue Jackets"
        "Dallas Stars" -> "Stars"
        "Detroit Red Wings" -> "Red Wings"
        "Edmonton Oilers" -> "Oilers"
        "Florida Panthers" -> "Panthers"
        "Los Angeles Kings" -> "Kings"
        "Minnesota Wild" -> "Wild"
        "Montréal Canadiens" -> "Canadiens"
        "Nashville Predators" -> "Predators"
        "New Jersey Devils" -> "Devils"
        "New York Islanders" -> "Islanders"
        "New York Rangers" -> "Rangers"
        "Ottawa Senators" -> "Senators"
        "Philadelphia Flyers" -> "Flyers"
        "Pittsburgh Penguins" -> "Penguins"
        "San Jose Sharks" -> "Sharks"
        "Seattle Kraken" -> "Kraken"
        "St. Louis Blues" -> "Blues"
        "Tampa Bay Lightning" -> "Lightning"
        "Toronto Maple Leafs" -> "Maple Leafs"
        "Vancouver Canucks" -> "Canucks"
        "Vegas Golden Knights" -> "Knights"
        "Washington Capitals" -> "Capitals"
        "Winnipeg Jets" -> "Jets"
        else -> name
    }
}

fun TeamModel.getTeamShortName(): String {
    return when (name) {
        "Arizona Coyotes" -> "ARI"
        "Anaheim Ducks" -> "ANA"
        "Boston Bruins" -> "BOS"
        "Buffalo Sabres" -> "BUF"
        "Calgary Flames" -> "CGY"
        "Carolina Hurricanes" -> "CAR"
        "Chicago Blackhawks" -> "CHI"
        "Colorado Avalanche" -> "COL"
        "Columbus Blue Jackets" -> "CBJ"
        "Dallas Stars" -> "DAL"
        "Detroit Red Wings" -> "DET"
        "Edmonton Oilers" -> "EDM"
        "Florida Panthers" -> "FLA"
        "Los Angeles Kings" -> "LAK"
        "Minnesota Wild" -> "MIN"
        "Montréal Canadiens" -> "MTL"
        "Nashville Predators" -> "NSH"
        "New Jersey Devils" -> "NJD"
        "New York Islanders" -> "NYI"
        "New York Rangers" -> "NYR"
        "Ottawa Senators" -> "OTT"
        "Philadelphia Flyers" -> "PHI"
        "Pittsburgh Penguins" -> "PIT"
        "San Jose Sharks" -> "SJS"
        "Seattle Kraken" -> "SEA"
        "St. Louis Blues" -> "STL"
        "Tampa Bay Lightning" -> "TBL"
        "Toronto Maple Leafs" -> "TOR"
        "Vancouver Canucks" -> "VAN"
        "Vegas Golden Knights" -> "VGK"
        "Washington Capitals" -> "WSH"
        "Winnipeg Jets" -> "WPG"
        else -> name
    }
}
