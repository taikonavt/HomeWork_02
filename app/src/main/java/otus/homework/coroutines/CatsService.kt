package otus.homework.coroutines

import retrofit2.http.GET

interface CatsService {

    @GET("api/v1/resources/dogs?number=1")
    suspend fun getCatFact() : List<Fact>
}