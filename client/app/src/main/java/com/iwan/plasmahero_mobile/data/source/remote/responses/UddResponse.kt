package com.iwan.plasmahero_mobile.data.source.remote.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UddResponse(
        @SerializedName("name")
        @Expose
        var name: String? = null,
        @SerializedName("lat")
        @Expose
        var lat: Double? = null,
        @SerializedName("lng")
        @Expose
        var lng: Double? = null
)

class UddValue {
        var name: String? = null
        var lat: Double? = null
        var lng: Double? = null

        constructor(name: String, lat:Double, lng:Double){
                this.name = name
                this.lat = lat
                this.lng = lng
        }

}
