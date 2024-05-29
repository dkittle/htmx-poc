package com.example

import com.mongodb.client.model.Filters
import com.mongodb.kotlin.client.coroutine.MongoClient
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import kotlin.test.Test

class TestPaintOrders {
    data class PaintOrder(
        val qty: Int,
        val color: String,
        @BsonId val id: ObjectId = ObjectId(),
    )

    @Test
    fun `test simple paint code`() {
        val mongoUrl = "mongodb://mongoadmin:Garibaldi!@localhost:27017"
        val client = MongoClient.create(mongoUrl)
        val database = client.getDatabase("story")
        val collection = database.getCollection<PaintOrder>("paint")
        println("Finding paint orders...........")
        runBlocking {
            var result = collection.insertOne(PaintOrder(10, "purple"))
            println("Inserted with id ${result.insertedId?.asObjectId()?.value}")
            result = collection.insertOne(PaintOrder(8, "green"))
            println("Inserted with id ${result.insertedId?.asObjectId()?.value}")
            result = collection.insertOne(PaintOrder(4, "purple"))
            println("Inserted with id ${result.insertedId?.asObjectId()?.value}")
            result = collection.insertOne(PaintOrder(11, "green"))
            println("Inserted with id ${result.insertedId?.asObjectId()?.value}")
            val filter = Filters.eq(PaintOrder::qty.name, 10)
            val resultsFlow = collection.find(filter)
            resultsFlow.collect { println(it) }
            delay(4_000L)
        }
    }
}
