package otus.homework.coroutines

import com.google.gson.annotations.SerializedName

data class Picture(
	@field:SerializedName("message")
	val pictureUrl: String
)