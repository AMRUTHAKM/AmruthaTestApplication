package com.amrutha.amruthatestapplication

import com.amrutha.amruthatestapplication.database.CatRoomModel
import com.amrutha.amruthatestapplication.model.CatDataItem

class CatDataItemToCatRoomModelConverter {
    fun fromAPItoDB(input: CatDataItem): CatRoomModel {
        return CatRoomModel(input.id!!, input.name, input.origin, input.image?.url)
    }
}